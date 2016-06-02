package aisoai.screens.gamescreeens.tetrisgame;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;

public class TetrisGameRF extends TITRequestFactory
{
    public void sendGameAnswer(int index,int fullItemRowCount)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.GAME_ID,5);
        toServerData.putInt(KJS.INDEX,index);
        toServerData.putInt(KJS.PARAM1,fullItemRowCount);
        ExtensionRequest request=new ExtensionRequest(CMDRQ.TETRISGAMEANSWER_RQ,toServerData,room);
        sendRequest(request);
    }
}
