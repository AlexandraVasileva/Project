package library;

import java.util.*;
import java.io.*;
import books.*;


public class Library {
    ArrayList<Book> list = new ArrayList<>();
    String fileforsave = "\\books.dat";
    
    public ArrayList<Book> getListOfBooks() {
        return list;
    }
    
    public void find(String way) {
        File path = new File(way);
        int i;
        String[] listoffiles;
        listoffiles = path.list(new TxtFilter());
        for(i = 0; i < listoffiles.length; i++){
            Book newbook = new Book();
            newbook.setName(listoffiles[i].substring(0, listoffiles[i].length() - 4));
            listoffiles[i] = way + "\\" + listoffiles[i];
            newbook.setAdress(listoffiles[i]);
            list.add(newbook);
        }
        
        File[] listofdirs;
        listofdirs = path.listFiles(new DirFilter());
        for(i = 0; i < listofdirs.length; i++){
            find(listofdirs[i].getAbsolutePath());
        }   
    }
    
    public void save(String way) {
        way += fileforsave;
        FileOutputStream t;
        try {
            t = new FileOutputStream(way);
        } catch (FileNotFoundException ex) {
            try {
                new File(way).createNewFile();
            } catch (IOException ex1) {
                System.out.println("Error: can't create file");
                return;
            }
            try {t = new FileOutputStream(way);} catch (FileNotFoundException ex1){return;}
        }
        DataOutputStream savefile = new DataOutputStream(t);
        
        int i;
        for(i = 0; i < list.size(); i++) {
            try {
                savefile.writeChars(list.get(i).getAdress());
            } catch (IOException ex) {
                System.out.println("Error: can't write a string");
                return;
            }
            try {
                savefile.writeChar('\n');
            } catch (IOException ex) {
                System.out.println("Error: can't write a string.");
                return;
            }
            try {
                savefile.writeChars(list.get(i).getName());
            } catch (IOException ex) {
                System.out.println("Error: can't write a string");
                return;
            }
            try {
                savefile.writeChar('\n');
            } catch (IOException ex) {
                System.out.println("Error: can't write a string.");
                return;
            }
            try {
                savefile.writeChars(list.get(i).getAuthor());
            } catch (IOException ex) {
                System.out.println("Error: can't write a string");
                return;
            }
            try {
                savefile.writeChar('\n');
            } catch (IOException ex) {
                System.out.println("Error: can't write a string.");
                return;
            }
            try {
                savefile.writeChars(list.get(i).getSeries());
            } catch (IOException ex) {
                System.out.println("Error: can't write a string");
                return;
            }
            try {
                savefile.writeChar('\n');
            } catch (IOException ex) {
                System.out.println("Error: can't write a string.");
                return;
            }
            try {
                savefile.writeChars(list.get(i).getGenre());
            } catch (IOException ex) {
                System.out.println("Error: can't write a string");
                return;
            }
            try {
                savefile.writeChar('\n');
            } catch (IOException ex) {
                System.out.println("Error: can't write a string.");
                return;
            }
            try {
                savefile.writeInt(list.get(i).getPage());
            } catch (IOException ex) {
                System.out.println("Error: can't write a string");
                return;
            }
            try {
                savefile.writeChar('\n');
            } catch (IOException ex) {
                System.out.println("Error: can't write a string.");
                return;
            }
            try {
                savefile.writeInt(list.get(i).getMode());
            } catch (IOException ex) {
                System.out.println("Error: can't write a string");
                return;
            }
            try {
                savefile.writeChar('\n');
            } catch (IOException ex) {
                System.out.println("Error: can't write a string.");
                return;
            }
        }
    }
    
    public void load(String way) {
        way += fileforsave;
        FileInputStream t;
        try {
            t = new FileInputStream(way);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: there is no such file");
            return;
            }
        DataInputStream savefile = new DataInputStream(t);
        Book next;
        String temp;
        char c;
        int num;
        while(true) {
            next = new Book();
            try {
                c = savefile.readChar();
            } catch (EOFException ex) {
                return;
            } catch (IOException ex1) {
                System.out.println("Error: can't read a string.");
                return;
            }
            temp = "";
            while(c != '\n') {
                temp+=c;
                try {
                    c = savefile.readChar();
                } catch (IOException ex) {
                    System.out.println("Error: can't reade a string.");
                    return;
                }
            }
            next.setAdress(temp);
            try {
                c = savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            temp = "";
            while(c != '\n') {
                temp+=c;
                try {
                    c = savefile.readChar();
                } catch (IOException ex) {
                    System.out.println("Error: can't reade a string.");
                    return;
                }
            }
            next.setName(temp);
            try {
                c = savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            temp = "";
            while(c != '\n') {
                temp+=c;
                try {
                    c = savefile.readChar();
                } catch (IOException ex) {
                    System.out.println("Error: can't reade a string.");
                    return;
                }
            }
            next.setAuthor(temp);
            try {
                c = savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            temp = "";
            while(c != '\n') {
                temp+=c;
                try {
                    c = savefile.readChar();
                } catch (IOException ex) {
                    System.out.println("Error: can't reade a string.");
                    return;
                }
            }
            next.setSeries(temp);
            try {
                c = savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            temp = "";
            while(c != '\n') {
                temp+=c;
                try {
                    c = savefile.readChar();
                } catch (IOException ex) {
                    System.out.println("Error: can't reade a string.");
                    return;
                }
            }
            next.setGenre(temp);
            try {
                num = savefile.readInt();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            next.setPage(num);
            try {
                savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            try {
                num = savefile.readInt();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            next.setMode(num);
            try {
                savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            list.add(next);
        }
    }
    
    public void print() {
        int i;
        for(i = 0; i < list.size(); i++) {
            System.out.println("Book №" + (i+1) + ":\n  Adress: " + list.get(i).getAdress() + ";\n  Name: " + list.get(i).getName() + ";\n  Author: " + list.get(i).getAuthor() + ";\n  Series: " + list.get(i).getSeries() + ";\n  Genre: " + list.get(i).getGenre() + ";\n  Page: " + list.get(i).getPage() + ";\n  Mode: " + list.get(i).getMode() + ';');
        }
    }
    
    public ArrayList<String> listOfSmth(int code, ArrayList<Book> oldlist){
        ArrayList<String> result = new ArrayList<>();
        int i;
        int j;
        boolean flag;
        String str;
        switch(code) {
            case 0:
                for(i = 0; i < oldlist.size(); i++) {
                    flag = true;
                    str = oldlist.get(i).getName();
                    for(j = 0; j < result.size(); j++) {
                        if(result.get(j).equals(str)){
                            flag = false;
                            break; 
                        }
                    }
                    if(flag) {
                        result.add(str);
                    }
                } 
                break;
            case 1:
                for(i = 0; i < oldlist.size(); i++) {
                    flag = true;
                    str = oldlist.get(i).getAuthor();
                    for(j = 0; j < result.size(); j++) {
                        if(result.get(j).equals(str)){
                            flag = false;
                            break; 
                        }
                    }
                    if(flag) {
                        result.add(str);
                    }
                } 
                break;
            case 2:
                for(i = 0; i < oldlist.size(); i++) {
                    flag = true;
                    str = oldlist.get(i).getSeries();
                    for(j = 0; j < result.size(); j++) {
                        if(result.get(j).equals(str)){
                            flag = false;
                            break; 
                        }
                    }
                    if(flag) {
                        result.add(str);
                    }
                } 
                break;
            case 3:
                for(i = 0; i < oldlist.size(); i++) {
                flag = true;
                str = oldlist.get(i).getGenre();
                for(j = 0; j < result.size(); j++) {
                    if(result.get(j).equals(str)){
                        flag = false;
                        break; 
                    }
                }
                if(flag) {
                    result.add(str);
                }
            } 
            break;
        }
        Collections.sort(result);
        return result;
    }
    
    public ArrayList<Book> shortList(int code, String str) {
        ArrayList<Book> shortlist = new ArrayList<>();
        int i;
        switch(code) {
            case 0:
                for(i = 0; i < list.size(); i++) {
                    if(list.get(i).getName().equals(str)) {
                        shortlist.add(list.get(i));
                    }
                }
                break;
            case 1:
                for(i = 0; i < list.size(); i++) {
                    if(list.get(i).getAuthor().equals(str)) {
                        shortlist.add(list.get(i));
                    }
                }
                break;
            case 2:
                for(i = 0; i < list.size(); i++) {
                    if(list.get(i).getSeries().equals(str)) {
                        shortlist.add(list.get(i));
                    }
                }
                break;
            case 3:
                for(i = 0; i < list.size(); i++) {
                    if(list.get(i).getGenre().equals(str)) {
                        shortlist.add(list.get(i));
                    }
                }
                break;
        }
        return shortlist;
    }
    
    public ArrayList<Book> searchForBook(String str, ArrayList<Book> slist) {
        int i;
        Book t;
        ArrayList<Book> result = new ArrayList<>();
        for(i = 0; i < slist.size(); i++) {
            if(slist.get(i).getAuthor().equals(str)||slist.get(i).getGenre().equals(str)||slist.get(i).getName().equals(str)||slist.get(i).getSeries().equals(str)) {
                t = slist.get(i);
                result.add(t);
            }
        }
        return result;
    }
    
    public ArrayList<Book> searchForBook(String str, ArrayList<Book> slist, int code) {
        int i;
        Book t;
        ArrayList<Book> result = new ArrayList<>();
        switch(code) {
            case 0:
                for(i = 0; i < slist.size(); i++) {
                    if(slist.get(i).getName().equals(str)) {
                        t = slist.get(i);
                        result.add(t);
                    }
                }
                break;
            case 1:
                for(i = 0; i < slist.size(); i++) {
                    if(slist.get(i).getAuthor().equals(str)) {
                        t = slist.get(i);
                        result.add(t);
                    }
                }
                break;
            case 2:
                for(i = 0; i < slist.size(); i++) {
                    if(slist.get(i).getSeries().equals(str)) {
                        t = slist.get(i);
                        result.add(t);
                    }
                }
                break;
            case 3:
                for(i = 0; i < slist.size(); i++) {
                    if(slist.get(i).getGenre().equals(str)) {
                        t = slist.get(i);
                        result.add(t);
                    }
                }
                break;
        }
        return result;
    }
}