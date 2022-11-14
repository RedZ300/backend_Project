package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface RoomDaoCustom {

    Room findRoomByName(String name);

    List<Window> getRelatedWindows(Long id);

    List<Heater> getRelatedHeaters(Long id);

}
