package com.company;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula1Championshipmanager implements ChampionshipManager {
    public static Scanner input = new Scanner(System.in);
    private ArrayList < Formular1Driver > drivers = new ArrayList < > (); 
    private ArrayList < Race > races = new ArrayList < > (); 
    public ArrayList < Formular1Driver > getDrivers() {
        return drivers;
    } 
    public ArrayList < Race > getRaces() {
        return races;
    } 
    @Override
    public void createDriver() { 
        String dname = strValidInputs("Enter name of Driver :"+ "\n"); 
        if (driverValidate(dname)) {
            String dteam = strValidInputs("Enter team name : "+ "\n"); 
            if (teamValidate(dteam)) {
                String dlocation = strValidInputs("Enter location :"+ "\n");
                int noraces = intValidInputs("Enter races participated : " + "\n");
                Formular1Driver driver = new Formular1Driver(dname, dlocation, dteam, noraces);
                drivers.add(driver);
                System.out.println("\n new Driver " + dname + " Successfully Added.\n");
            } else {
                System.out.println("Team already exists");
            }
        } else {
            System.out.println("Name already exists");
        }
    }

    public boolean driverValidate(String name) {
        for (Formular1Driver l: drivers) {
            if (l.getDname().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean teamValidate(String team) {
        for (Formular1Driver s: drivers) {
            if (s.getDteam().equals(team)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void deleteDriver() {
        Formular1Driver a = null;
        System.out.println("Enter the name of the driver to delete:");
        String deldriver = input.next();
        System.out.println("------------------------------------------");
        boolean found = false;
        for (Formular1Driver i: drivers) {
            if (i.getDname().equals(deldriver)) {
                a = i;
                found = true;
                break;
            }
        }
        drivers.remove(a);
        if (!found) {
            System.out.println("Record is not found !!");
        } else {
            System.out.println("-----------Record is deleted sucessfully-----------");
            System.out.println("\n  Driver " + deldriver + " Sucessfully Deleted.\n");
        }
    }
    public void changeDriver() { 
        System.out.println("Enter Drivers team name : ");
        String tname = input.next();
        System.out.println("------------------------------------------");
        for (Formular1Driver cdriver: drivers) {
            if (cdriver.getDteam().equals(tname)) {
                System.out.println("Enter new driver : ");
                String dName = input.next();
                cdriver.setDname(dName);
                System.out.println("\n  Driver changed in ferarri team " + tname + " .\n");
            }
        }
    }
    @Override
    public void addRace() {
        try {
            System.out.println("Enter the date of Race (dd/MM/yyyy): "); 
            String ddate = input.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(ddate);;
            Race race = new Race(date, drivers.size());
            races.add(race);
            for (Formular1Driver dpos: drivers) {
                int driverpos = intValidInputs("Enter position of driver:" + dpos.getDname() + "\n"); 
                dpos.cal(driverpos);
                if (driverpos == 1) {
                    dpos.setNoOffirstplaces();
                } else if (driverpos == 2) {
                    dpos.setNoOfsecondPlaces();
                } else if (driverpos == 3) {
                    dpos.setNoOfthirdPlaces();
                }
                dpos.setNoraces();
                race.setDrivDetails(dpos.getDname(), String.valueOf(driverpos));
            }
        } catch (ParseException ignored) {}
    }
    public static Integer intValidInputs(String intval) {
        while (true) {
            System.out.print(intval);
            String unchecked1 = input.next();
            try {
                int checkInt = Integer.parseInt(unchecked1);
                if (checkInt < 0) {
                    System.out.println("\nValid only positive numbers!\n");
                } else
                    return checkInt;
            } catch (Exception e) {
                System.out.println("\ninvalid Input integer required!\n");
            }
        }
    }

    public static String strValidInputs(String StrVal2) { 
        String regX = "^[A-a-zZ\\s]+$";
        Pattern pattern = Pattern.compile(regX, Pattern.CASE_INSENSITIVE);
        while (true) {
            System.out.print(StrVal2);
            String unchecked2 = input.next();
            Matcher matcher = pattern.matcher(unchecked2);
            if (matcher.find()) {
                return unchecked2;
            } else
                System.out.println("\nString not in proper type!\n");
        }
    }
    @Override
    public void viewstatistics() {
        String drivercom = strValidInputs("Enter the name to view statistics : ");
        for (Formular1Driver viewdst: drivers) {
            if (viewdst.getDname().equals(drivercom)) {
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

    public void viewtable() { 
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
            Collections.sort(drivers, new PointsComparator()); 
            for (Formular1Driver viewtable: drivers) {
                System.out.printf(leftAlignment, viewtable.getDname(), viewtable.getDteam(), viewtable.getDlocation(), viewtable.getNoraces(), viewtable.getNopoints(), viewtable.getNoOffirstplaces(), viewtable.getNoOfsecondPlaces(), viewtable.getNoOfthirdPlaces());
            }
        } else {
            System.out.println("Record is not found");
        }
    }
    public void savefile() { 
        try {
            File file = new File("drivers.txt");
            file.createNewFile(); 
            FileOutputStream fout = new FileOutputStream(file); 
            ObjectOutputStream obj = new ObjectOutputStream(fout);

            obj.writeObject(drivers);
            obj.close();
            fout.close();

            File file2 = new File("race.txt");
            file2.createNewFile();
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
    public void readfile() { 
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
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void exit() {
        System.exit(0);
    }

}
