package aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen;

import java.util.ArrayList;
import aisoai.screens.titentities.model.TITModel;

public class FriendListModel extends TITModel
{
    private ArrayList<FriendInfo> friendArr=new ArrayList<FriendInfo>();

    public ArrayList<FriendInfo> getFriendArr()
    {
        return friendArr;
    }

    public void setFriendArr(ArrayList<FriendInfo> friendArr)
    {
        this.friendArr = friendArr;
    }
}
