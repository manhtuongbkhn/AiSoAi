package aisoai.screens.gamescreeens.carogame;

import org.andengine.entity.IEntity;

import aisoai.screens.gamescreeens.titentities.TITHUD;

public class CaroGameHUD extends TITHUD
{
    private DownTimeText downTimeText;
    private Bout bout;

    @Override
    public void attachChild(IEntity iEntity)
    {
        if(iEntity instanceof DownTimeText)
        {
            DownTimeText iDownTimeText =(DownTimeText) iEntity;
            this.downTimeText=iDownTimeText;
        }

        if(iEntity instanceof Bout)
        {
            Bout iBout=(Bout) iEntity;
            this.bout=iBout;
        }

        super.attachChild(iEntity);
        sortChildren();
    }

    @Override
    public boolean detachChild(IEntity iEntity)
    {
        if(iEntity instanceof DownTimeText)
        {
            DownTimeText iDownTimeText =(DownTimeText) iEntity;
            this.downTimeText=null;
        }

        if(iEntity instanceof Bout)
        {
            Bout iBout=(Bout) iEntity;
            this.bout=null;
        }

        boolean b=super.detachChild(iEntity);
        sortChildren();
        return b;
    }

    public DownTimeText getDownTimeText()
    {
        return downTimeText;
    }

    public Bout getBout()
    {
        return bout;
    }
}
