package aisoai.screens.hometabscreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.requests.ExtensionRequest;

public class HomeTabRF extends TITRequestFactory
{
    public void cancelFriendListRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CANCELFRIENDLIST_RQ,data);
        sendRequest(request);
    }

    public void cancelRoomListRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CANCELROOMLIST_RQ,data);
        sendRequest(request);
    }

}
