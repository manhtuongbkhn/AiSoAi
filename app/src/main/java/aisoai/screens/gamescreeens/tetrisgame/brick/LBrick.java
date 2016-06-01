package aisoai.screens.gamescreeens.tetrisgame.brick;

import aisoai.screens.gamescreeens.tetrisgame.BrickItem;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameConfig;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameControl;

public class LBrick extends Brick
{
    public LBrick(TetrisGameControl iControl,int iRunTimeMillis)
    {
        super(iControl,iRunTimeMillis);
        int centerRow= TetrisGameConfig.CENTER_ROW;
        int centerColumn=TetrisGameConfig.CENTER_COLUMN;

        BrickItem brickItem;
        brickItem=BrickItem.createBrickItem(5,centerRow+1,centerColumn-1,iControl);
        birckItemArr.add(brickItem);
        brickItem=BrickItem.createBrickItem(5,centerRow-1,centerColumn,iControl);
        birckItemArr.add(brickItem);
        brickItem=BrickItem.createBrickItem(5,centerRow-1,centerColumn-1,iControl);
        birckItemArr.add(brickItem);
        brickItem=BrickItem.createBrickItem(5,centerRow,centerColumn-1,iControl);
        birckItemArr.add(brickItem);
        setCenterRow(centerRow);
        setCenterColumn(centerColumn);
    }
}
