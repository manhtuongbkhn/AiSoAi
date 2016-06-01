package aisoai.screens.gamescreeens.titentities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

abstract public class TITGameScriptReader
{
    private int current;
    private JsonArray tokenArr;
    private boolean stop;

    public TITGameScriptReader(JsonArray tokenArr)
    {
        current=0;
        stop=false;
        this.tokenArr=tokenArr;
    }

    public void start()
    {
        stop=false;
        Thread thread=new Thread()
        {
            @Override
            public void run()
            {
                while(!stop)
                {
                    if(current<tokenArr.size())
                    {
                        JsonObject token=tokenArr.get(current).getAsJsonObject();
                        readToken(token);
                        current++;
                    }
                }
            }
        };
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    public void stop()
    {
        stop=true;
    }

    public void resume()
    {
        stop=false;
        Thread thread=new Thread()
        {
            @Override
            public void run()
            {
                while(!stop)
                {
                    if(current<tokenArr.size())
                    {
                        JsonObject token=tokenArr.get(current).getAsJsonObject();
                        readToken(token);
                        current++;
                    }
                }
            }
        };
        thread.setPriority(Thread. MAX_PRIORITY);
        thread.start();
    }

    abstract public void readToken(JsonObject token);

}
