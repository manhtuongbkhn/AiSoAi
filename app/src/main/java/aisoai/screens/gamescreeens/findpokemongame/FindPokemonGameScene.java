package aisoai.screens.gamescreeens.findpokemongame;

import org.andengine.entity.IEntity;

import aisoai.screens.gamescreeens.titentities.TITScene;

public class FindPokemonGameScene extends TITScene
{
    private PokemonButtonBoard pokemonButtonBoard;

    @Override
    public void attachChild(IEntity iEntity)
    {
        Class inputClass=iEntity.getClass();

        if(inputClass.equals(PokemonButtonBoard.class))
        {
            PokemonButtonBoard iPokemonButtonBoard =(PokemonButtonBoard) iEntity;
            pokemonButtonBoard=iPokemonButtonBoard;
        }
        super.attachChild(iEntity);
    }

    public PokemonButtonBoard getPokemonButtonBoard()
    {
        return pokemonButtonBoard;
    }

    protected FindPokemonGameControl getControl()
    {
        return (FindPokemonGameControl) control;
    }
}
