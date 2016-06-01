package aisoai.screens.titentities.dialog;

import android.app.Activity;

import java.util.ArrayList;

import aisoai.config.UIDefine;
import aisoai.screens.titentities.model.TITGameMaturity;
import aisoai.screens.titentities.model.TITGameMaturityArrayAdapter;

public class GameMaturityArrayAdapter extends TITGameMaturityArrayAdapter
{

    public GameMaturityArrayAdapter(Activity activity,
                                                        ArrayList<TITGameMaturity> gameMaturityArr)
    {
        super(activity,gameMaturityArr);
    }

    @Override
    protected void scaleView()
    {
        item.requestLayout();
        item.getLayoutParams().width= MoreUserInfoDialogUIDefine.GAMEMATURITYITEM_WIDTH();
        item.getLayoutParams().height=MoreUserInfoDialogUIDefine.GAMEMATURITYITEM_HEIGHT();

        ivGameIcon.requestLayout();
        ivGameIcon.getLayoutParams().width=MoreUserInfoDialogUIDefine.GAMEICONIV_WIDTH();
        ivGameIcon.getLayoutParams().height=MoreUserInfoDialogUIDefine.GAMEICONIV_HEIGHT();

        ivRank.requestLayout();
        ivRank.getLayoutParams().width=MoreUserInfoDialogUIDefine.RANKIV_WIDTH();
        ivRank.getLayoutParams().height=MoreUserInfoDialogUIDefine.RANKIV_HEIGHT();

        tvGameMatchCount.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvGameWinPercent.setTextSize(UIDefine.SMALLTEXT_SIZE());
        tvExperiencePoint.setTextSize(UIDefine.SMALLTEXT_SIZE());
    }
}
