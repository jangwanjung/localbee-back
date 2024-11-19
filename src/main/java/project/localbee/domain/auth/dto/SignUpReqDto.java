package project.localbee.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.localbee.domain.user.entity.RoleType;
import project.localbee.domain.user.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpReqDto {

    private String email;
    private String password;
    private String username;
    private String profileImage;
    private String phoneNumber;

    public User toEntity(){

        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .phone_number(phoneNumber)
                .profile_image("default")
                .role(RoleType.ADMIN)
                .build();
    }
}
