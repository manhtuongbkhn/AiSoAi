package aisoai.screens.insidetabscreen.insideroomscreen;

import java.util.ArrayList;

import aisoai.screens.insidetabscreen.insideroomscreen.invitation.InvitationFriendInfo;
import aisoai.screens.titentities.model.TITModel;

public class InsideRoomModel extends TITModel
{
    private ArrayList<PlayerInfo> playerArr=new ArrayList<PlayerInfo>();

    private ArrayList<InvitationFriendInfo> friendArr=new ArrayList<InvitationFriendInfo>();

    public ArrayList<PlayerInfo> getPlayerArr()
    {
        return playerArr;
    }

    public void setPlayerArr(ArrayList<PlayerInfo> playerArr)
    {
        this.playerArr = playerArr;
    }

    public ArrayList<InvitationFriendInfo> getFriendArr()
    {
        return friendArr;
    }

    public void setFriendArr(ArrayList<InvitationFriendInfo> friendArr)
    {
        this.friendArr = friendArr;
    }
}
