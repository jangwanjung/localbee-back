package project.localbee.domain.option.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import project.localbee.domain.booking.entity.Booking;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Enumerated(EnumType.STRING)
    private OptionType type;

    @CreationTimestamp
    private Timestamp created_at;
}
