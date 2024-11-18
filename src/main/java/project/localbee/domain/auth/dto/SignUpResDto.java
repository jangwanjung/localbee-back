package project.localbee.domain.auth.dto;

import lombok.Getter;

@Getter
public class SignUpResDto {

    private int code;
    private String message;

    public SignUpResDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
