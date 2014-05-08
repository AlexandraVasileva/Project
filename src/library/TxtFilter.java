package library;

import java.io.*;

class TxtFilter implements FilenameFilter{
    String type = ".txt";
    @Override
    public boolean accept(File dir, String name) {
        String f = new File(name).getName();
        return f.indexOf(type) != -1;
    }
}