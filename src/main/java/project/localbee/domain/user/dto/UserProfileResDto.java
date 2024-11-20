package project.localbee.domain.user.dto;

import lombok.Getter;
import lombok.Setter;
import project.localbee.domain.user.entity.User;

@Getter
@Setter
public class UserProfileResDto {

    private String username;
    private String phoneNumber;
    private String email;
    private String profileImage;

    public UserProfileResDto(String username, String phoneNumber, String email, String profileImage) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profileImage = profileImage;
    }
}
