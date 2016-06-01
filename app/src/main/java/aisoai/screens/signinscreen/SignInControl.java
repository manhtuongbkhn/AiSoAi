package aisoai.screens.signinscreen;

import com.facebook.AccessToken;
import com.google.gson.JsonObject;

import aisoai.TITApplication;
import aisoai.config.KJS;
import aisoai.firebasecommunicate.TITFirebaseCommunicate;
import aisoai.facebookcommunincate.TITFacebookCommunicate;
import aisoai.gameservercommunicate.KeepConnectionThread;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.titentities.control.TITNormalControl;
import aisoai.screens.titentities.dialog.NetWorkErrorDialog;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.TITRequestFactory;

public class SignInControl extends TITNormalControl
{
    public void init()
    {
        TITFirebaseCommunicate.getDefaultFirebaseCommunicate(getActivity());
    }

    @Override
    public void finish()
    {

    }

    public void logoEvent()
    {

    }

    public void facebookLoginResponse(int sucess)
    {
        switch (sucess)
        {
            case 1:
                System.out.println("Facebook Login");
                AccessToken accessToken=AccessToken.getCurrentAccessToken();
                String facebookId=accessToken.getUserId();
                String accessTokenStr=accessToken.getToken();
                getRequestFactory().connectRequest();
                getActivity().setDlLogin(new LoginDialog(getActivity(),this));
                getActivity().getDlLogin().show();
                TITFacebookCommunicate.getCurrentFacebookCommunicate().friendsRequest(accessToken);
                break;
            case 0:
                System.out.println("Facebook Cancel");
                break;
            case -1:
                System.out.println("Facebook Exception");
                getActivity().setNetWorkErrorDialog(new NetWorkErrorDialog(getActivity(), this));
                getActivity().getNetWorkErrorDialog().show();
                break;
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void connectionResponse()
    {
        //System.out.println("Conection");
        String facebookId=AccessToken.getCurrentAccessToken().getUserId();
        AccessToken accessToken=AccessToken.getCurrentAccessToken();
        getRequestFactory().loginRequest(facebookId,accessToken.getToken());
    }

    public void sucessloginResponse()
    {
        KeepConnectionThread.start();
        getActivity().showMessage("Login thành công !", 1);
    }

    public void joinZoneNotify(JsonObject fromServerData)
    {
        boolean sucess=fromServerData.get(KJS.SUCESS).getAsBoolean();

        if(sucess)
        {
            getActivity().getDlLogin().dismiss();
            TITApplication.getScreenControlManager().changeScreen(new HomeTabControl());
        }
    }

    public void errorLoginResponse()
    {
        getActivity().showMessage("Login thất bại !", 1);
        TITApplication.getScreenControlManager().changeScreen(new SignInControl());
    }


    public SignInActivity getActivity()
    {
        return (SignInActivity) activity;
    }

    @Override
    public TITModel getModel()
    {
        return model;
    }

    @Override
    public SignInRF getRequestFactory()
    {
        return (SignInRF)requestFactory;
    }

    @Override
    public Class<SignInActivity> initActivity()
    {
        return SignInActivity.class;
    }
    @Override
    protected TITModel initModel()
    {
        return new TITModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new SignInRF();
    }
}
