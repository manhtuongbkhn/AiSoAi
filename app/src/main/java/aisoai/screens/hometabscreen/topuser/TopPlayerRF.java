package aisoai.screens.hometabscreen.topuser;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.requests.ExtensionRequest;

public class TopPlayerRF extends TITRequestFactory
{
    public void topPlayerRequest()
    {
        //System.out.println("-Top Player Request");
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.TOP_PLAYER_RQ,data);
        sendRequest(request);
    }

    public void cancelTopPlayerRequest()
    {
        //System.out.println("-Cancel Top Player Request");
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CANCEL_TOP_PLAYER_RQ,data);
        sendRequest(request);
    }
}
