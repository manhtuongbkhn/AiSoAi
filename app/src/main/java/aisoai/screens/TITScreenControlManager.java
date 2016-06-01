package aisoai.screens;

import aisoai.screens.gamescreeens.carogame.CaroGameControl;
import aisoai.screens.gamescreeens.doublepokemongame.DoublePokemonGameControl;
import aisoai.screens.gamescreeens.findpokemongame.FindPokemonGameControl;
import aisoai.screens.gamescreeens.snakehuntinggame.SnakeHuntingControl;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameControl;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameControl;
import aisoai.screens.hometabscreen.friendtabcreen.FriendTabControl;
import aisoai.screens.hometabscreen.friendtabcreen.chatfriendscreen.ChatFriendControl;
import aisoai.screens.hometabscreen.settings.SettingsControl;
import aisoai.screens.hometabscreen.topuser.TopPlayerControl;
import aisoai.screens.insidetabscreen.chatroomscreen.ChatRoomControl;
import aisoai.screens.hometabscreen.friendtabcreen.friendlistscreen.FriendListControl;
import aisoai.screens.hometabscreen.homeprofilescreen.ProfileControl;
import aisoai.screens.insidetabscreen.insideroomscreen.InsideRoomControl;
import aisoai.screens.hometabscreen.roomlistscreen.RoomListControl;
import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.scoringscreen.scoringcaro.ScoringCaroControl;
import aisoai.screens.scoringscreen.scoringvsgame.ScoringVsGameControl;
import aisoai.screens.titentities.activity.ITITActivity;
import aisoai.screens.signinscreen.SignInControl;
import aisoai.screens.startscreen.StartControl;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.screens.titentities.control.TITAppControl;
import aisoai.screens.titentities.control.TITControl;
import aisoai.screens.titentities.control.TITNormalControl;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class TITScreenControlManager
{
    private static TITScreenControlManager defaultScreenControlManager;
    private TITControl control;

    private TITScreenControlManager()
    {
        control=new StartControl();
    }

    public static TITScreenControlManager getDefaultScreenControlManager()
    {
        if(defaultScreenControlManager == null)
        {
            defaultScreenControlManager  =new TITScreenControlManager();
        }
        return defaultScreenControlManager;
    }

    public void changeScreen(TITControl nextControl)
    {
        changeControl(nextControl);
        System.gc();
    }

    private void changeControl(TITControl nextControl)
    {
        TITControl backControl=control;
        control=nextControl;
        ITITActivity backActivity=backControl.getActivity();
        backActivity.changeActivity(nextControl.initActivity(), true);
    }

    public void setControl(TITControl control)
    {
        this.control=control;
    }

    public StartControl getStartControl()
    {
        return (StartControl) control;
    }

    public SignInControl getSignInControl()
    {
        return (SignInControl) control;
    }

    public HomeTabControl getHomeTabControl()
    {
        return (HomeTabControl) control;
    }

    public ProfileControl getProfileControl()
    {
        return getHomeTabControl().getProfileControl();
    }

    public RoomListControl getListRoomControl()
    {
        return getHomeTabControl().getRoomListControl();
    }

    public FriendTabControl getFriendTabControl()
    {
        return getHomeTabControl().getFriendTabControl();
    }

    public FriendListControl getFriendListControl()
    {
        return getFriendTabControl().getFriendListControl();
    }

    public ChatFriendControl getChatFriendControl()
    {
        return getFriendTabControl().getChatFriendControl();
    }

    public TopPlayerControl getTopUserControl()
    {
        return getHomeTabControl().getTopUserControl();
    }

    public SettingsControl getSettingsControl()
    {
        return getHomeTabControl().getSettingsControl();
    }

    public InsideTabControl getInsideTabControl()
    {
        return (InsideTabControl)control;
    }

    public InsideRoomControl getInsideRoomControl()
    {
        return getInsideTabControl().getInsideRoomControl();
    }

    public ChatRoomControl getChatRoomControl()
    {
        return getInsideTabControl().getChatRoomControl();
    }

    public FindPokemonGameControl getFindPokemonGameControl()
    {
        return (FindPokemonGameControl) control;
    }

    public DoublePokemonGameControl getDoublePokemonGameControl()
    {
        return (DoublePokemonGameControl) control;
    }

    public SnakeHuntingControl getSaSnakeHuntingControl()
    {
        return (SnakeHuntingControl) control;
    }

    public TetrisGameControl getTetrisGameControl()
    {
        return (TetrisGameControl) control;
    }

    public CaroGameControl getCaroGameControl()
    {
        return (CaroGameControl) control;
    }

    public ScoringCaroControl getScoringCaroControl()
    {
        return (ScoringCaroControl) control;
    }

    public ScoringVsGameControl getScoringVsGameControl()
    {
        return (ScoringVsGameControl) control;
    }

    public TITControl getControl()
    {
        return control;
    }

    public TITAppControl getAppControl()
    {
        return (TITAppControl) control;
    }

    public TITTabControl getTabControl()
    {
        return (TITTabControl) control;
    }

    public TITNormalControl getNormalControl()
    {
        return (TITNormalControl) control;
    }

    public TITGameControl getGameControl()
    {
        return (TITGameControl)control;
    }

    public ScoringControl getScoringControl()
    {
        return (ScoringControl) control;
    }

    public TITSingleGameControl getSingleGameControl()
    {
        return (TITSingleGameControl) control;
    }
}
