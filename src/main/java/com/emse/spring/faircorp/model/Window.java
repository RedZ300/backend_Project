package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WindowStatus window_status;


    @ManyToOne(optional = false)
    private Room room;

    public Window() {

    }

    public Window(String name, WindowStatus status, Room room) {
        this.window_status = status;
        this.name = name;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public WindowStatus getWindowStatus() {
        return window_status;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.window_status = windowStatus;
    }

}
