package project.localbee.domain.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.localbee.domain.booking.entity.BookingRepository;

@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

}
