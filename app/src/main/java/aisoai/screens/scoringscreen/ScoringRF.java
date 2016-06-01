package aisoai.screens.scoringscreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.requests.ExtensionRequest;

public class ScoringRF extends TITRequestFactory
{
    public void backRoomFinishRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.BACKROOMFINISH_RQ,data);
        sendRequest(request);
    }

    public void exitRoomWhenFinishRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.EXITROOMFINISH_RQ,data);
        sendRequest(request);
    }
}
