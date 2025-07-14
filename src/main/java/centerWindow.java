
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class centerWindow extends JFrame {/*κεντρικο παράθυρο (σημείο εκκίνησης app),το οποίο παρέχει 4 επιλογές*/
    //To Jbutton ειναι συστατικο που μόλις πατηθεί θα προωθήσει το event στον κατάλληλο ακροατή(listener)
    //τα παρακάτω θα είναι κουμπιά στο Panel του center_window
    private JButton ticket_issuance;//εκδοση εισ.
    private JButton ticket_list;
    private JButton app_info;
    private JButton exit;

    private JMenuBar menuBar;//μαλλον φιταχνω αυτο το αντικειμενο για να μπορει να φαινεται το menu

    //παρακάτω είναι τα στοιχεία menu του center_window
    private JMenu fileMenu;
    private JMenu InfoMenu;//εδω μπαίνει τo appInfo_item

    private JMenuItem tickIssuance_item;
    private JMenuItem ticketList_item;
    private JMenuItem appInfo_item;//θα μπει
    private JMenuItem exit_item;

    private JMenuItem exit_Item;

    public centerWindow(String title) {
        //εφοσον θα βάλω τον constructor να construct τα χαρακτηριστικά του MyFrame(center_window) ,τα οποία θα είναι αντικείμενα της κλασης αυτής,
        //θα τα Θέσω ως private attributes της κλάσης MyFrame
        ticket_issuance = new JButton("Έκδοση νέου εισιτηρίου");
        ticket_list = new JButton("Λίστα εισιτηρίων");
        app_info = new JButton("Πληροφορίες εφαρμογής");
        exit = new JButton("Έξοδος");
        //setEnabled(false);//ειναι πχ για TextField να μη μπορει να γραψω κατι μεσα 

        //area = new JTextArea();
        //userList = new ArrayList();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("Κατάλογος");
        InfoMenu = new JMenu("Πληροφοριες εφαρμογής");

        tickIssuance_item = new JMenuItem("Έκδοση νέου εισιτηρίου");
        ticketList_item = new JMenuItem("Λίστα εισιτηρίων");
        //appInfo_item = new JMenuItem("Πληροφοριες εφαρμογής");
        exit_item = new JMenuItem("Έξοδος");

    }

    public void prepareUI() {

        JPanel Panel = new JPanel();
        Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        /*JPanel center_panel=new JPanel();//Ta panels δεν εχουν BorderLayout αλλα FLowLayout
        //αρα τα συστατικα τους πηγαινουν το ενα διπλα αποτο αλλο,ταιριαζει για τα buttons
        //Αρα,εδω θα βγάλω την περιοχη north θα βαλω την south και σαυτην δε θα βαλω το
        center_panel.setLayout(new FlowLayout(FlowLayout.LEFT));*/
        Panel.add(ticket_issuance);
        Panel.add(ticket_list);
        Panel.add(app_info);
        Panel.add(exit);
        this.add(Panel, BorderLayout.PAGE_START);//sthn panw perioxh
        //PAGE_START=NORTH, βαζω το ενα panel

        fileMenu.add(tickIssuance_item);
        fileMenu.add(ticketList_item);
        fileMenu.addSeparator();//μια γραμμη που χωριζει τα menu
        fileMenu.add(exit_item);

        //InfoMenu.add(appInfo_item);
        menuBar.add(fileMenu);//βαζουμε ολα τα items στο menubar
        menuBar.add(InfoMenu);//στο menubar μπορω να βαλω και το helpMenu

        this.setJMenuBar(menuBar);//τελευταιο βημα ειναι να προσθεσουμε στο menu bar
        //το Frame(δλδ το this ).Δεν το κανουμε με την method add αλλα με την
        //μεθοδο setJMenuBar την οποια την εχουν διαθεσιμη ολα τα JFrames.Exei Set
        //γτ  μπορω να θεσω μονο 1 μπαρα σε ενα frame .Δε μπορω να κανω add πολλα πραγματα
        //Πως μπορω να βαλω λειτουργιες σε αυτα τα items;
        //Ta items auta leitourgoun ws koubia ,δλδ θα μπορουσα να βαλω ενεργειες,με τον ιδιο 
        //τροπο που βαζω σε κουμπια
        //ετσω θελω να κανω το exitItem

        //JTextArea area=new JTextArea();//ειναι μεγαλυτερο απο το TextField που εκει εγραφα μονο ενα πεδιο κειμενο
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//για να μην κανει τπτ παρα μονο να κλεινει το παραθυρο 
        //Το DefaultCloseOperation είναι το hide and close 
        //Άρα, δίνω σήμα στο παράθυρο ,οταν πατιέται το X ,να μην κάνει τπτ .Αρα,αναλαμβάνει ο WindowListener και καλεί την exit_App();
        this.setTitle("διαχειριση αεροποριών εισιτηρίων");
        this.setSize(600, 100);
        this.setVisible(true);

        exit.addActionListener(new ActionListener() {//δημιουργώ μία ανώνυμη εσωτερική κλάση που υλοποιεί την διεπαφή ActionListener.
            @Override
            public void actionPerformed(ActionEvent e) {//Αυτή η μέθοδος καλείται όταν πατιεται το κουμπί exit,όπου το συμβάν αποθηκεύεται στο 
                //αντικείμενο e τύπου ActionEvent
                //χειρισμός συμβάντος
                exit_App();
            }
        });
        exit_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit_App();
            }
        });
        this.addWindowListener(new WindowAdapter() {//οποτε ανοιγει τον adaptop(αυτό εδω μέσα δλδ) αλλα χωρις κωδικα οποια θέλω 
            //κανω overwrite.κανω δεξι(εδω μεσα)->insert code-> για να επιleξω to overwrite και να μου
            //βγαλει επιλογες.Για να μην εχω ομως τον ιδιο κωδικα 2 φορες θα τον φτιαξω 1 φορα
            //και για τα 2 σε 1 function(exitApp)
            @Override
            public void windowClosing(WindowEvent e) {
                exit_App();
                //εχω θέμα με την επιλογη του cancel (μου κλεινει το παραθυρο, της εφορμογής,
                //ενώ θέλω να κλείνει μόνο το παράθυρο του showConfirmDialog.
                //κανει δλδ hide and close.Aυτο που κανω ειναι line:60
            }
        });
        ticket_issuance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketIssuanceFrame TicketIss = new TicketIssuanceFrame();
                TicketIss.prepareTicketUI();
            }
        });
        ticket_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IssuedTicketsFrame IssuedTicket = new IssuedTicketsFrame();
                IssuedTicket.handleTicketUI();
            }
        });
        app_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
    private void exit_App() {
        int i = JOptionPane.showConfirmDialog(centerWindow.this, "Είσαι σίγουρος ότι θες να κλείσεις την εφαρμογή;");
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
}
/*   int i=JOptionPane.showMessageDialog(centerWindow.this,
                 "όνομα εφαρμογής:διαχειριση αεροποριών εισιτηρίων"
                         + "\n ονοματεπώνυμο του προγραμματιστή:Γεώργιος-Παναγιώτης Χειμωνίδης"
                         + "\n αριθμό μητρώου του προγραμματιστή:18390027"
                         + "\n Ημερομηνία ολοκλήρωσης του project:13/06/2021");
                if (i == JOptionPane.YES_OPTION) {
                }*//*private void about(){                
        
        
        About ab = new About();

        /*int i=JOptionPane.showMessageDialog(centerWindow.this,"όνομα εφαρμογής:διαχειριση αεροποριών εισιτηρίων"
                         + "\n ονοματεπώνυμο του προγραμματιστή:Γεώργιος-Παναγιώτης Χειμωνίδης"
                         + "\n αριθμό μητρώου του προγραμματιστή:18390027"
                         + "\n Ημερομηνία ολοκλήρωσης του project:13/06/2021",
                    JOptionPane.INFORMATION_MESSAGE);*/
        //ArrayList<String> infoList;
        
 /*       infoList.add("όνομα εφαρμογής:διαχειριση αεροποριών εισιτηρίων"
                         + "\n ονοματεπώνυμο του προγραμματιστή:Γεώργιος-Παναγιώτης Χειμωνίδης"
                         + "\n αριθμό μητρώου του προγραμματιστή:18390027"
                         + "\n Ημερομηνία ολοκλήρωσης του project:13/06/2021");
        

        
        JOptionPane.showMessageDialog(
                    centerWindow.this,infoList,
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();//Για να κλείσω αυτόματα το παράθυρο=TicketIssuanceFrame
    }
    */