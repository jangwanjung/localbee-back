package project.localbee.config.dto;

import lombok.Data;
import project.localbee.domain.user.entity.User;

@Data
public class LoginUser {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String role;
    private String provider;
    private String providerId;

    public LoginUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole().getKey();
    }

    public User getUser(){
        return User.builder()
                .build();

    }
}