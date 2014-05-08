package library;

import java.io.*;

class DirFilter implements FileFilter{
    @Override
    public boolean accept(File file) {
        return (file.isDirectory());
    }
}