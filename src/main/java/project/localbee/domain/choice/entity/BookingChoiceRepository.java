package project.localbee.domain.choice.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookingChoiceRepository extends JpaRepository<Booking_choice,Long> {
    @Query("SELECT bc.type FROM Booking_choice bc WHERE bc.booking.id = :id")
    List<ChoiceType> findChoiceTypesByBookingId(@Param("id") Long id);
}