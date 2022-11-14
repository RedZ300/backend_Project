package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;

public class BuildingDto {

    private Long id;

    private String name;

    private Integer FloorCount;

    private String adresse;

    public BuildingDto() {

    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.FloorCount = building.getFloorCount();
        this.name = building.getName();
        this.adresse = building.getAdress();
    }

    public void setFloorCount(Integer floorCount) {
        FloorCount = floorCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloorCount() {
        return FloorCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
