
public class statisticalClient_info {

    private int maxNumberOfIssuedTickets;
    private int maxCostOfTickets;
    private int minCost;
    private int maxCost;
    private int[] minCostTicket_Potitions;
    private int[] maxCostTicket_Potitions;
    private int[] minTicketCode_Potitions;
    private int[] maxTicketCode_Potitions;    
    private int minTicketCode;
    private int maxTicketCode;
    
    private boolean thereAreMoreTicketsWithSameMinxCosts;
    private boolean thereAreMoreTicketsWithSameMaxCosts;
    
    static int i;

    /*public statisticalClient_info(int maxNumberOfIssuedTickets, int maxCostOfTickets, int[] minCostTicket_Potitions, int[] maxCostTicket_Potitions,
            int ticketCode, int[] minTicketCode_Potitions, int[] maxTicketCode_Potitions,
            boolean thereAreMoreTicketsWithSameMinxCosts, boolean thereAreMoreTicketsWithSameMaxCosts) {
        this.maxNumberOfIssuedTickets = maxNumberOfIssuedTickets;
        this.maxCostOfTickets = maxCostOfTickets;
        this.minCostTicket_Potitions = minCostTicket_Potitions;
        this.maxCostTicket_Potitions = maxCostTicket_Potitions;
        this.minTicketCode = ticketCode;
        this.minTicketCode = ticketCode;
        this.minTicketCode_Potitions = minTicketCode_Potitions;
        this.maxTicketCode_Potitions = maxTicketCode_Potitions;
        this.thereAreMoreTicketsWithSameMinxCosts = thereAreMoreTicketsWithSameMinxCosts;
        this.thereAreMoreTicketsWithSameMaxCosts = thereAreMoreTicketsWithSameMaxCosts;
    }*/
    public statisticalClient_info(int maxNumberOfIssuedTickets,int maxCostOfTickets,int minCost,int maxCost,int minTicketCode, int maxTicketCode){
        this.maxNumberOfIssuedTickets = maxNumberOfIssuedTickets;
        this.maxCostOfTickets = maxCostOfTickets;
        this.minCost = minCost;
        this.maxCost = maxCost;
        this.minTicketCode = minTicketCode;
        this.minTicketCode = maxTicketCode;
    }
    
    public boolean isThereAreMoreTicketsWithSameMinxCosts() {
        return thereAreMoreTicketsWithSameMinxCosts;
    }

    public void setThereAreMoreTicketsWithSameMinxCosts(boolean thereAreMoreTicketsWithSameMinxCosts) {
        this.thereAreMoreTicketsWithSameMinxCosts = thereAreMoreTicketsWithSameMinxCosts;
    }

    public boolean isThereAreMoreTicketsWithSameMaxCosts() {
        return thereAreMoreTicketsWithSameMaxCosts;
    }

    public void setThereAreMoreTicketsWithSameMaxCosts(boolean thereAreMoreTicketsWithSameMaxCosts) {
        this.thereAreMoreTicketsWithSameMaxCosts = thereAreMoreTicketsWithSameMaxCosts;
    }

    public int getMaxNumberOfIssuedTickets() {
        return maxNumberOfIssuedTickets;
    }

    public void setMaxNumberOfIssuedTickets(int maxNumberOfIssuedTickets) {
        this.maxNumberOfIssuedTickets = maxNumberOfIssuedTickets;
    }

    public int getMaxCostOfTickets() {
        return maxCostOfTickets;
    }

    public void setMaxCostOfTickets(int maxCostOfTickets) {
        this.maxCostOfTickets = maxCostOfTickets;
    }

    public int[] getMinCostTicket() {
        return minCostTicket_Potitions;
    }

    public void setMinCostTicket(int[] minCostTicket) {
        this.minCostTicket_Potitions = minCostTicket;
    }

    public int[] getMaxCostTicket() {
        return maxCostTicket_Potitions;
    }

    public void setMaxCostTicket(int[] maxCostTicket) {
        this.maxCostTicket_Potitions = maxCostTicket;
    }

    @Override
    public String toString() {
            return "συνολικός αριθμός των εκδοθέντων εισιτηρίων=    " + maxNumberOfIssuedTickets +
                    "\n" + "Συνολικό κόστος όλων των εισιτηρίων=    " + maxCostOfTickets +
                    "\n" + "ελάχιστο κόστος εισιτηρίου= " + minCost + "με κωδικό= " + minTicketCode +
                    "\n" + "ελάχιστο κόστος εισιτηρίου= " + maxCost + "με κωδικό= " + maxTicketCode;          

    }
   // Το εισιτήριο με το ελάχιστο κόστος (κωδικός εισιτηρίου και κόστος)
   // Το εισιτήριο με το μέγιστο κόστος (κωδικός εισιτηρίου και κόστος)
}
/*+ "ονοματεπώνυμο" + "#" + "δρομολόγιο" + "#" + "τιμή"
                    + "#" + "ηλεκτρονικό ταχυδρομίο" + "#" + "αριθμός ταυτότητας" + "#" + "προνομιακή θέση" + "#" + "οικονομική θέση\n"
                    + ticketId + ticketCost + "#" + issueDate + "#" + clientName + "#" + itenary + "#" + ticketCost + "#" + email
                    + "#" + PoliceIdCard + "#" + bussinessClass + "#" + regularClass;*/