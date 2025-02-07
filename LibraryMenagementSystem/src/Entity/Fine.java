package Entity;

import java.util.Date;

public class Fine {
    private IUser user;
    private double amount;
    private Date fineDate;
    public Fine(IUser user, double amount, Date fineDate) {
        this.user = user;
        this.amount = amount;
        this.fineDate = fineDate;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }
}
