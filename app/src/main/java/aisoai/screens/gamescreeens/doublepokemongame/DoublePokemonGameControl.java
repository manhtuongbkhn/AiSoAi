package aisoai.screens.gamescreeens.doublepokemongame;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.ReverseXModifier;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.util.modifier.IModifier;

import aisoai.config.KJS;
import aisoai.screens.gamescreeens.titentities.TITGameModel;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameControl;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.ITITActivity;

public class DoublePokemonGameControl extends TITSingleGameControl
{
    @Override
    protected TextureRegion getBackground()
    {
        return DoublePokemonGameResource.getBackground();
    }

    @Override
    protected void initTITScene()
    {
        PokemonButtonBoard pokemonButtonBoard=PokemonButtonBoard.createPokemonButtonBoard(this);
        getScene().attachChild(pokemonButtonBoard);

        MemoryButton memoryButton=MemoryButton.createMemoryButton(this);
        getScene().attachChild(memoryButton);
        getScene().registerTouchArea(memoryButton);
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
                getModel().setGameStatus(GameStatus.SLEEPING);
                Float gameOverTime=token.get(KJS.PARAM1).getAsFloat();
                getModel().setTime(gameOverTime);
                break;
            case "sleep":
                int sleepTime=token.get(KJS.PARAM1).getAsInt();
                try {Thread.sleep(sleepTime);} catch (InterruptedException e) {}
                break;
            case "createNewPokemonQuestion":
                getModel().setGameStatus(GameStatus.SHOWING);
                int index=token.get(KJS.INDEX).getAsInt();
                int widthColumn=token.get(KJS.PARAM1).getAsInt();
                int heightRow=token.get(KJS.PARAM2).getAsInt();
                JsonArray question=token.get(KJS.PARAM3).getAsJsonArray();
                showQuestion(index,question,heightRow,widthColumn);
                gameScriptReader.stop();
                break;
        }
    }

    private void showQuestion(int index,JsonArray jsonArray,int heightRow,int widthColumn)
    {
        getModel().setCurrentQuestionIndex(index);
        getScene().getMemoryButton().enble();
        getScene().getPokemonButtonBoard().showQuestion(jsonArray,heightRow,widthColumn);
        getModel().newAnswerArr();
    }

    public void memoryButtonTouchEvent()
    {
        if(getModel().getGameStatus()==GameStatus.SHOWING)
        {
            getScene().getPokemonButtonBoard().hiden();
            getScene().getMemoryButton().hiden();
            getModel().setGameStatus(GameStatus.PLAYING);
        }
    }

    public void pokemonButtonTouchEvent(PokemonButton pokemonButton)
    {
        if(getModel().getGameStatus()==GameStatus.PLAYING)
        {
            getModel().setGameStatus(GameStatus.SLEEPING);
            int type = pokemonButton.getType();
            float delayTime=DoublePokemonGameConfig.MODIFIER_DELAY_TIME();
            ReverseXModifier modifier = new ReverseXModifier(delayTime,type);
            IModifier.IModifierListener<IEntity> modifierListener =
                                                        new IModifier.IModifierListener<IEntity>()
            {
                @Override
                public void onModifierStarted(IModifier<IEntity> iModifier, IEntity iEntity)
                {
                }

                @Override
                public void onModifierFinished(IModifier<IEntity> iModifier, IEntity iEntity)
                {
                    ReverseXModifier thisReverseXModifier = (ReverseXModifier) iModifier;
                    PokemonButton thisPokemonButton = (PokemonButton) iEntity;
                    PokemonButton olderPokemonButton = getModel().getOlderPokemonButton();
                    if (olderPokemonButton == null)
                    {
                        getModel().setOlderPokemonButton(thisPokemonButton);
                        getModel().setGameStatus(GameStatus.PLAYING);
                    }
                    else
                    {
                        if (thisPokemonButton.getType() == olderPokemonButton.getType())
                        {
                            thisPokemonButton.setCurrentTileIndex(0);
                            olderPokemonButton.setCurrentTileIndex(0);
                            thisPokemonButton.setType(0);
                            olderPokemonButton.setType(0);
                            getModel().getAnswerArr().add(olderPokemonButton.getQuestionIndex());
                            getModel().getAnswerArr().add(thisPokemonButton.getQuestionIndex());
                            if (getScene().getPokemonButtonBoard().getEnblePokemonButtonCount()==0)
                            {
                                int index=getModel().getCurrentQuestionIndex();
                                getRequestFactory().sendGameAnswer(index,getModel().getAnswerArr());
                                getModel().setGameStatus(GameStatus.SLEEPING);
                                gameScriptReader.resume();
                            }
                            else
                                getModel().setGameStatus(GameStatus.PLAYING);
                        }
                        else
                        {
                            thisPokemonButton.setCurrentTileIndex(12);
                            olderPokemonButton.setCurrentTileIndex(12);
                            getModel().setGameStatus(GameStatus.PLAYING);
                        }
                        getModel().setOlderPokemonButton(null);
                    }
                }
            };
            modifier.addModifierListener(modifierListener);
            modifier.setAutoUnregisterWhenFinished(true);
            pokemonButton.registerEntityModifier(modifier);
        }
    }

    @Override
    public void finish()
    {

    }

    @Override
    public DoublePokemonGameScene getScene()
    {
        return (DoublePokemonGameScene) engine.getScene();
    }

    @Override
    public Class<? extends ITITActivity> initActivity()
    {
        return DoublePokemonGameActivity.class;
    }

    @Override
    protected TITGameModel initModel()
    {
        return new DoublePokemonGameModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new DoublePokemonGameRF();
    }

    @Override
    public DoublePokemonGameActivity getActivity()
    {
        return (DoublePokemonGameActivity) activity;
    }

    @Override
    public DoublePokemonGameModel getModel()
    {
        return (DoublePokemonGameModel) model;
    }

    @Override
    public DoublePokemonGameRF getRequestFactory()
    {
        return (DoublePokemonGameRF) requestFactory;
    }
}
