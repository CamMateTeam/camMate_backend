package com.cammate.service;

import com.cammate.domain.Room;
import com.cammate.dto.RoomRequest;
import com.cammate.repository.DBRoomRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final DBRoomRepository dbRoomRepository;

    public List<Room> findWithMacAddress(List<String> macAddress) {
        return dbRoomRepository.findByMacAddressIn(macAddress);
    }

    public Room saveRoom(RoomRequest roomRequest){
        Room room = new Room();
        room.setNickname(roomRequest.getNickname());
        room.setMacAddress(roomRequest.getMacAddress());
        room.setRoomCode(roomRequest.getPassword());
        return dbRoomRepository.save(room);
    }

    public Room deleteRoom(Long id){
        Room room = dbRoomRepository.findById(id).get();
        dbRoomRepository.delete(room);
        return room;
    }

}
