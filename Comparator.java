package com.company;

import java.util.Map;

public class Comparator implements java.util.Comparator<Map.Entry<String, Long>> {

    @Override
    public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
        if (o1.getValue().equals(o2.getValue())) {
            return o1.getKey().compareTo(o2.getKey());
        } else {
            return o2.getValue().compareTo(o1.getValue());
        }
    }
}
