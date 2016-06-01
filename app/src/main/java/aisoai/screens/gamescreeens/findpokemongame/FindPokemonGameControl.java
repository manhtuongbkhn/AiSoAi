package aisoai.screens.gamescreeens.findpokemongame;

import com.google.gson.JsonObject;

import org.andengine.entity.modifier.ScaleAtModifier;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.util.modifier.IModifier;

import aisoai.config.KJS;
import aisoai.screens.gamescreeens.titentities.TITGameModel;
import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameControl;
import aisoai.screens.titentities.TITRequestFactory;
import aisoai.screens.titentities.activity.ITITActivity;


public class FindPokemonGameControl extends TITSingleGameControl
{

    @Override
    protected TextureRegion getBackground()
    {
        return FindPokemonGameResource.getBackground();
    }

    @Override
    protected void initTITScene()
    {
        PokemonButtonBoard pokemonButtonBoard=PokemonButtonBoard.createPokemonButtonBoard(this);
        getScene().attachChild(pokemonButtonBoard);
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
                int pokemonType=token.get(KJS.PARAM1).getAsInt();
                int heightRow=token.get(KJS.PARAM2).getAsInt();
                int widthColumn=token.get(KJS.PARAM3).getAsInt();
                int differentRow=token.get(KJS.PARAM4).getAsInt();
                int differentColumn=token.get(KJS.PARAM5).getAsInt();
                showQuestion(pokemonType,heightRow,widthColumn,differentRow,differentColumn);
                getModel().setCurrentQuestion(token);
                gameScriptReader.stop();
                break;
        }
    }

    private void showQuestion(int typePokemon,int heightRow,int widthColumn,
                                                                int differentRow,int differentColumn)
    {
        PokemonButtonBoard pokemonButtonBoard=getScene().getPokemonButtonBoard();
        pokemonButtonBoard.showQuestion
                                    (typePokemon,heightRow,widthColumn,differentRow,differentColumn);
        float centerX=pokemonButtonBoard.getWidth()/2;
        float centerY=pokemonButtonBoard.getHeight()/2;
        ScaleAtModifier scaleAtModifier=new ScaleAtModifier(0.5f,0f,1f,centerX,centerY);
        IModifier.IModifierListener modifierListener=new IModifier.IModifierListener()
        {
            @Override
            public void onModifierStarted(IModifier pModifier, Object pItem)
            {

            }

            @Override
            public void onModifierFinished(IModifier pModifier, Object pItem)
            {
                getModel().setGameStatus(GameStatus.PLAYING);
            }
        };

        scaleAtModifier.addModifierListener(modifierListener);
        scaleAtModifier.setAutoUnregisterWhenFinished(true);
        pokemonButtonBoard.registerEntityModifier(scaleAtModifier);
    }

    public void pokemonButtonTouchEvent(PokemonButton pokemonButton)
    {
        if(getModel().getGameStatus()==GameStatus.PLAYING)
        {
            getModel().setGameStatus(GameStatus.SLEEPING);

            JsonObject jsonObject=getModel().getCurrentQuestion();
            int index=jsonObject.get(KJS.INDEX).getAsInt();
            int heightRow=jsonObject.get(KJS.PARAM2).getAsInt();
            int widthColumn=jsonObject.get(KJS.PARAM3).getAsInt();
            int differentRow=jsonObject.get(KJS.PARAM4).getAsInt();
            int differentColumn=jsonObject.get(KJS.PARAM5).getAsInt();

            int buttonRow=pokemonButton.getRow();
            int buttonColumn=pokemonButton.getColumn();

            int beginRow=FindPokemonGameFunction.getBeginRow(heightRow);
            int beginColum=FindPokemonGameFunction.getBeginColumn(widthColumn);

            buttonRow=buttonRow-beginRow+1;
            buttonColumn=buttonColumn-beginColum+1;

            if(buttonRow==differentRow&&buttonColumn==differentColumn)
                playTrueSound();
            else
                playFlaseSound();
            getRequestFactory().sendGameAnswer(index,buttonRow,buttonColumn);
            PokemonButtonBoard pokemonButtonBoard=getScene().getPokemonButtonBoard();
            float centerX = pokemonButtonBoard.getWidth() / 2;
            float centerY = pokemonButtonBoard.getHeight() / 2;
            ScaleAtModifier scaleAtModifier = new ScaleAtModifier(0.5f, 1, 0f, centerX, centerY);
            IModifier.IModifierListener modifierListener = new IModifier.IModifierListener()
            {
                @Override
                public void onModifierStarted(IModifier pModifier, Object pItem)
                {

                }

                @Override
                public void onModifierFinished(IModifier pModifier, Object pItem)
                {
                    getScene().getPokemonButtonBoard().clear();
                    gameScriptReader.resume();
                }
            };

            scaleAtModifier.addModifierListener(modifierListener);
            scaleAtModifier.setAutoUnregisterWhenFinished(true);
            pokemonButtonBoard.registerEntityModifier(scaleAtModifier);
        }
    }

    private void playTrueSound()
    {

    }

    private void playFlaseSound()
    {

    }

    @Override
    public void finish()
    {
        getModel().setGameStatus(GameStatus.FINISH);
    }

    @Override
    public FindPokemonGameScene getScene()
    {
        return (FindPokemonGameScene) engine.getScene();
    }

    @Override
    public Class<? extends ITITActivity> initActivity()
    {
        return FindPokemonGameActivity.class;
    }

    @Override
    protected TITGameModel initModel()
    {
        return new FindPokemonGameModel();
    }

    @Override
    protected TITRequestFactory initRequestFactory()
    {
        return new FindPokemonGameRF();
    }

    @Override
    public FindPokemonGameActivity getActivity()
    {
        return (FindPokemonGameActivity) activity;
    }

    @Override
    public FindPokemonGameModel getModel()
    {
        return (FindPokemonGameModel) model;
    }

    @Override
    public FindPokemonGameRF getRequestFactory()
    {
        return (FindPokemonGameRF) requestFactory;
    }
}
