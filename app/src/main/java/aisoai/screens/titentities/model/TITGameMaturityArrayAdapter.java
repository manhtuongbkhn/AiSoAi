package aisoai.screens.titentities.model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import aisoai.R;
import aisoai.config.TierRouter;
import aisoai.screens.gamescreeens.TITGameRouter;
import aisoai.screens.titentities.activity.TITNormalActivity;

abstract public class TITGameMaturityArrayAdapter extends ArrayAdapter<TITGameMaturity>
{
    protected Activity activity;
    protected ArrayList<TITGameMaturity> gameMaturityArr;

    protected View item;
    protected ImageView ivGameIcon;
    protected TextView tvGameMatchCount;
    protected TextView tvGameWinPercent;
    protected TextView tvExperiencePoint;
    protected ImageView ivRank;

    public TITGameMaturityArrayAdapter(Activity activity,ArrayList<TITGameMaturity> gameMaturityArr)
    {
        super(activity, R.layout.game_maturity_item,gameMaturityArr);
        this.activity = activity;
        this.gameMaturityArr=gameMaturityArr;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        View view=linkToLayout(parent);
        scaleView();
        setContentView(position);
        return view;
    }

    protected View linkToLayout(ViewGroup parent)
    {
        LayoutInflater inflater= activity.getLayoutInflater();
        item=inflater.inflate(R.layout.game_maturity_item, parent, false);

        ivGameIcon=(ImageView) item.findViewById(R.id.ivGameIcon);
        tvGameMatchCount=(TextView) item.findViewById(R.id.tvGameMatchCount);
        tvGameWinPercent=(TextView) item.findViewById(R.id.tvGameWinPercent);
        tvExperiencePoint=(TextView) item.findViewById(R.id.tvExperiencePoint);
        ivRank=(ImageView) item.findViewById(R.id.ivRank);
        return item;
    }

    abstract protected void scaleView();

    protected void setContentView(int position)
    {
        TITGameMaturity gameMaturity=gameMaturityArr.get(position);
        int gameId=gameMaturity.getGameId();
        ivGameIcon.setImageResource(TITGameRouter.routerGameIcon(gameId));
        Integer gameMatchCount=gameMaturity.getGameMatchCount();
        Integer gameWinPercent=gameMaturity.getGameWinPercent();
        Integer experiencePoint=gameMaturity.getExperiencePoint();
        Integer rank=gameMaturity.getRank();
        tvGameMatchCount.setText(gameMatchCount.toString());
        tvGameWinPercent.setText(gameWinPercent.toString());
        tvExperiencePoint.setText(experiencePoint.toString());
        ivRank.setImageResource(TierRouter.tierRouter(rank));
    }
}