// ===== Ticket Class =====
class Ticket {
    private int id;
    private boolean isSold;

    

    public Ticket(int id,boolean isSold) {
        this.id = id;
        this.isSold = isSold;
    }

    public int getId() {
        return id;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }
}