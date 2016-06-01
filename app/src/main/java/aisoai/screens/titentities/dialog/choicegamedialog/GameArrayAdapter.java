package aisoai.screens.titentities.dialog.choicegamedialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aisoai.R;
import aisoai.gameinfo.TITGameInfo;
import aisoai.screens.gamescreeens.TITGameRouter;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class GameArrayAdapter extends ArrayAdapter<TITGameInfo>
{
    private TITNormalActivity titActivity;
    private ArrayList<TITGameInfo> gameInfoArr;

    private View item;
    private ImageView ivGameIcon;
    private TextView tvGameName;

    public GameArrayAdapter(TITNormalActivity titActivity, ArrayList<TITGameInfo> gameInfoArr)
    {
        super(titActivity, R.layout.game_item, gameInfoArr);
        this.titActivity = titActivity;
        this.gameInfoArr = gameInfoArr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = titActivity.getLayoutInflater();
        item = inflater.inflate(R.layout.game_item, parent, false);
        linkToLayout();
        scaleView();
        setContentView(position);
        return item;
    }

    public void linkToLayout()
    {
        ivGameIcon = (ImageView) item.findViewById(R.id.ivGameIcon);
        tvGameName = (TextView) item.findViewById(R.id.tvGameName);
    }

    public void scaleView()
    {
        item.requestLayout();
        item.getLayoutParams().width = ChoiceGameUIDefine.ITEM_WIDTH();
        item.getLayoutParams().height = ChoiceGameUIDefine.ITEM_HEIGHT();

        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width = ChoiceGameUIDefine.GAMEICONIV_WIDTH();
        ivGameIcon.getLayoutParams().height = ChoiceGameUIDefine.GAMEICON_HEIGHT();
    }

    public void setContentView(int postion)
    {
        TITGameInfo gameInfo=gameInfoArr.get(postion);
        String gameName = gameInfo.getGameName();
        int gameId = gameInfo.getGameId();
        tvGameName.setText(gameName);
        ivGameIcon.setImageResource(TITGameRouter.routerGameIcon(gameId));
    }
}