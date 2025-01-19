package com.company;

import java.io.IOException;

public interface ChampionshipManager {

    public void createDriver();

    public void deleteDriver();

    public void addRace();

    public void changeDriver();

    public void viewstatistics();

    public void viewtable();

    public void savefile() throws IOException;

    public void readfile() throws IOException;

}
