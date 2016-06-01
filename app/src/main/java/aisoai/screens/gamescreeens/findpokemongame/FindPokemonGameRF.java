package aisoai.screens.gamescreeens.findpokemongame;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.config.KJS;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;

public class FindPokemonGameRF extends TITRequestFactory
{
    public void sendGameAnswer(int index,int answerRow,int answerColumn)
    {
        Room room=getSFSClient().getLastJoinedRoom();
        SFSObject toServerData=new SFSObject();
        toServerData.putInt(KJS.INDEX,index);
        toServerData.putInt(KJS.GAME_ID,2);
        toServerData.putInt(KJS.PARAM1,answerRow);
        toServerData.putInt(KJS.PARAM2,answerColumn);
        ExtensionRequest request=new ExtensionRequest
                                            (CMDRQ.FINDPOKEMONGAMEANSWER_RQ,toServerData,room);
        sendRequest(request);
    }
}
