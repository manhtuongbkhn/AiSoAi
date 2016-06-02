package aisoai.config;

public class ServerConfig
{
    public static String getIpServer()
    {
        return "103.54.250.124";
        //return "192.168.1.3";
    }
    public static int getPortServer()
    {
        return 9933;
    }
    final public static boolean DEBUG_SFS=true;
    //final public static String ZONE_DEFAULT="BasicExamples";
    final public static String ZONE_DEFAULT="MyZone";
    final public static boolean BLUE_BOX=true;
    final public static int RECONNECTION_TIME=0;
    final public static int RECONNECTION_DELAY_MILLIS=1000;
}