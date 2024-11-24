package project.localbee.domain.booking.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import project.localbee.config.auth.LoginUserAnnotation;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.booking.dto.BookingSubmitReqDto;
import project.localbee.domain.booking.dto.ReceiptResDto;
import project.localbee.domain.booking.service.BookingService;
import project.localbee.domain.travel.service.TravelService;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BookingController {

    private final TravelService travelService;
    private final BookingService bookingService;

    @GetMapping("/booking/{travelId}")
    public ResponseEntity<Map<String,Long>> bookingPage(@PathVariable("travelId") Long travelId) {
        return ResponseEntity.ok(Map.of("price",travelService.travelPriceSearch(travelId)));
    }

    @PostMapping("/booking/{travelId}")
    public MessageResDto bookingSubmit(@PathVariable("travelId") Long travelId
            , @RequestBody BookingSubmitReqDto bookingSubmitReqDto, @LoginUserAnnotation LoginUser loginUser) {
        return bookingService.CreateBooking(travelId, bookingSubmitReqDto, loginUser);
    }

    @GetMapping("/booking/receipt/{id}")
    public ReceiptResDto receiptPage(@PathVariable("id") Long id, @LoginUserAnnotation LoginUser loginUser) {

        return bookingService.receiptSearch(id, loginUser);
    }
}
