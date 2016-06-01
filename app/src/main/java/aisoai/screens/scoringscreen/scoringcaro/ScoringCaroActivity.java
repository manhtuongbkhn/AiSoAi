package aisoai.screens.scoringscreen.scoringcaro;

import aisoai.R;
import aisoai.TITApplication;
import aisoai.screens.scoringscreen.ScoringActivity;
import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.titentities.control.TITNormalControl;

public class ScoringCaroActivity extends ScoringActivity
{

    @Override
    protected int initLayout()
    {
        return R.layout.scoring_caro;
    }

    @Override
    protected void linkToLayout()
    {
        super.linkToLayout();
    }

    @Override
    protected TITNormalControl linkControl()
    {
        return TITApplication.getScreenControlManager().getScoringCaroControl();
    }

    @Override
    public ScoringCaroControl getControl()
    {
        return (ScoringCaroControl) control;
    }
}
