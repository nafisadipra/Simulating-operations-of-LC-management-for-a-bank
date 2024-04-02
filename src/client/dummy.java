/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import common.finder.Tree;
import common.reader.Reader;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class dummy {
    public static void main(String[] args){
        //ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/MERCHANT/zara@lc.mrc.com"  , "product.bin")).splitFile('▓');
        //System.out.println(proFetch);
        ArrayList<String>companyFetch=new Tree("Database/User/MERCHANT").view();
        for( String X:companyFetch ){
            ArrayList <ArrayList<String>> nameFetch = (new Reader("Database/User/MERCHANT/" + X  , "profile.bin")).splitFile('▓');
            System.out.println(nameFetch.get(0).get(0));
            ArrayList <ArrayList<String>> productFetch = (new Reader("Database/User/MERCHANT/" + X  , "product.bin")).splitFile('▓');
            System.out.println(productFetch);
            System.out.println(" ");
            
        }
    }
    
}
