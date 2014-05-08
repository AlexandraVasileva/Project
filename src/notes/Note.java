package notes;

public class Note {
    String adressofbook;
    String text;
    int page;
    Note(String str, String text, int x) {
        adressofbook = str;
        this.text = text;
        page = x;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getAdress() {
        return adressofbook;
    }
    public String getText() {
        return text;
    }
    public int getPage() {
        return page;
    }
}
