/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrator;
import common.aes.AES;

/**
 *
 * @author User
 */
public class dummy {
    public static void main(String[] args) {
        String data = AES.encrypt("gg123");
        System.out.println(data);
        System.out.println(AES.decrypt(data));
    }
    
}
