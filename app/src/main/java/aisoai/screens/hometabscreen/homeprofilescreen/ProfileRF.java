package aisoai.screens.hometabscreen.homeprofilescreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.KJS;
import sfs2x.client.requests.ExtensionRequest;
import aisoai.config.CMDRQ;
import aisoai.screens.titentities.TITRequestFactory;

public class ProfileRF extends TITRequestFactory
{
    public void userInfoRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.USERPROFILE_RQ,data);
        sendRequest(request);
    }

    public void challengeRequest(int gameId)
    {
        SFSObject data=new SFSObject();
        data.putInt(KJS.GAME_ID,gameId);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CHALLENGE_RQ,data);
        sendRequest(request);
    }

    public void cancelChallengeRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CANCEL_CHALLENGE_RQ,data);
        sendRequest(request);
    }

    public void xxxRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest("xxx",data);
        sendRequest(request);
    }
}
