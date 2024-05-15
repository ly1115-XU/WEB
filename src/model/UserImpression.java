package model;

import java.util.List;

public class UserImpression {
    private int user_id;//用户id
    private String register;//是否为新用户
    private String action;//是否为活跃用户
    private String cost;//消费水平
    private List<String>impression;//创建词云

    public UserImpression() {
    }

    public UserImpression(int user_id, String register, String action, String cost, List<String> impression) {
        this.user_id = user_id;
        this.register = register;
        this.action = action;
        this.cost = cost;
        this.impression = impression;
    }

    @Override
    public String toString() {
        return "UserImpression{" +
                "user_id=" + user_id +
                ", register='" + register + '\'' +
                ", action='" + action + '\'' +
                ", cost='" + cost + '\'' +
                ", impression=" + impression +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public List<String> getImpression() {
        return impression;
    }

    public void setImpression(List<String> impression) {
        this.impression = impression;
    }
}
