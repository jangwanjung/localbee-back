package project.localbee.domain.user.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.localbee.config.auth.LoginUserAnnotation;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.user.dto.ChangePasswordReqDto;
import project.localbee.domain.user.dto.SignUpReqDto;
import project.localbee.domain.user.dto.BookingListResDto;
import project.localbee.domain.user.dto.UserProfileResDto;
import project.localbee.domain.user.service.UserService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public UserProfileResDto userProfile( @LoginUserAnnotation LoginUser loginUser) {
        return userService.userProfileSearch(loginUser.getId());
    }

    @GetMapping("/booking/planned-travels")
    public BookingListResDto bookingPlanedList( @LoginUserAnnotation LoginUser loginUser) {
        return userService.bookingPlannedListSearch(loginUser.getId());
    }

    @GetMapping("/booking/completed-travels")
    public BookingListResDto bookingCompletedList( @LoginUserAnnotation LoginUser loginUser) {
        return userService.bookingCompletedListSearch(loginUser.getId());
    }

    @PostMapping("/")
    public MessageResDto signUp(SignUpReqDto signUpReqDto) {
        return userService.createUser(signUpReqDto);
    }
    @PostMapping("/check")
    public MessageResDto check(@RequestBody Map<String, String> email) {

        return userService.checkUser(email.get("email"));
    }
    @GetMapping("/change/password")
    public ResponseEntity<Map<String,String>> changePassword(@LoginUserAnnotation LoginUser loginUser) {
        return ResponseEntity.ok(Map.of("phoneNumber",loginUser.getUser().getPhone_number()));
    }
    @PostMapping("/change/password")
    public MessageResDto changePasswordPost(@RequestBody ChangePasswordReqDto changePasswordReqDto, @LoginUserAnnotation LoginUser loginUser) {
        System.out.println(changePasswordReqDto);
        return userService.changePasswordRequest(changePasswordReqDto, loginUser);
    }

    @PostMapping("/verify_phone/check")
    public MessageResDto verifyPhone(@LoginUserAnnotation LoginUser loginUser, @RequestBody Map<String, String> verificationCode) {
        return userService.verifyPhoneCheck(loginUser.getPhoneNumber(), verificationCode.get("verificationCode"));
    }


}
