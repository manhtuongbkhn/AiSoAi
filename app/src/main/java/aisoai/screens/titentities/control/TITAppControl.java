package aisoai.screens.titentities.control;

import android.graphics.Bitmap;

import com.google.gson.JsonObject;

import aisoai.TITApplication;
import aisoai.config.KJS;
import aisoai.config.StrDefine;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.loadnetimage.TITRequestImage;
import aisoai.screens.titentities.activity.ITITAppActivity;
import aisoai.screens.titentities.dialog.WasInvitedDialog;

abstract public class TITAppControl extends TITControl
{
    public void invitationAnswerEvent(boolean answer)
    {
        JsonObject fromServerData=getModel().getFromServerData();
        String inviteUserFullName=fromServerData.get(KJS.FULL_NAME).getAsString();
        int roomId=fromServerData.get(KJS.ROOM_ID).getAsInt();
        String inviteTime=fromServerData.get(KJS.TIME).getAsString();
        requestFactory.invitationAnswerRequest(inviteUserFullName, roomId, inviteTime, answer);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void wasInvitedNotify(JsonObject fromServerData)
    {
        getModel().setFromServerData(fromServerData);
        WasInvitedDialog wasInvitedDialog=new WasInvitedDialog(getActivity().getContext(),this);
        getActivity().setWasInvitedDialog(wasInvitedDialog);
        getActivity().getWasInvitedDialog().show();
        String avatarUrl=fromServerData.get(KJS.AVATAR_URL).getAsString();
        String notification=fromServerData.get(KJS.NOTIFICATION).getAsString();
        new TITRequestImage(avatarUrl,8)
        {
            @Override
            protected void setImage(Bitmap bitmap)
            {
                getActivity().getWasInvitedDialog().getIvPlayerAvatar().setImageBitmap(bitmap);
            }
        };
        getActivity().getWasInvitedDialog().getTvNotification().setText(notification);
    }

    public void invitationAnswerResponse(JsonObject fromServerData)
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
            }
        }
    }

    @Override
    abstract public Class< ? extends ITITAppActivity> initActivity();

    @Override
    abstract public ITITAppActivity getActivity();
}
