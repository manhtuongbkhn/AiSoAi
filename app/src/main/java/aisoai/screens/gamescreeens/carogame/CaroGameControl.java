package aisoai.screens.gamescreeens.carogame;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.smartfoxserver.v2.entities.data.SFSArray;

import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.config.KJS;
import aisoai.loadnetimage.TITDownLoadImage;
import aisoai.loadnetimage.TITRequestImage;
import aisoai.screens.gamescreeens.titentities.TITGameConfig;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITGameModel;
import aisoai.screens.gamescreeens.titentities.TITHUD;
import aisoai.screens.gamescreeens.titentities.TITSprite;
import aisoai.screens.gamescreeens.titentities.titvsgame.TITVsGameControl;
import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.scoringscreen.scoringcaro.ScoringCaroControl;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.ITITActivity;

public class CaroGameControl extends TITVsGameControl
{
    @Override
    protected void initHUD()
    {
        CaroGameHUD hud=new CaroGameHUD();
        hud.setZIndex(TITGameConfig.HUD_LAYER);
        getCamera().setHUD(hud);
        initHudBackground();

        DownTimeText downTimeText=DownTimeText.createDownTime(this);
        hud.attachChild(downTimeText);

        Bout bout=Bout.createBout(CaroGameControl.this);
        hud.attachChild(bout);
    }

    protected void initHudBackground()
    {
        TextureRegion hudBackgroundTR=gameResource.getHudBackground();
        TITSprite background=
                new TITSprite(0,0,CaroGameConfig.HUD_WIDTH,CaroGameConfig.HUD_HEIGHT,hudBackgroundTR,this)
                {
                    @Override
                    public TITGameControl getControl()
                    {
                        return CaroGameControl.this;
                    }
                };

        background.setZIndex(15);
        getHud().attachChild(background);
    }

    @Override
    protected void initPlaySpace()
    {
        initLine();
        initItem();
    }

    private void initLine()
    {
        for(int column=1;column<=17;column++)
        {
            HorizontalLine horizontalLine=HorizontalLine.createLine(column,this);
            getScene().attachChild(horizontalLine);
        }

        for(int row=1;row<=17;row++)
        {
            VerticalLine verticalLine=VerticalLine.createLine(row,this);
            getScene().attachChild(verticalLine);
        }
    }

    private void initItem()
    {
        for(int row=1;row<=16;row++)
        {
            for(int column=1;column<=16;column++)
            {
                Item item=Item.createItem(row,column,CaroGameControl.this);
                getScene().attachChild(item);
                getScene().registerTouchArea(item);
            }
        }
    }

    public void itemTouchEvent(Item item)
    {
        int row=item.getRow();
        int column= item.getColumn();

        getRequestFactory().tickRequest(row,column);
    }

    public void tickResponse(JsonObject fromServerData)
    {
        //System.out.println("-Tick Response");
    }

    public void tickNotify(JsonObject fromServerData)
    {
        //System.out.println("-Tick Notity");
        int row=fromServerData.get(KJS.PARAM1).getAsInt();
        int column=fromServerData.get(KJS.PARAM2).getAsInt();
        int type=fromServerData.get(KJS.PARAM3).getAsInt();
        Item item=getScene().getItem(row, column);
        item.setCurrentTileIndex(type);
    }

    public void boutNotify(JsonObject fromServerData)
    {
        int bout=fromServerData.get(KJS.PARAM1).getAsInt();
        if(bout==0)
            getHud().getBout().hiden();
        if(bout==1)
            getHud().getBout().toTop();
        if(bout==2)
            getHud().getBout().toBot();
    }

    public void downtimeNotify(JsonObject fromServerData)
    {
        Integer downTime=fromServerData.get(KJS.PARAM1).getAsInt();
        System.out.println("-Down Time:" + downTime);
        getHud().getDownTimeText().changeText(downTime.toString());
    }

    public void winNotify(JsonObject fromServerData)
    {
        System.out.println("-Win Notify");
        JsonArray indexJsonArray=fromServerData.get(KJS.ARRAY).getAsJsonArray();
        int size=indexJsonArray.size();
        for(int i=0;i<indexJsonArray.size();i++)
        {
            int fromIndex=indexJsonArray.get(0).getAsInt();
            int toIndex=indexJsonArray.get(size-1).getAsInt();
            WinLine winLine=WinLine.createWiLine(fromIndex,toIndex,CaroGameControl.this);
            getScene().attachChild(winLine);
        }
    }

    @Override
    public void playingGameUserInfoNotify(JsonObject fromServerData)
    {
        JsonArray userJsonArray=fromServerData.get(KJS.ARRAY).getAsJsonArray();

        JsonObject user1JsonObject=userJsonArray.get(0).getAsJsonObject();
        String url1=user1JsonObject.get(KJS.AVATAR_URL).getAsString();
        new TITRequestImage(url1,10)
        {
            @Override
            protected void setImage(Bitmap bitmap)
            {
                TextureRegion textureRegion=gameResource.createTextureRegionFromBitmap(bitmap,1);
                Avarta avarta=Avarta.createAvatar(true,textureRegion,CaroGameControl.this);
                getHud().attachChild(avarta);
            }
        };

        JsonObject user2JsonObject=userJsonArray.get(1).getAsJsonObject();
        String url2=user2JsonObject.get(KJS.AVATAR_URL).getAsString();
        new TITRequestImage(url2,10)
        {
            @Override
            protected void setImage(Bitmap bitmap)
            {
                TextureRegion textureRegion=gameResource.createTextureRegionFromBitmap(bitmap,1);
                Avarta avarta=Avarta.createAvatar(false,textureRegion,CaroGameControl.this);
                getHud().attachChild(avarta);
            }
        };
    }

    @Override
    protected ScoringControl initScoringControl()
    {
        return new ScoringCaroControl();
    }

    @Override
    public CaroGameSence getScene()
    {
        return (CaroGameSence) engine.getScene();
    }

    @Override
    public void finish()
    {

    }

    @Override
    public Class<? extends ITITActivity> initActivity()
    {
        return CaronGameActivity.class;
    }

    @Override
    protected TITGameModel initModel()
    {
        return new TITGameModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new CaroGameRF();
    }

    @Override
    public CaronGameActivity getActivity()
    {
        return (CaronGameActivity) activity;
    }

    @Override
    public TITGameModel getModel()
    {
        return (TITGameModel) model;
    }

    @Override
    public CaroGameRF getRequestFactory()
    {
        return (CaroGameRF) requestFactory;
    }

    public CaroGameHUD getHud()
    {
        return (CaroGameHUD) getCamera().getHUD();
    }
}
