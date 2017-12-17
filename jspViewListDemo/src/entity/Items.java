package entity;

import java.util.Objects;

public class Items {
    private int id;
    private String name;
    private String city;
    private  double price;
    private  int num;
    private  String picture;

    public Items(int id, String name, String city, double price, int num, String picture) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.price = price;
        this.num = num;
        this.picture = picture;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String piture) {
        this.picture = piture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Items) {
            Items i = (Items) o;
            if (this.getId() == i.getId() && this.getName().equals(i.getName())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId()+this.getName().hashCode();
    }




    @Override
    public String toString() {
        return "商品编号:"+this.getId()+",商品名称:"+this.getName();
    }
}
