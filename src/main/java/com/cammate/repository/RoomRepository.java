package com.cammate.repository;

import com.cammate.domain.Room;
import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    //방 만들기. 찾기, 삭제
    Room saveRoom(Room room);

    Optional<Room> findRoomById(String id);

    Optional<Room> findRoomByName(String nickname);

    List<Room> findAll();

    List<Room> findWithMacAddress(List<String> macAddressList);

    Optional<Room> removeRoomById(String id);
}
