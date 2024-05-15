package model;

import java.util.*;

public class AdminBigdata {
    private int id;
    private Date log_datetime;
    private Date exit_datetime;
    private String ip_address;
    private int user_id;
    private Map<Integer,OperationItem> itemMap= new HashMap<Integer,OperationItem>();
    private List<OperationItem> itemList = new ArrayList<OperationItem>();


    public AdminBigdata() {
    }

    public AdminBigdata(int id, Date log_datetime, Date exit_datetime,
                        String ip_address, int user_id, Map<Integer, OperationItem> itemMap,
                        List<OperationItem> itemList) {
        this.id = id;
        this.log_datetime = log_datetime;
        this.exit_datetime = exit_datetime;
        this.ip_address = ip_address;
        this.user_id = user_id;
        this.itemMap = itemMap;
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "AdminBigdata{" +
                "id=" + id +
                ", log_datetime=" + log_datetime +
                ", exit_datetime=" + exit_datetime +
                ", ip_address='" + ip_address + '\'' +
                ", user_id=" + user_id +
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Map<Integer, OperationItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, OperationItem> itemMap) {
        this.itemMap = itemMap;
    }

    public List<OperationItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OperationItem> itemList) {
        this.itemList = itemList;
    }
}
