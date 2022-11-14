package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Tuple;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BuildingDaoTest {

    @Autowired
    private BuildingDao buildingDao;

    @Test
    void shouldFindBuilding() {

        Building result = buildingDao.getReferenceById(1L);
        Assertions.assertThat(result.getName()).isEqualTo("Espace Fauriel");
        Assertions.assertThat(result.getAdress()).isEqualTo("29 Rue Pierre et Dominique Ponchardier, 42100 Saint-Ã‰tienne");
    }

    @Test
    void shouldFindRelatedRooms() {

        List<Room> result = buildingDao.GetRelatedRooms(1L);
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("Room1");
    }

    @Test
    void shouldNotFindRelatedRooms() {

        List<Room> result = buildingDao.GetRelatedRooms(5L);
        Assertions.assertThat(result).isEmpty();
    }

}