package ru.vsu.cs.course1;
import java.util.ArrayList;

public class Apartament {
    private String discrictName;
    private Integer numberRooms;
    private Double totalSquare;
    private Double kitchenSquare;
    private Integer price;

    public Apartament(String _discrictName, Integer _numberRooms, Double _totalSquare, Double _kitchenSquare, Integer _price) {
        discrictName = _discrictName;
        numberRooms = _numberRooms;
        totalSquare = _totalSquare;
        kitchenSquare = _kitchenSquare;
        price = _price;
    }

    public String getDiscrictName() {
        return discrictName;
    }
    public Integer getNumberRooms() {
        return numberRooms;
    }
    public Double getTotalSquare() {
        return totalSquare;
    }
    public Double getKitchenSquare() {
        return kitchenSquare;
    }
    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return discrictName + " " + numberRooms + " " + totalSquare + " " + kitchenSquare + " " + price;
    }

    public static String[][] toStringArray(ArrayList<Apartament> apartaments){
        String str[][] = new String[apartaments.size()][5];
        for(int i = 0 ; i < apartaments.size(); i++){
            str[i][0] =  apartaments.get(i).discrictName;
            str[i][1] =  apartaments.get(i).numberRooms.toString();
            str[i][2] =  apartaments.get(i).totalSquare.toString();
            str[i][3] =  apartaments.get(i).kitchenSquare.toString();
            str[i][4] =  apartaments.get(i).price.toString();
        }
        return str;
    }

    public static ArrayList<Apartament> toList(String str[][]){
        ArrayList<Apartament> apartaments = new ArrayList<>();
        for(int i = 0 ; i < str.length; i++){
            Apartament apartament = new Apartament(
                    str[i][0],
                    Integer.valueOf(str[i][1]),
                    Double.valueOf(str[i][2]),
                    Double.valueOf(str[i][3]),
                    Integer.valueOf(str[i][4])
            );
            apartaments.add(apartament);
        }
        return apartaments;
    }





}
