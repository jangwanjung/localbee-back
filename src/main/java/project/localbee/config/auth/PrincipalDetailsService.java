package project.localbee.config.auth;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.user.entity.User;
import project.localbee.domain.user.entity.UserRepository;

import java.util.function.Function;


@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username).
                map(new Function<User, User>() {
                    @Override
                    public User apply(User t) {
                        session.setAttribute("loginUser", new LoginUser(t));
                        return t;
                    }
                })
                .orElse(null);

        return new PrincipalDetails(userEntity);
    }

}
