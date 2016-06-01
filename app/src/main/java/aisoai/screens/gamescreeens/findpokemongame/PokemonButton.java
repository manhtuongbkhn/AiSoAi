package aisoai.screens.gamescreeens.findpokemongame;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import aisoai.screens.gamescreeens.titentities.TITAnimatedSprite;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class PokemonButton extends TITAnimatedSprite
{
    private int row;
    private int column;

    public PokemonButton(float x,float y,float width,float height,
                                TiledTextureRegion tiledTextureRegion, TITGameControl inputControl)
    {
        super(x,y,width,height,tiledTextureRegion,inputControl);
    }

    @Override
    public boolean onAreaTouched(TouchEvent event,float x,float y)
    {
        if(event.getAction()== TouchEvent.ACTION_UP)
        {
            getControl().pokemonButtonTouchEvent(this);
        }
        return true;
    }

    @Override
    public FindPokemonGameControl getControl()
    {
        return (FindPokemonGameControl) control;
    }

    public static PokemonButton createPokemonButton(int row,int column,TITGameControl inputControl)
    {
        float x,y,width,height;
        width=FindPokemonGameConfig.POKEMONBUTTON_WIDTH();
        height=FindPokemonGameConfig.POKEMONBUTTON_HEIGHT();
        x=FindPokemonGameConfig.POKEMONBUTTON_X(column);
        y=FindPokemonGameConfig.POKEMONBUTTON_Y(row);

        TiledTextureRegion tiledTextureRegion=FindPokemonGameResource.getPokemon();
        PokemonButton pokemonButton=new PokemonButton
                                                (x,y,width,height,tiledTextureRegion,inputControl);
        pokemonButton.setRow(row);
        pokemonButton.setColumn(column);
        return pokemonButton;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }
}
