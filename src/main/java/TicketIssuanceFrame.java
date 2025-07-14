
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

public class TicketIssuanceFrame extends JFrame {

    private JLabel ticketId_Lb;
    private JLabel issueDate_Lb;
    private JLabel clientName_Lb;
    private JLabel itenary_Lb;
    private JLabel ticketCost_Lb;
    private JLabel email_Lb;
    private JLabel PoliceIdCard_Lb;
    private JLabel bussinessClassLb;
    private JLabel regularClassLb;

    private JTextField ticketId_Tf;
    private JTextField issueDate_Tf;
    private JTextField clientName_Tf;
    private JTextField itenary_Tf;
    private JTextField ticketCost_Tf;
    private JTextField emailTf;
    private JTextField PoliceIdCard_Tf;

    private JCheckBox bussinessClassCb;//υλοποιηση με checkbox
    private JCheckBox regularClassCb;//υλοπ. με checkbox

    private JTextArea textArea;

    private JButton textSave_Btn;
    private JButton ClientsSave_Btn;

    private ArrayList<Client> clientList;//Tα arraylist μπορουν να δεχτουν οτιδηποτε αντικειμενα 
    //θελουμε.Οχι μονο utility types(απλα arrayS),μπορουν πχ να δεχτουν strings ,τις δικές μου κλάσεις κτλ.
    //και επισης μπορω σε καθε θεση να βάζω διαφορετικό αντικείμενο(καποιες βοηθαει ,καποιες οχι
    //Χρησιμοποιήσω diamond syntax(<τυπο που θελω>),για να εξακριβώσω τον τύπο δεδομένων που θέλω .Εδω είναι Client

    public TicketIssuanceFrame() {//constructor του mainframe που construct τα παρακατω χαρακτηριστικα
        //θα μπορουσα να τα construct αυτα και στην prepareUI ,απλα το εσπασα για να μην γινει 
        //μελαγος ο κωδικας της prepareUI,ΔΕΝ ΕΧΕΙ ΚΑΜΙΑ ΔΙΑΦΟΡΑ. 
        super();//implicit call

        //create components
        ticketId_Lb = new JLabel("κωδικός εισιτηρίου: ");
        issueDate_Lb = new JLabel("ημερομηνία έκδοσης: ");
        clientName_Lb = new JLabel("ονοματεπώνυμο: ");
        itenary_Lb = new JLabel("δρομολόγιο:\t");
        ticketCost_Lb = new JLabel("τιμή : ");
        email_Lb = new JLabel("ηλεκτρονικό ταχυδρομίο: ");
        PoliceIdCard_Lb = new JLabel("αριθμός ταυτότητας:");

        ticketId_Tf = new JTextField(5);
        issueDate_Tf = new JTextField(5);//να ρυθμίσω το χαρακτηρα διαχωρισμου(οποτε εδω θα τσεκαρω για σφαλματα)
        clientName_Tf = new JTextField(5);
        itenary_Tf = new JTextField(5);//να ρυθμίσω το χαρακτηρα διαχωρισμού μεταξυ των 2 πολεων
        ticketCost_Tf = new JTextField(5);//μονο 2 ψηφία
        emailTf = new JTextField(5);
        PoliceIdCard_Tf = new JTextField(5);

        bussinessClassLb = new JLabel("");
        regularClassLb = new JLabel("");

        bussinessClassCb = new JCheckBox("προνομιακή θέση ");
        regularClassCb = new JCheckBox("οικονομική θέση ");

        textArea = new JTextArea();

        textSave_Btn = new JButton("προσωρινή αποθήκευση πελατη");
        ClientsSave_Btn = new JButton("αποθήκευση πελατών");
        clientList = new ArrayList();
    }

    public void prepareTicketUI() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //create panels
        JPanel topPanel = new JPanel();
        //Panel.setLayout(new BoxLayout(Panel, BoxLayout.X_AXIS));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));//Αρα, εδω τα buttons θα γινουν allign στα αριστερα 
        this.add(topPanel, BorderLayout.PAGE_START);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(bottomPanel, BorderLayout.PAGE_END);
        this.add(textArea, BorderLayout.CENTER);//μεσσαια περιοχη

        //Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        //this.add(Panel, BorderLayout.PAGE_START);
        bottomPanel.add(textSave_Btn);
        bottomPanel.add(ClientsSave_Btn);
        topPanel.add(ticketId_Lb);
        topPanel.add(ticketId_Tf);
        topPanel.add(issueDate_Lb);
        topPanel.add(issueDate_Tf);
        topPanel.add(clientName_Lb);
        topPanel.add(clientName_Tf);
        topPanel.add(itenary_Lb);
        topPanel.add(itenary_Tf);
        topPanel.add(ticketCost_Lb);
        topPanel.add(ticketCost_Tf);
        topPanel.add(email_Lb);
        topPanel.add(emailTf);

        topPanel.add(PoliceIdCard_Lb);
        topPanel.add(PoliceIdCard_Tf);
        topPanel.add(bussinessClassCb);
        topPanel.add(regularClassCb);

        this.setTitle("έκδοση εισιτηρίων");
        this.setSize(1600, 700);
        this.setVisible(true);

        textSave_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticketId = ticketId_Tf.getText().trim();
                String issueDate = issueDate_Tf.getText().trim();
                String clientName = clientName_Tf.getText().trim();
                String itenary = itenary_Tf.getText().trim();
                String ticketCost = ticketCost_Tf.getText().trim();
                String email = emailTf.getText().trim();
                String PoliceIdCard = PoliceIdCard_Tf.getText().trim();

                boolean bussinessClass = bussinessClassCb.isSelected();
                boolean regularClass = regularClassCb.isSelected();

                if ((ticketId != null && !ticketId.isEmpty())//ελεγχω αν εχει κενο χαρακτηρα ή τιμη NULL /*isString()=για κενο string*/
                        && (issueDate != null && !issueDate.isEmpty())
                        && (clientName != null && !clientName.isEmpty())
                        && (itenary != null && !itenary.isEmpty())
                        && (ticketCost != null && !ticketCost.isEmpty())
                        && (email != null && !email.isEmpty())
                        && (PoliceIdCard != null && !PoliceIdCard.isEmpty())) {
                    if (!issueDate.matches("^[0-3][0-9]\\-[0-1][0-9]\\-202[0-9]$") || issueDate.matches("^[0-3]0\\-1[3-9]\\-202[0-9]$")
                            || issueDate.matches("^[0-3][0-9]\\-1[3-9]\\-202[0-9]$")
                            || issueDate.matches("^3[2-9]\\-0[0-9]\\-202[0-9]$")
                            || issueDate.matches("^3[2-9]\\-1[0-9]\\-202[0-9]$")) {
                        JOptionPane.showMessageDialog(
                                TicketIssuanceFrame.this,
                                "λαθος διάτακη ημερομηνίας..\n"
                                + "σωστή διάταξη:[0-31]-[0-12]-202[0-9]",
                                "αδύνατη αποθήκευση",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bussinessClass == true && regularClass == true) {
                        JOptionPane.showMessageDialog(
                                TicketIssuanceFrame.this,
                                "Έχεις την δυνατότητα να επιλέξεις μόνο ένα είδος αεροπορικών θέσεων",
                                "αδύνατη αποθήκευση",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (bussinessClass == false && regularClass == false) {
                        JOptionPane.showMessageDialog(
                                TicketIssuanceFrame.this,
                                "Πρεπει να επιλέξεις ένα είδος αεροπορικών θέσεων",
                                "αδύνατη αποθήκευση",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        tempSave_Client(ticketId, issueDate, clientName, itenary, ticketCost, email,
                                PoliceIdCard, bussinessClass, regularClass);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            TicketIssuanceFrame.this,
                            "Δεν έχουν συμπληρωθεί όλα τα πεδία",
                            "αδύνατη αποθήκευση",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.addWindowListener(new WindowAdapter() {//οποτε ανοιγει τον adaptop(αυτό εδω μέσα δλδ) αλλα χωρις κωδικα οποια θέλω 
            //κανω overwrite.κανω δεξι(εδω μεσα)->insert code-> για να επιleξω to overwrite και να μου
            //βγαλει επιλογες.Για να μην εχω ομως τον ιδιο κωδικα 2 φορες θα τον φτιαξω 1 φορα
            //και για τα 2 σε 1 function(exitApp)
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(TicketIssuanceFrame.this, "Είσαι σίγουρος ότι θες να κλείσεις τo παράθυρο;");
                if (i == JOptionPane.YES_OPTION) {
                }
            }
        }
        );
        ClientsSave_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientList.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            TicketIssuanceFrame.this,
                            "Δεν υπάρχουν δεδομένα πελατών",
                            "αδύνατη αποθήκευση",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //Για να αποθηκεύσω τα δεδομένα μου σε αρχείο θα χρησιμοποιήσω το dialog (JFileChooser)
                //με τον οποίο μπορώ να διαλέξω τα αρχεία που θέλω να αποθηκεύσω.
                //Ο fileChooser όμως,δεν είναι static class οπως το OptionPane.Αρα, πρεπει να το χρησιμοποιήσω ως αντικείμενο 
                final JFileChooser fileChooser = new JFileChooser();//το χρησιμοποιώ ως αντικείμενο(filechooser)
                //επειδη δεν ειναι static class σαν το JoptionPane.
                int buttonResult = fileChooser.showSaveDialog(TicketIssuanceFrame.this);//η παράμετρος είναι ο ιδιοκτητης του dialog 
                //με την μεθοδο αυη μπορω να ελεγξω αν πατηθηκε αποθήκευση ή αναίρεση
                //η μεθοδος επιστρεφει int 
                if (buttonResult == JFileChooser.APPROVE_OPTION) {
                    //επειδη δε ξέρω ποια ειναι η σταθερα για cancel και για save
                    //θα user τον ιδιο τον JfileChooser και εχει καποια σταθερα (APPROVE_OPTION=ΕΧΕΙ ΠΑΤΗΘΕΙ SAVE)
                    //Tον fileChooser τον θελω to take a file name
                    //επειδη δε ξέρω ποια ειναι η σταθερα για αναίρεση και για αποθήκευση
                    //θα user τον ιδιο τον JfileChooser και εχει καποια σταθερα (APPROVE_OPTION=ΕΧΕΙ ΠΑΤΗΘΕΙ SAVE)
                    //Tον fileChooser τον θελω to take a file name
                    String fileName = fileChooser.getSelectedFile().getPath();//Για να πάρω πληρες μονοπατι προς το αρχείο 
                    //χρησιμοποιώ getPath()
                    //Tωρα που έχω το ονομα του fileName(αρχείου) μπορώ να φτιάξω ένα stream ,εναν bufferedWriter,
                    //και να αποθηκεύσω στο αρχείο τα δεδομένα
                    if (fileName != null && !fileName.isEmpty()) {
                        saveClients_List(fileName);
                    }
                }
            }
        });;

    };

    private void tempSave_Client(String ticketId, String issueDate, String clientName, String itenary, String ticketCost, String email,
            String PoliceIdCard, boolean bussinessClass, boolean regularClass) {
        Client client = new Client(ticketId, issueDate, clientName, itenary, ticketCost, email, PoliceIdCard, bussinessClass, regularClass);
        //Επειδή ο client ειναι τοπική μεταβλητή(με πολλά στοιχεία) ,θα χαθεί μόλις τελειώσει η κλήση της tempSave_Client().
        //Οπότε πρεπει να τον αποθηκεύω σε ενα που θα το βάλω να ανήκει σε array που θα ανήκει σε ολη την κλάση ,
        //να είναι δλδ 1 private μεταβλητή(Array).Είναι ενα ειδικο array(arraylist),το οποιο δεν χρειαζεται να ξερω 
        //απο πριν ποσα αντικειμενα.
        clientList.add(client);
        textArea.append(client.toString());
        textArea.append("\n");
    }

    private void saveClients_List(String fileName) {//πατάω την επιλογη surround try-catch για το exception
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            //Αυτο που κανω εδω είναι να πάρω την arraylist, να την διατρεξω και
            //ο,τι βρω το κάνω String και το αποθηκεύω.
            //διατρεχω με for loop
            for (int i = 0; i < clientList.size(); i++) {
                writer.write(clientList.get(i).toString());//ετσι παιρνω τα στοιχεια το πινακα και επισης
                //καλει την toString για να τυπωσει ,με συγκεκριμένη μορφη τα στοιχεία των πελατών στο αρχειο clintList.
                writer.newLine();// \n

            }
            writer.close();//αποδεσμεύω τον buffer εφόσον δεν τον χρειάζομαι αλλο,για εξοικονόμηση πόρων
            //Για να καταλάβω ότι όντως έγινε αποθήκευση των πελατών στο αρχείο μου χρησιμοποιώ dialog που αναφέρει μόνο πληροφορίες
            JOptionPane.showMessageDialog(
                    TicketIssuanceFrame.this,
                    clientList.size() + "οι εγγραφές μου αποθηκεύτηκαν στο " + fileName,//εδω εκανα concatenation για να ειναι πιο δυναμικο
                    "η αποθήκευση ολοκληρώθηκε",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();//Για να κλείσω αυτόματα το παράθυρο=TicketIssuanceFrame
        } catch (IOException ex) {

        }

    }
}
