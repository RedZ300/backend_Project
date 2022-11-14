package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.*;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getReferenceById(1L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getFloor()).isEqualTo(1);
    }

    @Test
    public void shouldFindRoom(){
        Room result = roomDao.findRoomByName("Room2");
        Assertions.assertThat(result.getId()).isEqualTo(2L);

    }

    @Test void shouldNotFindRoom(){
        Room result = roomDao.findRoomByName("Room15");
        Assertions.assertThat(result).isNull();
    }

    @Test void shouldFindRoomWindows(){

        List<Window> result = roomDao.getRelatedWindows(2L);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("Window 3");
        Assertions.assertThat(result.get(0).getWindowStatus()).isEqualTo(WindowStatus.OPEN);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test void shouldNotFindRoomWindows(){

        List<Window> result = roomDao.getRelatedWindows(7L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test void shouldFindRoomHeaters(){

        List<Heater> result = roomDao.getRelatedHeaters(2L);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("Heater5");
        Assertions.assertThat(result.get(0).getHeater_status()).isEqualTo(HeaterStatus.ON);
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test void shouldNotFindRoomHeaters(){

        List<Heater> result = roomDao.getRelatedHeaters(7L);
        Assertions.assertThat(result).isEmpty();
    }

}