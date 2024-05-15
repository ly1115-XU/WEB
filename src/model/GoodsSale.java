package model;

public class GoodsSale {
    private int goodsid;
    private String name;
    private String cover;
    private String typeid;
    private int stock;
    private int amount;

    public GoodsSale() {
    }

    public GoodsSale(int goodsid, String name, String cover, String typeid, int stock, int amount) {
        this.goodsid = goodsid;
        this.name = name;
        this.cover = cover;
        this.typeid = typeid;
        this.stock = stock;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GoodsSale{" +
                "goodsid=" + goodsid +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", typeid='" + typeid + '\'' +
                ", stock=" + stock +
                ", amount=" + amount +
                '}';
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
