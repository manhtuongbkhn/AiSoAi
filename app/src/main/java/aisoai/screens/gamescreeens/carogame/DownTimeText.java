package aisoai.screens.gamescreeens.carogame;

import org.andengine.opengl.font.Font;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITText;

public class DownTimeText extends TITText
{
    public DownTimeText(float x, float y, Font font, String text, int textMax, TITGameControl iControl)
    {
        super(x, y, font, text, textMax, iControl);
    }

    public static DownTimeText createDownTime(TITGameControl inputControl)
    {
        Font timeFont=inputControl.gameResource.getTimeFont();
        float width=(float) timeFont.getStringWidth("");
        float height=(float) timeFont.getLineHeight();
        float x=CaroGameConfig.HUD_WIDTH/2-width/2;
        float y= CaroGameConfig.HUD_HEIGHT/2-height/2;
        DownTimeText timeText =
                new DownTimeText(x,y,timeFont,"",2,inputControl);
        timeText.setZIndex(CaroGameConfig.TIME_TEXT_LAYER);
        return timeText;
    }
}
