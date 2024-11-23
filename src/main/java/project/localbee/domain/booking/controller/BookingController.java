package project.localbee.domain.booking.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.localbee.domain.travel.service.TravelService;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BookingController {

    private final TravelService travelService;

    @GetMapping("/booking/{travelId}")
    public ResponseEntity<Map<String,Long>> bookingSubmit(@PathVariable("travelId") Long travelId) {
        return ResponseEntity.ok(Map.of("price",travelService.travelPriceSearch(travelId)));
    }
}
