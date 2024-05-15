package model;

public class OrderItem {
    private int id;
    private float price;
    private int amount;
    private String goodsName;
//    private int typeid;
    private Goods goods;
    private Order order;
    private Type type;

    public OrderItem( float price, int amount, Goods goods, Order order,Type type) {
        super();
        this.price = price;
        this.amount = amount;
        this.goods = goods;
        this.order = order;
        this.type = type;
//        this.typeid=typeid;
    }

//    @Override


    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", price=" + price +
                ", amount=" + amount +
                ", goodsName='" + goodsName + '\'' +
                ", goods=" + goods +
//                ", order=" + order +
                ", type=" + type +
                '}';
    }

    public OrderItem() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

//    public int getTypeid() {
//        return typeid;
//    }
//
//    public void setTypeid(int typeid) {
//        this.typeid = typeid;
//    }
}
