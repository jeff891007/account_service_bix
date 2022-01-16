package jeff.bix.jwt.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @author Jeff
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${bix.jwt-key}")
    private String bixJwtKey;

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication,
                                 HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = null;
        if(header!=null){
            token = header.substring(header.indexOf("bearer") + 7);
        }else {
            token = request.getParameter("access_token");
        }
        return Jwts.parser()
                .setSigningKey(bixJwtKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();

    }
}
