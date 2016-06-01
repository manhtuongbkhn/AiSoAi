package aisoai.screens.titentities;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.gameservercommunicate.TITGameServerCommunicate;
import sfs2x.client.SmartFox;
import sfs2x.client.requests.ExtensionRequest;
import sfs2x.client.requests.IRequest;
import sfs2x.client.requests.LogoutRequest;

public class TITRequestFactory
{
    protected TITGameServerCommunicate serverCommunicate;

    public TITRequestFactory()
    {
        serverCommunicate= TITGameServerCommunicate.getDefaultGameServerCommunicate();
    }

    public void sendRequest(IRequest iRequest)
    {
        serverCommunicate.sendServer(iRequest);
    }

    protected SmartFox getSFSClient()
    {
       return serverCommunicate.getSFS();
    }

    public void connectRequest()
    {
        serverCommunicate.connectServer();
    }

    public void logoutRequest()
    {
        LogoutRequest logoutRequest=new LogoutRequest();
        sendRequest(logoutRequest);
    }

    public void disconnectServer()
    {
        serverCommunicate.disconnectServer();
    }

    public void invitationAnswerRequest
                            (String inviteUserFullName,int roomId,String inviteTime,boolean answer)
    {
        SFSObject data=new SFSObject();
        data.putUtfString(KJS.FULL_NAME,inviteUserFullName);
        data.putInt(KJS.ROOM_ID,roomId);
        data.putUtfString(KJS.TIME,inviteTime);
        data.putBool(KJS.RESULT,answer);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.INVITATIONANSWER_RQ,data);
        sendRequest(request);
    }

    public void reconnect()
    {

    }
}
