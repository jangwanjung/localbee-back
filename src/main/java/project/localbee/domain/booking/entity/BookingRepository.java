package project.localbee.domain.booking.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.localbee.domain.user.dto.BookingListResDto;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT new project.localbee.domain.user.dto.BookingListResDto$BookingDetail (b.id, b.travel.title, b.time, b.personnel, b.travel.region) FROM Booking b WHERE b.user.id = :userId AND b.time >= CURRENT_DATE")
    List<BookingListResDto.BookingDetail> findUpcomingBookings(@Param("userId") Long userId);

    @Query("SELECT new project.localbee.domain.user.dto.BookingListResDto$BookingDetail (b.id, b.travel.title, b.time, b.personnel, b.travel.region) FROM Booking b WHERE b.user.id = :userId AND b.time < CURRENT_DATE")
    List<BookingListResDto.BookingDetail> findPastBookings(@Param("userId") Long userId);

}
