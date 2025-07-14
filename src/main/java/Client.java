
public class Client {

    private String ticketId;
    private String issueDate;
    private String clientName;
    private String itenary;
    private String ticketCost;
    private String email;
    private String PoliceIdCard;

    private Boolean bussinessClass;
    private Boolean regularClass;
    
    static int i;
    public Client(String ticketId, String issueDate, String clientName, String itenary, String ticketCost, String email, String PoliceIdCard, Boolean bussinessClass, Boolean regularClass) {
        this.ticketId = ticketId;
        this.issueDate = issueDate;
        this.clientName = clientName;
        this.itenary = itenary;
        this.ticketCost = ticketCost;
        this.email = email;
        this.PoliceIdCard = PoliceIdCard;
        this.bussinessClass = bussinessClass;
        this.regularClass = regularClass;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getItenary() {
        return itenary;
    }

    public void setItenary(String itenary) {
        this.itenary = itenary;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPoliceIdCard() {
        return PoliceIdCard;
    }

    public void setPoliceIdCard(String PoliceIdCard) {
        this.PoliceIdCard = PoliceIdCard;
    }

    public Boolean getBussinessClass() {
        return bussinessClass;
    }

    public void setBussinessClass(Boolean bussinessClass) {
        this.bussinessClass = bussinessClass;
    }

    public Boolean getRegularClass() {
        return regularClass;
    }

    public void setRegularClass(Boolean regularClass) {
        this.regularClass = regularClass;
    }

    @Override
    public String toString(){
        
        if(i==0)
        {
            i++;
            return "κωδικός εισιτηρίου" + "#" + "ημερομηνία έκδοσης" + "#" + "ονοματεπώνυμο" + "#" + "δρομολόγιο" + "#" + "τιμή" 
                + "#" + "ηλεκτρονικό ταχυδρομίο" + "#" + "αριθμός ταυτότητας" + "#" + "προνομιακή θέση" + "#" + "οικονομική θέση\n" +
                ticketId + ticketCost + "#" + issueDate + "#" + clientName + "#" + itenary + "#" + ticketCost + "#" + email 
                + "#" + PoliceIdCard + "#" + bussinessClass + "#" + regularClass;
            
        }
        else
            return ticketId + ticketCost + "#" + issueDate + "#" + clientName + "#" + itenary + "#" + ticketCost + "#" + email 
                + "#" + PoliceIdCard + "#" + bussinessClass + "#" + regularClass;
    }
}
