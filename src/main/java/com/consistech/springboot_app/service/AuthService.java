import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.consistech.springboot_app.config.JwtUtil;
import com.consistech.springboot_app.model.dto.LoginRequest;
import com.consistech.springboot_app.model.dto.UserResponse;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserResponse userRepository;

    public String authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePas(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            )
        );
        
        return jwtUtil.generateToken(authentication.getName());
    }
}