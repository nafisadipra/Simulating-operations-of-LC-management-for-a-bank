/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.device;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author User
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

