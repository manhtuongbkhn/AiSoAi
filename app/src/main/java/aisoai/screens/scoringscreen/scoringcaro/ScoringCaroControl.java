package aisoai.screens.scoringscreen.scoringcaro;


import aisoai.screens.scoringscreen.ScoringControl;
import aisoai.screens.titentities.activity.TITNormalActivity;

public class ScoringCaroControl extends ScoringControl
{

    @Override
    public Class<? extends TITNormalActivity> initActivity()
    {
        return ScoringCaroActivity.class;
    }
}
