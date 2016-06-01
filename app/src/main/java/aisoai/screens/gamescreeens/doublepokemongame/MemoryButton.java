package aisoai.screens.gamescreeens.doublepokemongame;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITAnimatedSprite;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class MemoryButton extends TITAnimatedSprite
{

    public MemoryButton(float x,float y,float width,float height, TiledTextureRegion tiledTextureRegion,
                                                                            TITGameControl iControl)
    {
        super(x, y, width, height, tiledTextureRegion, iControl);
    }

    @Override
    public boolean onAreaTouched(TouchEvent event,float x,float y)
    {
        if(event.getAction()== TouchEvent.ACTION_UP)
        {
            if(getCurrentTileIndex()==0)
                getControl().memoryButtonTouchEvent();
        }
        return true;
    }


    @Override
    public DoublePokemonGameControl getControl()
    {
        return (DoublePokemonGameControl) control;
    }

    public static MemoryButton createMemoryButton(TITGameControl iControl)
    {
        TiledTextureRegion tiledTextureRegion=DoublePokemonGameResource.getMemory();
        float x,y,width,height;
        width=DoublePokemonGameConfig.MEMORYBUTTON_WIDTH();
        height=DoublePokemonGameConfig.MEMORYBUTTON_HEIGHT();
        x=DoublePokemonGameConfig.MEMORYBUTTON_X();
        y=DoublePokemonGameConfig.MEMORYBUTTON_Y();

        MemoryButton memoryButton=new MemoryButton(x,y,width,height,tiledTextureRegion,iControl);
        return memoryButton;
    }

    public void hiden()
    {
        setCurrentTileIndex(1);
    }

    public void enble()
    {
        setCurrentTileIndex(0);
    }
}
