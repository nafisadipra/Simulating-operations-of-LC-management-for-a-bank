package common.finder;

import common.reader.Reader;
import common.user.User;
import java.util.ArrayList;

/**
 *
 * @author Muyeed
 */
public class UserList {
    public ArrayList <User> getList() {
        ArrayList <String> ADMINISTRATOR = (new Tree("Database/User/ADMINISTRATOR")).view();
        ArrayList <String> CLIENT = (new Tree("Database/User/CLIENT")).view();
        ArrayList <String> COMPLIANCEOFFICER = (new Tree("Database/User/COMPLIANCEOFFICER")).view();
        ArrayList <String> CREDITANALYST = (new Tree("Database/User/CREDITANALYST")).view();
        ArrayList <String> GENERALMANAGER = (new Tree("Database/User/GENERALMANAGER")).view();
        ArrayList <String> ITOFFICER = (new Tree("Database/User/ITOFFICER")).view();
        ArrayList <String> LCOFFICER = (new Tree("Database/User/LCOFFICER")).view();
        ArrayList <String> MERCHANT = (new Tree("Database/User/MERCHANT")).view();
        ArrayList <String> REPORTINGOFFICER = (new Tree("Database/User/REPORTINGOFFICER")).view();
        ArrayList <String> SALESREPRESENTATIVE = (new Tree("Database/User/SALESREPRESENTATIVE")).view();
        
        ArrayList <User> userList = new ArrayList();
        
        for (String X: ADMINISTRATOR) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/ADMINISTRATOR/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "Administrator", data.get(5)));
        }
        
        for (String X: CLIENT) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/CLIENT/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "Client", data.get(5)));
        }
        
        for (String X: COMPLIANCEOFFICER) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/COMPLIANCEOFFICER/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "Compliance Officer", data.get(5)));
        }
        
        for (String X: CREDITANALYST) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/CREDITANALYST/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "Credit Analyst", data.get(5)));
        }
        
        for (String X: GENERALMANAGER) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/GENERALMANAGER/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "General Manager", data.get(5)));
        }
        
        for (String X: ITOFFICER) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/ITOFFICER/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "IT Officer", data.get(5)));
        }
        
        for (String X: LCOFFICER) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/LCOFFICER/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "L\\C Officer", data.get(5)));
        }
        
        for (String X: MERCHANT) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/MERCHANT/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "Merchant", data.get(5)));
        }
        
        for (String X: REPORTINGOFFICER) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/REPORTINGOFFICER/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "Reporting Officer", data.get(5)));
        }
        
        for (String X: SALESREPRESENTATIVE) {
            ArrayList <ArrayList<String>> proFetch = (new Reader("Database/User/SALESREPRESENTATIVE/" + X, "profile.bin")).splitFile('▓');
            ArrayList <String> data = proFetch.get(0);
            userList.add(new User(data.get(0), data.get(1), X, data.get(2), data.get(3), data.get(4), "Sales Representative", data.get(5)));
        }
        
        return userList;
        
    }
    
    public ArrayList <User> getFilterList(String type, String email) {
        ArrayList <User> userList = (new UserList()).getList();
        ArrayList <User> filterList = new ArrayList();
        
        for (User X: userList) {
            if ((type.toLowerCase()).equals("all") || (X.getType()).equals(type)) {
                if (email.isEmpty() || (-1 != (X.getEmail().toLowerCase()).indexOf(email.toLowerCase()))) {
                    filterList.add(X);
                }
            }
        }
        
        return filterList;
        
    }
    
}
