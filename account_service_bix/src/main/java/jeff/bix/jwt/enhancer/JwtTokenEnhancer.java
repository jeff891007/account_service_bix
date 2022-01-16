package jeff.bix.jwt.enhancer;

import jeff.bix.account.model.Account;
import jeff.bix.jwt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jeff
 * enhancer for jeff.bix.jwt
 */
public class JwtTokenEnhancer implements TokenEnhancer {
    @Autowired
    UserDao usrDao;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();
        info.put("enhance", "enhance info");
        String userName = ((User)authentication.getPrincipal()).getUsername();
        if(null != userName && !"".equals(userName)){
            Account account = usrDao.getDetailByAccont(userName);
            info.put("account", account);
        }

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}