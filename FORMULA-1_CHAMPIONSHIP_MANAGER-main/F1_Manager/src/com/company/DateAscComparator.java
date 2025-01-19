package com.company;

import java.util.Comparator;

public class DateAscComparator implements Comparator <Race>{

    @Override
    public int compare(Race d1, Race d2) {
        if (d1.getDate().compareTo(d2.getDate())==0){ 
            return 0;
        }else if (d1.getDate().compareTo(d2.getDate())>0) { 
            return 1;
        }else{
            return -1; 
        }
    }
}
