package aisoai.screens.gamescreeens.titentities;

import android.graphics.Bitmap;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.source.BaseTextureAtlasSource;

public class TITTextureSource extends BaseTextureAtlasSource implements
                                                                        IBitmapTextureAtlasSource
{
    private Bitmap bitmap;

    public TITTextureSource(Bitmap iBitmap)
    {
        super(0,0,iBitmap.getWidth(),iBitmap.getHeight());
        bitmap=iBitmap;
    }

    @Override
    public Bitmap onLoadBitmap(Bitmap.Config pBitmapConfig)
    {
        return bitmap.copy(pBitmapConfig.ARGB_8888,true);
    }

    @Override
    public IBitmapTextureAtlasSource deepCopy()
    {
        return new TITTextureSource(bitmap.copy(Bitmap.Config.ARGB_8888,true));
    }
}
