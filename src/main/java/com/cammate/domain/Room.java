package com.cammate.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Room {
    private String roomId;
    private String nickname;
    private String macAddress;
    private String roomCode;
    private Date createdAt;
    private Date deletedAt;
}
