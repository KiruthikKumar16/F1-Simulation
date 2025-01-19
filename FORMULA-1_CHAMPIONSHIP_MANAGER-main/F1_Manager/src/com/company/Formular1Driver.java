package com.company;


public class Formular1Driver extends Driver { 

    public Formular1Driver(String name, String location, String dteam, int noraces) {  
        super(name, location, dteam,noraces);
    }
    public void cal(int noposition){
        if(noposition == 1){
             setNopoints(25);
        }else if(noposition == 2){
            setNopoints(18);
        }else if(noposition == 3){
            setNopoints(15);
        }else if(noposition == 4){
            setNopoints(12);
        }else if(noposition == 5){
            setNopoints(10);
        }else if(noposition == 6) {
            setNopoints(8);
        }else if(noposition == 7){
                setNopoints(6);
        }else if(noposition == 8){
                setNopoints(4);
        }else if(noposition == 9){
                setNopoints(2);
        }else if(noposition==10){
            setNopoints(1);
        }
    }
}



