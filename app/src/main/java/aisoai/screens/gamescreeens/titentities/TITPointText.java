package aisoai.screens.gamescreeens.titentities;

import org.andengine.opengl.font.Font;

import aisoai.screens.gamescreeens.titentities.titsinglegame.TITSingleGameConfig;

public class TITPointText extends TITText
{
    public TITPointText(float x, float y, Font font, String text, int textMax, TITGameControl inputControl)
    {
        super(x, y, font, text, textMax, inputControl);
    }

    public static TITPointText createPointText(int player,TITGameControl inputControl)
    {
        String content="0";
        Font pointFont=inputControl.gameResource.getPointFont();
        float x,y,width,height;
        width=(float) pointFont.getStringWidth(content);
        height=(float) pointFont.getLineHeight();

        switch (player)
        {
            case 1:
                x= TITSingleGameConfig.CENTER_POINT1_X()-width/2;
                break;
            case 2:
                x= TITSingleGameConfig.CENTER_POINT2_X()-width/2;
                break;
            case 3:
                x= TITSingleGameConfig.CENTER_POINT3_X()-width/2;
                break;
            case 4:
            default:
                x= TITSingleGameConfig.CENTER_POINT4_X()-width/2;
                break;
        }
        y= TITSingleGameConfig.CENTER_POINT_Y()-height/2;
        int pointCharMax= TITSingleGameConfig.POINT_MAX_CHAR;
        TITPointText pointText=new TITPointText(x,y,pointFont,content,pointCharMax,inputControl);
        pointText.setHorizontalAlign(TITGameConfig.HORIZONTAL_ALIGN());
        pointText.setZIndex(TITGameConfig.POINT_TEXT_LAYER);
        return pointText;
    }
}
