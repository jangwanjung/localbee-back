package project.localbee.domain.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import project.localbee.domain.option.Option;
import project.localbee.domain.travel.Travel;
import project.localbee.domain.user.User;

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

    private String Time;

    private String request;

    private Long price;

    @Enumerated(EnumType.STRING)
    private ApprovalType approval_type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JsonIgnoreProperties({"booking"})
    private List<Option> options;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @Transient
    private boolean is_Completed;

    @CreationTimestamp
    private Timestamp created_at;

}
