package aisoai;

import aisoai.facebookcommunincate.TITFacebookCommunicate;
import aisoai.firebasecommunicate.TITFirebaseCommunicate;
import aisoai.gameinfo.TITGameInfoFactory;
import aisoai.gameservercommunicate.TITGameServerCommunicate;
import aisoai.screens.TITScreenControlManager;

public class TITApplication
{
    private static TITScreenControlManager screenControlManager;
    private static TITGameServerCommunicate gameServerCommunicate;
    private static TITFirebaseCommunicate firebaseCommunicate;
    private static TITFacebookCommunicate facebookCommunicate;

    public static void init()
    {
        screenControlManager=TITScreenControlManager.getDefaultScreenControlManager();
        gameServerCommunicate=TITGameServerCommunicate.getDefaultGameServerCommunicate();
        facebookCommunicate=TITFacebookCommunicate.getCurrentFacebookCommunicate();
        firebaseCommunicate=TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null);
        TITGameInfoFactory.init();
    }

    public static void reset()
    {
        screenControlManager=null;
        gameServerCommunicate=null;
        firebaseCommunicate=null;
        facebookCommunicate=null;
    }

    public static TITScreenControlManager getScreenControlManager()
    {
        return screenControlManager;
    }
}
