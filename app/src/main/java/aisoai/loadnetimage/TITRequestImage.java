package aisoai.loadnetimage;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Date;


abstract public class TITRequestImage
{
    private String url;
    private Date requestTime;
    private int priority;
    private static Bitmap defaultPlayerAvatar;
    private static ArrayList<TITNetImage> bitmapArr=new ArrayList<TITNetImage>();

    public TITRequestImage(String iUrl,int iPriority)
    {
        this.url=iUrl;
        this.requestTime=new Date();
        this.priority=iPriority;
        TITDownLoadImage downLoadImage=new TITDownLoadImage(this);
    }

    public String getUrl()
    {
        return url;
    }

    public Date getRequestTime()
    {
        return requestTime;
    }

    public int getPriority()
    {
        return priority;
    }

    abstract protected void setImage(Bitmap bitmap);
}