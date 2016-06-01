package aisoai.screens.gamescreeens.tetrisgame;

import aisoai.screens.gamescreeens.titentities.TITGameModel;

public class TetrisGameModel extends TITGameModel
{
    public int baseSlowRunTimeMillis;
    public int baseFastRunTimeMillis;
    private GameStatus gameStatus;

    public GameStatus getGameStatus()
    {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus)
    {
        this.gameStatus = gameStatus;
    }
}
