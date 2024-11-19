package project.localbee.domain.auth.dto;

import lombok.Getter;

@Getter
public class CheckResDto {

    private int code;
    private String message;

    public CheckResDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
