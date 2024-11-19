package project.localbee.config.dto;

import lombok.Data;
import project.localbee.domain.user.entity.User;

@Data
public class LoginUser {
    private Long id;
    private String email;
    private String role;

    public LoginUser(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.role = user.getRole().getKey();
    }

    public User getUser(){
        return User.builder()
                .id(id)
                .build();

    }
}