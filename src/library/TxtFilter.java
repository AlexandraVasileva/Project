package library;

import java.io.*;

class TxtFilter implements FilenameFilter{
    String type1 = ".txt";
    String type2 = ".fb2";
    @Override
    public boolean accept(File dir, String name) {
        String f = new File(name).getName();
        return (f.indexOf(type1) != -1)||(f.indexOf(type2) != -1);
    }
}