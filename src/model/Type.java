package model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Type {
    private int id;
    private String name;
    private String encodeName;

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", encodeName='" + encodeName + '\'' +
                '}';
    }

    public Type() {
        super();
    }

    public Type(String name) {
        super();
        this.name = name;
    }


    public Type(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        try {
            this.encodeName= URLEncoder.encode(name,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getEncodeName() {
        return encodeName;
    }

    public void setEncodeName(String encodeName) {
        this.encodeName = encodeName;
    }
}
