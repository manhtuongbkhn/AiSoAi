package aisoai.screens.signinscreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import sfs2x.client.requests.LoginRequest;
import aisoai.config.KJS;
import aisoai.config.ServerConfig;
import aisoai.screens.titentities.TITRequestFactory;

public class SignInRF extends TITRequestFactory
{
    public void loginRequest(String facebookId,String accessToken)
    {
        SFSObject data=new SFSObject();
        data.putUtfString(KJS.ACCESS_TOKEN,accessToken);
        LoginRequest request=new LoginRequest(facebookId,"",ServerConfig.ZONE_DEFAULT,data);
        sendRequest(request);
    }
}
