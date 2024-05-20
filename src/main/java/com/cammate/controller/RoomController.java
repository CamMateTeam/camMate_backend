package com.cammate.controller;

import com.cammate.domain.FindRoomDto;
import com.cammate.domain.MakeRoomDto;
import com.cammate.domain.Room;
import com.cammate.service.RoomService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("room")
@Controller
public class RoomController {
    private RoomService roomService;

    @PostMapping("/")
    public Room makeRoom(@RequestBody MakeRoomDto makeRoomDto) {
        return roomService.makeRoom(makeRoomDto);
    }

    @GetMapping("/")
    public List<Room> getRoom(@RequestBody FindRoomDto findRoomDto) {
        return roomService.findRoom(findRoomDto);
    }

    @DeleteMapping("/")
    public void deleteRoom(@RequestParam("id") String id) {
        roomService.removeRoom(id);
    }

}
