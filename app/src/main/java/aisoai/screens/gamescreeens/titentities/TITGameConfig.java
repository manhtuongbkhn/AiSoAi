package aisoai.screens.gamescreeens.titentities;

import org.andengine.util.HorizontalAlign;

import aisoai.config.ClientConfig;

public class TITGameConfig
{
    public static float SCREEN_WIDTH= ClientConfig.SCREEN_WIDTH_PX;
    public static float SCREEN_HEIGHT=ClientConfig.SCREEN_HEIGHT_PX;

    public final static int PHYSICENTITYRUN_DELAYTIMEMILLIS=25;

    public static HorizontalAlign HORIZONTAL_ALIGN()
    {
        return HorizontalAlign.CENTER;
    }

    public static boolean MULTITOUCHSUPPORT;
    public static boolean MULTITOUCHSUPPORTDISTINCT;

    public static String GAME_IMAGE_FOLDER="gfx/";
    public static String FONT_FOLDER="fonts/";
    public static String MUSIC_FOLDER="mfx/";

    public static int TINY_TEXTURE_WIDTH=64;
    public static int TINY_TEXTURE_HEIGHT=64;

    public static int SMALL_TEXTURE_WIDTH=128;
    public static int SMALL_TEXTURE_HEIGHT=128;

    public static int MEDIUM_TEXTURE_WIDTH=256;
    public static int MEDIUM_TEXTURE_HEIGHT=256;

    public static int BIG_TEXTURE_WIDTH=512;
    public static int BIG_TEXTURE_HEIGHT=512;

    public static int HUGE_TEXTURE_WIDTH=1024;
    public static int HUGE_TEXTURE_HEIGHT=1024;

    public static int GIGATIC_TEXTURE_WIDTH=2048;
    public static int GIGATIC_TEXTURE_HEIGHT=2048;

    public static int CHILD_COUNT=0;

    public static int HUD_LAYER=12;
    public static int TIME_TEXT_LAYER=20;
    public static int POINT_TEXT_LAYER=20;
}