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

    private String username;
    private String password;
    public User toEntity(){

        return User.builder()
                .username(username)
                .password(password)
                .role(RoleType.ADMIN)
                .build();
    }
}
