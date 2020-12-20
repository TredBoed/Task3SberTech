package com.company;

import java.util.List;
import java.util.Map;

public class Main {
    //CollectionUtils contains own Main method
    public static void main(String[] args) {
        CountMapImpl<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);


        System.out.println(map.getCount(5));
        System.out.println(map.getCount(6));
        System.out.println(map.getCount(10));
    }
}


