package project.localbee.domain.user.entity;

import lombok.Getter;


@Getter
public enum RoleType {
    USER("ROLE_USER"),ADMIN("ROLE_ADMIN"),GUIDE("ROLE_GUIDE");

    private String key;

    RoleType(String key) {
        this.key = key;
    }
}
