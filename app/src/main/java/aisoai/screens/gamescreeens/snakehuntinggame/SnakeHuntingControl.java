package aisoai.screens.gamescreeens.snakehuntinggame;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.config.KJS;
import aisoai.screens.gamescreeens.titentities.TITGameModel;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameControl;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.ITITActivity;
import aisoai.titapplib.TITFunction;

public class SnakeHuntingControl extends TITSingleGameControl
{
    @Override
    protected TextureRegion getBackground()
    {
        return SnakeHuntingGameResource.getBackground();
    }

    @Override
    protected void initTITScene()
    {
        for(int direction=1;direction<=4;direction++)
        {
            DirectionButton directionButton=DirectionButton.createDirectionButton(direction,this);
            getScene().attachChild(directionButton);
            getScene().registerTouchArea(directionButton);
        }

        Wall topWall=Wall.createTopWall(this);
        Wall leftWall=Wall.createLeftWall(this);
        Wall botWall=Wall.createBotWall(this);
        Wall rightWall=Wall.createRightWall(this);

        getScene().attachChild(topWall);
        getScene().attachChild(leftWall);
        getScene().attachChild(botWall);
        getScene().attachChild(rightWall);
    }

    @Override
    protected void initUpdateHandler()
    {
        gameScriptReader.start();
    }

    @Override
    protected void readToken(JsonObject token)
    {
        String methodName=token.get(KJS.METHOD_NAME).getAsString();
        switch (methodName)
        {
            case "init":
                Float gameOverTime=token.get(KJS.PARAM1).getAsFloat();
                getModel().setTime(gameOverTime);
                initGame(token);
                break;
            case "sleep":
                int sleepTime=token.get(KJS.PARAM1).getAsInt();
                try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
                break;
            case "createNewApple":
                int index=token.get(KJS.INDEX).getAsInt();
                int appleIndex1=token.get(KJS.PARAM1).getAsInt();
                int appleIndex2=token.get(KJS.PARAM2).getAsInt();
                int appleIndex3=token.get(KJS.PARAM3).getAsInt();
                initApple(index,appleIndex1,appleIndex2,appleIndex3);
                gameScriptReader.stop();
                break;
        }
    }

    private void initGame(JsonObject token)
    {
        getModel().snakeRunTimeMillis=token.get(KJS.PARAM4).getAsInt();
        ///////////////////////////////////////////////////////////////////////////////////////////
        JsonArray wallJsonArray=token.get(KJS.PARAM5).getAsJsonArray();
        for(int i=0;i<wallJsonArray.size();i++)
        {
            JsonObject wallJsonObject=wallJsonArray.get(i).getAsJsonObject();
            int wallRow=wallJsonObject.get(KJS.PARAM1).getAsInt();
            int wallColumn=wallJsonObject.get(KJS.PARAM2).getAsInt();
            int itemWidth=wallJsonObject.get(KJS.PARAM3).getAsInt();
            int itemHeight=wallJsonObject.get(KJS.PARAM4).getAsInt();
            Wall wall=Wall.createCustomWall(wallRow,wallColumn,itemWidth,itemHeight,this);
            getScene().attachChild(wall);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////
        JsonObject startPostionJSonObject=token.get(KJS.PARAM6).getAsJsonObject();
        getModel().snakeStartRow=startPostionJSonObject.get(KJS.PARAM1).getAsInt();
        getModel().snakeStartColumn=startPostionJSonObject.get(KJS.PARAM2).getAsInt();
        getModel().snakeStartDirection=startPostionJSonObject.get(KJS.PARAM3).getAsInt();
        getModel().partLen=startPostionJSonObject.get(KJS.PARAM4).getAsInt();
        initSnake();

        JsonArray wallIndexJsonArray=token.get(KJS.PARAM7).getAsJsonArray();
        getModel().wallIndexArr=TITFunction.covertToIntArrayList(wallIndexJsonArray);
    }

    private void initSnake()
    {
        Snake snake=new Snake(getModel().snakeStartRow,getModel().snakeStartColumn,
                                        getModel().snakeStartDirection,getModel().partLen,this);
        getScene().addSnake(snake);
        snake.setRunTimeMillis(getModel().snakeRunTimeMillis);
    }

    private int initApple(int index,Integer appleIndex1,Integer appleIndex2,Integer appleIndex3)
    {
        boolean b1=!getModel().wallIndexArr.contains(appleIndex1);
        boolean b2=!getScene().getSnake().getIndexArr().contains(appleIndex1);
        if(b1&&b2)
        {
            Apple apple = Apple.createApple(index,appleIndex1, this);
            getScene().attachChild(apple);
            return 0;
        }
        else
        {
            b1=!getModel().wallIndexArr.contains(appleIndex2);
            b2=!getScene().getSnake().getIndexArr().contains(appleIndex2);
            if(b1&&b2)
            {
                Apple apple = Apple.createApple(index,appleIndex2,this);
                getScene().attachChild(apple);
                return 0;
            }
            else
            {
                b1=!getModel().wallIndexArr.contains(appleIndex3);
                b2=!getScene().getSnake().getIndexArr().contains(appleIndex3);
                if(b1&&b2)
                {
                    Apple apple = Apple.createApple(index,appleIndex3,this);
                    getScene().attachChild(apple);
                    return 0;
                }
                else
                {
                    while(true)
                    {
                        int radomIndex=TITFunction.randInt(320)-1;
                        b1=!getModel().wallIndexArr.contains(radomIndex);
                        b2=!getScene().getSnake().getIndexArr().contains(radomIndex);
                        if(b1&&b2)
                        {
                            Apple apple = Apple.createApple(index,radomIndex,this);
                            getScene().attachChild(apple);
                            return 0;
                        }
                    }
                }
            }
        }
    }

    public void eateAppleEvent()
    {
        Apple apple=getScene().getApple();
        getRequestFactory().eatAppleRequest(apple.getIndex());
        getScene().detachChild(getScene().getApple());
        gameScriptReader.resume();
    }

    public void collidesEvent()
    {
        getScene().getSnake().stop();
        getScene().removeSnake(getScene().getSnake());
        getRequestFactory().dieRequest();
        initSnake();
        getScene().detachChild(getScene().getApple());
        gameScriptReader.resume();
    }

    public void directionButtonTouchEvent(DirectionButton directionButton)
    {
        getScene().getSnake().changeDirection(directionButton.getDirection());
    }

    @Override
    public void finish()
    {
        getScene().getSnake().stop();
    }

    @Override
    public Class<? extends ITITActivity> initActivity()
    {
        return SnakeHuntingGameActivity.class;
    }

    @Override
    public SnakeHuntingGameSence getScene()
    {
        return (SnakeHuntingGameSence) engine.getScene();
    }

    @Override
    protected TITGameModel initModel()
    {
        return new SnakeHuntingGameModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new SnakeHuntingGameRF();
    }

    @Override
    public SnakeHuntingGameActivity getActivity()
    {
        return (SnakeHuntingGameActivity) activity;
    }

    @Override
    public SnakeHuntingGameModel getModel()
    {
        return (SnakeHuntingGameModel) model;
    }

    @Override
    public SnakeHuntingGameRF getRequestFactory()
    {
        return (SnakeHuntingGameRF) requestFactory;
    }
}
