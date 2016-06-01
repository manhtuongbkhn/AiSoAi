package aisoai.screens.gamescreeens.titentities;

import android.content.res.AssetManager;
import android.graphics.Bitmap;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.texture.Texture;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import java.io.IOException;
import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameConfig;

public abstract class TITGameResource
{
    protected TITGameActivity titGameActivity;
    protected Font timeFont;
    protected Font pointFont;
    protected TextureRegion hudBackground;
    private ArrayList<TITTexture> textureArr;

    public TITGameResource(TITGameActivity titGameActivity)
    {
        FontFactory.setAssetBasePath(TITGameConfig.FONT_FOLDER);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(TITGameConfig.GAME_IMAGE_FOLDER);
        MusicFactory.setAssetBasePath(TITGameConfig.MUSIC_FOLDER);
        this.titGameActivity=titGameActivity;
        textureArr=new ArrayList<TITTexture>();
    }

    public void init()
    {
        initDefaultFonts();
        initFonts();

        initDefaultPictures();
        initPictures();

        initDefaultSounds();
        initSounds();

        initDefaultMusics();
        initMusics();
    }

    private void initDefaultFonts()
    {
        int timeSize= TITSingleGameConfig.TIME_FONT_SIZE();
        int timeColor= TITSingleGameConfig.TIME_COLOR;
        timeFont=createFontFromAsset(timeSize,timeColor,"times.ttf");

        int pointSize= TITSingleGameConfig.POINT_FONT_SIZE();
        int pointColor= TITSingleGameConfig.POINT_COLOR;
        pointFont=createFontFromAsset(pointSize,pointColor,"times.ttf");
    }

    private void initDefaultPictures()
    {
        hudBackground=createTextureRegionFromAsset("hud-background.png",4);
    }

    private void initDefaultSounds()
    {

    }

    private void initDefaultMusics()
    {

    }

    public Font createFontFromAsset(int fontSize,int color,String imgPath)
    {
        Texture texture=createTexture(3);
        FontManager fontManager=titGameActivity.getFontManager();
        AssetManager assetManager=titGameActivity.getAssets();
        Font font=FontFactory.createFromAsset(fontManager,texture,assetManager,imgPath,fontSize,
                                                                                        true,color);
        texture.load();
        titGameActivity.getEngine().getFontManager().loadFont(font);

        return font;
    }

    public TextureRegion createTextureRegionFromAsset(String imgPath,int sizeType)
    {
        TITTexture texture=createTexture(sizeType);
        TextureRegion textureRegion=BitmapTextureAtlasTextureRegionFactory.createFromAsset
                (texture,titGameActivity,imgPath,0,0);
        texture.load();
        return textureRegion;
    }

    public TiledTextureRegion createTiledTextureRegionFromAsset(String imgPath,int column,int row,
                                                                                        int sizeType)
    {
        TITTexture texture=createTexture(sizeType);
        TiledTextureRegion tiledTextureRegion=BitmapTextureAtlasTextureRegionFactory.
                createTiledFromAsset(texture, titGameActivity, imgPath,0,0,column,row);
        texture.load();
        return tiledTextureRegion;
    }

    public TextureRegion createTextureRegionFromBitmap(Bitmap bitmap,int sizeType)
    {
        TITTexture texture=createTexture(sizeType);
        TITTextureSource textureSource=new TITTextureSource(bitmap);
        texture.addTextureAtlasSource(textureSource,0,0);
        texture.load();
        TextureRegion avartaTR= BitmapTextureAtlasTextureRegionFactory.createFromSource
                                                            (texture,textureSource,0,0);
        return avartaTR;
    }

    protected Music createMusicFromAsset(String musicPath)
    {
        try
        {
            return MusicFactory.createMusicFromAsset
                                    (titGameActivity.getMusicManager(),titGameActivity,musicPath);
        } catch (IOException e)
        {
            return null;
        }
    }

    protected abstract void initFonts();
    protected abstract void initPictures();
    protected abstract void initSounds();
    protected abstract void initMusics();

    public Font getTimeFont()
    {
        return timeFont;
    }

    public Font getPointFont()
    {
        return pointFont;
    }

    public TextureRegion getHudBackground()
    {
        return hudBackground;
    }

    private TITTexture createTexture(int sizeType)
    {
        int width,height;
        TextureManager textureManager=titGameActivity.getTextureManager();
        switch (sizeType)
        {
            case 0:
                width= TITGameConfig.TINY_TEXTURE_WIDTH;
                height= TITGameConfig.TINY_TEXTURE_HEIGHT;
                break;
            case 1:
                width= TITGameConfig.SMALL_TEXTURE_WIDTH;
                height= TITGameConfig.SMALL_TEXTURE_HEIGHT;
                break;
            case 2:
                width= TITGameConfig.MEDIUM_TEXTURE_WIDTH;
                height= TITGameConfig.MEDIUM_TEXTURE_HEIGHT;
                break;
            case 3:
                width= TITGameConfig.BIG_TEXTURE_WIDTH;
                height= TITGameConfig.BIG_TEXTURE_HEIGHT;
                break;
            case 4:
                width= TITGameConfig.HUGE_TEXTURE_WIDTH;
                height= TITGameConfig.HUGE_TEXTURE_HEIGHT;
                break;
            case 5:
            default:
                width= TITGameConfig.GIGATIC_TEXTURE_WIDTH;
                height= TITGameConfig.GIGATIC_TEXTURE_HEIGHT;
                break;
        }
        TITTexture texture=new TITTexture(textureManager,width,height,TextureOptions.BILINEAR);
        titGameActivity.getEngine().getTextureManager().loadTexture(texture);
        textureArr.add(texture);

        return texture;
    }

    public void destroy()
    {
        clearTexture();
        clearDefaultResource();
        clearResource();
    }

    private void clearTexture()
    {
        for(int i=0;i<textureArr.size();i++)
        {
            TITTexture texture=textureArr.get(i);
            titGameActivity.getTextureManager().unloadTexture(texture);
        }
    }

    private void clearDefaultResource()
    {
        timeFont=null;
        pointFont=null;
        hudBackground=null;
    }

    abstract protected void clearResource();
}
