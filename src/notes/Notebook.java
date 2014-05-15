package notes;

import java.util.*;
import java.io.*;

public class Notebook {
    ArrayList<Note> listofnotes = new ArrayList<>();
    String filefornotes = "\\notes.dat";
    
    //в конструкторе будем читать существующие заметки из файла
    public Notebook(String way) {
        way += filefornotes;
        FileInputStream t;
        try {
            t = new FileInputStream(way);//проверка существования файла
        } catch (FileNotFoundException ex) {
            return;
            }
        DataInputStream notesfile = new DataInputStream(t);
        //открыли на чтение если существует
        Note next;
        String text;
        String adress;
        char c;
        int num;
        while(true) {
            try {
                c = notesfile.readChar();
            } catch (EOFException ex) {
                return;
            } catch (IOException ex1) {
                System.out.println("Error: can't read a string.");
                return;
            }
            adress = "";
            while(c != '\n') {
                adress+=c;
                try {
                    c = notesfile.readChar();
                } catch (IOException ex) {
                    System.out.println("Error: can't reade a string.");
                    return;
                }
            }
            // прочитали полный адрес
            try {
                c = notesfile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            text = "";
            while(c != '\n') {
                text+=c;
                try {
                    c = notesfile.readChar();
                } catch (IOException ex) {
                    System.out.println("Error: can't reade a string.");
                    return;
                }
            }
            //Прочитали текст заметки
            try {
                num = notesfile.readInt();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }
            try {
                notesfile.readChar();
            } catch (IOException ex) {
                System.out.println("Error: can't read a string.");
                return;
            }//прочитали страницу
            next = new Note(adress, text, num);
            listofnotes.add(next);//добавили заметку в список
        }
    }

    //список всех заметок
    public ArrayList<Note> getListOfNotes() {
        return listofnotes;
    }
    
    
    //сохранить заметки
                                            //придумать другой символ для разделения!!!
    public void saveNotes(String way) {
        way += filefornotes;
        FileOutputStream t;
        try {
            t = new FileOutputStream(way);//проверка существования файла
        } catch (FileNotFoundException ex) {
            try {
                new File(way).createNewFile();
            } catch (IOException ex1) {
                System.out.println("Error: can't create file");
                return;
            }//теперь точно существует
            try {t = new FileOutputStream(way);} catch (FileNotFoundException ex1){return;}//откроем его на запись
        }
        DataOutputStream savefile = new DataOutputStream(t);
        int i;
        for(i = 0; i < listofnotes.size(); i++) {
            try {
                savefile.writeChars(listofnotes.get(i).getAdress());
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
            //записали полный путь
            try {
                savefile.writeChars(listofnotes.get(i).getText());
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
            //записали  текст
            try {
                savefile.writeInt(listofnotes.get(i).getPage());
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
            //записали страницу
        }
    }
    
    //добавим заметку
    public void addNote(String text, String adress, int page) {
        int i;
        if(text.equals("")) {
            return;
        }
        for(i = 0; i < listofnotes.size(); i++) {
            if(listofnotes.get(i).getAdress().equals(adress)&&(listofnotes.get(i).getPage() == page)) {
                listofnotes.get(i).setText(listofnotes.get(i).getText() + ' ' + text);
                //дописываем к уже существующей заметке
                return;
            }
        }
        listofnotes.add(new Note(adress, text, page));
    }//таким  образом, существует единственная заметка с заданным adress и page
    
    //прочитать существующую заметку
    public String getNote(String adress, int page) {
        int i;
        for(i = 0; i < listofnotes.size(); i++) {
            if(listofnotes.get(i).getAdress().equals(adress)&&(listofnotes.get(i).getPage() == page)) {
                return listofnotes.get(i).getText();
            }
        }
        return "";//пустая строка - если заметка не найдена
    }
}