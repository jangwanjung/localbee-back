package project.localbee.domain;

import lombok.Getter;

@Getter
public class MessageResDto {

    private String message;

    public MessageResDto(String message) {
        this.message = message;
    }
}
