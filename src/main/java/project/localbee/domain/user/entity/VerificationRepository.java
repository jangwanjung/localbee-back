package project.localbee.domain.user.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification, Long> {
    Verification findTopByPhoneNumberOrderByIdDesc(String phoneNumber);
}
