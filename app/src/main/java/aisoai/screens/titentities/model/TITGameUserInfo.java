package aisoai.screens.titentities.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;

import aisoai.config.KJS;

public class TITGameUserInfo
{
    protected int totalMatchCount;
    protected int totalWinMatchCount;
    protected int totalWinPercent;

    protected int totalNormalMatchCount;
    protected int totalNormalWinMatchCount;
    protected int totalNormalWinPercent;

    protected int totalRankMatchCount;
    protected int totalRankWinMatchCount;
    protected int totalRankWinPercent;

    protected ArrayList<TITGameMaturity> gameMaturityArr;

    public TITGameUserInfo(JsonObject jsonObject)
    {
        gameMaturityArr=new ArrayList<TITGameMaturity>();
        totalMatchCount=jsonObject.get(KJS.TOTAL_MATCH_COUNT).getAsInt();
        totalWinMatchCount=jsonObject.get(KJS.TOTAL_WIN_MATCH_COUNT).getAsInt();
        totalWinPercent=jsonObject.get(KJS.TOTAL_WIN_PERCENT).getAsInt();

        totalNormalMatchCount=jsonObject.get(KJS.TOTAL_NORMAL_MATCH_COUNT).getAsInt();
        totalNormalWinMatchCount=jsonObject.get(KJS.TOTAL_NORMAL_WIN_MATCH_COUNT).getAsInt();
        totalNormalWinPercent=jsonObject.get(KJS.TOTAL_NORMAL_WIN_PERCENT).getAsInt();

        totalRankMatchCount=jsonObject.get(KJS.TOTAL_RANK_MATCH_COUNT).getAsInt();
        totalRankWinMatchCount=jsonObject.get(KJS.TOTAL_RANK_WIN_MATCH_COUNT).getAsInt();
        totalRankWinPercent=jsonObject.get(KJS.TOTAL_RANK_WIN_PERCENT).getAsInt();

        JsonArray jsonArray=jsonObject.get(KJS.GAME_MATURITY_ARR).getAsJsonArray();

        for(int i=0;i<jsonArray.size();i++)
        {
            JsonObject gameMaturityJsonObject=jsonArray.get(i).getAsJsonObject();
            TITGameMaturity gameMaturity=new TITGameMaturity(gameMaturityJsonObject);
            gameMaturityArr.add(gameMaturity);
        }
    }

    public int getTotalMatchCount()
    {
        return totalMatchCount;
    }

    public void setTotalMatchCount(int totalMatchCount)
    {
        this.totalMatchCount = totalMatchCount;
    }

    public int getTotalWinMatchCount()
    {
        return totalWinMatchCount;
    }

    public void setTotalWinMatchCount(int totalWinMatchCount)
    {
        this.totalWinMatchCount = totalWinMatchCount;
    }

    public int getTotalWinPercent()
    {
        return totalWinPercent;
    }

    public void setTotalWinPercent(int totalWinPercent)
    {
        this.totalWinPercent = totalWinPercent;
    }

    public int getTotalNormalMatchCount()
    {
        return totalNormalMatchCount;
    }

    public void setTotalNormalMatchCount(int totalNormalMatchCount)
    {
        this.totalNormalMatchCount = totalNormalMatchCount;
    }

    public int getTotalNormalWinMatchCount()
    {
        return totalNormalWinMatchCount;
    }

    public void setTotalNormalWinMatchCount(int totalNormalWinMatchCount)
    {
        this.totalNormalWinMatchCount = totalNormalWinMatchCount;
    }

    public int getTotalNormalWinPercent()
    {
        return totalNormalWinPercent;
    }

    public void setTotalNormalWinPercent(int totalNormalWinPercent)
    {
        this.totalNormalWinPercent = totalNormalWinPercent;
    }

    public int getTotalRankMatchCount()
    {
        return totalRankMatchCount;
    }

    public void setTotalRankMatchCount(int totalRankMatchCount)
    {
        this.totalRankMatchCount = totalRankMatchCount;
    }

    public int getTotalRankWinMatchCount()
    {
        return totalRankWinMatchCount;
    }

    public void setTotalRankWinMatchCount(int totalRankWinMatchCount)
    {
        this.totalRankWinMatchCount = totalRankWinMatchCount;
    }

    public int getTotalRankWinPercent()
    {
        return totalRankWinPercent;
    }

    public void setTotalRankWinPercent(int totalRankWinPercent)
    {
        this.totalRankWinPercent = totalRankWinPercent;
    }

    public ArrayList<TITGameMaturity> getGameMaturityArr()
    {
        return gameMaturityArr;
    }

    public void setGameMaturityArr(ArrayList<TITGameMaturity> gameMaturityArr)
    {
        this.gameMaturityArr = gameMaturityArr;
    }

    public TITGameMaturity getGameMaturity(int gameId)
    {
        return gameMaturityArr.get(gameId-1);
    }
}
