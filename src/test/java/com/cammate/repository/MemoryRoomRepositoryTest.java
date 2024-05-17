package com.cammate.repository;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.cammate.domain.Room;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemoryRoomRepositoryTest {
    public static final int TOTAL_ROOMS = 5;
    MemoryRoomRepository memoryRoomRepository = new MemoryRoomRepository();

    @AfterEach
    public void afterEach() {
        memoryRoomRepository.clearStore();
    }

    @BeforeEach
    public void setTestData() {
        for (int i = 1; i <= TOTAL_ROOMS; i++) {
            Room room = new Room();
            room.setRoomId(Integer.toString(i));
            room.setNickname("방" + i);
            room.setMacAddress("주소" + i);
            memoryRoomRepository.saveRoom(room);
        }
    }

    @Test
    void saveRoom() {
        Room room = new Room();
        room.setNickname("방7");
        room.setMacAddress("주소7");

        Room result = memoryRoomRepository.saveRoom(room);
        assertThat(result).isEqualTo(room);

    }

    @Test
    void findRoomById() {
        Room result = memoryRoomRepository.findRoomById("1").get();
        assertThat(result.getRoomId()).isEqualTo("1");
    }

    @Test
    void findRoomByName() {
        Room result = memoryRoomRepository.findRoomById("방2").get();
        assertThat(result.getRoomId()).isEqualTo("방2");
    }

    @Test
    void findAll() {
        List<Room> result = memoryRoomRepository.findAll();
        assertThat(result.size()).isEqualTo(TOTAL_ROOMS);
    }

    @Test
    void findWithMacAddress() {
        List<String> macAddressList = new ArrayList<>() {
            {
                add("주소1");
                add("주소3");
                add("주소5");
            }
        };
        Room room1 = new Room();
        room1.setRoomId("1");
        room1.setNickname("방1");
        room1.setMacAddress("주소1");

        Room room2 = new Room();
        room2.setRoomId("2");
        room2.setNickname("방2");
        room2.setMacAddress("주소2");

        Room room3 = new Room();
        room3.setRoomId("3");
        room3.setNickname("방3");
        room3.setMacAddress("주소3");

        List<Room> sample = new ArrayList<>();
        sample.add(room1);
        sample.add(room2);
        sample.add(room3);

        List<Room> result = memoryRoomRepository.findWithMacAddress(macAddressList);
        assertThat(result).extracting("macAddress").containsOnly("주소1", "주소3", "주소5");
    }

}