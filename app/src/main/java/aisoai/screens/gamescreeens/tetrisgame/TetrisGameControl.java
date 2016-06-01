package aisoai.screens.gamescreeens.tetrisgame;

import android.view.MotionEvent;

import com.google.gson.JsonObject;
import org.andengine.opengl.texture.region.TextureRegion;

import aisoai.config.KJS;
import aisoai.screens.gamescreeens.tetrisgame.brick.Brick;
import aisoai.screens.gamescreeens.tetrisgame.brick.IBrick;
import aisoai.screens.gamescreeens.tetrisgame.brick.LBrick;
import aisoai.screens.gamescreeens.tetrisgame.brick.LXBrick;
import aisoai.screens.gamescreeens.tetrisgame.brick.OBrick;
import aisoai.screens.gamescreeens.tetrisgame.brick.TXBrick;
import aisoai.screens.gamescreeens.tetrisgame.brick.ZBirck;
import aisoai.screens.gamescreeens.tetrisgame.brick.ZXBrick;
import aisoai.screens.gamescreeens.titentities.TITGameModel;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameControl;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.ITITActivity;

public class TetrisGameControl extends TITSingleGameControl
{
    @Override
    protected void initBackground()
    {

    }

    @Override
    protected TextureRegion getBackground()
    {
        return null;
    }

    @Override
    protected void initTITScene()
    {
        initWall();
        initLine();

        DirectionButton directionButton=DirectionButton.createDirectionButton(1,this);
        getScene().attachChild(directionButton);
        getScene().registerTouchArea(directionButton);

        directionButton=DirectionButton.createDirectionButton(2,this);
        getScene().attachChild(directionButton);
        getScene().registerTouchArea(directionButton);

        directionButton=DirectionButton.createDirectionButton(3,this);
        getScene().attachChild(directionButton);
        getScene().registerTouchArea(directionButton);

        RotateButton rotateButton = RotateButton.createSpeedButton(this);
        getScene().attachChild(rotateButton);
        getScene().registerTouchArea(rotateButton);

        NextBrick nextBrick=NextBrick.createNextBrick(this);
        getScene().attachChild(nextBrick);
    }

    public void initWall()
    {
        for(int row=1;row<=19;row++)
        {
            StoneItem stoneItem = StoneItem.createWall(row, 1, this);
            getScene().attachChild(stoneItem);
            stoneItem = StoneItem.createWall(row,12,this);
            getScene().attachChild(stoneItem);
        }

        for(int column=2;column<=11;column++)
        {
            int row=1;
            StoneItem stoneItem = StoneItem.createWall(row, column, this);
            getScene().attachChild(stoneItem);
        }
    }

    public void initLine()
    {
        for(int row=3;row<=17;row++)
        {
            VerticalLine verticalLine=VerticalLine.createVerticalLine(row, this);
            getScene().attachChild(verticalLine);
        }

        for(int column=3;column<=11;column++)
        {
            HorizontalLine horizontalLine=HorizontalLine.createHorizontalLine(column, this);
            getScene().attachChild(horizontalLine);
        }
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
                getModel().setGameStatus(GameStatus.READY);
                Float gameOverTime=token.get(KJS.PARAM1).getAsFloat();
                getModel().setTime(gameOverTime);
                getModel().baseSlowRunTimeMillis=token.get(KJS.PARAM1).getAsInt();
                getModel().baseFastRunTimeMillis=token.get(KJS.PARAM2).getAsInt();
                break;
            case "sleep":
                int sleepTime=token.get(KJS.PARAM1).getAsInt();
                try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
                break;
            case "createNewBrick":

                int index=token.get(KJS.INDEX).getAsInt();
                int currentBrickType=token.get(KJS.PARAM1).getAsInt();
                int nextBrickType=token.get(KJS.PARAM2).getAsInt();
                int slowRunTimeMillis=token.get(KJS.PARAM3).getAsInt();
                showQuestion(currentBrickType,nextBrickType,slowRunTimeMillis);
                gameScriptReader.stop();
                break;
        }
    }

    private void showQuestion(int currentBrickType,int nextBirckType,int slowRunTimeMillis)
    {
        getModel().setGameStatus(GameStatus.SHOWING);
        Brick brick;
        switch (currentBrickType)
        {
            case 1:
                brick=new OBrick(this,slowRunTimeMillis);
                break;
            case 2:
                brick=new ZBirck(this,slowRunTimeMillis);
                break;
            case 3:
                brick=new ZXBrick(this,slowRunTimeMillis);
                break;
            case 4:
                brick=new TXBrick(this,slowRunTimeMillis);
                break;
            case 5:
                brick=new LXBrick(this,slowRunTimeMillis);
                break;
            case 6:
                brick=new LBrick(this,slowRunTimeMillis);
                break;
            case 7:
            default:
                brick=new IBrick(this,slowRunTimeMillis);
                break;
        }
        getScene().addBrick(brick);
        brick.move();

        getScene().getNextBrick().setType(nextBirckType);
        getModel().setGameStatus(GameStatus.PLAYING);
    }

    public void directionButtonTouchEvent(MotionEvent motionEvent,DirectionButton directionButton)
    {
        switch (getModel().getGameStatus())
        {
            case PLAYING:
                switch (directionButton.getDirection())
                {
                    case 1:
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                            getScene().getCurrentBrick().turnRight();
                        break;
                    case 2:
                        switch (motionEvent.getAction())
                        {
                            case MotionEvent.ACTION_DOWN:
                            case MotionEvent.ACTION_MOVE:
                                getScene().getCurrentBrick().
                                                        setSpeed(getModel().baseFastRunTimeMillis);
                             break;
                            case MotionEvent.ACTION_UP:
                                getScene().getCurrentBrick().setSpeed(getScene().
                                        getCurrentBrick().getSlowRunTimeMillis());
                                break;
                        }
                        break;
                    case 3:
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                            getScene().getCurrentBrick().turnLeft();
                        break;
                }
                break;
        }
    }

    public void speedButtonTouchEvent(RotateButton rotateButton)
    {
        switch (getModel().getGameStatus())
        {
            case PLAYING:
                getScene().getCurrentBrick().rotate90();
                break;
        }
    }

    public void fallFinishEvent()
    {
        getModel().setGameStatus(GameStatus.SLEEPING);
        int fullItemRowCount=getScene().reloadAllItem();
        if(fullItemRowCount>0)
        {
            getRequestFactory().sendGameAnswer(-1,fullItemRowCount);
            playTrueSound();
        }
        if(getScene().checkGameOver())
            gameOver();
        else
        {
            try {Thread.sleep(200);} catch (InterruptedException e) {}
            gameScriptReader.resume();
        }
    }

    private void playTrueSound()
    {

    }

    private void gameOver()
    {
        getModel().setGameStatus(GameStatus.FINISH);
    }

    @Override
    public void finish()
    {
        getModel().setGameStatus(GameStatus.FINISH);
        getScene().getCurrentBrick().stop();
    }

    @Override
    public Class<? extends ITITActivity> initActivity()
    {
        return TetrisGameActivity.class;
    }

    @Override
    public TetrisGameSence getScene()
    {
        return (TetrisGameSence) engine.getScene();
    }

    @Override
    protected TITGameModel initModel()
    {
        return new TetrisGameModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new TetrisGameRF();
    }

    @Override
    public TetrisGameActivity getActivity()
    {
        return (TetrisGameActivity) activity;
    }

    @Override
    public TetrisGameModel getModel()
    {
        return (TetrisGameModel) model;
    }

    @Override
    public TetrisGameRF getRequestFactory()
    {
        return (TetrisGameRF) requestFactory;
    }
}
