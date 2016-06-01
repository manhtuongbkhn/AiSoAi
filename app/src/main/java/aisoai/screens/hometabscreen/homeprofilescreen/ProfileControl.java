package aisoai.screens.hometabscreen.homeprofilescreen;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.facebook.share.model.ShareLinkContent;
import com.google.gson.JsonObject;
import aisoai.R;
import aisoai.TITApplication;
import aisoai.config.KJS;
import aisoai.config.StrDefine;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.insidetabscreen.InsideTabControl;
import aisoai.screens.titentities.model.TITUserInfo;
import aisoai.titapplib.TITFunction;
import aisoai.screens.titentities.model.TITModel;
import aisoai.titapplib.TITUserVariable;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.TITRequestFactory;

public class ProfileControl extends TITSpecControl
{
    private WaitingChallengeThread waitingChallengeThread;

    @Override
    public void init()
    {
        super.init();
        getRequestFactory().userInfoRequest();
    }

    @Override
    public void reinit()
    {
        getRequestFactory().userInfoRequest();
    }

    @Override
    public void finish()
    {
        super.finish();
    }

    public void challengeEvent()
    {
        getActivity().setDlchallenge(new ChallengeDialog(getActivity(),this));
        getActivity().getDlchallenge().setContent();
        getActivity().getDlchallenge().show();
    }

    public void trainingEvent()
    {
        getActivity().showMessage("Chức năng chưa hỗ trợ !",1);
    }

    public void challengeConfirmEvent()
    {
        int gameId=getActivity().getDlchallenge().getSpGame().getSelectedItemPosition()+1;
        getRequestFactory().challengeRequest(gameId);
    }

    public void cancelChallengeEvent()
    {
        getRequestFactory().cancelChallengeRequest();
    }

    /////////////////////////////////////////////////////////

    public void userInfoResponse(JsonObject fromServerData)
    {
        fromServerData.addProperty(KJS.AVATAR_PRIORITY, 10);
        TITUserInfo userInfo=new TITUserInfo(fromServerData)
        {
            @Override
            public void reloadImage(Bitmap bitmap)
            {
                getActivity().getIvPlayerAvatar().setImageBitmap(bitmap);
            }
        };

        getActivity().getTvPlayerName().setText(userInfo.getUserProfile().getFullName());

        if(userInfo.getUserProfile().getGender().equals("male"))
        {
            getActivity().getIvGender().setImageResource(R.drawable.male);
        }
        if(userInfo.getUserProfile().getGender().equals("female"))
        {
            getActivity().getIvGender().setImageResource(R.drawable.female);
        }

        getActivity().getTvTotalNormalMatchCount().setText
                                    (userInfo.getGameUserInfo().getTotalNormalMatchCount()+" thường");
        getActivity().getTvTotalNormalWinMatchCount().setText
                                ((userInfo.getGameUserInfo().getTotalNormalWinMatchCount())+" thắng");
        getActivity().getTvTotalRankMatchCount().setText
                                        (userInfo.getGameUserInfo().getTotalRankMatchCount()+" hạng");
        getActivity().getTvTotalRankWinMatchCount().setText
                (userInfo.getGameUserInfo().getTotalRankWinMatchCount() + " thắng");

        GameMaturityArrayAdapter gameMaturityArrayAdapter=new GameMaturityArrayAdapter
                                (getActivity(),userInfo.getGameUserInfo().getGameMaturityArr());
        getActivity().getLvGameMaturity().setAdapter(gameMaturityArrayAdapter);
        getActivity().getLvGameMaturity().invalidateViews();
        TITUserVariable.setUserInfo(userInfo);
    }

    public void challengeResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            getActivity().showMessage(StrDefine.CHALLENGERESPONSE_SUCESS_SHOW,1);
            int handTime=fromServerData.get(KJS.TIME).getAsInt();
            int minute=TITFunction.convertMinute(handTime);
            int second=TITFunction.convertSecond(handTime);
            getActivity().setDlChallengeWaiting(new ChallengeWaitingDialog(getActivity(),this));
            getActivity().getDlChallengeWaiting().setGuessTime(minute,second);
            getActivity().getDlChallengeWaiting().setRealityTime(minute,second);
            getActivity().getDlChallengeWaiting().show();

            waitingChallengeThread=new WaitingChallengeThread();
            waitingChallengeThread.start();
        }
        else
        {
            getActivity().showMessage(StrDefine.CHALLENGERESPONSE_FAIL_SHOW,1);
        }
    }

    public void cancelChallengeResponse(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            waitingChallengeThread.setStop(true);
            getActivity().showMessage(StrDefine.CANLCEL_CHALLENGERESPONSE_SUCESS_SHOW,1);
            getActivity().getDlChallengeWaiting().dismiss();
        }
        else
        {
            getActivity().showMessage(StrDefine.CANLCEL_CHALLENGERESPONSE_FAIL_SHOW,1);
        }
    }

    public void challengeNotify(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();
        if(sucess)
        {
            waitingChallengeThread.setStop(true);
            getActivity().showMessage(StrDefine.CHALLENGENOTIFY_SHOW, 1);
            TITApplication.getScreenControlManager().changeScreen(new InsideTabControl());
        }
    }

    @Override
    public ProfileActivity getActivity()
    {
        return (ProfileActivity) activity;
    }

    @Override
    public TITModel getModel()
    {
        return model;
    }

    @Override
    public ProfileRF getRequestFactory()
    {
        return (ProfileRF) requestFactory;
    }

    @Override
    public TITTabControl getTabControl()
    {
        return (HomeTabControl) tabControl;
    }

    @Override
    public Class<ProfileActivity> initActivity()
    {
        return ProfileActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new TITModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new ProfileRF();
    }

    @Override
    public String initTitle()
    {
        return "Profile";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.user_profile;
    }

    class WaitingChallengeThread extends Thread
    {
        private boolean stop;

        private Handler handler=new Handler()
        {
            @Override
            public void handleMessage(Message message)
            {
                int handTime=message.getData().getInt("time");
                int minute=TITFunction.convertMinute(handTime);
                int second=TITFunction.convertSecond(handTime);
                getActivity().getDlChallengeWaiting().setRealityTime(minute,second);
            }
        };

        @Override
        public void run()
        {
            int i=0;
            while(!stop)
            {
                Bundle bundle=new Bundle();
                bundle.putInt("time",i);
                Message message=new Message();
                message.setData(bundle);
                handler.sendMessage(message);
                i++;
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
            }
        }

        public boolean isStop()
        {
            return stop;
        }

        public void setStop(boolean stop)
        {
            this.stop = stop;
        }
    }
}
