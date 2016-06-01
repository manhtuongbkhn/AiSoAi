package aisoai.screens.gamescreeens.titentities.titsinglegame;

import org.andengine.opengl.font.Font;

import aisoai.screens.gamescreeens.titentities.TITGameConfig;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITText;

public class TITDownTimeText extends TITText
{

    public TITDownTimeText(float x, float y, Font font, String text, int textMax,
                           TITGameControl inputControl)
    {
        super(x, y, font, text, textMax, inputControl);
    }

    public static TITDownTimeText createDownTime(TITGameControl inputControl)
    {
        Font timeFont=inputControl.gameResource.getTimeFont();
        float width=(float) timeFont.getStringWidth("");
        float height=(float) timeFont.getLineHeight();
        float postionX= TITGameConfig.SCREEN_WIDTH/2-width/2;
        float postionY= TITSingleGameConfig.HUD_HEIGHT()/2-height/2;
        TITDownTimeText timeText =
                new TITDownTimeText(postionX,postionY,timeFont,"", TITSingleGameConfig.TIME_MAX_CHAR,inputControl);
        timeText.setZIndex(TITGameConfig.TIME_TEXT_LAYER);
        return timeText;
    }
}
