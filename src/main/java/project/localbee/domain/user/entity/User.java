package project.localbee.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import project.localbee.domain.booking.entity.Booking;
import project.localbee.domain.travel.entity.Travel;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String phone_number;

    private String email;

    private String profile_image;

    @OneToMany
    @JsonIgnoreProperties({"user"})
    private List<Travel> travels;

    @OneToMany
    @JsonIgnoreProperties({"user"})
    private List<Booking> bookings;


    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @CreationTimestamp
    private Timestamp created_at;
}
