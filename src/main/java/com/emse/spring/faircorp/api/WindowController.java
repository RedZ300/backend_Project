package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/window")
@Transactional
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public WindowDto getById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null);
    }

    @PostMapping
    public WindowDto UpdateOrCreateWindow(@RequestBody WindowDto dto) {

        Room room = roomDao.getById(dto.getRoomId());
        Window window = null;
        if(dto.getId() == null){
            window = windowDao.save(new Window(dto.getName(), dto.getWindow_status(), room));
        } else {
            window = windowDao.getReferenceById(dto.getId());
            window.setWindowStatus(dto.getWindow_status());
            window.setName(dto.getName());
        }
        return new WindowDto(window);
    }

    @PutMapping
    public WindowDto UpdateWindow(@RequestBody WindowDto dto){

        Window window = null;
        window = windowDao.getReferenceById(dto.getId());
        window.setWindowStatus(dto.getWindow_status());
        window.setName(dto.getName());

        return new WindowDto(window);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        windowDao.deleteById(id);
    }
}
