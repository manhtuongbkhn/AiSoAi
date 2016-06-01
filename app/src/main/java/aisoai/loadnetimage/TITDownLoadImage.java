package aisoai.loadnetimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import aisoai.titapplib.TITFunction;

public class TITDownLoadImage
{
    private static Bitmap defaultPlayerAvatar;
    //Cache
    private static ArrayList<TITNetImage> netImageArr=new ArrayList<TITNetImage>();

    private TITRequestImage requestImage;
    private Bitmap bitmap;
    private Handler handler;

    public TITDownLoadImage(TITRequestImage iRequestImage)
    {
        this.requestImage=iRequestImage;
        downloadImage();
    }

    private int downloadImage()
    {
        if(requestImage.getUrl().equals(""))
        {
            requestImage.setImage(defaultPlayerAvatar);
            return 0;
        }

        TITNetImage netImage=getNetImage(requestImage.getUrl());

        if(netImage!=null)
        {
            netImage.increaseRequestCount();
            switch (netImage.getStatus())
            {
                case DOWNLOADING:
                    netImage.addRequestImage(requestImage);
                    break;
                case SETTINGIMAGE:
                case FINISH:
                    requestImage.setImage(netImage.getBitmap());
                    break;
                case FAIL:
                    requestImage.setImage(defaultPlayerAvatar);
                    break;
            }
        }
        else
        {
            requestImage.setImage(defaultPlayerAvatar);
            final TITNetImage newNetImage=new TITNetImage(requestImage);
            newNetImage.increaseRequestCount();
            addNetImage(newNetImage);

            handler=new Handler()
            {
                @Override
                public void handleMessage(Message msg)
                {
                    if(bitmap!=null)
                    {
                        Bitmap newBitmap = TITFunction.getRoundedBitmap(bitmap);
                        newNetImage.setBitmap(newBitmap);
                        newNetImage.setStatus(TITNetImageStatus.SETTINGIMAGE);
                        newNetImage.reloadImage();
                        newNetImage.setStatus(TITNetImageStatus.FINISH);
                    }
                    else
                    {
                        newNetImage.setStatus(TITNetImageStatus.FAIL);
                    }
                }
            };

            Thread thread=new Thread()
            {
                @Override
                public void run()
                {
                    bitmap=null;
                    for(int i=1;i<=3;i++)
                    {
                        bitmap = downloadBitmap(newNetImage.getUrl());
                        if(bitmap!=null)
                            break;
                    }
                    handler.sendMessage(new Message());
                }
            };
            thread.start();
        }
        return 0;
    }

    private Bitmap downloadBitmap(String url)
    {
        try
        {
            InputStream inputStream = new URL(url).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e)
        {
            return null;
        }
    }

    synchronized private static void addNetImage(TITNetImage netImage)
    {
        syncNetImageArrMethod("addNetImage", netImage);
    }

    private static TITNetImage getNetImage(String url)
    {
        return (TITNetImage) syncNetImageArrMethod("getNetImage", url);
    }

    synchronized private static Object syncNetImageArrMethod(String methodName, Object param1)
    {
        TITNetImage netImage;
        switch (methodName)
        {
            case "addNetImage":
                netImage=(TITNetImage) param1;
                if(netImageArr.size()>= TITLoadNetImageConfig.CACHE_IMAGE_COUNT)
                {
                    netImageArr.clear();
                }
                netImageArr.add(netImage);
                break;
            case "getNetImage":
                String url=(String) param1;
                for(int i=0;i<netImageArr.size();i++)
                {
                    netImage=netImageArr.get(i);
                    if(netImage.getUrl().equals(url))
                        return netImage;
                }
                return null;
        }
        return null;
    }

    /*
    private static void clearTrash()
    {
        //Priority Filter
        ArrayList<TITNetImage> priorityFilterArr=new ArrayList<TITNetImage>();
        int minPriority=10;
        for(int i=0;i<netImageArr.size();i++)
        {
            TITNetImage netImage=netImageArr.get(i);
            int priority=netImage.getPriority();
            if(priority<minPriority)
                minPriority=priority;
        }

        for(int i=0;i<netImageArr.size();i++)
        {
            TITNetImage netImage=netImageArr.get(i);
            int priority=netImage.getPriority();
            if(priority==minPriority)
                priorityFilterArr.add(netImage);
        }
        System.out.println();
        //Request Count Filter
        ArrayList<TITNetImage> requestCountFilterArr=new ArrayList<TITNetImage>();
        int minRequestCount=1000;
        for(int i=0;i<priorityFilterArr.size();i++)
        {
            TITNetImage netImage=priorityFilterArr.get(i);
            int requestCount=netImage.getRequestCount();
            if(requestCount<minRequestCount)
                minRequestCount=requestCount;
        }

        for(int i=0;i<priorityFilterArr.size();i++)
        {
            TITNetImage netImage=priorityFilterArr.get(i);
            int requestCount=netImage.getRequestCount();
            if(requestCount==minRequestCount)
                requestCountFilterArr.add(netImage);
        }

        //Time Filter
        ArrayList<TITNetImage> timeFilterArr=new ArrayList<TITNetImage>();
        Date minTime=new Date();
        for(int i=0;i<requestCountFilterArr.size();i++)
        {
            TITNetImage netImage=requestCountFilterArr.get(i);
            Date requestTime=netImage.getNewRequestTime();
            if(requestTime.compareTo(minTime)<0)
                minTime=requestTime;
        }

        for(int i=0;i<requestCountFilterArr.size();i++)
        {
            TITNetImage netImage=requestCountFilterArr.get(i);
            Date requestTime=netImage.getNewRequestTime();
            if(requestTime.compareTo(minTime)==0)
            {
                timeFilterArr.add(netImage);
            }
        }

        while (true)
        {
            System.out.println("-Remove Image");
            TITNetImage netImage=timeFilterArr.get(0);
            netImageArr.remove(netImage);
            timeFilterArr.remove(netImage);
        }
    }
    */
    public static void setDefaultPlayerAvatar(Bitmap defaultPlayerAvatar)
    {
        TITDownLoadImage.defaultPlayerAvatar = defaultPlayerAvatar;
    }
}
