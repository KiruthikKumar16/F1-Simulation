package com.company;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula1Championshipmanager implements ChampionshipManager { //implementing the championship manager interface
    public static Scanner input = new Scanner(System.in); // static scanner class
    private ArrayList < Formular1Driver > drivers = new ArrayList < > (); // arraylist for drivers
    private ArrayList < Race > races = new ArrayList < > (); // arraylist for races
    public ArrayList < Formular1Driver > getDrivers() {
        return drivers;
    } //getter method for Arraylist Formular1Driver(to call the drivers out)
    public ArrayList < Race > getRaces() {
        return races;
    } //getter method for Arraylist Race to call the races out
    @Override
    public void createDriver() { //this is create driver method overided from championshipmanager interface
        String dname = strValidInputs("Enter name of Driver :"+ "\n"); //calling the validation method and String validation for the input Drivername
        if (driverValidate(dname)) {
            String dteam = strValidInputs("Enter team name : "+ "\n"); //calling the validation method and String validation for the input Team name
            if (teamValidate(dteam)) {
                String dlocation = strValidInputs("Enter location :"+ "\n");
                int noraces = intValidInputs("Enter races participated : " + "\n"); // calling the validation method and String validation for the input races
                Formular1Driver driver = new Formular1Driver(dname, dlocation, dteam, noraces);
                drivers.add(driver); //adds into the Formular1Driver arraylist
                System.out.println("\n new Driver " + dname + " Successfully Added.\n");
            } else {
                System.out.println("Team already exists");
            }
        } else {
            System.out.println("Name already exists");
        }
    }

    public boolean driverValidate(String name) { // validate the driver checks weather it already exsits?
        for (Formular1Driver l: drivers) {
            if (l.getDname().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean teamValidate(String team) { // validate the team checks weather it already exsits?
        for (Formular1Driver s: drivers) {
            if (s.getDteam().equals(team)) {
                return false;
            }
        }
        return true;
    }

    //=================================================================================================
    @Override
    public void deleteDriver() { //delete driver method overided from ChampionshipManager interface
        Formular1Driver a = null;
        System.out.println("Enter the name of the driver to delete:");
        String deldriver = input.next();
        System.out.println("------------------------------------------");
        boolean found = false;
        for (Formular1Driver i: drivers) {
            if (i.getDname().equals(deldriver)) { //delete condition
                a = i;
                found = true;
                break;
            }
        }
        drivers.remove(a); // removes the selected items from the array.
        if (!found) {
            System.out.println("Record is not found !!");
        } else {
            System.out.println("-----------Record is deleted sucessfully-----------");
            System.out.println("\n  Driver " + deldriver + " Sucessfully Deleted.\n");
        }
    }
    //======================================================================================================================
    public void changeDriver() { //change driver method overided from ChampionshipManager interface
        System.out.println("Enter Drivers team name : ");
        String tname = input.next();
        System.out.println("------------------------------------------");
        for (Formular1Driver cdriver: drivers) {
            if (cdriver.getDteam().equals(tname)) { //changing condition
                System.out.println("Enter new driver : ");
                String dName = input.next();
                cdriver.setDname(dName); //this parameter sets the team name
                System.out.println("\n  Driver changed in ferarri team " + tname + " .\n");
            }
        }
    }
    //======================================================================================================================
    @Override
    public void addRace() { //add race method overided from ChampionshipManager interface
        try {
            System.out.println("Enter the date of Race (dd/MM/yyyy): "); //race
            String ddate = input.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(ddate);;
            Race race = new Race(date, drivers.size());
            races.add(race);
            for (Formular1Driver dpos: drivers) {
                int driverpos = intValidInputs("Enter position of driver:" + dpos.getDname() + "\n"); // calling the validation method.
                dpos.cal(driverpos); // calling the cal method
                if (driverpos == 1) {
                    dpos.setNoOffirstplaces();
                } else if (driverpos == 2) {
                    dpos.setNoOfsecondPlaces();
                } else if (driverpos == 3) {
                    dpos.setNoOfthirdPlaces();
                }
                dpos.setNoraces(); //to calculate the no of races
                race.setDrivDetails(dpos.getDname(), String.valueOf(driverpos)); // calling the set method in race.java class
            }
        } catch (ParseException ignored) {}
    }
    //=====================valid start====================================
    public static Integer intValidInputs(String intval) { // validate the inputs method for integers
        while (true) {
            System.out.print(intval);
            String unchecked1 = input.next();
            try {
                //try to convert user input to integer
                int checkInt = Integer.parseInt(unchecked1);
                //is user input checking positive number or not
                if (checkInt < 0) {
                    System.out.println("\nValid only positive numbers!\n");
                } else
                    return checkInt;
            } catch (Exception e) {
                System.out.println("\ninvalid Input integer required!\n");
            }
        }
    }

    public static String strValidInputs(String StrVal2) { // validate the inputs method for strings
        //this is string pattern wants to get from user
        String regX = "^[A-a-zZ\\s]+$";
        //given string pattern compile to default format
        Pattern pattern = Pattern.compile(regX, Pattern.CASE_INSENSITIVE);
        while (true) {
            System.out.print(StrVal2);
            String unchecked2 = input.next();
            //given user input matching to customize pattern
            Matcher matcher = pattern.matcher(unchecked2);
            //if given input matched condition is true
            if (matcher.find()) {
                return unchecked2;
            } else
                System.out.println("\nString not in proper type!\n");
        }
    }
    //=========================================valid end=========================
    @Override
    public void viewstatistics() { // view statistics method overided from ChampionshipManager interface
        String drivercom = strValidInputs("Enter the name to view statistics : ");
        for (Formular1Driver viewdst: drivers) {
            if (viewdst.getDname().equals(drivercom)) { // the input name
                System.out.println("Name: " + viewdst.getDname());
                System.out.println("Location: " + viewdst.getDlocation());
                System.out.println("Races participated: " + viewdst.getNoraces());
                System.out.println("Points earned: " + viewdst.getNopoints());
                System.out.println("Noof 1 places: " + viewdst.getNoOffirstplaces());
                System.out.println("Noof 2 places: " + viewdst.getNoOfsecondPlaces());
                System.out.println("Noof 3 places: " + viewdst.getNoOfthirdPlaces());
            }
        }
    }

    //Driver table
    public void viewtable() { //this is view table method overided from ChampionshipManager interface
        boolean exists = false;
        if (!exists) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                                             FORMULAR 1 RACING CAR CHAMPIONSHIP Table                                          ");
            System.out.println("==========================================================================================================================");
            System.out.println("");
            System.out.println("");

            String leftAlignment = "%-18s | %-8s | %-8s| %-17d | %-12d| %-13d | %-13d| %-13d |%n";

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-18s | %-8s | %-8s| %-8s | %-8s| %-8s | %-8s| %-8s\n", "Name", "Team", "Location", "Racesparticipated", "Pointsearned", "1st positions", "2nd positions", "3rd positions");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            Collections.sort(drivers, new PointsComparator()); // sort
            for (Formular1Driver viewtable: drivers) {
                System.out.printf(leftAlignment, viewtable.getDname(), viewtable.getDteam(), viewtable.getDlocation(), viewtable.getNoraces(), viewtable.getNopoints(), viewtable.getNoOffirstplaces(), viewtable.getNoOfsecondPlaces(), viewtable.getNoOfthirdPlaces());
            }
        } else {
            System.out.println("Record is not found");
        }
    }
    public void savefile() { //this is save to a txt file method overided from ChampionshipManager interface
        try {
            File file = new File("drivers.txt");
            file.createNewFile(); // create a new file
            FileOutputStream fout = new FileOutputStream(file); //append
            ObjectOutputStream obj = new ObjectOutputStream(fout);

            obj.writeObject(drivers);
            obj.close();
            fout.close();

            File file2 = new File("race.txt");
            file2.createNewFile(); // create a new file
            FileOutputStream fout2 = new FileOutputStream(file2);
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fout2);
            objectOutputStream1.writeObject(races);
            objectOutputStream1.close();
            fout2.close();

            System.out.println("**-----------Race details successfully saved!-----------**");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        } catch (IOException e) {
            System.out.println("Error Initializing Stream!");
        }
    }
    public void readfile() { //This is read file method overided from ChampionshipManager interface
        try {
            FileInputStream fin = new FileInputStream("drivers.txt");
            ObjectInputStream objin = new ObjectInputStream(fin);
            drivers = (ArrayList < Formular1Driver > ) objin.readObject();
            objin.close();
            fin.close();

            FileInputStream fin2 = new FileInputStream("race.txt");
            ObjectInputStream objin1 = new ObjectInputStream(fin2);
            races = (ArrayList < Race > ) objin1.readObject();
            objin1.close();
            fin2.close();

        } catch (FileNotFoundException ignored) {

        } catch (IOException e) {
            //System.out.println("Error Initializing Stream");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void exit() {
        System.exit(0);
    } //method to exit the application

}