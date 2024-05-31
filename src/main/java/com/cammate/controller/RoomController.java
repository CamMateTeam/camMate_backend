package com.cammate.controller;

import com.cammate.domain.Room;
import com.cammate.dto.FindRoomRequest;
import com.cammate.dto.RoomRequest;
import com.cammate.global.ApiResponse;
import com.cammate.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @Operation(summary = "방 정보 저장 API")
    @PostMapping
    public ApiResponse<Room> saveRoom(@RequestBody RoomRequest roomRequest) {
        Room room = roomService.saveRoom(roomRequest);
        return ApiResponse.createSuccess(room);
    }

    @Operation(summary = "방 삭제 API")
    @DeleteMapping("/{id}")
    public ApiResponse<Room> deleteRoom(@PathVariable Long id) {
        Room room = roomService.deleteRoom(id);
        return ApiResponse.createSuccess(room);
    }

    @Operation(summary = "주변 방 조회 API")
    @GetMapping
    public ApiResponse<List<Room>> findRoom(@RequestParam List<String> macAddress){
        List<Room> room = roomService.findRoom();
        return ApiResponse.createSuccess(room);
    }


}
