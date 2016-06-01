package aisoai.titapplib;


import android.graphics.Bitmap;

import java.util.ArrayList;

public class TITTransferData
{
    private static ArrayList<Object> objectArr=new ArrayList<Object>();
    private static ArrayList<Bitmap> listAvatar=new ArrayList<Bitmap>();

    public static Object getObject(int index)
    {
        return objectArr.get(index);
    }

    public static void setObject(Object object,int index)
    {
        objectArr.set(index,object);
    }

    public static void addObject(Object object)
    {
        objectArr.add(object);
    }

    public static void removeObject(Object object)
    {
        objectArr.remove(object);
    }

    public static void init()
    {
        listAvatar=new ArrayList<Bitmap>();
    }

    public static void addAvatar(Bitmap avartar)
    {
        listAvatar.add(avartar);
    }

    public static Bitmap getAvatar(int player)
    {
        return listAvatar.get(player-1);
    }
}