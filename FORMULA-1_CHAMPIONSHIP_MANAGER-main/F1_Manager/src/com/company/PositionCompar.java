package com.company;

import java.util.Comparator;

public class PositionCompar implements Comparator < Formular1Driver > { //firstposition comparator
    @Override
    public int compare(Formular1Driver posit1, Formular1Driver posit2) {
        if (posit1.getNoOffirstplaces() == posit2.getNoOffirstplaces()) {
            return 0;
        } else if (posit1.getNoOffirstplaces() < posit2.getNoOffirstplaces()){
            return 1;
        }else{
            return -1;
        }
    }
}