package aisoai.screens.gamescreeens.titentities.titsinglegame;

import android.graphics.Bitmap;

import org.andengine.opengl.texture.region.TextureRegion;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class TITAvatar extends TITSprite
{

    public TITAvatar(float x,float y,float width,float height,TextureRegion textureRegion,
                                                                        TITGameControl inputControl)
    {
        super(x, y, width, height, textureRegion, inputControl);
    }

    @Override
    public TITGameControl getControl()
    {
        return null;
    }

    public static TITAvatar createAvatar(Bitmap bitmap,int player,TITGameControl inputControl)
    {
        TextureRegion avataTR=inputControl.gameResource.createTextureRegionFromBitmap(bitmap,1);
        float x,y,width,height;
        width= TITSingleGameConfig.AVATAR_WIDTH();
        height= TITSingleGameConfig.AVATAR_HEIGHT();

        switch (player)
        {
            case 1:
                x= TITSingleGameConfig.CENTER_AVATAR1_X()- TITSingleGameConfig.AVATAR_WIDTH()/2;
                break;
            case 2:
                x= TITSingleGameConfig.CENTER_AVATAR2_X()- TITSingleGameConfig.AVATAR_WIDTH()/2;
                break;
            case 3:
                x= TITSingleGameConfig.CENTER_AVATAR3_X()- TITSingleGameConfig.AVATAR_WIDTH()/2;
                break;
            case 4:
            default:
                x= TITSingleGameConfig.CENTER_AVATAR4_X()- TITSingleGameConfig.AVATAR_WIDTH()/2;
                break;
        }

        y= TITSingleGameConfig.CENTER_AVATAR_Y()- TITSingleGameConfig.AVATAR_WIDTH()/2;
        TITAvatar avatar=new TITAvatar(x,y,width,height,avataTR,inputControl);
        avatar.setZIndex(TITSingleGameConfig.AVARTA_LAYER);
        return avatar;
    }
}
