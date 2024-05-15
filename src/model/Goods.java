package model;

public class Goods {
    private int id;
    private String name;
    private String cover;
    private String image1;
    private String intro;
    private String image2;
    private float price;
    private int stock;
    private Type type;

    private boolean isScroll;
    private boolean isHot;
    private boolean isNew;

    public Goods() {
        super();
    }

    public Goods(int id, String name, String cover,
                 String image1, String intro, String image2,
                 float price, int stock, Type type,
                 boolean isScroll, boolean isHot, boolean isNew) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.image1 = image1;
        this.intro = intro;
        this.image2 = image2;
        this.price = price;
        this.stock = stock;
        this.type = type;
        this.isScroll = isScroll;
        this.isHot = isHot;
        this.isNew = isNew;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", image1='" + image1 + '\'' +
                ", intro='" + intro + '\'' +
                ", image2='" + image2 + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", type=" + type +
                ", isScroll=" + isScroll +
                ", isHot=" + isHot +
                ", isNew=" + isNew +
                '}';
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }
    public Type getType() {
        return type;
    }

    public int getTypeId(){
        return type.getId();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isScroll() {
        return isScroll;
    }

    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
