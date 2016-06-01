package aisoai.screens.gamescreeens.findpokemongame;

import org.andengine.entity.IEntity;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class PokemonButtonBoard extends TITSprite
{
    private ArrayList<PokemonButton> pokemonButtonArr;

    public PokemonButtonBoard(float x,float y,float width,float height,TextureRegion textureRegion,
                                                                        TITGameControl inputControl)
    {
        super(x, y, width, height, textureRegion, inputControl);
        pokemonButtonArr=new ArrayList<PokemonButton>();
    }

    @Override
    public TITGameControl getControl()
    {
        return (FindPokemonGameControl) control;
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
        TiledTextureRegion tiledTextureRegion=FindPokemonGameResource.getPokemon();
        TextureRegion textureRegion=(TextureRegion)tiledTextureRegion.getTextureRegion(0);
        float x,y,width,height;
        x=FindPokemonGameConfig.POKEMONBUTTONBOARD_X();
        y=FindPokemonGameConfig.POKEMONBUTTONBOARD_Y();
        width=FindPokemonGameConfig.POKEMONBUTTONBOARD_WIDTH();
        height=FindPokemonGameConfig.POKEMONBUTTONBOARD_HEIGHT();
        PokemonButtonBoard pokemonButtonBoard=new
                                        PokemonButtonBoard(x,y,width,height,textureRegion,iControl);
        for(int row=1;row<=6;row++)
        {
            for(int column=1;column<=5;column++)
            {
                PokemonButton pokemonButton=PokemonButton.createPokemonButton(row,column,iControl);
                pokemonButton.setCurrentTileIndex(0);
                pokemonButtonBoard.attachChild(pokemonButton);
                iControl.getScene().registerTouchArea(pokemonButton);
            }
        }
        return pokemonButtonBoard;
    }

    public void showQuestion(int typePokemon,int heightRow,int widthColumn,int row,int column)
    {
        int beginRow=FindPokemonGameFunction.getBeginRow(heightRow);
        int beginColumn=FindPokemonGameFunction.getBeginColumn(widthColumn);

        for(int i=beginRow;i<=beginRow+heightRow-1;i++)
        {
            for(int j=beginColumn;j<=beginColumn+widthColumn-1;j++)
            {
                PokemonButton pokemonButton=getPokemonButton(i,j);
                pokemonButton.setCurrentTileIndex(typePokemon);
            }
        }

        PokemonButton differentPokemonButton=getPokemonButton(beginRow+row-1,beginColumn+column-1);
        differentPokemonButton.setCurrentTileIndex(typePokemon+8);

        float x,y;
        if(widthColumn%2==0)
        {
            x=getX();
            setX(x+FindPokemonGameConfig.BOX_WIDTH()/2);
        }

        if(heightRow%2!=0)
        {
            y=getY();
            setY(y+FindPokemonGameConfig.BOX_HEIGHT()/2);
        }
    }

    public void clear()
    {
        for(int i=0;i<pokemonButtonArr.size();i++)
        {
            PokemonButton pokemonButton=pokemonButtonArr.get(i);
            pokemonButton.setCurrentTileIndex(0);
        }

        setX(FindPokemonGameConfig.POKEMONBUTTONBOARD_X());
        setY(FindPokemonGameConfig.POKEMONBUTTONBOARD_Y());
    }

    public PokemonButton getPokemonButton(int row,int column)
    {
        int index=(row-1)*5+column;
        return pokemonButtonArr.get(index-1);
    }
}
