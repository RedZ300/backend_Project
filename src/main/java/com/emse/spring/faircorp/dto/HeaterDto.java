package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class HeaterDto {

    private Long id;

    private String name;

    private Long power;

    private String roomname;

    private Long roomid;

    private HeaterStatus heater_status;

    public HeaterDto(){

    }

    public HeaterDto(Heater heater){
        this.id = heater.getId();
        this.heater_status = heater.getHeater_status();
        this.name = heater.getName();
        this.roomid = heater.getRoom().getId();
        this.roomname = heater.getRoom().getName();
        this.power = heater.getPower();
    }

    public HeaterStatus getHeater_status() {
        return heater_status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPower() {
        return power;
    }

    public Long getRoomid() {
        return roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setHeater_status(HeaterStatus heater_status) {
        this.heater_status = heater_status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public void setPower(Long power) {
        this.power = power;
    }
}
