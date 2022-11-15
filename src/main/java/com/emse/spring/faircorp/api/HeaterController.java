package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import org.springframework.http.HttpHeaders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

        public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public HeaterDto getById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    @PostMapping
    public HeaterDto UpdateOrCreateWindow(@RequestBody HeaterDto dto) {

        Room room = roomDao.getById(dto.getRoomid());
        Heater heater = null;
        if(dto.getId() == null){
            Long id = heaterDao.findAll().stream().max(Comparator.comparing(heater1 -> heater1.getId())).get().getId();
            heater = heaterDao.save(new Heater(id+1,dto.getName(), dto.getHeater_status(), room));
        } else {
            heater = heaterDao.getReferenceById(dto.getId());
            heater.setHeater_status(dto.getHeater_status());
            heater.setName(dto.getName());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        heaterDao.deleteById(id);
    }
}
