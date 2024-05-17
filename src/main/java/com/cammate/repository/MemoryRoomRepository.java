package com.cammate.repository;


import com.cammate.domain.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryRoomRepository implements RoomRepository {

    private static Map<String, Room> store = new HashMap<>();

    @Override
    public Room saveRoom(Room room) {
        store.put(room.getRoomId(), room);
        return room;
    }

    @Override
    public Optional<Room> findRoomById(String id) {
        System.out.println("store size is "+store.size());
        store.forEach(
                (key,val)-> {System.out.print(key); System.out.println(val);}
        );
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Room> findRoomByName(String nickname) {
        return store.values().stream().filter(room -> room.getNickname().equals(nickname)).findAny();
    }

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Room> findWithMacAddress(List<String> macAddressList) {

        return store.values().stream().filter(room -> macAddressList.contains(room.getMacAddress()))
                .collect(Collectors.toList());
    }

    public void clearStore(){
        store.clear();
    }
}
