package aisoai.screens.hometabscreen.roomlistscreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import sfs2x.client.requests.ExtensionRequest;
import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;

public class RoomListRF extends TITRequestFactory
{
    public void roomListRequest(int gameId,String roomName)
    {
        SFSObject toServerData=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.ROOMLIST_RQ,toServerData);
        toServerData.putInt(KJS.GAME_ID,gameId);
        toServerData.putUtfString(KJS.ROOM_NAME,roomName);
        sendRequest(request);
    }

    public void cancelRoomListRequest()
    {
        //System.out.println("-Cancel Room List");
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CANCELROOMLIST_RQ,data);
        sendRequest(request);
    }


    public void joinRoomRequest(int roomId,String roomName,String roomPass)
    {
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.ROOM_ID,roomId);
        toServerData.putUtfString(KJS.ROOM_NAME,roomName);
        toServerData.putUtfString(KJS.ROOM_PASS,roomPass);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.JOINROOM_RQ,toServerData);
        sendRequest(request);
    }

    public void createRoomRequest(String roomInvite,String roomPass,int gameId,int roomAvatar)
    {
        SFSObject data=new SFSObject();
        data.putUtfString(KJS.ROOM_INVITE,roomInvite);
        data.putUtfString(KJS.ROOM_PASS,roomPass);
        data.putInt(KJS.GAME_ID,gameId);
        data.putInt(KJS.ROOM_AVATAR,roomAvatar);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CREATEROOM_RQ,data);
        sendRequest(request);
    }
}
