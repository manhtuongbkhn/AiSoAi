package aisoai.loadnetimage;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Date;

class TITNetImage
{
    private String url;
    private Bitmap bitmap;
    private TITNetImageStatus status;
    private ArrayList<TITRequestImage> requestImageArr=new ArrayList<TITRequestImage>();

    private int requestCount=0;
    private Date newRequestTime;
    private int priority;

    public TITNetImage(TITRequestImage requestImage)
    {
        this.url=requestImage.getUrl();
        addRequestImage(requestImage);
        this.newRequestTime=requestImage.getRequestTime();
        this.priority=requestImage.getPriority();
        this.status=TITNetImageStatus.DOWNLOADING;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap)
    {
        this.bitmap = bitmap;
    }

    public TITNetImageStatus getStatus()
    {
        return status;
    }

    public void setStatus(TITNetImageStatus status)
    {
        this.status = status;
    }

    public void addRequestImage(TITRequestImage requestImage)
    {
        syncRIArrMethod("addRequestImage",requestImage);
    }

    public void reloadImage()
    {
        syncRIArrMethod("reloadImage",null);
    }

    synchronized private Object syncRIArrMethod(String methodName,Object param1)
    {
        TITRequestImage requestImage;
        switch (methodName)
        {
            case "addRequestImage":
                requestImage=(TITRequestImage) param1;
                requestImageArr.add(requestImage);
                break;
            case "reloadImage":
                while (requestImageArr.size()>0)
                {
                    requestImage=requestImageArr.get(0);
                    requestImage.setImage(bitmap);
                    requestImageArr.remove(0);
                }
                break;
        }
        return null;
    }

    public void increaseRequestCount()
    {
        requestCount++;
    }

    public int getRequestCount()
    {
        return requestCount;
    }

    public Date getNewRequestTime()
    {
        return newRequestTime;
    }

    public void setNewRequestTime(Date newRequestTime)
    {
        this.newRequestTime = newRequestTime;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }
}
