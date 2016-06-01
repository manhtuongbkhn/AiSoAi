package aisoai.titapplib;

import aisoai.screens.titentities.model.TITUserInfo;

public class TITUserVariable
{
    private static TITProgramStatus programStatus;

    private static TITUserInfo userInfo;

    public static TITUserInfo getUserInfo()
    {
        return userInfo;
    }

    public static void setUserInfo(TITUserInfo userInfo)
    {
        TITUserVariable.userInfo = userInfo;
    }

    public static TITProgramStatus getProgramStatus()
    {
        if(programStatus==null)
            return TITProgramStatus.NULL;
        else
            return programStatus;
    }

    public static void setProgramStatus(TITProgramStatus programStatus)
    {
        TITUserVariable.programStatus = programStatus;
    }

    public static boolean isWaitingResponse()
    {
        if(getProgramStatus()==TITProgramStatus.WAITING_RESPONSE)
            return true;
        else
            return false;
    }
}
