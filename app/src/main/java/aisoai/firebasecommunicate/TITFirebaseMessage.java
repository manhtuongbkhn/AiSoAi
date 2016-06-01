package aisoai.firebasecommunicate;

import java.util.Date;

public class TITFirebaseMessage
{
    private String time;
    private String content;
    private boolean received;

    public TITFirebaseMessage(String time,String content,boolean received)
    {
        this.time=time;
        this.content=content;
        this.received=received;
    }

    public TITFirebaseMessage(String content,boolean received)
    {
        Date date=new Date();
        this.time=date.toGMTString();
        this.content=content;
        this.received=received;
    }

    public String getTime()
    {
        return time;
    }

    public String getContent()
    {
        return content;
    }

    public boolean isReceived()
    {
        return received;
    }

    public void setReceived(boolean received)
    {
        this.received = received;
    }
}
