package aisoai.screens.titentities.activity;

import aisoai.screens.titentities.control.TITTabControl;
import aisoai.screens.titentities.control.TITSpecControl;

abstract public class TITSpecActivity extends TITNormalActivity
{
    abstract protected TITSpecControl linkControl();
    abstract public TITSpecControl getControl();
}
