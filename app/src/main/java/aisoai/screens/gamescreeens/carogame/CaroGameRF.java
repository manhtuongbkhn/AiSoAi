package aisoai.screens.gamescreeens.carogame;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;

public class CaroGameRF extends TITRequestFactory
{
    public void tickRequest(int row,int column)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.GAME_ID,1);
        toServerData.putInt(KJS.PARAM1,row);
        toServerData.putInt(KJS.PARAM2, column);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.CAROGAME_TICK_RQ,toServerData,room);
        sendRequest(request);
    }
}
