package aisoai.screens.gamescreeens.doublepokemongame;

import com.google.gson.JsonArray;

import org.andengine.entity.IEntity;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import java.util.ArrayList;
import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class PokemonButtonBoard extends TITSprite
{
    private ArrayList<PokemonButton> pokemonButtonArr;

    public PokemonButtonBoard(float x, float y, float width, float height, TextureRegion textureRegion,
                              TITGameControl inputControl)
    {
        super(x, y, width, height, textureRegion, inputControl);
        pokemonButtonArr=new ArrayList<PokemonButton>();
    }

    @Override
    public TITGameControl getControl()
    {
        return (DoublePokemonGameControl) control;
    }

    @Override
    public void attachChild(IEntity iEntity)
    {
        Class inputClass=iEntity.getClass();

        if(inputClass.equals(PokemonButton.class))
        {
            PokemonButton pokemonButton =(PokemonButton) iEntity;
            pokemonButtonArr.add(pokemonButton);
        }

        super.attachChild(iEntity);
    }

    public static PokemonButtonBoard createPokemonButtonBoard(TITGameControl iControl)
    {
        TiledTextureRegion tiledTextureRegion=DoublePokemonGameResource.getPokemon();
        TextureRegion textureRegion=(TextureRegion)tiledTextureRegion.getTextureRegion(0);
        float x,y,width,height;
        x=DoublePokemonGameConfig.POKEMONBUTTONBOARD_X();
        y=DoublePokemonGameConfig.POKEMONBUTTONBOARD_Y();
        width=DoublePokemonGameConfig.POKEMONBUTTONBOARD_WIDTH();
        height=DoublePokemonGameConfig.POKEMONBUTTONBOARD_HEIGHT();
        PokemonButtonBoard pokemonButtonBoard=new
                                        PokemonButtonBoard(x,y,width,height,textureRegion,iControl);
        for(int row=1;row<=5;row++)
        {
            for(int column=1;column<=5;column++)
            {
                PokemonButton pokemonButton= PokemonButton.createPokemonButton(row,column,iControl);
                pokemonButton.setType(0);
                pokemonButton.setCurrentTileIndex(0);
                pokemonButtonBoard.attachChild(pokemonButton);
                iControl.getScene().registerTouchArea(pokemonButton);
            }
        }
        return pokemonButtonBoard;
    }

    public void showQuestion(JsonArray jsonArray,int heightRow,int widthColumn)
    {
        reset();
        int beginRow=DoublePokemonGameFunction.getBeginRow(heightRow);
        int beginColumn=DoublePokemonGameFunction.getBeginColumn(widthColumn);
        int index=0;
        for(int i=beginRow;i<=beginRow+heightRow-1;i++)
        {
            for(int j=beginColumn;j<=beginColumn+widthColumn-1;j++)
            {
                int type=jsonArray.get(index).getAsInt();
                PokemonButton pokemonButton=getPokemonButton(i,j);
                pokemonButton.setType(type);
                pokemonButton.setCurrentTileIndex(type);
                index++;
                pokemonButton.setQuestionIndex(index);
            }
        }

        float x,y;
        if(widthColumn%2==0)
        {
            x=getX();
            setX(x+DoublePokemonGameConfig.BOX_WIDTH()/2);
        }
        else
            setX(DoublePokemonGameConfig.POKEMONBUTTONBOARD_X());
        /*
        if(heightRow%2==0)
        {
            y=getY();
            setY(y+DoublePokemonGameConfig.BOX_HEIGHT()/2);
        }
        */
    }

    public void hiden()
    {
        for(int i=0;i<pokemonButtonArr.size();i++)
        {
            PokemonButton pokemonButton=pokemonButtonArr.get(i);
            if(pokemonButton.getType()!=0)
                pokemonButton.setCurrentTileIndex(12);
        }
    }

    public void reset()
    {
        for(int i=0;i<pokemonButtonArr.size();i++)
        {
            PokemonButton pokemonButton=pokemonButtonArr.get(i);
            pokemonButton.setType(0);
            pokemonButton.setCurrentTileIndex(0);
            pokemonButton.setQuestionIndex(0);
        }

        setX(DoublePokemonGameConfig.POKEMONBUTTONBOARD_X());
        setY(DoublePokemonGameConfig.POKEMONBUTTONBOARD_Y());
    }

    public PokemonButton getPokemonButton(int row,int column)
    {
        int index=(row-1)*5+column;
        return pokemonButtonArr.get(index-1);
    }

    public int getEnblePokemonButtonCount()
    {
        int count=0;
        for(int i=0;i<pokemonButtonArr.size();i++)
        {
            PokemonButton pokemonButton=pokemonButtonArr.get(i);
            if(pokemonButton.getType()!=0)
                count++;
        }
        return count;
    }
}
