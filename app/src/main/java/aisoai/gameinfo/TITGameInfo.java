package aisoai.gameinfo;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.KJS;

public class TITGameInfo
{
    private int gameId;
    private String gameName;
    private int playerMax;
    private String gameGuide;

    public int getGameId()
    {
        return this.gameId;
    }

    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    public String getGameName()
    {
        return this.gameName;
    }

    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }

    public int getPlayerMax()
    {
        return playerMax;
    }

    public void setPlayerMax(int playerMax)
    {
        this.playerMax = playerMax;
    }

    public String getGameGuide()
    {
        return this.gameGuide;
    }

    public void setGameGuide(String gameGuide)
    {
        this.gameGuide = gameGuide;
    }

    public SFSObject toSFSObject()
    {
        SFSObject sfsObject = new SFSObject();
        sfsObject.putInt(KJS.GAME_ID,gameId);
        sfsObject.putUtfString(KJS.GAME_NAME,gameName);
        return sfsObject;
    }
}