package model;

public class Sold {
    private int id;
    private double price;
    private int amount;
    private int goods_id;
    private int order_id;
    private int type_id;

    @Override
    public String toString() {
        return "Sold{" +
                "id=" + id +
                ", price=" + price +
                ", amount=" + amount +
                ", goods_id=" + goods_id +
                ", order_id=" + order_id +
                ", type_id=" + type_id +
                '}';
    }

    public Sold() {
    }

    public Sold(int id, double price, int amount, int goods_id, int order_id, int type_id) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.goods_id = goods_id;
        this.order_id = order_id;
        this.type_id = type_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
