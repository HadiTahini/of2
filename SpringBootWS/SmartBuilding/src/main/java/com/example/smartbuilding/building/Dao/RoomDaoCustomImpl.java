package com.example.smartbuilding.building.Dao;

import com.example.smartbuilding.building.Pattern.Room;
import com.example.smartbuilding.building.Enums.WindowStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomByName(String name){
        String jpql = "select r from Room r where r.name = :name";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", name)
                .getResultList();

    }

    @Override
    public List<Room> findRoomsWithOpenWindow(String status) {
        String jpql = "select r from Room r where Window.room.id = :id and Window .windowStatus= :status";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", -10)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }
}
