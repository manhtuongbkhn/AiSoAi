package aisoai.screens.titentities.model;

import com.google.gson.JsonObject;

import aisoai.config.KJS;

public class TITGameMaturity
{
    protected int gameId;

    protected int normalMatchCount;
    protected int normalWinMatchCount;
    protected int normalWinPercent;

    protected int rankMatchCount;
    protected int rankWinMatchCount;
    protected int rankWinPercent;

    protected int gameMatchCount;
    protected int gameWinMatchCount;
    protected int gameWinPercent;

    protected int experiencePoint;
    protected int rankPoint;
    protected int rank;
    protected int afkMatchCount;

    public TITGameMaturity(JsonObject jsonObject)
    {
        gameId=jsonObject.get(KJS.GAME_ID).getAsInt();

        normalMatchCount=jsonObject.get(KJS.NORMAL_MATCH_COUNT).getAsInt();
        normalWinMatchCount=jsonObject.get(KJS.NORMAL_WIN_MATCH_COUNT).getAsInt();
        normalWinPercent=jsonObject.get(KJS.NORMAL_WIN_PERCENT).getAsInt();

        rankMatchCount=jsonObject.get(KJS.RANK_MATCH_COUNT).getAsInt();
        rankWinMatchCount=jsonObject.get(KJS.RANK_WIN_MATCH_COUNT).getAsInt();
        rankWinPercent=jsonObject.get(KJS.RANK_WIN_PERCENT).getAsInt();

        gameMatchCount=jsonObject.get(KJS.GAME_MATCH_COUNT).getAsInt();
        gameWinMatchCount=jsonObject.get(KJS.GAME_WIN_MATCH_COUNT).getAsInt();
        gameWinPercent=jsonObject.get(KJS.GAME_WIN_PERCENT).getAsInt();

        experiencePoint=jsonObject.get(KJS.EXPERIENCE_POINT).getAsInt();
        rankPoint=jsonObject.get(KJS.RANK_POINT).getAsInt();
        rank=jsonObject.get(KJS.RANK).getAsInt();
        afkMatchCount=jsonObject.get(KJS.AFK_MATCH_COUNT).getAsInt();
    }

    public int getGameId()
    {
        return gameId;
    }

    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    public int getNormalMatchCount()
    {
        return normalMatchCount;
    }

    public void setNormalMatchCount(int normalMatchCount)
    {
        this.normalMatchCount = normalMatchCount;
    }

    public int getNormalWinMatchCount()
    {
        return normalWinMatchCount;
    }

    public void setNormalWinMatchCount(int normalWinMatchCount)
    {
        this.normalWinMatchCount = normalWinMatchCount;
    }

    public int getNormalWinPercent()
    {
        return normalWinPercent;
    }

    public void setNormalWinPercent(int normalWinPercent)
    {
        this.normalWinPercent = normalWinPercent;
    }

    public int getRankMatchCount()
    {
        return rankMatchCount;
    }

    public void setRankMatchCount(int rankMatchCount)
    {
        this.rankMatchCount = rankMatchCount;
    }

    public int getRankWinMatchCount()
    {
        return rankWinMatchCount;
    }

    public void setRankWinMatchCount(int rankWinMatchCount)
    {
        this.rankWinMatchCount = rankWinMatchCount;
    }

    public int getGameMatchCount()
    {
        return gameMatchCount;
    }

    public void setGameMatchCount(int gameMatchCount)
    {
        this.gameMatchCount = gameMatchCount;
    }

    public int getRankWinPercent()
    {
        return rankWinPercent;
    }

    public void setRankWinPercent(int rankWinPercent)
    {
        this.rankWinPercent = rankWinPercent;
    }

    public int getGameWinMatchCount()
    {
        return gameWinMatchCount;
    }

    public void setGameWinMatchCount(int gameWinMatchCount)
    {
        this.gameWinMatchCount = gameWinMatchCount;
    }

    public int getGameWinPercent()
    {
        return gameWinPercent;
    }

    public void setGameWinPercent(int gameWinPercent)
    {
        this.gameWinPercent = gameWinPercent;
    }

    public int getExperiencePoint()
    {
        return experiencePoint;
    }

    public void setExperiencePoint(int experiencePoint)
    {
        this.experiencePoint = experiencePoint;
    }

    public int getRankPoint()
    {
        return rankPoint;
    }

    public void setRankPoint(int rankPoint)
    {
        this.rankPoint = rankPoint;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public int getAfkMatchCount()
    {
        return afkMatchCount;
    }

    public void setAfkMatchCount(int afkMatchCount)
    {
        this.afkMatchCount = afkMatchCount;
    }
}
