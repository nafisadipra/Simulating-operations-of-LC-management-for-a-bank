package common.device;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Muyeed
 */

public class IP {
    public static String getIP() {
        String localhost = "127.0.0.1";
        try {
            localhost = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }
        
        return localhost;
    }
}

