package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

public class WindowDto {

    private Long id;
    private String name;
    private WindowStatus window_status;
    private String roomName;
    private Long roomId;

    public WindowDto() {

    }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.window_status = window.getWindowStatus();
        this.roomName = window.getRoom().getName();
        this.roomId = window.getRoom().getId();
    }

    public Long getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public Long getId() {
        return id;
    }

    public WindowStatus getWindow_status() {
        return window_status;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setWindow_status(WindowStatus window_status) {
        this.window_status = window_status;
    }
}
