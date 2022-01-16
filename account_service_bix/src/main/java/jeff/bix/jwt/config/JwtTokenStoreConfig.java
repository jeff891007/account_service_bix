package jeff.bix.jwt.config;

import jeff.bix.jwt.enhancer.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author jeff
 */
@Configuration
public class JwtTokenStoreConfig {

    @Value("${bix.jwt-key}")
    private String bixJwtKey;

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new
                JwtAccessTokenConverter();
        //salt key for jeff.bix.jwt
        accessTokenConverter.setSigningKey(bixJwtKey);
        return accessTokenConverter;
    }

    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }
}
