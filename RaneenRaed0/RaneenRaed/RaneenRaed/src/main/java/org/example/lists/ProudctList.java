package org.example.lists;

import org.example.model.Proudct;

import java.util.ArrayList;
import java.util.List;

public class ProudctList {


    static List<Proudct> ProudctList = new ArrayList<Proudct>();

    public   static List<Proudct> getProudctList() {
        return ProudctList;
    }


    public static void addProudct(Proudct Proudct){
        ProudctList.add(Proudct);
    }
}
