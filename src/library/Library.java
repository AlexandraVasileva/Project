package library;

import java.util.*;
import java.io.*;
import books.*;
import Mode.*;


public class Library {
    ArrayList<Book> list = new ArrayList<>();
    String fileforsave = "\\books.dat";
    String fileforprevbook = "\\previous.dat";
    String fileformodes = "\\modes.dat";
    ArrayList<Mode> modes = new ArrayList<>();
    
    public ArrayList<Book> getListOfBooks() {
        return list;
    }
    
    public void savePreviousBook(String way, String adress){
    	way += fileforprevbook;
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
        try {
            savefile.writeChars(adress);
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
    
    public String loadPreviousBook(String way) {
    	way += fileforprevbook;
        FileInputStream t;
        try {
            t = new FileInputStream(way);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: there is no such file");
            return null;
            }
        DataInputStream savefile = new DataInputStream(t);
        char c;
        String temp;
        try {
            c = savefile.readChar();
        } catch (EOFException ex) {
            return null;
        } catch (IOException ex1) {
            System.out.println("Error: can't read a string.");
            return null;
        }
        temp = "";
        while(c != '\n') {
            temp+=c;
            try {
                c = savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't reade a string.");
                return null;
            }
        }
        return temp;
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
            if(searchForBook(newbook.getAdress(), list, 4).size() == 0) {
            	list.add(newbook);
            	}
        }
        
        File[] listofdirs;
        listofdirs = path.listFiles(new DirFilter());
        for(i = 0; i < listofdirs.length; i++){
            find(listofdirs[i].getAbsolutePath());
        }   
    }
    
    public void check() {
    	int i;
    	
    	FileInputStream t;
        String temp;
        
    	
    	for(i = 0; i < list.size(); i++) {
    		temp = list.get(i).getAdress();
            try {
                t = new FileInputStream(temp);
            } catch (FileNotFoundException ex) {
                //System.out.println("Error: there is no such file");
                list.remove(i);
                return;
                }
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
            System.out.println("Book в„–" + (i+1) + ":\n  Adress: " + list.get(i).getAdress() + ";\n  Name: " + list.get(i).getName() + ";\n  Author: " + list.get(i).getAuthor() + ";\n  Series: " + list.get(i).getSeries() + ";\n  Genre: " + list.get(i).getGenre() + ";\n  Page: " + list.get(i).getPage() + ";\n  Mode: " + list.get(i).getMode() + ';');
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
    
    public ArrayList<Book> shortList(int code, String str, ArrayList<Book> oldlist) {
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
            case 4:
                for(i = 0; i < slist.size(); i++) {
                    if(slist.get(i).getAdress().equals(str)) {
                        t = slist.get(i);
                        result.add(t);
                    }
                }
                break;    
        }
        return result;
    }
    
    public void saveModes(String way) {
    	way += fileformodes;
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
        for(i = 0; i < modes.size(); i++) {
            try {
                savefile.writeChars(modes.get(i).getName());
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
                savefile.writeChars(modes.get(i).getFont());
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
                savefile.writeInt(modes.get(i).getSizeOfType());
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
    
    public void loadModes(String way) {
    	way += fileformodes;
        FileInputStream t;
        try {
            t = new FileInputStream(way);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: there is no such file");
            return;
            }
        DataInputStream savefile = new DataInputStream(t);
        
        Mode next;
        String temp;
        char c;
        int num;
        
        while(true) {
            next = new Mode("");
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
            next.setFont(temp);
            try {
                num = savefile.readInt();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            next.setSizeOfType(num);
            try {
                savefile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            modes.add(next);
        }

    }

    public void setDefaultModes(String way) {
    	modes.clear();
    	modes.add(new Mode("Художественный"));		//0
    	modes.add(new Mode("Рабочий"));				//1
    	modes.add(new Mode("Пользовательский"));	//2
    	saveModes(way);
    }
    
    public ArrayList<Mode> getListOfModes() {
    	return modes;
    }
    
    public Mode searchForMode(String str) {
    	int i;
    	for(i = 0; i < modes.size(); i++) {
    		if(modes.get(i).getName().equals(str)) {
    			return modes.get(i);
    		}
    	}
    	return null;
    }
}