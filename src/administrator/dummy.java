/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrator;
import common.reader.Reader;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class dummy {
    public static void main(String[] args) {
        ArrayList<String> d1 = (new Reader("System", "d1.bin")).readFile();
        System.out.println(d1);
    }
    
}
