package model;

import java.util.*;

public class UserBigdata {
    private int id;
    private Date log_datetime;
    private Date exit_datetime;
    private String ip_address;
    private long staytime;
    private int user_id;
    private int oreder_id;
    private Map<Integer,OrderItem> itemMap= new HashMap<Integer,OrderItem>();
    private List<OrderItem> itemList = new ArrayList<OrderItem>();

    public UserBigdata() {
    }

    public UserBigdata(int id, Date log_datetime, Date exit_datetime, String ip_address, long staytime,
                       int user_id, int oreder_id, Map<Integer, OrderItem> itemMap, List<OrderItem> itemList) {
        this.id = id;
        this.log_datetime = log_datetime;
        this.exit_datetime = exit_datetime;
        this.ip_address = ip_address;
        this.staytime = staytime;
        this.user_id = user_id;
        this.oreder_id = oreder_id;
        this.itemMap = itemMap;
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "UserBigdata{" +
                "id=" + id +
                ", log_datetime=" + log_datetime +
                ", exit_datetime=" + exit_datetime +
                ", ip_address='" + ip_address + '\'' +
                ", staytime=" + staytime +
                ", user_id=" + user_id +
                ", oreder_id=" + oreder_id +
                ", itemMap=" + itemMap +
                ", itemList=" + itemList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLog_datetime() {
        return log_datetime;
    }

    public void setLog_datetime(Date log_datetime) {
        this.log_datetime = log_datetime;
    }

    public Date getExit_datetime() {
        return exit_datetime;
    }

    public void setExit_datetime(Date exit_datetime) {
        this.exit_datetime = exit_datetime;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public long getStaytime() {
        return staytime;
    }

    public void setStaytime(long staytime) {
        this.staytime = staytime;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOreder_id() {
        return oreder_id;
    }

    public void setOreder_id(int oreder_id) {
        this.oreder_id = oreder_id;
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
