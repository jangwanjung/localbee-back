package project.localbee.domain.auth.dto;

import lombok.Getter;

@Getter
public class SignUpResDto {

    private String message;

    public SignUpResDto(String message) {
        this.message = message;
    }
}
