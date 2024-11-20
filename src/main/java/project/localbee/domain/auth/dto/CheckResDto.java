package project.localbee.domain.auth.dto;

import lombok.Getter;

@Getter
public class CheckResDto {

    private String message;

    public CheckResDto(String message) {
        this.message = message;
    }
}
