package aisoai.screens.insidetabscreen.insideroomscreen;


import android.graphics.Bitmap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.config.KJS;
import aisoai.config.StrDefine;;
import aisoai.gameinfo.TITGameInfo;
import aisoai.gameinfo.TITGameInfoFactory;
import aisoai.screens.gamescreeens.TITGameRouter;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.screens.insidetabscreen.insideroomscreen.invitation.FriendArrayAdapter;
import aisoai.screens.insidetabscreen.insideroomscreen.invitation.FriendListDialog;
import aisoai.screens.insidetabscreen.insideroomscreen.invitation.InvitationFriendInfo;
import aisoai.screens.insidetabscreen.insideroomscreen.invitation.MoreFriendInfoDialog;
import aisoai.screens.titentities.dialog.choicegamedialog.GameArrayAdapter;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.TITSpecActivity;
import aisoai.titapplib.TITProgramStatus;
import aisoai.titapplib.TITTransferData;
import aisoai.titapplib.TITUserVariable;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.dialog.TITRoomAvatarRouter;

public class InsideRoomControl extends TITSpecControl
{
    @Override
    public void init()
    {
        super.init();
        initDlChoiceGame();
        PlayerArrayAdapter arrayAdapter=
                new PlayerArrayAdapter(getActivity(),this,getModel().getPlayerArr());

        getActivity().getLvRoomPlayer().setAdapter(arrayAdapter);
        getRequestFactory().roomInfoRequest();
        getRequestFactory().insideRoomAllUserInfoInRoomRequest();
    }

    private void initDlChoiceGame()
    {
        getActivity().getDlChoiceGame().setControl(this);

        ArrayList<TITGameInfo> gameInfoArr= TITGameInfoFactory.getAllGameInfoArr();
        GameArrayAdapter gameArrayAdapter=new GameArrayAdapter(getActivity(),gameInfoArr);
        getActivity().getDlChoiceGame().getGvGame().setAdapter(gameArrayAdapter);
    }

    @Override
    public void reinit()
    {

    }

    @Override
    public void finish()
    {

    }

    public void changeGameEvent()
    {
        getActivity().getDlChoiceGame().show();
    }

    public void choiGameEvent(int position)
    {
        getActivity().getDlChoiceGame().dismiss();
        int gameId = position + 1;
        getRequestFactory().changeGameRequest(gameId);
    }

    public void startGameEvent()
    {
        TITUserVariable.setProgramStatus(TITProgramStatus.WAITING_RESPONSE);
        getRequestFactory().startGameRequest();
    }

    public void invitationsEvent()
    {
        getRequestFactory().invitationRequest();
    }

    public void inviteFriendEvent(int postion)
    {
        InvitationFriendInfo friendInfo=getModel().getFriendArr().get(postion);
        String userId=friendInfo.getUserProfile().getUserId();
        int systemUserId=friendInfo.getUserProfile().getSystemUserId();
        String fullName=friendInfo.getUserProfile().getFullName();
        getRequestFactory().inviteFriendRequest(userId, systemUserId, fullName);
    }

    public void moreInviteFriendInfoEvent(int postion)
    {
        getActivity().setDlMoreFriendInfo(new MoreFriendInfoDialog(getActivity(),this));
        InvitationFriendInfo friendInfo=getModel().getFriendArr().get(postion);
        getActivity().getDlMoreFriendInfo().setContent(friendInfo);
        getActivity().getDlMoreFriendInfo().show();
    }

    public void closeFriendListDialogEvent()
    {
        getRequestFactory().cancelInvitationRequest();
    }

    public void kickPlayerEvent(int postion)
    {
        PlayerInfo playerInfo=getModel().getPlayerArr().get(postion);
        String userId=playerInfo.getUserProfile().getUserId();
        int systemUserId=playerInfo.getUserProfile().getSystemUserId();
        String fullName=playerInfo.getUserProfile().getFullName();
        TITUserVariable.setProgramStatus(TITProgramStatus.WAITING_RESPONSE);
        getRequestFactory().kickPlayerRequest(userId, systemUserId, fullName);
    }

    public void morePlayerInfoEvent(int postion)
    {
        getActivity().setDlMorePlayerInfo(new MorePlayerInfoDialog(getActivity(),this));
        PlayerInfo playerInfo=getModel().getPlayerArr().get(postion);
        getActivity().getDlMorePlayerInfo().setContent(playerInfo);
        getActivity().getDlMorePlayerInfo().show();
    }

    public void exitRoomEvent()
    {
        TITUserVariable.setProgramStatus(TITProgramStatus.WAITING_RESPONSE);
        getRequestFactory().exitRoomRequest();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public void roomInfoResponse(JsonObject fromServerData){}

    public void roomInfoNotify(JsonObject fromServerData)
    {
        String roomName=fromServerData.get(KJS.ROOM_NAME).getAsString();
        String roomPass=fromServerData.get(KJS.ROOM_PASS).getAsString();
        String roomInvite=fromServerData.get(KJS.ROOM_INVITE).getAsString();
        int roomType=fromServerData.get(KJS.ROOM_TYPE).getAsInt();
        int gameId=fromServerData.get(KJS.GAME_ID).getAsInt();
        Integer roomAvatar=fromServerData.get(KJS.ROOM_AVATAR).getAsInt();
        String roomStatus=fromServerData.get(KJS.ROOM_STATUS).getAsString();
        Integer playerCount=fromServerData.get(KJS.PLAYER_COUNT).getAsInt();
        Integer playerMax=fromServerData.get(KJS.PLAYER_MAX).getAsInt();
        int ownerSystemUserId=fromServerData.get(KJS.SYSTEM_USER_ID).getAsInt();
        String ownerUserId=fromServerData.get(KJS.USER_ID).getAsString();

        getActivity().getTvRoomName().setText(roomName);
        //getActivity().getTvRoomPass().setText(roomPass);
        getActivity().getTvRoomInvite().setText(roomInvite);
        getActivity().getTvPlayerCount().setText(playerCount.toString() + "/" + playerMax.toString());
        getActivity().getIvRoomAvatar().setImageResource
                (TITRoomAvatarRouter.routerRoomAvatar(roomAvatar));
        getActivity().getIvGameIcon().setImageResource(TITGameRouter.routerGameIcon(gameId));
        String myUserId= TITUserVariable.getUserInfo().getUserProfile().getUserId();

        if(roomType==1)//Normal Room
        {
            if (!myUserId.equals(ownerUserId))
            {
                getActivity().getIbtStartGame().setEnabled(false);
                getActivity().getIbtInviteFriends().setEnabled(false);
                getActivity().getIvGameIcon().setEnabled(false);
            }
        }

        if(roomType==2) //Challenge Room
        {
            getActivity().getIbtStartGame().setEnabled(false);
            getActivity().getIbtInviteFriends().setEnabled(false);
            getActivity().getIbtExitRoom().setEnabled(false);
            getActivity().getIvGameIcon().setEnabled(false);
        }
    }

    synchronized public void allPlayerInfoNotify(JsonObject fromServerData)
    {
        //System.out.println("-All Player Notify:"+fromServerData.toString());
        getModel().getPlayerArr().clear();
        JsonArray jsonArray=fromServerData.getAsJsonArray(KJS.ARRAY);
        for(int i=0;i<jsonArray.size();i++)
        {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            jsonObject.addProperty(KJS.AVATAR_PRIORITY, 4);
            PlayerInfo playerInfo=new PlayerInfo(jsonObject)
            {
                @Override
                public void reloadImage(Bitmap bitmap)
                {
                    getActivity().getLvRoomPlayer().invalidateViews();
                }
            };
            getModel().getPlayerArr().add(playerInfo);
        }
       getActivity().getLvRoomPlayer().invalidateViews();
    }

    public void changeGameResponse(JsonObject fromServerData)
    {

    }

    public void invitationResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            getActivity().setDlFriendList(new FriendListDialog(getActivity(),this));
            getActivity().getDlFriendList().show();
            FriendArrayAdapter arrayAdapter=
                    new FriendArrayAdapter(getActivity(),this,getModel().getFriendArr());
            getActivity().getDlFriendList().getLvFriend().setAdapter(arrayAdapter);
        }
        else
        {
            String systemMessage=fromServerData.get(KJS.SYSTEM_MESSAGE).getAsString();
            switch (systemMessage)
            {
                case StrDefine.ISNT_ROOM_OWNER:
                    getActivity().showMessage(StrDefine.ISNT_ROOM_OWNER_SHOW,1);
                    break;

            }
        }
    }

    public void inviteFriendResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            System.out.println("Invite Friend Sucess");
        }
        else
        {
            System.out.println("Invite Friend False");
            String systemMessage=fromServerData.get(KJS.SYSTEM_MESSAGE).getAsString();
            switch (systemMessage)
            {
                case StrDefine.ISNT_ROOM_OWNER:
                    getActivity().showMessage(StrDefine.ISNT_ROOM_OWNER_SHOW,1);
                    break;
                case StrDefine.USER_NOT_ONLINE:
                    getActivity().showMessage(StrDefine.USER_NOT_ONLINE_SHOW,1);
                    break;
                case StrDefine.USER_NOT_FRIEND:
                    getActivity().showMessage(StrDefine.USER_NOT_FRIEND_SHOW,1);
                    break;
                case StrDefine.FRIEND_CANT_JOIN:
                    String fullName=fromServerData.get(KJS.FULL_NAME).getAsString();
                    getActivity().showMessage(fullName+StrDefine.FRIEND_CANT_JOIN_SHOW,1);
                    break;
            }
        }
    }

    synchronized public void reloadInvitationFriendListNotify(JsonObject fromServerData)
    {
        getModel().getFriendArr().clear();

        JsonArray jsonArray=fromServerData.getAsJsonArray(KJS.ARRAY);
        for(int i=0;i<jsonArray.size();i++)
        {
            JsonObject jsonObject=jsonArray.get(i).getAsJsonObject();
            jsonObject.addProperty(KJS.AVATAR_PRIORITY,4);
            InvitationFriendInfo friendInfo=new InvitationFriendInfo(jsonObject)
            {
                @Override
                public void reloadImage(Bitmap bitmap)
                {
                    getActivity().getDlFriendList().getLvFriend().invalidateViews();
                }
            };
            getModel().getFriendArr().add(friendInfo);
        }
        getActivity().getDlFriendList().getLvFriend().invalidateViews();
    }



    public void exitRoomResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            getActivity().showMessage(StrDefine.EXIT_ROOM_SUCESS_SHOW, 1);
            TITApplication.getScreenControlManager().changeScreen(new HomeTabControl());
        }
        TITUserVariable.setProgramStatus(TITProgramStatus.LOGGED);
    }

    public void kickPlayerResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            String fullName=fromServerData.get(KJS.FULL_NAME).getAsString();
            String message=StrDefine.KICK_USER_SUCESS_SHOW+fullName+"!";
            getActivity().showMessage(message,1);
        }
        else
        {
            switch (fromServerData.get(KJS.SYSTEM_MESSAGE).getAsString())
            {
                case StrDefine.ISNT_ROOM_OWNER:
                    getActivity().showMessage(StrDefine.ISNT_ROOM_OWNER_SHOW,1);
                    break;
                case StrDefine.USER_NOT_IN_ROOM:
                    String fullName=fromServerData.get(KJS.FULL_NAME).getAsString();
                    String message=fullName+StrDefine.USER_NOT_IN_ROOM_SHOW;
                    getActivity().showMessage(message,1);
                    break;
            }
        }
        TITUserVariable.setProgramStatus(TITProgramStatus.LOGGED);
    }

    public void wasKickedUserNotify(JsonObject fromServerData)
    {
        getActivity().showMessage(StrDefine.WAS_KICKED_USER_SHOW, 1);
        TITApplication.getScreenControlManager().changeScreen(new HomeTabControl());
    }

    public void startGameResponse(JsonObject fromServerData)
    {
        if(fromServerData.get(KJS.SUCESS).getAsBoolean())
        {
            System.out.println("Start Game thanh cong");
        }
        else
        {
            switch (fromServerData.get(KJS.SYSTEM_MESSAGE).getAsString())
            {
                case StrDefine.ISNT_ROOM_OWNER:
                    getActivity().showMessage(StrDefine.ISNT_ROOM_OWNER_SHOW,1);
                    break;
                case StrDefine.NOT_ENOUGH_USER:
                    getActivity().showMessage(StrDefine.NOT_ENOUGH_USER_SHOW,1);
                    break;
                case StrDefine.ROOM_STATUS_INVALIDATE:
                    getActivity().showMessage(StrDefine.ROOM_STATUS_INVALIDATE_SHOW,1);
                    break;
            }
        }
        TITUserVariable.setProgramStatus(TITProgramStatus.LOGGED);
    }

    public void singleGameScriptNotify(JsonObject fromServerData)
    {
        JsonArray gameScript=fromServerData.get(KJS.ARRAY).getAsJsonArray();
        TITTransferData.addObject(gameScript);
    }

    public void beginGameDownTimeNotify(JsonObject fromServerData)
    {
        Integer downTime=fromServerData.get(KJS.DOWN_TIME).getAsInt();
        getActivity().showMessage(downTime.toString(), 2);
    }

    public void readyStartGameNotify(JsonObject fromServerData)
    {
        getActivity().showMessage("Chuẩn bị bắt đầu game!",1);
        getActivity().setDlTime(new DownTimeDialog(getActivity(),this));
        getActivity().getDlTime().show();
    }

    public void startGameDownTimeNotify(JsonObject fromServerData)
    {
        Integer time=fromServerData.get(KJS.DOWN_TIME).getAsInt();
        getActivity().getDlTime().getTvTime().setText(time.toString());
    }

    public void startPlayingGameNotify(JsonObject fromServerData)
    {
        int gameId=fromServerData.get(KJS.GAME_ID).getAsInt();
        TITApplication.getScreenControlManager().changeScreen(TITGameRouter.routerGameControl(gameId));
    }


    @Override
    public InsideRoomActivity getActivity()
    {
        return (InsideRoomActivity) activity;
    }

    @Override
    public InsideRoomModel getModel()
    {
        return (InsideRoomModel)model;
    }

    @Override
    public InsideRoomRF getRequestFactory()
    {
        return (InsideRoomRF) requestFactory;
    }

    @Override
    public TITTabControl getTabControl()
    {
        return (InsideTabControl) tabControl;
    }

    @Override
    public Class<? extends TITSpecActivity> initActivity()
    {
        return InsideRoomActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new InsideRoomModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new InsideRoomRF();
    }

    @Override
    public String initTitle()
    {
        return "Inside Room";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.inside_room;
    }
}
