/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.aes;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class AESoutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        
        String encrypted = AES.encrypt(scanner.nextLine());
        String decrypted = AES.decrypt(encrypted);
        
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        scanner.close();
    }
}
