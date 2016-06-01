package aisoai.screens.insidetabscreen.insideroomscreen;

import com.smartfoxserver.v2.entities.data.SFSObject;

import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;
import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;

public class InsideRoomRF extends TITRequestFactory
{
    public void roomInfoRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.ROOMINFO_RQ,data,room);
        sendRequest(request);
    }

    public void insideRoomAllUserInfoInRoomRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.ALLPLAYERINFO_RQ,data,room);
        sendRequest(request);
    }

    public void changeGameRequest(int gameId)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        data.putInt(KJS.GAME_ID,gameId);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CHANGEGAME_RQ,data,room);
        sendRequest(request);
    }

    public void exitRoomRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.EXITROOM_RQ,data,room);
        sendRequest(request);
    }

    public void kickPlayerRequest(String userId,int systemUserId,String fullName)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        data.putUtfString(KJS.USER_ID,userId);
        data.putInt(KJS.SYSTEM_USER_ID,systemUserId);
        data.putUtfString(KJS.FULL_NAME,fullName);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.KICKPLAYER_RQ,data,room);
        sendRequest(request);
    }

    public void inviteFriendRequest(String userId,int systemUserId,String fullName)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        data.putUtfString(KJS.USER_ID,userId);
        data.putInt(KJS.SYSTEM_USER_ID,systemUserId);
        data.putUtfString(KJS.FULL_NAME,fullName);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.INVITEFRIEND_RQ,data,room);
        sendRequest(request);
    }

    public void startGameRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.STARTGAME_RQ,data,room);
        sendRequest(request);
    }

    public void invitationRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.INVITATION_RQ,data,room);
        sendRequest(request);
    }

    public void cancelInvitationRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject data=new SFSObject();
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CANCELINVITATION_RQ,data,room);
        sendRequest(request);
    }
}
