package aisoai.screens.gamescreeens.doublepokemongame;

import org.andengine.entity.IEntity;

import aisoai.screens.gamescreeens.titentities.TITGameControl;
import aisoai.screens.gamescreeens.titentities.TITScene;

public class DoublePokemonGameScene extends TITScene
{
    private PokemonButtonBoard pokemonButtonBoard;
    private MemoryButton memoryButton;

    @Override
    protected TITGameControl getControl()
    {
        return (DoublePokemonGameControl) control;
    }

    @Override
    public void attachChild(IEntity iEntity)
    {
        Class inputClass=iEntity.getClass();

        if(inputClass.equals(PokemonButtonBoard.class))
        {
            PokemonButtonBoard iPokemonButtonBoard =(PokemonButtonBoard) iEntity;
            pokemonButtonBoard=iPokemonButtonBoard;
        }

        if(inputClass.equals(MemoryButton.class))
        {
            MemoryButton iMemoryButton =(MemoryButton) iEntity;
            memoryButton=iMemoryButton;
        }

        super.attachChild(iEntity);
    }

    public PokemonButtonBoard getPokemonButtonBoard()
    {
        return pokemonButtonBoard;
    }

    public MemoryButton getMemoryButton()
    {
        return memoryButton;
    }
}
