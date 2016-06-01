package aisoai.screens.gamescreeens.titentities;

import org.andengine.entity.primitive.Line;

abstract public class TITLine extends Line
{
    protected TITGameControl control;

    public TITLine(float x1,float y1,float x2,float y2,TITGameControl iControl)
    {
        super(x1,y1,x2,y2,iControl.getActivity().getVertexBufferObjectManager());
        this.control=iControl;
    }

    abstract protected TITGameControl getControl();
}
