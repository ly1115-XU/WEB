package model;

import java.util.Date;

public class OperationItem {
    private Date op_datetime;
    private String operation;
    private String ip_address;
    private int user_id;

    public OperationItem() {
    }

    public OperationItem(Date op_datetime, String operation, String ip_address, int user_id) {
        this.op_datetime = op_datetime;
        this.operation = operation;
        this.ip_address = ip_address;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "OperationItem{" +
                "op_datetime=" + op_datetime +
                ", operation='" + operation + '\'' +
                ", ip_address='" + ip_address + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public Date getOp_datetime() {
        return op_datetime;
    }

    public void setOp_datetime(Date op_datetime) {
        this.op_datetime = op_datetime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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


}
