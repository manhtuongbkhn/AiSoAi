package aisoai.gameservercommunicate;

import com.smartfoxserver.v2.entities.data.SFSObject;

import aisoai.config.CMDRQ;
import aisoai.config.ClientConfig;
import aisoai.screens.titentities.TITRequestFactory;
import sfs2x.client.requests.ExtensionRequest;

public class KeepConnectionThread
{
    private static boolean runing=false;
    private static boolean stop=true;

    public static void start()
    {
        Thread keepConnecitonThread=new Thread()
        {
            @Override
            public void run()
            {
                while (!stop)
                {
                    ExtensionRequest keepConnectionRequest =
                            new ExtensionRequest(CMDRQ.KEEPCONNECTION_RQ, new SFSObject());
                    TITRequestFactory requestFactory=new TITRequestFactory();
                    requestFactory.sendRequest(keepConnectionRequest);
                    try {sleep(ClientConfig.KEEPCONNECTION_TIME);}
                    catch (InterruptedException e) {e.printStackTrace();}
                }
                runing=false;
            }
        };
        keepConnecitonThread.setPriority(3);
        if(!runing)
        {
            runing=true;
            stop=false;
            keepConnecitonThread.start();
        }
    }

    public static void stop()
    {
        stop=true;
    }
}