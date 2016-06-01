package aisoai.screens.hometabscreen.settings;

import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.requests.LogoutRequest;

public class SettingsRF extends TITRequestFactory
{
    public void logoutRequest()
    {
        LogoutRequest logoutRequest=new LogoutRequest();
        sendRequest(logoutRequest);
    }
}
