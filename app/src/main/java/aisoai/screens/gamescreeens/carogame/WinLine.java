package aisoai.screens.gamescreeens.carogame;

import org.andengine.util.color.Color;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITLine;

public class WinLine extends TITLine
{

    public WinLine(float x1, float y1, float x2, float y2, TITGameControl iControl)
    {
        super(x1, y1, x2, y2, iControl);
    }

    @Override
    protected CaroGameControl getControl()
    {
        return (CaroGameControl) control;
    }

    public static WinLine createWiLine(int fromItemIndex,int toItemIndex,TITGameControl iControl)
    {
        int fromItemRow=CaroGameFunction.getItemRow(fromItemIndex);
        int fromItemColumn=CaroGameFunction.getItemColumn(fromItemIndex);

        float x1=CaroGameConfig.ITEMCENTER_X(fromItemColumn);
        float y1=CaroGameConfig.ITEMCENTER_Y(fromItemRow);

        int toItemRow=CaroGameFunction.getItemRow(toItemIndex);
        int toItemColumn=CaroGameFunction.getItemColumn(toItemIndex);

        float x2=CaroGameConfig.ITEMCENTER_X(toItemColumn);
        float y2=CaroGameConfig.ITEMCENTER_Y(toItemRow);


        WinLine winLine=new WinLine(x1,y1,x2,y2,iControl);
        winLine.setColor(Color.RED);
        winLine.setLineWidth(CaroGameConfig.WINLINE_WIDTH());
        return winLine;


    }
}
