package project.localbee.domain.user.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.localbee.domain.user.dto.UserProfileResDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    @Query("SELECT new project.localbee.domain.user.dto.UserProfileResDto( u.username, u.phone_number, u.email, u.profile_image) FROM User u WHERE u.id = :id")
    UserProfileResDto findUserProfileById(@Param("id") Long id);

}
