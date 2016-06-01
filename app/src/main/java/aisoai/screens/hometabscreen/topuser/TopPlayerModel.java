package aisoai.screens.hometabscreen.topuser;

import java.util.ArrayList;

import aisoai.screens.titentities.model.TITModel;

public class TopPlayerModel extends TITModel
{
    ArrayList<TopPlayerInfo> playerArr=new ArrayList<TopPlayerInfo>();

    public ArrayList<TopPlayerInfo> getPlayerArr()
    {
        return playerArr;
    }
}
