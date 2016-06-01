package aisoai.screens.hometabscreen.roomlistscreen;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.config.KJS;
import aisoai.config.StrDefine;
import aisoai.gameinfo.TITGameInfo;
import aisoai.gameinfo.TITGameInfoFactory;
import aisoai.screens.gamescreeens.TITGameRouter;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.titentities.dialog.choicegamedialog.GameArrayAdapter;
import aisoai.screens.hometabscreen.roomlistscreen.createroomdialog.RoomAvatarArrayAdapter;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.screens.titentities.model.TITModel;
import aisoai.titapplib.TITProgramStatus;
import aisoai.titapplib.TITUserVariable;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.TITRequestFactory;

public class RoomListControl extends TITSpecControl
{
    @Override
    public void init()
    {
        super.init();
        getActivity().getIvGameIcon().setImageResource
                                (TITGameRouter.routerGameIcon(getModel().getDefaultGameId()));
        getActivity().getDlPassword().setControl(this);
        initDlCreateRoom();
        initDlChoiceGame();
        RoomArrayAdapter roomArrayAdapter=
                                        new RoomArrayAdapter(getActivity(),getModel().getRoomArr());
        getActivity().getLvRoom().setAdapter(roomArrayAdapter);
        searchRoomEvent();
    }

    private void initDlCreateRoom()
    {
        getActivity().getDlCreateRoom().setControl(this);
        String[] strArr2={"Gà mờ","Thách thức","Thân thiện"};
        getActivity().getDlCreateRoom().
                getSpAvatar().setAdapter(new RoomAvatarArrayAdapter(getActivity(), strArr2));
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
        super.finish();
        sendRoomListRequest();
    }

    @Override
    public void finish()
    {
        getRequestFactory().cancelRoomListRequest();
    }

    public void sendRoomListRequest()
    {
        int gameId=getModel().getDefaultGameId();
        String roomName=getActivity().getEtSearchNameRoom().getText().toString();
        getRequestFactory().roomListRequest(gameId,roomName);
    }

    public void gameIconEvent()
    {
        getActivity().getDlChoiceGame().show();
    }

    public void choiceGameEvent(int postion)
    {
        getActivity().getDlChoiceGame().dismiss();
        int gameId = postion+1;
        getModel().setDefaultGameId(gameId);
        getActivity().getIvGameIcon().setImageResource(TITGameRouter.routerGameIcon(gameId));
        sendRoomListRequest();
    }

    public void searchRoomEvent()
    {
        sendRoomListRequest();
    }

    public void creatRoomEvent()
    {
        getActivity().getDlCreateRoom().show();
    }

    public void confirmCreateRoomEvent()
    {
        String roomInvite=getActivity().getDlCreateRoom().getEtInvite().getText().toString();
        String roomPass=getActivity().getDlCreateRoom().getEtPass().getText().toString();
        int roomAvatar=getActivity().getDlCreateRoom().getSpAvatar().getSelectedItemPosition()+1;
        int gameId=getModel().getDefaultGameId();
        if(checkValidateCreateRoomInfo(roomInvite,roomPass))
        {
            TITUserVariable.setProgramStatus(TITProgramStatus.WAITING_RESPONSE);
            getRequestFactory().createRoomRequest(roomInvite,roomPass,gameId,roomAvatar);
        }
        else
            invalidateCreateRoomInfo();
    }

    private boolean checkValidateCreateRoomInfo(String roomInvite,String roomPass)
    {
        return true;
    }

    public void invalidateCreateRoomInfo() {}

    public void joinRoomEvent(int postion)
    {
        JsonObject roomInfo=getModel().getRoomArr().get(postion);

        boolean roomLock=roomInfo.get(KJS.ROOM_LOCK).getAsBoolean();

        if(roomLock)
        {
            getActivity().getDlPassword().setPostion(postion);
            getActivity().getDlPassword().show();
        }
        else
        {
            int roomId = roomInfo.get(KJS.ROOM_ID).getAsInt();
            String roomName = roomInfo.get(KJS.ROOM_NAME).getAsString();
            TITUserVariable.setProgramStatus(TITProgramStatus.WAITING_RESPONSE);
            getRequestFactory().joinRoomRequest(roomId,roomName,"");
        }
    }

    public void joinLockRoomEvent(int postion,String password)
    {
        JsonObject roomInfo=getModel().getRoomArr().get(postion);
        int roomId = roomInfo.get(KJS.ROOM_ID).getAsInt();
        String roomName = roomInfo.get(KJS.ROOM_NAME).getAsString();
        TITUserVariable.setProgramStatus(TITProgramStatus.WAITING_RESPONSE);
        getRequestFactory().joinRoomRequest(roomId,roomName,password);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void listRoomResponse(JsonObject fromServerData)
    {
    }

    synchronized public void reloadRoomListNotify(JsonObject fromServerData)
    {
        System.out.println("-Room List Notify");
        System.out.println(fromServerData.toString());
        getModel().getRoomArr().clear();
        JsonArray jsonArray=fromServerData.getAsJsonArray(KJS.ARRAY);
        for(int i=0;i<jsonArray.size();i++)
        {
            JsonObject jsonObject=jsonArray.get(i).getAsJsonObject();
            getModel().getRoomArr().add(jsonObject);
        }
        getActivity().getLvRoom().invalidateViews();
    }

    public void creatRoomResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();

        if(sucess)
        {
            getActivity().showMessage(StrDefine.CREATE_ROOM_SUCESS_SHOW,1);
            TITApplication.getScreenControlManager().changeScreen(new InsideTabControl());
        }
        else
        {
            getActivity().showMessage(StrDefine.CREATE_ROOM_FAIL_SHOW,1);
        }
        TITUserVariable.setProgramStatus(TITProgramStatus.LOGGED);
    }

    public void joinRoomResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            TITApplication.getScreenControlManager().changeScreen(new InsideTabControl());
        }
        else
        {
            String systemMessage=fromServerData.get(KJS.SYSTEM_MESSAGE).getAsString();
            switch (systemMessage)
            {
                case StrDefine.ROOM_NOT_EXIST:
                    getActivity().showMessage(StrDefine.ROOM_NOT_EXIST_SHOW,1);
                    break;
                case StrDefine.ROOM_STATUS_INVALIDATE:
                    getActivity().showMessage(StrDefine.ROOM_STATUS_INVALIDATE_SHOW,1);
                    break;
                case StrDefine.ROOM_FULL:
                    getActivity().showMessage(StrDefine.ROOM_FULL_SHOW,1);
                    break;
                case StrDefine.PASSWORD_FAIL:
                    getActivity().showMessage(StrDefine.PASSWORD_FAIL_SHOW,1);
                    break;
                case StrDefine.SYSTEM_ERROR:
                    getActivity().showMessage(StrDefine.SYSTEM_ERROR_SHOW,1);
                    break;
            }
        }
        TITUserVariable.setProgramStatus(TITProgramStatus.LOGGED);
    }

    @Override
    public RoomListActivity getActivity()
    {
        return (RoomListActivity) activity;
    }

    @Override
    public RoomListModel getModel()
    {
        return (RoomListModel) model;
    }

    @Override
    public RoomListRF getRequestFactory()
    {
        return (RoomListRF) requestFactory;
    }

    @Override
    public TITTabControl getTabControl()
    {
        return (HomeTabControl) tabControl;
    }

    @Override
    public Class<RoomListActivity> initActivity()
    {
        return RoomListActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new RoomListModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new RoomListRF();
    }

    @Override
    public String initTitle()
    {
        return "Room List";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.list_room;
    }
}
