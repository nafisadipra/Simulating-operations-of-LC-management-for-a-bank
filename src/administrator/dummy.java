/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrator;
import common.aes.AES;
import common.reader.Reader;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class dummy {
    public static void main(String[] args) {
        ArrayList x = new Reader("Database/User/Administrator/m@g.com", "notification.bin").splitFile();
        
        System.out.println(x);
    }
    
}
