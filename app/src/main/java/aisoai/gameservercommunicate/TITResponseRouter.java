package aisoai.gameservercommunicate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.screens.TITScreenControlManager;
import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.titentities.control.TITControl;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.SFSEvent;
import aisoai.config.CMDNF;
import aisoai.config.CMDRP;
import aisoai.config.KJS;

public class TITResponseRouter
{
    private TITScreenControlManager controlManager;
    private static TITResponseRouter defaultResponseRouter;

    private TITResponseRouter()
    {
        controlManager= TITScreenControlManager.getDefaultScreenControlManager();
    }

    public static TITResponseRouter getDefaultResponseRouter()
    {
        if(defaultResponseRouter ==null)
            defaultResponseRouter =new TITResponseRouter();
        return defaultResponseRouter;
    }

    public static TITResponseRouter resetDefaultResponseRouter()
    {
        defaultResponseRouter=new TITResponseRouter();
        return defaultResponseRouter;
    }

    public void setControl(TITControl control)
    {
        controlManager.setControl(control);
    }

    public void routerEvent(BaseEvent event)
    {
        if (event.getType().equalsIgnoreCase(SFSEvent.CONNECTION))
            controlManager.getSignInControl().connectionResponse();
        if (event.getType().equalsIgnoreCase(SFSEvent.CONNECTION_LOST))
            controlManager.getControl().connectionLost();
        if (event.getType().equalsIgnoreCase(SFSEvent.CONNECTION_RESUME))
            controlManager.getControl().connectionResume();
        if (event.getType().equalsIgnoreCase(SFSEvent.CONNECTION_RETRY))
            controlManager.getControl().connectionRetry();
        if (event.getType().equalsIgnoreCase(SFSEvent.LOGIN))
            controlManager.getSignInControl().sucessloginResponse();
        if (event.getType().equalsIgnoreCase(SFSEvent.LOGIN_ERROR))
            controlManager.getSignInControl().errorLoginResponse();
        if (event.getType().equalsIgnoreCase(SFSEvent.LOGOUT))
            controlManager.getControl().logoutResponse();
        if (event.getType().equalsIgnoreCase(SFSEvent.EXTENSION_RESPONSE))
            routerExtensionResponse(event);
    }

    public void routerExtensionResponse(BaseEvent event)
    {
        try
        {
            String cmd = event.getArguments().get("cmd").toString();
            SFSObject sfsObj = (SFSObject) event.getArguments().get("params");
            String jsonStr = sfsObj.getUtfString(KJS.DATA);
            Gson gson = new Gson();
            JsonObject fromServerData = gson.fromJson(jsonStr, JsonObject.class);
            switch (cmd) {
                case CMDNF.USERJOINZONE_NF:
                    controlManager.getSignInControl().joinZoneNotify(fromServerData);
                    break;
                case CMDRP.USERPROFILE_RP:
                    controlManager.getProfileControl().userInfoResponse(fromServerData);
                    break;
                case CMDRP.CHALLENGE_RP:
                    controlManager.getProfileControl().challengeResponse(fromServerData);
                    break;
                case CMDRP.CANCEL_CHALLENGE_RP:
                    controlManager.getProfileControl().cancelChallengeResponse(fromServerData);
                    break;
                case CMDNF.CHALLENGE_NF:
                    controlManager.getProfileControl().challengeNotify(fromServerData);
                    break;
                case CMDRP.TOP_PLAYER_RP:
                    controlManager.getTopUserControl().topPlayerResponse(fromServerData);
                    break;
                case CMDRP.CANCEL_TOP_PLAYER_RP:
                    controlManager.getTopUserControl().cancelTopPlayerResponse(fromServerData);
                    break;
                case CMDNF.RELOADTOPPLAYER_NF:
                    controlManager.getTopUserControl().reloadTopPlayerNotify(fromServerData);
                    break;
                case CMDRP.FRIENDLIST_RP:
                    routerFriendListResponse(fromServerData);
                    break;
                case CMDRP.CANCELFRIENDLIST_RP:
                    break;
                case CMDNF.RELOADFRIENDLIST_NF:
                    controlManager.getFriendListControl().reloadFriendListNotify(fromServerData);
                    break;
                ////////////////////////////////////////////////////////////////////////////////////
                case CMDRP.ROOMLIST_RP:
                    controlManager.getListRoomControl().listRoomResponse(fromServerData);
                    break;
                case CMDRP.CANCELROOMLIST_RP:
                    break;
                case CMDNF.RELOADROOMLIST_NF:
                    controlManager.getListRoomControl().reloadRoomListNotify(fromServerData);
                    break;
                case CMDRP.CREATEROOM_RP:
                    controlManager.getListRoomControl().creatRoomResponse(fromServerData);
                    break;
                case CMDRP.JOINROOM_RP:
                    controlManager.getListRoomControl().joinRoomResponse(fromServerData);
                    break;
                case CMDRP.EXITROOM_RP:
                    controlManager.getInsideRoomControl().exitRoomResponse(fromServerData);
                    break;
                case CMDRP.KICKPLAYER_RP:
                    controlManager.getInsideRoomControl().kickPlayerResponse(fromServerData);
                    break;
                case CMDNF.USERWASKICKED_NF:
                    controlManager.getInsideRoomControl().wasKickedUserNotify(fromServerData);
                    break;
                case CMDRP.ROOMINFO_RP:
                    controlManager.getInsideRoomControl().roomInfoResponse(fromServerData);
                    break;
                case CMDNF.ROOMINFO_NF:
                    routerRoomInfoNotify(fromServerData);
                    break;
                case CMDRP.ALLPLAYERINFO_RP:
                    break;
                case CMDNF.ALLPLAYERINFO_NF:
                    controlManager.getInsideRoomControl().allPlayerInfoNotify(fromServerData);
                    break;
                case CMDRP.CHANGEGAME_RP:
                    controlManager.getInsideRoomControl().changeGameResponse(fromServerData);
                    break;
                case CMDRP.ALLMESSAGEINFO_RP:
                    controlManager.getChatRoomControl().allMessageInfoResponse(fromServerData);
                    break;
                case CMDRP.SENDMESSAGE_RP:
                    controlManager.getChatRoomControl().sendMessageResponse(fromServerData);
                    break;
                case CMDNF.NEWMESSAGE_NF:
                    controlManager.getChatRoomControl().newMessageNotify(fromServerData);
                    break;
                case CMDRP.INVITATION_RP:
                    controlManager.getInsideRoomControl().invitationResponse(fromServerData);
                    break;
                case CMDRP.CANCELINVITATION_RP:
                    break;
                case CMDNF.RELOADINVITATIONFRIENDLIST_NF:
                    controlManager.getInsideRoomControl().
                                                    reloadInvitationFriendListNotify(fromServerData);
                    break;
                case CMDRP.INVITEFRIEND_RP:
                    controlManager.getInsideRoomControl().inviteFriendResponse(fromServerData);
                    break;
                case CMDNF.WASINVITED_NF:
                    controlManager.getAppControl().wasInvitedNotify(fromServerData);
                    break;
                case CMDRP.INVITATIONANSWER_RP:
                    controlManager.getAppControl().invitationAnswerResponse(fromServerData);
                    break;
                case CMDNF.SINGLEGAMESCRIPT_NF:
                    controlManager.getInsideRoomControl().singleGameScriptNotify(fromServerData);
                    break;
                ///////////////////////////////////////////////////////////////////////////////////
                case CMDNF.CHALLENGEBEGINGAMEDOWNTIME_NF:
                    controlManager.getInsideRoomControl().beginGameDownTimeNotify(fromServerData);
                    break;
                case CMDRP.STARTGAME_RP:
                    controlManager.getInsideRoomControl().startGameResponse(fromServerData);
                    break;
                case CMDNF.READYSTARTGAME_NF:
                    controlManager.getInsideRoomControl().readyStartGameNotify(fromServerData);
                    break;
                case CMDNF.STARTGAMEDOWNTIME_NF:
                    controlManager.getInsideRoomControl().startGameDownTimeNotify(fromServerData);
                    break;
                case CMDNF.STARTPLAYINGGAME_NF:
                    controlManager.getInsideRoomControl().startPlayingGameNotify(fromServerData);
                    break;
                ////////////////////////////////////////////////////////////////////////////////////
                case CMDNF.PLAYINGGAMEUSERINFO_NF:
                    controlManager.getGameControl().playingGameUserInfoNotify(fromServerData);
                    break;
                case CMDRP.CAROGAME_TICK_RP:
                    controlManager.getCaroGameControl().tickResponse(fromServerData);
                    break;
                case CMDNF.CAROGAME_TICK_NF:
                    controlManager.getCaroGameControl().tickNotify(fromServerData);
                    break;
                case CMDNF.CAROGAME_BOUT_NF:
                    controlManager.getCaroGameControl().boutNotify(fromServerData);
                    break;
                case CMDNF.CAROGAME_DOWNTIME_NF:
                    controlManager.getCaroGameControl().downtimeNotify(fromServerData);
                    break;
                case CMDNF.CAROGAME_WIN_NF:
                    controlManager.getCaroGameControl().winNotify(fromServerData);
                    break;
                ////////////////////////////////////////////////////////////////////////////////////
                case CMDNF.PLAYINGGAMEDOWNTIME_NF:
                    controlManager.getSingleGameControl().playingGameDownTimeNotify(fromServerData);
                    break;
                case CMDNF.RELOADPLAYINGPOINT_NF:
                    controlManager.getSingleGameControl().reloadPlayingPointNotify(fromServerData);
                    break;
                ////////////////////////////////////////////////////////////////////////////////////
                case CMDNF.STARTSCORING_NF:
                    controlManager.getGameControl().startScoringNotify(fromServerData);
                    break;
                case CMDNF.WINERINFO_NF:
                    controlManager.getScoringControl().winerInfoNotify(fromServerData);
                    break;
                case CMDNF.POINTSUMMARY_NF:
                    controlManager.getScoringControl().pointSummaryNotify(fromServerData);
                    break;
                case CMDNF.SCORINGDOWNTIME_NF:
                    controlManager.getScoringControl().scoringDownTimeNotify(fromServerData);
                    break;
                case CMDRP.BACKROOMFINISH_RP:
                    controlManager.getScoringControl().backRoomFinishResponse(fromServerData);
                    break;
                case CMDRP.EXITROOMFINISH_RP:
                    controlManager.getScoringControl().exitRoomFinishResponse(fromServerData);
                    break;
                case CMDNF.WASKICKROOMBYSYSTEM_NF:
                    controlManager.getScoringControl().wasKickRoomBySystem(fromServerData);
                    break;
                default:
                    break;
            }
        } catch (Exception ex){}
    }

    private void routerRoomInfoNotify(JsonObject fromServerData)
    {
        if(controlManager.getAppControl() instanceof InsideTabControl)
        {
            controlManager.getInsideRoomControl().roomInfoNotify(fromServerData);
        }

        if(controlManager.getAppControl() instanceof ScoringControl)
        {
            controlManager.getScoringControl().roomInfoNotify(fromServerData);
        }
    }

    private void routerFriendListResponse(JsonObject fromServerData)
    {
        if(controlManager.getAppControl() instanceof HomeTabControl)
        {
            controlManager.getFriendListControl().friendListResponse(fromServerData);
        }
    }

    public TITScreenControlManager getControlManager()
    {
        return controlManager;
    }
}