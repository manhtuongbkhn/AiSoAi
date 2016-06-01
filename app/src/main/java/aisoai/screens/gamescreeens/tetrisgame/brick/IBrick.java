package aisoai.screens.gamescreeens.tetrisgame.brick;

import aisoai.screens.gamescreeens.tetrisgame.BrickItem;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameConfig;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameControl;

public class IBrick extends Brick
{
    public IBrick(TetrisGameControl iControl,int iRunTimeMillis)
    {
        super(iControl,iRunTimeMillis);
        int centerRow= TetrisGameConfig.CENTER_ROW;
        int centerColumn=TetrisGameConfig.CENTER_COLUMN;

        BrickItem brickItem;
        brickItem=BrickItem.createBrickItem(7,centerRow+1,centerColumn-1,iControl);
        birckItemArr.add(brickItem);
        brickItem=BrickItem.createBrickItem(7,centerRow,centerColumn-1,iControl);
        birckItemArr.add(brickItem);
        brickItem=BrickItem.createBrickItem(7,centerRow-1,centerColumn-1,iControl);
        birckItemArr.add(brickItem);
        brickItem=BrickItem.createBrickItem(7,centerRow-2,centerColumn-1,iControl);
        birckItemArr.add(brickItem);
        setCenterRow(centerRow);
        setCenterColumn(centerColumn);
    }
}
