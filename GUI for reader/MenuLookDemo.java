import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuLookDemo {
    JTextArea output;
    JScrollPane scrollPane;
    JButton button;
    static int WIDTH = 1000;
    static int HEIGHT = 500;
 
    public JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
 
        //BOOK DATA
        JMenuItem menuBookData = new JMenu("Данные о книге");     
        menuBookData.setMnemonic(KeyEvent.VK_A);
        
//      DataAction dataAction = new DataAction();
        menuBookData.addActionListener(new DataEventListener());
        
        menuBar.add(menuBookData);
        
        //READING SETTINGS
        JMenu menuReadSet = new JMenu("Настройки чтения");     
        menuReadSet.setMnemonic(KeyEvent.VK_B);
        menuBar.add(menuReadSet);
        
        //BOOK TOOLS
        JMenu menuBookTools = new JMenu("Инструменты книги");     
        menuBookTools.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menuBookTools);
        
        JMenuItem menuItemBookmark = new JMenuItem("Добавить закладку");
        menuBookTools.add(menuItemBookmark);
        
        JMenuItem menuItemNote = new JMenuItem("Добавить заметку");
        menuBookTools.add(menuItemNote);
        
        menuBookTools.addSeparator();
        
        JMenuItem menuItemSearch = new JMenuItem("Поиск по тексту");
        menuItemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
        menuItemSearch.addActionListener(new DataEventListener());
        menuBookTools.add(menuItemSearch);

        //BOOK NAVIGATION
        JMenu menuBookNav = new JMenu("Навигация по книге");     
        menuBookNav.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menuBookNav);
        
        JMenuItem menuItemBeginning = new JMenuItem("В начало");
        menuBookNav.add(menuItemBeginning);
        
        JMenuItem menuItemEnd = new JMenuItem("В конец");
        menuBookNav.add(menuItemEnd);
        
        JMenuItem menuItemBookmarkGo = new JMenuItem("Перейти к закладке...");
        menuBookNav.add(menuItemBookmarkGo);
        
        //LIBRARY NAVIGATION
        JMenu menuLibNav = new JMenu("Навигация по библиотеке");     
        menuLibNav.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menuLibNav);
        
        JMenuItem menuItemBack = new JMenuItem("Назад");
        menuLibNav.add(menuItemBack);
        
        JMenuItem menuItemAuthor = new JMenuItem("В папку автора");
        menuLibNav.add(menuItemAuthor);
        
        JMenuItem menuItemLib = new JMenuItem("В библиотеку");
        menuLibNav.add(menuItemLib);
        
        JMenuItem menuItemStart = new JMenuItem("На стартовую страницу");
        menuLibNav.add(menuItemStart);
 
        return menuBar;
    }
 
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setText("У сэра Джуффина Халли, практически во всех отношениях безупречного джентльмена, имеется одна-единственная скверная привычка, каковой, впрочем, совершенно достаточно, чтобы свести в могилу человека, вынужденного ежедневно иметь с ним дело. Шеф просто обожает будить хороших людей в самое неподходящее время. Грешные Магистры, иногда я начинаю почти искренне сожалеть, что мы с ним не проживаем где-нибудь на территории моей исторической родины, в не слишком уютном, зато простом и понятном мире, где деспотический начальник, возжелавший силой извлечь своего заместителя из сладкой тьмы сновидений, вынужден использовать примитивные технические средства связи типа телефона, пейджера или, на худой конец, посыльного, которому поручается жалобно мяукать под дверью несчастной жертвы до победного конца. Ибо телефон можно отключить и выбросить в окно, пейджер — растоптать, а потом утопить в унитазе, окна наглухо закрыть, установить бронированную входную дверь и обить ее войлоком (иногда лучше переборщить с предосторожностями). Потом следует заботливо обложить свои чуткие уши подушками, и пусть тогда хоть один гад попробует до тебя добраться! Но меня угораздило надолго застрять в Мире, где существует Безмолвная речь. Поди скройся от неугомонного шефа, когда его коронная реплика: «Давай, давай, просыпайся!» — раздается не в телефонной трубке, а в твоей собственной голове, от которой никуда не денешься. Во всяком случае, сколько раз я пробовал игнорировать его настойчивый зов — безрезультатно! Иногда я начинаю всерьез подумывать, что мне следует обзавестись уютной спальней в каком-нибудь ином Мире и завершать всякий рабочий день поспешным низвержением в Хумгат — отличная замена неторопливой прогулке по предрассветному городу. Зря я, что ли, так долго учился путешествовать между Мирами? Давно пора начинать применять сие таинственное магическое искусство в практических целях. На сей раз злодей Джуффин умудрился разбудить меня ровно через час после того, как я наконец-то закрыл глаза. Но мои жалкие попытки объяснить шефу, что столь омерзительно я не чувствовал себя даже сразу после того, как умер, не произвели на него никакого впечатления. «А бальзам Кахара тебе на что? — спросил он. — Целые поколения могущественных чародеев в течение долгих тысячелетий не щадили усилий, сберегая и совершенствуя рецепт этого бодрящего зелья. Должен же хоть кто-то применять его по назначению! Так что давай, исполняй свою историческую миссию, а потом поднимайся и приезжай ко мне домой. И учти, если через час тебя не будет, я начну рыдать в голос». «Ужас какой, — вяло откликнулся я. — Погодите-ка, я должен приехать именно к вам домой, а не в Управление? Я не ослышался?» «Ты не ослышался», — подтвердил Джуффин и умолк. Оно и к лучшему: башка у меня гудела, как церковный колокол после вечеринки беспутных попов-расстриг, решивших как следует отпраздновать Хеллоуин. Что мне действительно требовалось — так это опустить голову на подушку и поспать еще часов семь, но я был вынужден ограничиться глотком тонизирующего бальзама. Хвала Магистрам, это простенькое чудо — всего-то восьмая ступень Черной магии! — по-прежнему имеет некоторую власть над моим замордованным всяческими чудесами организмом. Во всяком случае, умываться я отправился уже в добром здравии. Я настолько пришел в порядок, что даже начал понемногу терзаться любопытством. Приглашение Джуффина показалось мне довольно странным. Ну, положим, тот факт, что шеф разбудил меня всего через пару часов после того, как мы расстались, вполне в порядке вещей. Я — такое специальное полезное живое существо, над которым можно всласть поизмываться, когда под рукой нет какой-нибудь другой дежурной жертвы, а злодейская душа господина Почтеннейшего Начальника требует своего… Но какого черта он ждет меня дома? До сих пор наш кабинет в Доме у Моста вполне подходил для деловых встреч. К тому же Джуффин не такой уж любитель бессмысленных перемещений в пространстве. Вряд ли шеф стал бы приезжать с утра на службу только для того, чтобы через пару часов получить счастливую возможность лишний раз поскучать на сиденье собственного амобилера, едва ползущего с Правого Берега на Левый под управлением бывшего гонщика Кимпы. Значит, домой он вернулся внезапно. Хотел бы я знать зачем?");
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
        scrollPane.setSize(WIDTH, HEIGHT);
        //scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
 
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }
 


    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Текущая книга");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        MenuLookDemo demo = new MenuLookDemo();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
    }
}