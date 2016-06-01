package aisoai.gameinfo;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;

import java.util.ArrayList;

public class TITGameInfoFactory
{
    private static ArrayList<Integer> allGameIdArr = new ArrayList();
    private static ArrayList<Integer> freeGameIdArr=new ArrayList<Integer>();
    private static ArrayList<TITGameInfo> allGameInfoArr = new ArrayList();
    private static SFSArray allGameInfoSFSArr = new SFSArray();

    public static void init()
    {
        allGameIdArr.add(1);
        allGameIdArr.add(2);
        allGameIdArr.add(3);
        allGameIdArr.add(4);
        allGameIdArr.add(5);
        freeGameIdArr=allGameIdArr;
        allGameInfoArr = TITGameInfoFactory.
                covertGameIdArrToGameInfoArr(allGameIdArr);
        allGameInfoSFSArr = TITGameInfoFactory.
                covertGameIdArrToGameInfoSFSArr(allGameIdArr);
    }

    public static TITGameInfo covertGameIdToGameInfo(int gameId)
    {
        TITGameInfo titGameInfo = new TITGameInfo();
        switch (gameId)
        {
            case 1:
                titGameInfo.setGameId(gameId);
                titGameInfo.setGameName("Caro Game");
                titGameInfo.setPlayerMax(2);
                titGameInfo.setGameGuide("");
                break;
            case 2:
                titGameInfo.setGameId(gameId);
                titGameInfo.setGameName("Find Pokemon");
                titGameInfo.setPlayerMax(1);
                titGameInfo.setGameGuide("");
                break;
            case 3:
                titGameInfo.setGameId(gameId);
                titGameInfo.setGameName("Double Pokemon");
                titGameInfo.setPlayerMax(1);
                titGameInfo.setGameGuide("");
                break;
            case 4:
                titGameInfo.setGameId(gameId);
                titGameInfo.setGameName("Snake Hunting");
                titGameInfo.setPlayerMax(1);
                titGameInfo.setGameGuide("");
                break;
            case 5:
                titGameInfo.setGameId(gameId);
                titGameInfo.setGameName("Tetris");
                titGameInfo.setPlayerMax(1);
                titGameInfo.setGameGuide("");
                break;
            default:
                return null;
        }
        return titGameInfo;
    }

    public static ArrayList<TITGameInfo> covertGameIdArrToGameInfoArr(ArrayList<Integer> gameIdArr)
    {
        ArrayList<TITGameInfo> gameInfoArr = new ArrayList<TITGameInfo>();
        for (int i = 0; i < gameIdArr.size(); ++i) {
            int gameId = gameIdArr.get(i);
            TITGameInfo gameInfo = TITGameInfoFactory.covertGameIdToGameInfo(gameId);
            gameInfoArr.add(gameInfo);
        }
        return gameInfoArr;
    }

    public static SFSArray covertGameIdArrToGameInfoSFSArr(ArrayList<Integer> gameIdArr)
    {
        SFSArray sfsArray = new SFSArray();
        for (int i = 0; i < gameIdArr.size(); ++i)
        {
            int gameId = gameIdArr.get(i);
            TITGameInfo gameInfo = TITGameInfoFactory.covertGameIdToGameInfo(gameId);
            SFSObject sfsObject = gameInfo.toSFSObject();
            sfsArray.addSFSObject((ISFSObject)sfsObject);
        }
        return sfsArray;
    }

    public static ArrayList<Integer> getAllGameIdArr()
    {
        ArrayList<Integer> copyAllGameIdArr=new ArrayList<>();
        for(int i=0;i<allGameIdArr.size();i++)
        {
            Integer gameId=allGameIdArr.get(i);
            Integer copygameId=new Integer(gameId);
            copyAllGameIdArr.add(copygameId);
        }
        return copyAllGameIdArr;
    }

    public static ArrayList<Integer> getFreeGameIdArr()
    {
        ArrayList<Integer> copyFreeGameIdArr=new ArrayList<>();
        for(int i=0;i<freeGameIdArr.size();i++)
        {
            Integer gameId=freeGameIdArr.get(i);
            Integer copygameId=new Integer(gameId);
            copyFreeGameIdArr.add(copygameId);
        }
        return copyFreeGameIdArr;
    }

    public static ArrayList<TITGameInfo> getAllGameInfoArr()
    {
        return allGameInfoArr;
    }
}
