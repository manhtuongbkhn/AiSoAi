package aisoai.screens.gamescreeens.doublepokemongame;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.TITGameModel;

public class DoublePokemonGameModel extends TITGameModel
{
    private int currentQuestionIndex;
    private PokemonButton olderPokemonButton=null;
    private GameStatus gameStatus;
    private ArrayList<Integer> answerArr;

    public PokemonButton getOlderPokemonButton()
    {
        return olderPokemonButton;
    }

    public void setOlderPokemonButton(PokemonButton iOlderPokemonButton)
    {
        this.olderPokemonButton = iOlderPokemonButton;
    }

    public GameStatus getGameStatus()
    {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus)
    {
        this.gameStatus = gameStatus;
    }

    public ArrayList<Integer> getAnswerArr()
    {
        return answerArr;
    }

    public void newAnswerArr()
    {
        answerArr=new ArrayList<Integer>();
    }

    public int getCurrentQuestionIndex()
    {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex)
    {
        this.currentQuestionIndex = currentQuestionIndex;
    }
}
