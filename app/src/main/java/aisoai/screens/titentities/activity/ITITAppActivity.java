package aisoai.screens.titentities.activity;

import aisoai.screens.titentities.dialog.WasInvitedDialog;

public interface ITITAppActivity extends ITITActivity
{
    public void setWasInvitedDialog(WasInvitedDialog wasInvitedDialog);
    public WasInvitedDialog getWasInvitedDialog();
}
