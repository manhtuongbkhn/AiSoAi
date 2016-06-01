package aisoai.screens.hometabscreen.roomlistscreen;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import aisoai.screens.titentities.model.TITModel;

public class RoomListModel extends TITModel
{
    private int defaultGameId=1;

    private ArrayList<JsonObject> roomArr=new ArrayList<JsonObject>();

    public ArrayList<JsonObject> getRoomArr()
    {
        return roomArr;
    }

    public void setRoomArr(ArrayList<JsonObject> roomArr)
    {
        this.roomArr = roomArr;
    }

    public int getDefaultGameId()
    {
        return defaultGameId;
    }

    public void setDefaultGameId(int defaultGameId)
    {
        this.defaultGameId = defaultGameId;
    }
}
