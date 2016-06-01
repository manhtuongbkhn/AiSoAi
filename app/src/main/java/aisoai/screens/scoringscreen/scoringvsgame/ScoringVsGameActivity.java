package aisoai.screens.scoringscreen.scoringvsgame;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.screens.scoringscreen.ScoringActivity;
import aisoai.screens.titentities.control.TITNormalControl;

public class ScoringVsGameActivity extends ScoringActivity
{
    @Override
    protected int initLayout()
    {
        return R.layout.scoring_vsgame;
    }

    @Override
    protected TITNormalControl linkControl()
    {
        return TITApplication.getScreenControlManager().getScoringVsGameControl();
    }
}
