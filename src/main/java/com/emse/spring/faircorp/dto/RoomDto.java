package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;

public class RoomDto {

    private Long id;

    private Integer floor;

    private String name;

    private Double current_temperature;

    private Double target_temperature;

    private Long buildingId;

    private String buildingName;

    public RoomDto(){

    }

    public RoomDto(Room room){
        this.id = room.getId();
        this.floor = room.getFloor();
        this.name = room.getName();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public double getCurrent_temperature() {
        return current_temperature;
    }

    public double getTarget_temperature() {
        return target_temperature;
    }

    public Integer getFloor() {
        return floor;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
