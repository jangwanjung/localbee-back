package project.localbee.config.dto;

import lombok.Data;
import project.localbee.domain.user.entity.User;

@Data
public class LoginUser {
    private Long id;
    private String email;
    private String role;
    private String phoneNumber;

    public LoginUser(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.role = user.getRole().getKey();
        this.phoneNumber = user.getPhone_number();
    }

    public User getUser(){
        return User.builder()
                .id(id)
                .phone_number(phoneNumber)
                .build();

    }
}