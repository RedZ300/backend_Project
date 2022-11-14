package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Building")
public class Building {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer FloorCount;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    @OneToMany(mappedBy = "building")
    private List<Room> rooms;

    public Building() {

    }

    public Building(Integer FloorCount, String name, String adress) {

        this.FloorCount = FloorCount;
        this.name = name;
        this.adress = adress;
    }

    public Building(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getFloorCount() {
        return FloorCount;
    }

    public long getId() {
        return id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setFloorCount(Integer floorCount) {
        FloorCount = floorCount;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
