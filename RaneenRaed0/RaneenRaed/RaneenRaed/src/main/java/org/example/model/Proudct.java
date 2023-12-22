package org.example.model;

import org.example.lists.ProudctList;

import java.util.List;

public   class Proudct {

    String photo;
    int  id;
    String name;
    String price;
    boolean reserve;
    List<Proudct> proudctList= ProudctList.getProudctList();

    public Proudct(String name,int id,boolean  reserve,String price ,String photo) {
        this.name= name;
        this .id= id;
        this.reserve = reserve;
        this.price= price;
        this.photo = photo;
    }



    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public int getProudctId() {
        return id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setReserve(boolean reserve) {

        this.reserve=reserve;
    }

    public boolean isReserve() {
        return reserve;
    }

    public Proudct(int i, String test_product, double v, String price, boolean b) {

    }


    public void setHouseId(int i) { this.id=i;
    }

    public void setProudctId(int i) {
    }
}
