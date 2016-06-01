package aisoai.screens.gamescreeens.snakehuntinggame;
import org.andengine.entity.IEntity;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.TITScene;

public class SnakeHuntingGameSence extends TITScene
{
    private Snake snake;
    private Apple apple;
    private ArrayList<Wall> wallArr=new ArrayList<Wall>();

    @Override
    protected SnakeHuntingControl getControl()
    {
        return (SnakeHuntingControl) control;
    }

    @Override
    public void attachChild(IEntity iEntity)
    {
        if(iEntity instanceof SnakePart)
        {
            SnakePart iSnakePart=(SnakePart) iEntity;
        }

        if(iEntity instanceof Apple)
        {
            Apple iApple=(Apple) iEntity;
            this.apple=iApple;
        }

        if(iEntity instanceof Wall)
        {
            Wall iWall=(Wall) iEntity;
            wallArr.add(iWall);
        }

        super.attachChild(iEntity);
    }

    @Override
    public boolean detachChild(IEntity iEntity)
    {
        if(iEntity instanceof SnakePart)
        {
            SnakePart iSnakePart=(SnakePart) iEntity;
        }

        if(iEntity instanceof Apple)
        {
            Apple iApple=(Apple) iEntity;
            this.apple=null;
        }

        if(iEntity instanceof Wall)
        {
            Wall iWall=(Wall) iEntity;
            wallArr.remove(iWall);
        }

        return super.detachChild(iEntity);
    }

    public void addSnake(Snake snake)
    {
        for(int i=0;i<snake.getSnakePartArr().size();i++)
        {
            SnakePart snakePart=snake.getSnakePartArr().get(i);
            attachChild(snakePart);
        }
        this.snake=snake;
    }

    public void removeSnake(Snake snake)
    {
        for(int i=0;i<snake.getSnakePartArr().size();i++)
        {
            SnakePart snakePart=snake.getSnakePartArr().get(i);
            detachChild(snakePart);
        }
        this.snake=null;
    }

    public boolean isHaveApple(int row,int column)
    {
        if(apple!=null)
        {
            int appleRow = apple.getRow();
            int appleColumn = apple.getColumn();

            return (row == appleRow && column == appleColumn);
        }
        else
            return false;
    }

    public Snake getSnake()
    {
        return snake;
    }

    public Apple getApple()
    {
        return apple;
    }

    public ArrayList<Wall> getWallArr()
    {
        return wallArr;
    }
}
