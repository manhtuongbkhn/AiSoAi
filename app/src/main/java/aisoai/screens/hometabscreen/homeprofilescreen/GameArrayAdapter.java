package aisoai.screens.hometabscreen.homeprofilescreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aisoai.R;
import aisoai.config.UIDefine;
import aisoai.gameinfo.TITGameInfo;
import aisoai.screens.gamescreeens.TITGameRouter;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class GameArrayAdapter extends ArrayAdapter<TITGameInfo>
{
    private TITNormalActivity titActivity;
    private ArrayList<TITGameInfo> gameInfoArr;

    private TextView tvGameName;
    private ImageView ivGameIcon;

    public GameArrayAdapter(TITNormalActivity titActivity,ArrayList<TITGameInfo> gameInfoArr)
    {
        super(titActivity, R.layout.game_spiner_item,gameInfoArr);
        this.titActivity=titActivity;
        this.gameInfoArr=gameInfoArr;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        View row=inflater.inflate(R.layout.game_spiner_item, parent, false);
        tvGameName=(TextView) row.findViewById(R.id.tvSPGameName);
        ivGameIcon=(ImageView) row.findViewById(R.id.ivSPGameIcon);

        TITGameInfo gameInfo=gameInfoArr.get(position);

        row.requestLayout();
        row.getLayoutParams().width= ChallengeDialogUIDefine.GAMEITEM_WIDTH();
        row.getLayoutParams().height= ChallengeDialogUIDefine.GAMEITEM_HEIGHT();

        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width= ChallengeDialogUIDefine.GAMEICONIV_WIDTH();
        ivGameIcon.getLayoutParams().height=ChallengeDialogUIDefine.GAMEICONIV_HEIGHT();

        tvGameName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

        tvGameName.setText(gameInfo.getGameName());
        ivGameIcon.setImageResource(TITGameRouter.routerGameIcon(gameInfo.getGameId()));

        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater=titActivity.getLayoutInflater();
        View row=inflater.inflate(R.layout.game_spiner_item,parent,false);
        tvGameName=(TextView) row.findViewById(R.id.tvSPGameName);
        ivGameIcon=(ImageView) row.findViewById(R.id.ivSPGameIcon);

        TITGameInfo gameInfo=gameInfoArr.get(position);

        row.requestLayout();
        row.getLayoutParams().width= ChallengeDialogUIDefine.GAMEITEM_WIDTH();
        row.getLayoutParams().height= ChallengeDialogUIDefine.GAMEITEM_HEIGHT();

        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width= ChallengeDialogUIDefine.GAMEICONIV_WIDTH();
        ivGameIcon.getLayoutParams().height=ChallengeDialogUIDefine.GAMEICONIV_HEIGHT();

        tvGameName.setTextSize(UIDefine.MEDIUMTEXT_SIZE());

        tvGameName.setText(gameInfo.getGameName());
        ivGameIcon.setImageResource(TITGameRouter.routerGameIcon(gameInfo.getGameId()));

        return row;
    }
}