package project.localbee.domain.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import project.localbee.domain.choice.entity.Booking_choice;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.user.entity.User;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String time;

    private String request;

    private Long price;

    @Enumerated(EnumType.STRING)
    private ApprovalType approval_type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"booking"})
    private List<Booking_choice> choices;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @Transient
    private boolean is_Completed;

    @CreationTimestamp
    private Timestamp created_at;

}
