package aisoai.screens.titentities.control;

import com.facebook.AccessToken;

import java.util.ArrayList;

import aisoai.TITApplication;
import aisoai.firebasecommunicate.TITFirebaseCommunicate;
import aisoai.gameservercommunicate.KeepConnectionThread;
import aisoai.screens.signinscreen.SignInControl;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.gameservercommunicate.TITGameServerCommunicate;
import aisoai.screens.titentities.activity.ITITActivity;
import aisoai.screens.titentities.dialog.ExitDialog;

public abstract class TITControl
{
    protected TITRequestFactory requestFactory;
    protected ITITActivity activity;
    protected TITModel model;

    public TITControl()
    {
        model=initModel();
        requestFactory=initRequestFactory();
    }


    abstract public void init();
    abstract public void finish();

    public void backEvent()
    {
        getActivity().setExitDialog(new ExitDialog(getActivity().getContext(),this));
        getActivity().getExitDialog().show();
    }

    public void exitDialogConfirmEvent()
    {
        finishProgram();
    }

    public void logoutResponse()
    {

    }

    public void connectionLost()
    {
        System.out.println("Connect Lost");
        KeepConnectionThread.stop();
        TITApplication.getScreenControlManager().changeScreen(new SignInControl());
    }

    protected void finishProgram()
    {
        KeepConnectionThread.stop();
        getRequestFactory().disconnectServer();
        getActivity().finish();
        System.exit(0);
    }

    public void connectionResume()
    {
        System.out.println("Connect Resume");
    }

    public void connectionRetry()
    {
        System.out.println("Connect Retry");
    }

    //Facebook And FireBase

    public void facebookFriendResponse(ArrayList<String> facebookIdArr)
    {
        AccessToken accessToken=AccessToken.getCurrentAccessToken();
        TITFirebaseCommunicate.getDefaultFirebaseCommunicate(null).
                                                            loginRequest(accessToken, facebookIdArr);
    }

    public void firebaseLoginResponse(int sucess)
    {
        switch (sucess)
        {
            case 1:
                System.out.println("Firebase login sucess");
                break;
            case 0:
                System.out.println("Firebase login fail");

                break;
            case -1:
                System.out.println("System Error");
        }
    }

    public void adminMessage()
    {

    }

    abstract public Class<? extends ITITActivity> initActivity();
    abstract protected TITModel initModel();
    abstract protected TITRequestFactory initRequestFactory();

    abstract public ITITActivity getActivity();
    abstract public TITModel getModel();
    abstract public TITRequestFactory getRequestFactory();



    public void setRequestFactory(TITRequestFactory requestFactory)
    {
        this.requestFactory=requestFactory;
    }

    public void setActivity(ITITActivity activity)
    {
        this.activity=activity;
    }

    public void setModel(TITModel model)
    {
        this.model = model;
    }
}
