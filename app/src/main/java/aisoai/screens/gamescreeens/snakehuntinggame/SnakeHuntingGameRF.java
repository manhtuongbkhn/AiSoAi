package aisoai.screens.gamescreeens.snakehuntinggame;


import com.smartfoxserver.v2.entities.data.SFSObject;
import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;

import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;

public class SnakeHuntingGameRF extends TITRequestFactory
{
    public void eatAppleRequest(int index)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.INDEX,index);
        toServerData.putInt(KJS.GAME_ID,4);
        ExtensionRequest request=new ExtensionRequest
                                            (CMDRQ.SNAKEHUNTINGGAMEEATAPPLE_RQ,toServerData,room);
        sendRequest(request);
    }

    public void dieRequest()
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.GAME_ID,4);
        ExtensionRequest request=new ExtensionRequest
                (CMDRQ.SNAKEHUNTINGDIEANSWER_RQ,toServerData,room);
        sendRequest(request);
    }
}
