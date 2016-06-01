package aisoai.config;

import aisoai.R;

public class TierRouter
{
    public static int tierRouter(int rank)
    {
        switch (rank)
        {
            case 1:
                return R.drawable.brass_tier;
            case 2:
                return R.drawable.iron_tier;
            case 3:
                return  R.drawable.gold_tier;
            case 4:
                return R.drawable.platinum_tier;
            case 5:
                return R.drawable.diamond_tier;
            case 6:
                return R.drawable.hotshot_tier;
            case 7:
                return R.drawable.challenge_tier;
            default:
                return -1;
        }
    }
}
