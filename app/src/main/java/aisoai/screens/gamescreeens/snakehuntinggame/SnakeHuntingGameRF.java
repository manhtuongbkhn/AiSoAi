package aisoai.screens.gamescreeens.snakehuntinggame;


import com.smartfoxserver.v2.entities.data.SFSObject;
import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;

import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;

public class SnakeHuntingGameRF extends TITRequestFactory
{
    public void sendGameAnswer(int index,boolean eated)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.INDEX,index);
        toServerData.putBool(KJS.PARAM1,eated);
        ExtensionRequest request=new ExtensionRequest
                                            (CMDRQ.SNAKEHUNTINGGAMEANSWER_RQ,toServerData,room);
        sendRequest(request);
    }
}
