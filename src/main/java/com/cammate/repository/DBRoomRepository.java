package com.cammate.repository;

import com.cammate.domain.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByMacAddressIn(final List<String> macAddress);
}
