package aisoai.screens.hometabscreen.settings;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.facebookcommunincate.TITFacebookCommunicate;
import aisoai.screens.hometabscreen.HomeTabControl;
import aisoai.screens.signinscreen.SignInControl;
import aisoai.screens.titentities.model.TITModel;
import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.control.TITSpecControl;
import aisoai.screens.titentities.TITRequestFactory;

public class SettingsControl extends TITSpecControl
{
    @Override
    public void init()
    {
        super.init();
    }

    @Override
    public void reinit()
    {

    }

    public void logoutEvent()
    {
        /*
        getRequestFactory().logoutRequest();
        TITFacebookCommunicate.getCurrentFacebookCommunicate().logout();
        TITApplication.getScreenControlManager().changeScreen(new SignInControl());
        */
    }

    @Override
    public void finish()
    {
        super.finish();
    }

    @Override
    public TITTabControl getTabControl()
    {
        return (HomeTabControl) tabControl;
    }

    @Override
    public SettingsActivity getActivity()
    {
        return (SettingsActivity) activity;
    }

    @Override
    public TITModel getModel()
    {
        return new TITModel();
    }

    @Override
    public SettingsRF getRequestFactory()
    {
        return (SettingsRF) requestFactory;
    }

    @Override
    public Class<SettingsActivity> initActivity()
    {
        return SettingsActivity.class;
    }

    @Override
    protected TITModel initModel()
    {
        return new TITModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new SettingsRF();
    }


    @Override
    public String initTitle() {
        return "Settings";
    }

    @Override
    public int initDrawableId()
    {
        return R.drawable.setting;
    }
}
