package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao){
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
    }

    @GetMapping
    public List<BuildingDto> findAll(){
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto find(@PathVariable Long id){
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }

    @GetMapping(path = "/rooms/{id}")
    public List<RoomDto> getRooms(@PathVariable Long id){
        return  buildingDao.GetRelatedRooms(id).stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/windows/{id}")
    public List<WindowDto> getWindows(@PathVariable Long id){
        List<WindowDto> windowDtos = new ArrayList<>();
        for(Room room: buildingDao.GetRelatedRooms(id)){
            windowDtos.addAll(room.getWindows().stream().map(WindowDto::new).collect(Collectors.toList()));
        }
        return windowDtos;
    }

    @GetMapping(path = "/heaters/{id}")
    public List<HeaterDto> getHeaters(@PathVariable Long id){
        List<HeaterDto> heaterDtos = new ArrayList<>();
        for(Room room: buildingDao.GetRelatedRooms(id)){
            heaterDtos.addAll(room.getHeaters().stream().map(HeaterDto::new).collect(Collectors.toList()));
        }
        return heaterDtos;
    }

    @PostMapping
    public BuildingDto createOrUpdate(@RequestBody BuildingDto dto){

        Building building = null;
        if(dto.getId() == null){
            building = buildingDao.save(new Building(dto.getFloorCount(), dto.getName(), dto.getAdresse()));
        } else {
            building = buildingDao.getReferenceById(dto.getId());
            building.setAdress(dto.getAdresse());
            building.setName(dto.getName());
            building.setFloorCount(dto.getFloorCount());
        }

        return new BuildingDto(building);
    }



    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        Building building = buildingDao.getReferenceById(id);
        if(building!=null){
            for(Room room : building.getRooms()){
                Long roomid = room.getId();

                windowDao.deleteByRoom(roomid);
                heaterDao.deleteByRoom(roomid);
                roomDao.deleteById(roomid);
            }
        }

    }

}
