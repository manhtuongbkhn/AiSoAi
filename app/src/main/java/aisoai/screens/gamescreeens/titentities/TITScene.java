package aisoai.screens.gamescreeens.titentities;

import org.andengine.entity.IEntity;
import org.andengine.entity.scene.Scene;

abstract public class TITScene extends Scene
{
    protected TITGameControl control;

    public TITScene()
    {
        super(TITGameConfig.CHILD_COUNT);
    }

    @Override
    public void attachChild(IEntity iEntity)
    {
        super.attachChild(iEntity);
        sortChildren();
    }

    @Override
    public boolean detachChild(IEntity iEntity)
    {
        boolean result=super.detachChild(iEntity);
        sortChildren();
        return result;
    }

    public void setControl(TITGameControl iControl)
    {
        this.control=iControl;
    }

    abstract protected TITGameControl getControl();
}
