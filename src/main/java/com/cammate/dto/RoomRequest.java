package com.cammate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class RoomRequest {
    @Schema(description = "사용자 닉네임" , example = "yeon")
    private String nickname;
    @Schema(description = "방 비밀번호" , example = "password")
    private String password;
    @Schema(description = "macAddress" , example = "1234")
    private String macAddress;
}
