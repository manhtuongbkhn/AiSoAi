package aisoai.screens.hometabscreen.homeprofilescreen;

import java.util.ArrayList;

import aisoai.config.UIDefine;
import aisoai.screens.titentities.activity.TITNormalActivity;
import aisoai.screens.titentities.model.TITGameMaturity;
import aisoai.screens.titentities.model.TITGameMaturityArrayAdapter;

public class GameMaturityArrayAdapter extends TITGameMaturityArrayAdapter
{
    public GameMaturityArrayAdapter(TITNormalActivity titActivity, ArrayList<TITGameMaturity> gameMaturityArr)
    {
        super(titActivity, gameMaturityArr);
    }

    @Override
    protected void scaleView()
    {
        item.requestLayout();
        item.getLayoutParams().width=ProfileUIDefine.GAMEMATURITYITEM_WIDTH();
        item.getLayoutParams().height=ProfileUIDefine.GAMEMATURITYITEM_HEIGHT();

        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width=ProfileUIDefine.GAMEICONIV_WIDTH();
        ivGameIcon.getLayoutParams().height=ProfileUIDefine.GAMEICONIV_HEIGHT();

        ivRank.requestLayout();
        ivRank.getLayoutParams().width=ProfileUIDefine.RANKIV_WIDTH();
        ivRank.getLayoutParams().height=ProfileUIDefine.RANKIV_HEIGHT();

        tvGameMatchCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvGameWinPercent.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvExperiencePoint.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }
}
