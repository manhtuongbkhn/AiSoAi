package aisoai.screens.insidetabscreen.chatroomscreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;
import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;

public class ChatRoomRF extends TITRequestFactory
{
    public void allMessageInfoRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.ALLMESSAGEINFO_RQ,data,room);
        sendRequest(request);
    }

    public void sendMessageRequest(String messageContent)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        data.putUtfString(KJS.MESSAGE_CONTENT,messageContent);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.SENDMESSAGE_RQ,data,room);
        sendRequest(request);
    }

}
