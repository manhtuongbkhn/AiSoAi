package aisoai.screens.gamescreeens;

import aisoai.R;
import aisoai.screens.gamescreeens.carogame.CaroGameControl;
import aisoai.screens.gamescreeens.doublepokemongame.DoublePokemonGameControl;
import aisoai.screens.gamescreeens.findpokemongame.FindPokemonGameControl;
import aisoai.screens.gamescreeens.snakehuntinggame.SnakeHuntingControl;
import aisoai.screens.gamescreeens.tetrisgame.TetrisGameControl;
import aisoai.screens.gamescreeens.titentities.TITGameControl;

public class TITGameRouter
    {
    public static TITGameControl routerGameControl(int gameId)
    {
        switch (gameId)
        {
            case 1:
                return new CaroGameControl();
            case 2:
                return new FindPokemonGameControl();
            case 3:
                return new DoublePokemonGameControl();
            case 4:
                return new SnakeHuntingControl();
            case 5:
                return new TetrisGameControl();
            default:
                return null;
        }
    }

    public static int routerGameIcon(int gameId)
    {
        switch (gameId)
        {
            case 1:
                return R.drawable.caro_icon;
            case 2:
                return R.drawable.find_pokemon_game_icon;
            case 3:
                return R.drawable.double_pokemon_game_icon;
            case 4:
                return R.drawable.snake_hunting_game_icon;
            case 5:
                return R.drawable.tetris_game_icon;
            default:
                return R.drawable.default_game_icon;
        }
    }
}
