package common.emailGen;

import common.finder.Tree;
import common.number.RandomNumber;
import java.util.ArrayList;

/**
 *
 * @author Muyeed
 */
public class EmailGen {
    public String getEmail(String xname, String xtype) {
        String head = xname.split(" ")[xname.split(" ").length - 1].toLowerCase();
        String email = "";
        String type = "";
        if (xtype.equals("CLIENT")) {
            email = head + new RandomNumber(8).generate() + "@lc.cli.com";
            type = "CLIENT";
            
        } else if (xtype.equals("MERCHANT")) {
            email = head + new RandomNumber(8).generate() + "@lc.mrc.com";
            type = "MERCHANT";
        }
        
        if (!type.equals("CLIENT") || !type.equals("MERCHANT")) {
            return email;
        }
        
        ArrayList<String> pathData = new Tree("Database/User/" + type).view();
        for (String X: pathData) {
            if (X.equals(email)) {
                email = new EmailGen().getEmail(xname, xtype);
            } else {
                return email;
            }
        }
        
        return email;
    }
    
}
