package project.localbee.domain.user.Controller;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.web.bind.annotation.*;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import org.springframework.beans.factory.annotation.Value;
import project.localbee.config.auth.LoginUserAnnotation;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.user.entity.Verification;
import project.localbee.domain.user.entity.VerificationRepository;

import java.util.Random;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class SMSApiController {

    private DefaultMessageService messageService;
    private final VerificationRepository verificationRepository;

    @Value("${sms.apikey}")
    private String apiKey;

    @Value("${sms.api_secret_key}")
    private String apiSecretKey;

    @PostConstruct
    private void MassageContra() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecretKey, "https://api.coolsms.co.kr");

    }
    /**
     * 단일 메시지 발송 예제
     */
    @PostMapping("/user/verify_phone/send_sms")
    public MessageResDto sendOne(@LoginUserAnnotation LoginUser loginUser) {
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01099858941");
        message.setTo(loginUser.getPhoneNumber());
        String numStr="";
        for(int i=0; i<6; i++) {
            Random random = new Random();
            String ran = Integer.toString(random.nextInt(10));
            numStr+=ran;
        }
        System.out.println(numStr);
        message.setText("인증번호는 ["+numStr+"] 입니다.");
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);
        Verification verification = Verification.builder()
                .phoneNumber(loginUser.getPhoneNumber())
                .verificationCode(numStr)
                .build();
        verificationRepository.save(verification);

        return new MessageResDto("전화번호 인증 요청 성공");
    }


}