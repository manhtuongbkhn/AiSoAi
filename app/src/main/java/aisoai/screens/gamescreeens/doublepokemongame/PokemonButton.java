package aisoai.screens.gamescreeens.doublepokemongame;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import aisoai.screens.gamescreeens.titentities.TITAnimatedSprite;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class PokemonButton extends TITAnimatedSprite
{
    private int row;
    private int column;
    private int type;
    private int questionIndex;

    public PokemonButton(float x, float y, float width, float height,
                                TiledTextureRegion tiledTextureRegion, TITGameControl inputControl)
    {
        super(x,y,width,height,tiledTextureRegion,inputControl);
    }

    @Override
    public boolean onAreaTouched(TouchEvent event,float x,float y)
    {
        if(event.getAction()== TouchEvent.ACTION_UP)
        {
            if(getCurrentTileIndex()==12)
                getControl().pokemonButtonTouchEvent(this);
        }
        return true;
    }

    @Override
    public DoublePokemonGameControl getControl()
    {
        return (DoublePokemonGameControl) control;
    }

    public static PokemonButton createPokemonButton(int row,int column,TITGameControl inputControl)
    {
        float x,y,width,height;
        width=DoublePokemonGameConfig.POKEMONBUTTON_WIDTH();
        height=DoublePokemonGameConfig.POKEMONBUTTON_HEIGHT();
        x=DoublePokemonGameConfig.POKEMONBUTTON_X(column);
        y=DoublePokemonGameConfig.POKEMONBUTTON_Y(row);

        TiledTextureRegion tiledTextureRegion=DoublePokemonGameResource.getPokemon();
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

    public void setType(int type)
    {
        this.type=type;
    }

    public int getType()
    {
        return type;
    }

    public int getQuestionIndex()
    {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex)
    {
        this.questionIndex = questionIndex;
    }
}
