package model;

public class View {
    private int id;

//    private int goodsid;
//    private int typeid;
    private Goods goods;
    private Type type;
    private int amount;

    public View() {
    }

    public View(int id, Goods goods, Type type, int amount) {
        this.id = id;
        this.goods = goods;
        this.type = type;
        this.amount = amount;
    }

    //    public View(int id,int goodsid,int typeid,int amount){
//        this.id=id;
//        this.goodsid=goodsid;
//        this.typeid=typeid;
//        this.amount=amount;
//    }

//    public View(int id, Goods goods, int goodsid, int typeid, Type type, int amount) {
//        this.id = id;
//        this.goods = goods;
//        this.goodsid = goodsid;
//        this.typeid = typeid;
//        this.type = type;
//        this.amount = amount;
//    }
//
//    public View(int id, Goods goods, Type type, int amount) {
//        this.id = id;
//        this.goods = goods;
//        this.type = type;
//        this.amount = amount;
//    }

//    @Override
//    public String toString() {
//        return "View{" +
//                "id=" + id +
//                ", goods=" + goods +
//                ", goodsid=" + goodsid +
//                ", typeid=" + typeid +
//                ", type=" + type +
//                ", amount=" + amount +
//                '}';
//    }

    @Override
    public String toString() {
        return "View{" +
                "id=" + id +
                ", goods=" + goods +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

//    public int getGoodsid() {
//        return goodsid;
//    }
//
//    public void setGoodsid(int goodsid) {
//        this.goodsid = goodsid;
//    }
//
//    public int getTypeid() {
//        return typeid;
//    }
//
//    public void setTypeid(int typeid) {
//        this.typeid = typeid;
//    }

    public int getTypeId(){
        return type.getId();
    }

    public int getGoodsId(){
        return goods.getId();
    }
}
