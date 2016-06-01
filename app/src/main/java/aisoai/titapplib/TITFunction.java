package aisoai.titapplib;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;


import java.util.ArrayList;
import java.util.Random;

import aisoai.config.KJS;

public class TITFunction
{
    public static JsonObject checkMessage(String message)
    {
        JsonObject jsonObject=new JsonObject();

        if(message==null)
            jsonObject.addProperty(KJS.SUCESS,false);
        else
        {
            jsonObject.addProperty(KJS.SUCESS,true);

        }

        return jsonObject;
    }

    public static int randInt(int max)
    {
        Random random=new Random();
        int d=random.nextInt(max);
        return d+1;
    }

    public static int covertTime(Float fTime)
    {
        int iTime=fTime.intValue();
        if(fTime-iTime>=0.00001)
        {
            iTime=iTime+1;
        }
        return iTime;
    }

    public static JsonObject covertToJsonObject(SFSObject sfsObject)
    {
        Gson gson=new Gson();
        String jsonStr=sfsObject.toJson();
        JsonObject jsonObject=gson.fromJson(jsonStr, JsonObject.class);
        return jsonObject;
    }

    public static SFSObject covertToSFSObject(JsonObject jsonObject)
    {
        String jsonStr=jsonObject.toString();
        SFSObject sfsObject=(SFSObject)SFSObject.newFromJsonData(jsonStr);
        return sfsObject;
    }

    public static JsonArray covertToJsonArray(SFSArray sfsArray)
    {
        Gson gson=new Gson();
        String jsonStr=sfsArray.toJson();
        JsonArray jsonArray=gson.fromJson(jsonStr, JsonArray.class);
        return jsonArray;
    }

    public static SFSArray covertToSFSArray(JsonArray jsonArray)
    {
        String jsonStr=jsonArray.toString();
        SFSArray sfsArray=SFSArray.newFromJsonData(jsonStr);
        return sfsArray;
    }

    public static ArrayList<Integer> covertToIntArrayList(JsonArray jsonArray)
    {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        for(int i=0;i<jsonArray.size();i++)
        {
            int number=jsonArray.get(i).getAsInt();
            arrayList.add(number);
        }
        return arrayList;
    }

    public static JsonArray covertToIntJsonArray(ArrayList<Integer> arrayList)
    {
        JsonArray jsonArray=new JsonArray();
        for(int i=0;i<arrayList.size();i++)
        {
            int number=arrayList.get(i);
            jsonArray.add(new JsonPrimitive(number));
        }
        return jsonArray;
    }

    public static SFSArray covertToIntSFSArray(ArrayList<Integer> arrayList)
    {
        SFSArray sfsArray=new SFSArray();
        for(int i=0;i<arrayList.size();i++)
        {
            int number=arrayList.get(i);
            sfsArray.addInt(number);
        }
        return sfsArray;
    }

    public static ArrayList<Float> covertToFloatArrayList(JsonArray jsonArray)
    {
        ArrayList<Float> arrayList=new ArrayList<Float>();
        for(int i=0;i<jsonArray.size();i++)
        {
            Float f=jsonArray.get(i).getAsFloat();
            arrayList.add(f);
        }
        return arrayList;
    }

    public static JsonArray covertToFloatJsonArray(ArrayList<Float> arrayList)
    {
        JsonArray jsonArray=new JsonArray();
        for(int i=0;i<arrayList.size();i++)
        {
            Float f=arrayList.get(i);
            jsonArray.add(new JsonPrimitive(f));
        }
        return jsonArray;
    }

    public static SFSArray covertToFloatSFSArray(JsonArray jsonArray)
    {
        SFSArray sfsArray=new SFSArray();
        for(int i=0;i<jsonArray.size();i++)
        {
            Float f=jsonArray.get(i).getAsFloat();
            sfsArray.addFloat(f);
        }
        return sfsArray;
    }

    public static SFSArray covertToFloatSFSArray(ArrayList<Float> arrayList)
    {
        SFSArray sfsArray=new SFSArray();
        for(int i=0;i<arrayList.size();i++)
        {
            Float f=arrayList.get(i);
            sfsArray.addFloat(f);
        }
        return sfsArray;
    }

    public static int stringWidth(String str,Paint paint)
    {
        Rect rect=new Rect();
        paint.getTextBounds(str,0,str.length(),rect);
        return rect.width();
    }

    public static int stringHeight(String str,Paint paint)
    {
        Rect rect=new Rect();
        paint.getTextBounds(str,0,str.length(),rect);
        return rect.height();
    }

    public static Bitmap overlay(Bitmap bitmap1, Bitmap bitmap2)
    {
        Bitmap bmOverlay = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(),bitmap2.getConfig());
        Canvas canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(bitmap1,new Matrix(),null);
        canvas.drawBitmap(bitmap2, 0, 0, null);
        return bmOverlay;
    }

    public static Bitmap getRoundedBitmap(Bitmap bitmap)
    {
        int width=bitmap.getWidth();
        int height=bitmap.getHeight();
        final Bitmap output = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = org.andengine.util.color.Color.ARGB_PACKED_BLUE_CLEAR;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0,0,width,height);
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        paint.setStrokeWidth(5);
        canvas.drawOval(rectF,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();

        return output;
    }

    public static Bitmap createSummaryPointBitmap(Integer ep,Integer rp,Bitmap bitmap1,Bitmap bitmap2,Integer width,Integer height,int textSize)
    {
        Bitmap bufferBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas bitmapCanvas = new Canvas(bufferBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(textSize);
        Typeface typeface=Typeface.create(paint.getTypeface(),Typeface.BOLD_ITALIC);
        paint.setTypeface(typeface);
        bitmapCanvas.drawARGB(255, 230, 230, 230);
        paint.setColor(Color.argb(255,255,51,204));

        String epStr,rpStr;
        float X,Y;
        int strWidth,strHeight;
        if(ep>=0)
            epStr="+"+ep.toString();
        else
            epStr=ep.toString();
        if(rp>=0)
            rpStr="+"+rp.toString();
        else
            rpStr=rp.toString();

        X = width/4;
        Y = height/2;
        strWidth = TITFunction.stringWidth(epStr, paint);
        strHeight = TITFunction.stringHeight(epStr, paint);
        bitmapCanvas.drawText(epStr,X-strWidth,Y+strHeight/2, paint);

        X = 3*width/4;
        Y = height/2;
        strWidth = TITFunction.stringWidth(rpStr, paint);
        strHeight = TITFunction.stringHeight(rpStr, paint);
        bitmapCanvas.drawText(rpStr,X-strWidth,Y+strHeight/2,paint);

        X = width/4;
        Y = height/2;
        Rect src=new Rect(0,0,bitmap1.getWidth(),bitmap1.getHeight());
        Rect dst=new Rect((int)X,(int)Y-height/2,(int)X+height,(int)Y+height/2);
        bitmapCanvas.drawBitmap(bitmap1, src, dst, paint);


        X = 3*width/4;
        Y = height/2;
        src=new Rect(0,0,bitmap2.getWidth(),bitmap2.getHeight());
        dst=new Rect((int) X,(int)Y-height/2,(int)X+height,(int)Y+height/2);
        bitmapCanvas.drawBitmap(bitmap2,src,dst,paint);

        return bufferBitmap;
    }

    public static int convertMinute(int time)
    {
        int minute=time/60;
        return minute;
    }

    public static int convertSecond(int time)
    {
        int minute=time/60;
        return time-minute*60;
    }

    public static Uri resourceToUri (Context context,int resID)
    {
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                context.getResources().getResourcePackageName(resID) + '/' +
                context.getResources().getResourceTypeName(resID) + '/' +
                context.getResources().getResourceEntryName(resID) );
    }
}
