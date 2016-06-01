package aisoai.screens.gamescreeens.titentities.titsinglegame;

import org.andengine.entity.IEntity;

import java.util.ArrayList;

import aisoai.screens.gamescreeens.titentities.TITHUD;
import aisoai.screens.gamescreeens.titentities.TITPointText;
import aisoai.screens.gamescreeens.titentities.TITSprite;

public class TITSingleGameHUD extends TITHUD
{
    private TITDownTimeText downTimeText;
    private ArrayList<TITPointText> pointTextArr;
    private ArrayList<TITSprite> listAvarta;

    public TITSingleGameHUD()
    {
        super();
        pointTextArr=new ArrayList<TITPointText>();
        listAvarta=new ArrayList<TITSprite>();
    }

    @Override
    public void attachChild(IEntity iEntity)
    {
        if(iEntity instanceof TITDownTimeText)
        {
            TITDownTimeText iDownTimeText =(TITDownTimeText) iEntity;
            this.downTimeText=iDownTimeText;
        }

        if(iEntity instanceof TITPointText)
        {
            TITPointText iPointText=(TITPointText) iEntity;
            pointTextArr.add(iPointText);
        }
        super.attachChild(iEntity);
        sortChildren();
    }

    public TITPointText getPointText1()
    {
        return pointTextArr.get(0);
    }

    public TITPointText getPointText2()
    {
        return pointTextArr.get(1);
    }

    public TITPointText getPointText3()
    {
        return pointTextArr.get(2);
    }

    public TITPointText getPointText4()
    {
        return pointTextArr.get(3);
    }

    public TITDownTimeText getDownTimeText()
    {
        return downTimeText;
    }
}
