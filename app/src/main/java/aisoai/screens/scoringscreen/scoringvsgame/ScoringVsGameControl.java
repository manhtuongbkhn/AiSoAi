package aisoai.screens.scoringscreen.scoringvsgame;

import aisoai.TITApplication;
import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class ScoringVsGameControl extends ScoringControl
{
    @Override
    public Class<? extends TITNormalActivity> initActivity()
    {
        return ScoringVsGameActivity.class;
    }
}
