package model;

import utils.PriceUtils;

import java.util.*;

public class Order {
    private int id;
    private float total; //all price
    private int amount;//商品的总数目
    private int status;//订单的状态 1未付款2已付款3已发货4已完成
    private int paytype;//付款方式 1微信2支付宝
    private String name;
    private String phone;
    private String address;
    private Date datetime;
    private User user;
    private Map<Integer,OrderItem> itemMap= new HashMap<Integer,OrderItem>();
    private List<OrderItem> itemList = new ArrayList<OrderItem>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", amount=" + amount +
                ", status=" + status +
                ", paytype=" + paytype +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", datetime=" + datetime +
                ", user=" + user +
                ", itemMap=" + itemMap +
                ", itemList=" + itemList +
                '}';
    }

    public void setUsername(String username){
        user=new User();
        user.setUsername(username);
    }

    public void addGoods(Goods g){ //加购商品
//        System.out.println("111");
        if(itemMap.containsKey(g.getId())){ //购物车里面有这个商品
            OrderItem item=itemMap.get(g.getId());//拿到车里面的这个商品
            item.setAmount(item.getAmount()+1);//数量加1
        }
        else{//没有这个商品
            //创建出这个item元素
            OrderItem item = new OrderItem(g.getPrice(),1,g,this,g.getType());
//            System.out.println(item.getGoods());
            //加入集合中去
            itemMap.put(g.getId(),item);
            amount++;
        }
        total=PriceUtils.add(total,g.getPrice());
    }

    public void lessen(int goodsid){ //订单中某一项的数目减1
        if(itemMap.containsKey(goodsid)){
            OrderItem item = itemMap.get(goodsid);
            item.setAmount(item.getAmount()-1);
            amount--;
            total=PriceUtils.subtract(total,item.getPrice());
            if(item.getAmount()<=0){
                itemMap.remove(goodsid);
            }
        }
    }

    public void delete(int goodsid){  //删除订单中的某一项
        if(itemMap.containsKey(goodsid)){
            OrderItem item = itemMap.get(goodsid);
            total= PriceUtils.subtract(total,item.getAmount()*item.getPrice());
            amount-=item.getAmount();
            itemMap.remove(goodsid);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Integer, OrderItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, OrderItem> itemMap) {
        this.itemMap = itemMap;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }
}
