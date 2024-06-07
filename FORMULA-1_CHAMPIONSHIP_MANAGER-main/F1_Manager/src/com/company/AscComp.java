package com.company;

import java.util.Comparator;

public class AscComp implements Comparator < Formular1Driver > { //Ascending Comparator
    @Override
    public int compare(Formular1Driver p1, Formular1Driver p2) {
        if (p1.getNopoints() == p2.getNopoints()) {
            if (p1.getNoOffirstplaces() < p2.getNoOffirstplaces()) {
                return -1;
            } else if (p1.getNoOffirstplaces() > p2.getNoOffirstplaces())
                return 1;
            else return 0;
        } else if (p1.getNopoints() < p2.getNopoints()) {
            return -1;
        } else
            return 1;
    }
}
