package aisoai.screens.scoringscreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.JsonObject;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.config.ClientConfig;
import aisoai.config.KJS;
import aisoai.config.StrDefine;
import aisoai.screens.gamescreeens.TITGameRouter;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.screens.titentities.control.TITNormalControl;
import aisoai.screens.titentities.dialog.TITRoomAvatarRouter;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.model.TITUserInfo;
import aisoai.titapplib.TITFunction;

abstract public class ScoringControl extends TITNormalControl
{
    @Override
    public void init()
    {

    }

    @Override
    public void finish()
    {

    }

    public void exitRoomFinishEvent()
    {
        System.out.println("-Exit Room Finish Request");
        getRequestFactory().exitRoomWhenFinishRequest();
    }

    public void backRoomFinishEvent()
    {
        System.out.println("-Back Room Finish Request");
        getRequestFactory().backRoomFinishRequest();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void roomInfoNotify(JsonObject fromServerData)
    {
        int roomAvatar=fromServerData.get(KJS.ROOM_AVATAR).getAsInt();
        String roomName=fromServerData.get(KJS.ROOM_NAME).getAsString();
        int gameId=fromServerData.get(KJS.GAME_ID).getAsInt();

        getActivity().getIvRoomAvatar().setImageResource(TITRoomAvatarRouter.routerRoomAvatar(roomAvatar));
        getActivity().getTvRoomName().setText(roomName);
        getActivity().getIvGameIcon().setImageResource(TITGameRouter.routerGameIcon(gameId));

        int roomType=fromServerData.get(KJS.ROOM_TYPE).getAsInt();
        switch (roomType)
        {
            case 1:
                break;
            case 2:
                getActivity().getBtBackRoom().setEnabled(false);
                break;
        }
    }

    public void winerInfoNotify(JsonObject fromServerData)
    {
        System.out.println("-Winer Info Notify");
        String userId=fromServerData.get(KJS.USER_ID).getAsString();
        if(userId.equals("00000000"))
        {
            getActivity().getIvWinPlayerAvatar().setImageResource(R.drawable.logo);
        }
        else
        {
            new TITUserInfo(fromServerData)
            {
                @Override
                public void reloadImage(Bitmap bitmap)
                {
                    getActivity().getIvWinPlayerAvatar().setImageBitmap(bitmap);
                }
            };
        }
    }

    public void pointSummaryNotify(JsonObject fromServerData)
    {
        System.out.println("-Point Summary Notify");
        int ep=fromServerData.get(KJS.EXPERIENCE_POINT).getAsInt();
        int rp=fromServerData.get(KJS.RANK_POINT).getAsInt();

        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inPreferredConfig= Bitmap.Config.ARGB_8888;
        options.inMutable=true;
        Bitmap epBitmap= BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.experience_point, options);
        Bitmap rpBitmap= BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.rank_point, options);
        Float fWidth=ClientConfig.SCREEN_WIDTH_PX;
        Float fHeight=70*ClientConfig.SCREEN_HEIGHT_PX/480;
        int textSize= ScoringUIDefine.SUMMARYPOINTTEXT_SIZE();
        Bitmap pointBitmap= TITFunction.createSummaryPointBitmap(ep,rp,epBitmap,rpBitmap,
                                                    fWidth.intValue(),fHeight.intValue(),textSize);
        getActivity().getIvSummaryPoint().setImageBitmap(pointBitmap);
    }

    public void backRoomFinishResponse(JsonObject fromServerData)
    {
        System.out.println("-back Room Finish Responses");
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();

        if(sucess)
        {
            TITApplication.getScreenControlManager().changeScreen(new InsideTabControl());
        }
        else
            getActivity().showMessage(StrDefine.WAS_KICKED_USER_SHOW,1);
    }

    public void exitRoomFinishResponse(JsonObject fromServerData)
    {
        System.out.println("-exit Room Finish Response");
        TITApplication.getScreenControlManager().changeScreen(new HomeTabControl());
    }

    public void scoringDownTimeNotify(JsonObject fromServerData)
    {

    }

    public void wasKickRoomBySystem(JsonObject fromServerData)
    {
        getActivity().showMessage(StrDefine.WAS_KICKED_USER_SHOW,1);
        getActivity().getBtBackRoom().setEnabled(false);
    }

    @Override
    protected TITModel initModel()
    {
        return new TITModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new ScoringRF();
    }

    @Override
    public ScoringActivity getActivity()
    {
        return (ScoringActivity) activity;
    }

    @Override
    public TITModel getModel()
    {
        return model;
    }

    @Override
    public ScoringRF getRequestFactory()
    {
        return (ScoringRF) requestFactory;
    }
}
