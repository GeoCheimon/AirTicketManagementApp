
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.lang.Boolean;
import javax.swing.JPanel;

public class IssuedTicketsFrame extends JFrame {

    private JButton loadTicketsFromFile;
    private JButton statisticalInfoOfClients;

    private JTextArea loadClientsRecords_Area;
    private JTextArea statisticalInfo_Area;
    private ArrayList<Client> ClientList;
    private ArrayList<statisticalClient_info> ClientStatistics;

    public IssuedTicketsFrame() {
        super();

        loadClientsRecords_Area = new JTextArea();
        statisticalInfo_Area = new JTextArea();
        loadTicketsFromFile = new JButton("φόρτωση πελατών από αρχείο");
        statisticalInfoOfClients = new JButton("στατιστικές πληροφορίες");
    }

    public void handleTicketUI() {

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //add components to the panel        
        topPanel.add(loadTicketsFromFile);
        topPanel.add(statisticalInfoOfClients);

        this.add(topPanel, BorderLayout.PAGE_START);
        this.add(loadClientsRecords_Area, BorderLayout.WEST);
        this.add(statisticalInfo_Area, BorderLayout.EAST);

        statisticalInfoOfClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxNumberOfIssuedTickets, maxCostOfTickets = 0;
                int minTicketCode=0, maxTicketCode=0;//Τα αρχικοποιώ αναγκαστικά γιατί στο πέρασμα της μεθόδου showStatisticalInfoOf_Clients
                //πρέπει να έχουν τιμή σε περίπτωση που δεν εκχωρηθεί πραγματικός κωδικός
                maxNumberOfIssuedTickets = ClientList.size();
                int[] minClientsCosts_Positions;//για να βρω έπειτα τα εισιτήρια με ίδιο ελάχιστο κόστος
                int[] maxClientsCosts_Positions;//για να βρω έπειτα τα εισιτήρια με ίδιο ελάχιστο κόστος
                //int[] maxCostOfTickets =new int [numClients];
                int maxCost = 100;//Εβαλα 100 γιατι δε θα πάει ποτέ αφου το κόστος είναι διψήφιος
                int minCost = 9;//Μονοψήφιος
                for (Client i : ClientList) {//διατρέχω το arrayList μου(ClientList)
                    maxCostOfTickets = maxCostOfTickets + Integer.parseInt(i.getTicketCost());
                    if (Integer.parseInt(i.getTicketCost()) <= minCost) {
                        minCost = Integer.parseInt(i.getTicketCost());
                        minTicketCode = Integer.parseInt(i.getTicketId());
                    }
                    if (Integer.parseInt(i.getTicketCost()) >= maxCost) {
                        maxCost = Integer.parseInt(i.getTicketCost());
                        maxTicketCode = Integer.parseInt(i.getTicketId());
                    }

                    minClientsCosts_Positions = minLinearSearch(minCost, ClientList.size());//Το δημιούργησα σε 
                    //περιπτωση που υπάρχουν παραπάνω απο 1 πελατης με το ίδιο ελάχιστο κόστος εισιτηρίου
                    //Είναι οι θέσεις των πελατών στο ClientList

                    if (minClientsCosts_Positions != null) {

                        boolean thereAreMoreTicketsWithSameMinCosts = true;

                        int number0fClientsOfminCosts = minClientsCosts_Positions.length;

                        int[] codeOfminClients = {0};//περιέχει τους κψδικούς των πελατών με ίδιο ελάχιστο κόστος

                        for (int k = 0; k < number0fClientsOfminCosts; k++) {
                            codeOfminClients[k] = Integer.parseInt(i.getTicketId());
                        }
                    }

                    maxClientsCosts_Positions = maxLinearSearch(maxCost, ClientList.size());//Το δημιούργησα σε 
                    //περιπτωση που υπάρχουν παραπάνω απο 1 πελατης με το ίδιο μέγιστο κόστος εισιτηρίου

                    /*if (minClientsCosts_Positions != null) {
                        boolean thereAreMoreTicketsWithSameMaxCosts = true;

                        int number0fClientsOfmaxCosts = maxClientsCosts_Positions.length;

                        int[] codeOfmaxClients = {0};//περιέχει τους κωδικούς των πελατών με ίδιο ελάχιστο κόστος

                        for (int k = 0; k < number0fClientsOfmaxCosts; k++) {
                            codeOfmaxClients[k] = Integer.parseInt(i.getTicketId());
                        }
                    
                    }*/
                    if (minClientsCosts_Positions == null && maxClientsCosts_Positions == null) {
                        showStatisticalInfoOf_Clients(maxNumberOfIssuedTickets, maxCostOfTickets,
                                minCost, maxCost, minTicketCode, maxTicketCode);
                    }
                }
            }
            /*(minClientsCosts_Positions != null && maxClientsCosts_Positions!=null){
                        showStatisticalInfoOf_Clients(maxNumberOfIssuedTickets, maxCostOfTickets, 
                                minClientsCosts_Positions, maxClientsCosts_Positions);
                    }else if(minClientsCosts_Positions == null && maxClientsCosts_Positions!=null){
                        showStatisticalInfoOf_Clients(maxNumberOfIssuedTickets, maxCostOfTickets, 
                                minCost, maxClientsCosts_Positions , minTicketCode , maxTicketCode ,);*/
        }
        );
        loadTicketsFromFile.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                //file chooser που να ανοιγει ενα αρχειο
                final JFileChooser fileChooser = new JFileChooser();//Το αντικείμενο της κλάσης JFileChooser αντιπροσωπεύει ένα παράθυρο διαλόγου από 
                //το οποίο ο χρήστης μπορεί να επιλέξει αρχείο.
                int returnVal = fileChooser.showOpenDialog(IssuedTicketsFrame.this);//Εμφανίζεται ένα παράθυρο επιλογής αρχείων
                if (returnVal == JFileChooser.APPROVE_OPTION) {//Mε το APPROVE_OPTION συγκλρίνω αν ήταν επιτυχείς η επίτρεψη του ανοιγματος παραθύρου
                    String fileName = fileChooser.getSelectedFile().getPath();

                    if (fileName != null && !fileName.isEmpty()) {
                        loadFromFile(fileName);
                    }
                }
            }
        }
        );

        this.setSize(
                900, 400);

        this.setLocationRelativeTo(
                null);

        this.setTitle(
                "λίστα εισιτηρίων");

        this.setVisible(
                true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void showStatisticalInfoOf_Clients(int maxNumberOfIssuedTickets,
            int maxCostOfTickets, int minCost, int maxCost, int minTicketCode, int maxTicketCode) {

        statisticalClient_info clientsStats = new statisticalClient_info(maxNumberOfIssuedTickets,
                maxCostOfTickets, minCost, maxCost, minTicketCode, maxTicketCode);

        ClientStatistics.add(clientsStats);

        statisticalInfo_Area.append(clientsStats.toString());

        statisticalInfo_Area.append("\n\n");
    }

    private int[] minLinearSearch(int minCost, int ClientRecords) {
        int[] minClientsCosts_Positions = new int[ClientRecords];
        int k = 0;
        for (Client i : ClientList) {
            if (minCost == Integer.parseInt(i.getTicketCost())) {
                minClientsCosts_Positions[k] = k;//αποθηκεύω τις θέσεις στις οποίες υπάρχουν πελάτες που το ελάχιστο κόστος τους είναι ίδιο
                k++;
            }
        }
        if (k > 0) {
            return minClientsCosts_Positions;
        } else {
            return null;
        }
    }

    private int[] maxLinearSearch(int maxCost, int ClientRecords) {
        int[] maxClientsCosts_Positions = new int[ClientRecords];
        int k = 0;
        for (Client i : ClientList) {
            if (maxCost == Integer.parseInt(i.getTicketCost())) {
                maxClientsCosts_Positions[k] = k;//αποθηκεύω τις θέσεις στις οποίες υπάρχουν πελάτες που το μέγιστο κόστος τους είναι ίδιο
                k++;
            }
        }
        if (k > 0) {
            return maxClientsCosts_Positions;
        } else {
            return null;
        }
    }

    private void loadFromFile(String fileName) {
        try {
            int j, linesNum, i = 0;

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            String[] lineRecord;
            //String[][] lineRecords;
            //ArrayList<String> ClientRecord;
            //String lineRecords[][] = new String[][];
            Client client;
            while (reader.ready()) {
                line = reader.readLine();//.toString().split("\t");//διαβάζει ολη την γραμμή απο το αρχείο και την βαζει στο lineRecords
                loadClientsRecords_Area.append(line);
                loadClientsRecords_Area.append("\n");
                lineRecord = line.split("\t");

                //ClientRecord = new ArrayList<>(Arrays.asList(line));
                //System.out.println(lineRecords[i]);
                //i++;
                //το split() επιστρεφει string array ,οποτε πρεπει να μετατρέψω τα τελευταία 2 στοιχεία της σειράς απο boolean σε string
                //Αρα,επειτα μπορω να use τα κομματια
                if (lineRecord.length == 9) {
                    client = new Client(lineRecord[0], lineRecord[1], lineRecord[2],
                            lineRecord[3], lineRecord[4], lineRecord[5], lineRecord[6],
                            Boolean.parseBoolean(lineRecord[7]), Boolean.parseBoolean(lineRecord[8]));
                    ClientList.add(client);
                }

            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {

        }
    }
}
