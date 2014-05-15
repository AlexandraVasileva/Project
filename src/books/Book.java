package books;

public class Book {
    ConstantProperties constpr = new ConstantProperties();
    ReadingProperties readpr = new ReadingProperties();
    
    public void setAdress(String s) {
        constpr.adress = s;
    }
    public void setName(String s) {
        constpr.name = s;
    }
    public void setAuthor(String s) {
        constpr.author = s;
    }
    public void setSeries(String s) {
        constpr.series = s;
    }
    public void setGenre(String s) {
        constpr.genre = s;
    }
    public void setPage(int s) {
        readpr.page = s;
    }
    public void setMode(int s) {
        readpr.mode = s;
    }
    
    
    public String getAdress() {
        return constpr.adress;
    }
    public String getName() {
        return constpr.name;
    }
    public String getAuthor() {
        return constpr.author;
    }
    public String getSeries() {
        return constpr.series;
    }
    public String getGenre() {
        return constpr.genre;
    }
    public int getPage() {
        return readpr.page;
    }
    public int getMode() {
        return readpr.mode;
    }
    
}