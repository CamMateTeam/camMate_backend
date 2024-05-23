package com.cammate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;

@Getter
public class FindRoomRequest {
    @Schema(description = "mac주소 리스트" , example = "[\"A\", \"B\", \"C\"]")
    List<String> macAddress;
}
