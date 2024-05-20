package com.cammate.service;

import com.cammate.domain.FindRoomDto;
import com.cammate.domain.MakeRoomDto;
import com.cammate.domain.Room;
import com.cammate.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    /**
     * 방 만들기
     */
    public Room makeRoom(MakeRoomDto makeRoomDto) {
        Room room = new Room();
        room.setNickname(makeRoomDto.getNickname());
        room.setMacAddress(makeRoomDto.getMacAddress());

        //ToDo: 비번 저장
        return roomRepository.saveRoom(room);
    }

    /**
     * 방 찾기
     */
    public List<Room> findRoom(FindRoomDto findRoomDto) {
        return roomRepository.findWithMacAddress(findRoomDto.getMacAddressList());
    }


    /**
     * 방 삭제
     */
    public Optional<Room> removeRoom(String id) {
        return roomRepository.removeRoomById(id);
    }


}
