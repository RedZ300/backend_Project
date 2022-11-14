package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Room findRoomByName(String name) {
        String jpql = "select r from Room r where r.name = :name";
        try {
            return em.createQuery(jpql, Room.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Window> getRelatedWindows(Long id){
        String jpql = "select w from Window w where w.room.id = :id";

        try{
            return em.createQuery(jpql, Window.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Heater> getRelatedHeaters(Long id){
        String jpql = "select h from Heater h where h.room.id = :id";

        try{
            return em.createQuery(jpql, Heater.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
