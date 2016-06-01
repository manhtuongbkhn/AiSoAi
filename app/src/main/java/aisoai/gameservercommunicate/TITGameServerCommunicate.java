package aisoai.gameservercommunicate;

import android.app.Activity;

import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;

import sfs2x.client.SmartFox;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.requests.ExtensionRequest;
import sfs2x.client.requests.IRequest;
import aisoai.config.CMDRQ;
import aisoai.config.ClientConfig;
import aisoai.config.ServerConfig;

public class TITGameServerCommunicate extends Activity implements IEventListener
{
    private SmartFox sfsClient;
    private TITResponseRouter responseRouter;
    private static TITGameServerCommunicate defaultGameServerCommunicate;

    private TITGameServerCommunicate()
    {
        responseRouter= TITResponseRouter.getDefaultResponseRouter();
        System.setProperty("java.net.preferIPv6Addresses","false");
        sfsClient=new SmartFox();
        addEventListener();
        sfsClient.setUseBlueBox(ServerConfig.BLUE_BOX);
        sfsClient.getSocketEngine().setReconnectionSeconds(ServerConfig.RECONNECTION_TIME);
        sfsClient.getSocketEngine().
                                setReconnectionDelayMillis(ServerConfig.RECONNECTION_DELAY_MILLIS);
    }

    public static TITGameServerCommunicate getDefaultGameServerCommunicate()
    {
        if(defaultGameServerCommunicate ==null)
            defaultGameServerCommunicate =new TITGameServerCommunicate();
        return defaultGameServerCommunicate;
    }

    public static void clearDefaultGameServerCommunicate()
    {
        defaultGameServerCommunicate =null;
    }

    @Override
    public void dispatch(final BaseEvent event) throws SFSException
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    responseRouter.routerEvent(event);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
    public void addEventListener()
    {
        sfsClient.addEventListener(SFSEvent.CONNECTION, this);
        sfsClient.addEventListener(SFSEvent.CONNECTION_LOST, this);
        sfsClient.addEventListener(SFSEvent.CONNECTION_RESUME,this);
        sfsClient.addEventListener(SFSEvent.CONNECTION_RETRY,this);

        sfsClient.addEventListener(SFSEvent.LOGIN, this);
        sfsClient.addEventListener(SFSEvent.LOGIN_ERROR, this);
        sfsClient.addEventListener(SFSEvent.LOGOUT, this);

        sfsClient.addEventListener(SFSEvent.EXTENSION_RESPONSE, this);
    }
    protected void onDestroy()
    {
        super.onDestroy();
        sfsClient.removeAllEventListeners();
    }

    public void sendServer(IRequest iRequest)
    {
        sfsClient.send(iRequest);
    }

    public void connectServer()
    {
        String ipServer=ServerConfig.getIpServer();
        int portServer=ServerConfig.getPortServer();
        sfsClient.connect(ipServer,portServer);
    }

    public void disconnectServer()
    {
        sfsClient.disconnect();
    }

    //Set Get Method
    public SmartFox getSFS()
    {
        return sfsClient;
    }

    public Room getLastJoinedRoom()
    {
        Room room = sfsClient.getLastJoinedRoom();
        return room;
    }
}
