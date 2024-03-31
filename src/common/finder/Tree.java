package common.finder;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Muyeed
 */
public class Tree {
    private String location;

    public Tree(String location) {
        this.location = location;
    }

    public String getPath() {
        return location;
    }

    public void setPath(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Tree{" + "location=" + location + '}';
    }
    
    public ArrayList <String> view() {
        ArrayList <String> locationList = new ArrayList();
        
        File directory = new File(location);
        
        for (String data: directory.list()) {
            locationList.add(data);
        }
        
        return locationList;
    }
    
    public static void main (String[] args) {
        Tree lol = new Tree("Database/user");
        
        System.out.println(lol.view());
        
    }
}
