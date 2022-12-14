package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> GetRelatedRooms(Long id) {
        String jpql = "select r from Room r where r.building.id = :id";

        try{
            return em.createQuery(jpql, Room.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
