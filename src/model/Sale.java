package model;

public class Sale {
    private User user;
    private int amount;

    public Sale() {
    }

    public Sale(User user, int amount) {
        this.user = user;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "user=" + user +
                ", amount=" + amount +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
