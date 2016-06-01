package aisoai.screens.gamescreeens.doublepokemongame;

import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;

import java.util.ArrayList;

import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.titapplib.TITFunction;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;

public class DoublePokemonGameRF extends TITRequestFactory
{
    public void sendGameAnswer(int index,ArrayList<Integer> answerArr)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.INDEX,index);
        SFSArray answerSFSArray=TITFunction.covertToIntSFSArray(answerArr);
        toServerData.putInt(KJS.GAME_ID,2);
        toServerData.putSFSArray(KJS.PARAM1,answerSFSArray);
        ExtensionRequest request=new ExtensionRequest
                                            (CMDRQ.DOUBLEPOKEMONGAMEANSWER_RQ,toServerData,room);
        sendRequest(request);

    }
}
