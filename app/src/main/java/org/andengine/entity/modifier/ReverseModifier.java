package org.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.util.modifier.ease.IEaseFunction;

public class ReverseModifier extends DoubleValueSpanEntityModifier
{
    public ReverseModifier(float pDuration)
    {
        super(pDuration,1f,-1f,1f,-1f);
    }

    public ReverseModifier(float pDuration,IEaseFunction pEaseFunction)
    {
        super(pDuration,1f,-1f,1f,-1f,pEaseFunction);
    }

    public ReverseModifier(float pDuration,IEntityModifierListener pEntityModifierListener)
    {
        super(pDuration,1f,-1f,1f,-1f,pEntityModifierListener);
    }

    public ReverseModifier(float pDuration,IEntityModifierListener pEntityModifierListener,
                                                                        IEaseFunction pEaseFunction)
    {
        super(pDuration,1f,-1f,1f,-1f,pEntityModifierListener, pEaseFunction);
    }

    protected ReverseModifier(ReverseModifier pReverseModifier)
    {
        super(pReverseModifier);
    }

    @Override
    protected void onSetInitialValues(IEntity pItem, float pValueA, float pValueB)
    {
        AnimatedSprite animatedSprite=(AnimatedSprite) pItem;
        if(pValueA==0||pValueB==0)
        {
            animatedSprite.setCurrentTileIndex(1);
        }

        if(pValueA<0||pValueB<0)
        {
            pValueA=pValueA*-1;
        }

        if(pValueB<0)
        {
            pValueB=pValueB*-1;
        }

        animatedSprite.setScale(pValueA,pValueB);
    }

    @Override
    protected void onSetValues(IEntity pItem,float pPercentageDone,float pValueA,float pValueB)
    {
        onSetInitialValues(pItem,pValueA,pValueB);
    }

    @Override
    public ReverseModifier deepCopy() throws DeepCopyNotSupportedException
    {
        return new ReverseModifier(this);
    }
}
