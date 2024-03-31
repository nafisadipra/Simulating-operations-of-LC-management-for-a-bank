package common.finder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
        
        locationList.addAll(Arrays.asList(directory.list()));
        
        return locationList;
    }

}
