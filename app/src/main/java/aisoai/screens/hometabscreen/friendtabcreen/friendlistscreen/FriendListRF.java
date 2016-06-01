package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.requests.ExtensionRequest;

public class FriendListRF extends TITRequestFactory
{
    public void friendListRequest()
    {
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.FRIENDLIST_RQ,data);
        sendRequest(request);
    }

    public void cancelFriendListRequest()
    {
        System.out.println("-Cancel Friend List");
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CANCELFRIENDLIST_RQ,data);
        sendRequest(request);
    }
}
