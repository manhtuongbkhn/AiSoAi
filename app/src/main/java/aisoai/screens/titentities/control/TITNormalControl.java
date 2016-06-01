package aisoai.screens.titentities.control;

import aisoai.screens.titentities.activity.TITNormalActivity;

abstract public class TITNormalControl extends TITAppControl
{
    @Override
    abstract public Class< ? extends TITNormalActivity> initActivity();

    @Override
    abstract public TITNormalActivity getActivity();
}
