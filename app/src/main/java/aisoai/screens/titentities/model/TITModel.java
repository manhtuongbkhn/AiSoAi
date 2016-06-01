package aisoai.screens.titentities.model;


import com.google.gson.JsonObject;

public class TITModel
{
    protected JsonObject fromServerData;

    public JsonObject getFromServerData()
    {
        return fromServerData;
    }

    public void setFromServerData(JsonObject fromServerData)
    {
        this.fromServerData = fromServerData;
    }
}
