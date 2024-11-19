package project.localbee.domain.user.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.localbee.config.auth.LoginUserAnnotation;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.user.dto.UserProfileResDto;
import project.localbee.domain.user.entity.User;
import project.localbee.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user/profile")
    public UserProfileResDto userProfile(User user, @LoginUserAnnotation LoginUser loginUser) {
        System.out.println(loginUser.getId());
        return userService.userProfileSearch(loginUser.getId());
    }
}
