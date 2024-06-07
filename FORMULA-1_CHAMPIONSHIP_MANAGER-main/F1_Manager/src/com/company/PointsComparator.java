package com.company;

import java.util.Comparator;

public class PointsComparator implements Comparator < Formular1Driver > { // Sorting the points in Descending order

    @Override
    public int compare(Formular1Driver p1, Formular1Driver p2) {
        if (p1.getNopoints() == p2.getNopoints()) {
            if (p1.getNoOffirstplaces() > p2.getNoOffirstplaces()) {
                return -1;
            } else if (p1.getNoOffirstplaces() < p2.getNoOffirstplaces())
                return 1;
            else return 0;
        } else if (p1.getNopoints() > p2.getNopoints()) {
            return -1;
        } else
            return 1;
    }
}