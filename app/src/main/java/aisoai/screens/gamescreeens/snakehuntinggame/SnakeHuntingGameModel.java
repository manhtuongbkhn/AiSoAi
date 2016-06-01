package aisoai.screens.gamescreeens.snakehuntinggame;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.TITGameModel;

public class SnakeHuntingGameModel extends TITGameModel
{
    public int snakeStartRow;
    public int snakeStartColumn;
    public int snakeStartDirection;
    public int snakeRunTimeMillis;
    public int partLen;
    public ArrayList<Integer> wallIndexArr;
}
