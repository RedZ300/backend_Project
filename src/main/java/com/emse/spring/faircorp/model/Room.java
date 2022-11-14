package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Double current_temperature;

    @Column(nullable = true)
    private Double target_temperature;

    @ManyToOne(optional = false)
    private Building building;

    @OneToMany(mappedBy = "room")
    private List<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private List<Window> windows;

    public Room() {

    }

    public Room(String name, Integer floor, Double current_temperature, Double target_temperature, Building building){
        this.name = name;
        this.floor = floor;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.building = building;
    }

    public Room(String s1) {
        this.name = s1;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public List<Heater> getHeaters() {
        return  heaters;
    }

    public void setCurrent_temperature(double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public double getCurrent_temperature() {
        if(current_temperature == null){
            return 0;
        } else {
            return current_temperature;
        }
    }

    public double getTarget_temperature() {
        if(target_temperature == null){
            return 0;
        } else {
            return target_temperature;
        }
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
