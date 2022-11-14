package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    private final BuildingDao buildingDao;

    public RoomController(RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao, BuildingDao buildingDao){
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<RoomDto> findAll(){
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto find(@PathVariable Long id){
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @GetMapping(path = "/heaters/{id}")
    public List<HeaterDto> getHeaters(@PathVariable Long id){
        return roomDao.getRelatedHeaters(id).stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/windows/{id}")
    public List<WindowDto> getWindows(@PathVariable Long id){
        return roomDao.getRelatedWindows(id).stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto){

        Building building = buildingDao.getById(dto.getBuildingId());
        Room room = null;
        if(dto.getId() == null){
            room = roomDao.save(new Room(dto.getName(),dto.getFloor(), dto.getCurrent_temperature(), dto.getTarget_temperature(),building));
        } else {
            room = roomDao.getReferenceById(dto.getId());
            room.setFloor(dto.getFloor());
            room.setCurrent_temperature(dto.getCurrent_temperature());
            room.setTarget_temperature(dto.getTarget_temperature());
            room.setName(dto.getName());
        }

        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        windowDao.deleteByRoom(id);
        heaterDao.deleteByRoom(id);
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switchWindow")
    public void switchWindows(@PathVariable Long id){
        for (Window w: roomDao.getRelatedWindows(id)){
            if(w.getWindowStatus() == WindowStatus.OPEN){
                w.setWindowStatus(WindowStatus.CLOSED);
            } else {
                w.setWindowStatus(WindowStatus.OPEN);
            }
        }
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public void switchHeaters(@PathVariable Long id){

        for (Heater h: roomDao.getRelatedHeaters(id)){
            if(h.getHeater_status() == HeaterStatus.OFF){
                h.setHeater_status(HeaterStatus.ON);
            } else {
                h.setHeater_status(HeaterStatus.OFF);
            }
        }
    }
}
