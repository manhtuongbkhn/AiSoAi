package org.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.util.modifier.ease.IEaseFunction;

public class ReverseXModifier extends SingleValueSpanEntityModifier
{
    private int behindIndex;

    public ReverseXModifier(float pDuration,int iBehindIndex)
    {
        super(pDuration,1f,-1f);
        behindIndex=iBehindIndex;
    }

    public ReverseXModifier(float pDuration,int iBehindIndex,IEaseFunction pEaseFunction)
    {
        super(pDuration,1f,-1f, pEaseFunction);
        behindIndex=iBehindIndex;
    }

    public ReverseXModifier(float pDuration,int iBehindIndex,IEntityModifierListener pEntityModifierListener)
    {
        super(pDuration,1f,-1f, pEntityModifierListener);
        behindIndex=iBehindIndex;
    }

    protected ReverseXModifier(ReverseXModifier reverseXModifier)
    {
        super(reverseXModifier);
    }

    public ReverseXModifier(float pDuration,IEntityModifierListener pEntityModifierListener,
                                                                        IEaseFunction pEaseFunction)
    {
        super(pDuration,1f,-1f,pEntityModifierListener, pEaseFunction);
    }

    @Override
    protected void onSetInitialValue(IEntity pItem, float pValue)
    {
        AnimatedSprite animatedSprite=(AnimatedSprite) pItem;
        if(pValue<0)
        {
            int currentIndex=animatedSprite.getCurrentTileIndex();
            if(currentIndex!=1)
                animatedSprite.setCurrentTileIndex(behindIndex);
        }

        if(pValue<0)
            pValue=pValue*-1;
        animatedSprite.setScaleX(pValue);
    }

    @Override
    protected void onSetValue(IEntity pItem, float pPercentageDone, float pValue)
    {
        AnimatedSprite animatedSprite=(AnimatedSprite) pItem;
        if(pValue<0)
        {
            int currentIndex=animatedSprite.getCurrentTileIndex();
            if(currentIndex!=1)
                animatedSprite.setCurrentTileIndex(behindIndex);
        }

        if(pValue<0)
            pValue=pValue*-1;
        animatedSprite.setScaleX(pValue);
    }

    @Override
    public ReverseXModifier deepCopy() throws DeepCopyNotSupportedException
    {
        return new ReverseXModifier(this);
    }
}
