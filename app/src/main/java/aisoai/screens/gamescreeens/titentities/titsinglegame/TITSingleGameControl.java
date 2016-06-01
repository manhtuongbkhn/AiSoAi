package aisoai.screens.gamescreeens.titentities.titsinglegame;

import android.graphics.Bitmap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.TITApplication;
import aisoai.config.KJS;
import aisoai.loadnetimage.TITRequestImage;
import aisoai.screens.gamescreeens.titentities.TITGameConfig;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITGameScriptReader;
import aisoai.screens.gamescreeens.titentities.TITPointText;
import aisoai.screens.gamescreeens.titentities.TITSprite;
import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.scoringscreen.scoringvsgame.ScoringVsGameControl;
import aisoai.titapplib.TITTransferData;

abstract public class TITSingleGameControl extends TITGameControl
{
    protected TITGameScriptReader gameScriptReader;

    @Override
    public void init()
    {
        super.init();
        initGameScriptReader();
        initUpdateHandler();
    }

    protected void initHUD()
    {
        TITSingleGameHUD titHud=new TITSingleGameHUD();
        titHud.setZIndex(TITGameConfig.HUD_LAYER);
        getCamera().setHUD(titHud);
        initHudBackGround();
        initTimeClock();
        initPoints(4);
        //Reset Point Text
        getHud().getPointText1().changeText("");
        getHud().getPointText2().changeText("");
        getHud().getPointText3().changeText("");
        getHud().getPointText4().changeText("");
    }

    protected void initHudBackGround()
    {

        TextureRegion hudBackgroundTR=gameResource.getHudBackground();
        TITSprite background=
                new TITSprite(0,0, TITSingleGameConfig.HUD_WIDTH(),TITSingleGameConfig.HUD_HEIGHT(),hudBackgroundTR,this)
                {
                    @Override
                    public TITGameControl getControl()
                    {
                        return TITSingleGameControl.this;
                    }
                };

        background.setZIndex(15);
        getHud().attachChild(background);
    }

    protected  void initPoints(int countPlayers)
    {
        for(int player=1;player<=countPlayers;player++)
        {
            initPoint(player);
        }
    }

    protected void initPoint(int player)
    {
        TITPointText pointText=TITPointText.createPointText(player, this);
        getHud().attachChild(pointText);
    }

    protected void initTimeClock()
    {
        TITDownTimeText timeText= TITDownTimeText.createDownTime(this);
        getHud().attachChild(timeText);
    }

    protected void initPlaySpace()
    {
        initBackground();
        initTITScene();
    }

    protected void initBackground()
    {
        AutoParallaxBackground autoParallaxBackground=new AutoParallaxBackground(0,0,0,5);
        TextureRegion backgroundTR=getBackground();
        float postionY=-1.0f* TITSingleGameConfig.CAMERA_Y();
        float width= TITSingleGameConfig.GS_WIDTH();
        float height= TITSingleGameConfig.GS_HEIGHT();
        TITSprite sprite=new TITSprite(0,postionY,width,height,backgroundTR,this)
        {
            @Override
            public TITGameControl getControl()
            {
                return TITSingleGameControl.this;
            }
        };
        AutoParallaxBackground.ParallaxEntity parallaxEntity=
                new AutoParallaxBackground.ParallaxEntity(0f,sprite);
        autoParallaxBackground.attachParallaxEntity(parallaxEntity);
        getScene().setBackground(autoParallaxBackground);
    }

    abstract protected TextureRegion getBackground();

    abstract protected void initTITScene();

    @Override
    public void playingGameUserInfoNotify(JsonObject fromServerData)
    {
        JsonArray userInfoJsonArr=fromServerData.get(KJS.ARRAY).getAsJsonArray();
        for(int i=0;i<userInfoJsonArr.size();i++)
        {
            JsonObject userInfo=userInfoJsonArr.get(i).getAsJsonObject();
            String avatarUrl=userInfo.get(KJS.AVATAR_URL).getAsString();
            switch (i)
            {
                case 0:
                    new TITRequestImage(avatarUrl,6)
                    {
                        @Override
                        protected void setImage(Bitmap bitmap)
                        {
                            pasteAvarta(bitmap, 1);
                        }
                    };
                    break;
                case 1:
                    new TITRequestImage(avatarUrl,6)
                    {
                        @Override
                        protected void setImage(Bitmap bitmap)
                        {
                            pasteAvarta(bitmap,2);
                        }
                    };
                    break;
                case 2:
                    new TITRequestImage(avatarUrl,6)
                    {
                        @Override
                        protected void setImage(Bitmap bitmap)
                        {
                            pasteAvarta(bitmap,3);
                        }
                    };
                    break;
                case 3:
                    new TITRequestImage(avatarUrl,6)
                    {
                        @Override
                        protected void setImage(Bitmap bitmap)
                        {
                            pasteAvarta(bitmap,4);
                        }
                    };
                    break;
            }
        }
    }

    private void pasteAvarta(Bitmap bitmap,int player)
    {
        TITAvatar avatar=TITAvatar.createAvatar(bitmap, player, this);
        getHud().attachChild(avatar);
    }

    public void reloadPlayingPointNotify(JsonObject fromServerData)
    {
        JsonArray jsonArray=fromServerData.get(KJS.POINT_ARR).getAsJsonArray();

        for(int i=0;i<jsonArray.size();i++)
        {
            Integer roundPoint=jsonArray.get(i).getAsInt();
            switch (i)
            {
                case 0:
                    getHud().getPointText1().changeText(roundPoint.toString());
                    break;
                case 1:
                    getHud().getPointText2().changeText(roundPoint.toString());
                    break;
                case 2:
                    getHud().getPointText3().changeText(roundPoint.toString());
                    break;
                case 3:
                    getHud().getPointText4().changeText(roundPoint.toString());
                    break;
            }
        }
    }

    public void playingGameDownTimeNotify(JsonObject fromServerData)
    {
        Integer time=fromServerData.get(KJS.DOWN_TIME).getAsInt();
        getHud().getDownTimeText().changeText(time.toString());
    }

    protected void initGameScriptReader()
    {
        JsonArray gameScript=(JsonArray) TITTransferData.getObject(0);
        TITTransferData.removeObject(gameScript);
        gameScriptReader =new TITGameScriptReader(gameScript)
        {
            @Override
            public void readToken(JsonObject token)
            {
                TITSingleGameControl.this.readToken(token);
            }
        };
    }

    abstract protected void initUpdateHandler();

    public void startScoringNotify(JsonObject fromServerData)
    {
        gameScriptReader.stop();
        super.startScoringNotify(fromServerData);
    }

    protected ScoringControl initScoringControl()
    {
        return new ScoringVsGameControl();
    }

    public TITSingleGameHUD getHud()
    {
        return (TITSingleGameHUD) getCamera().getHUD();
    }

    @Override
    abstract public void finish();

    abstract protected void readToken(JsonObject token);
}
