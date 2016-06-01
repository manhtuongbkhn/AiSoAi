package aisoai.screens.gamescreeens.findpokemongame;

import com.google.gson.JsonObject;

import aisoai.screens.gamescreeens.titentities.TITGameModel;

public class FindPokemonGameModel extends TITGameModel
{
    private GameStatus gameStatus;
    private JsonObject currentQuestion;

    public GameStatus getGameStatus()
    {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus)
    {
        this.gameStatus = gameStatus;
    }

    public JsonObject getCurrentQuestion()
    {
        return currentQuestion;
    }

    public void setCurrentQuestion(JsonObject currentQuestion)
    {
        this.currentQuestion = currentQuestion;
    }
}
