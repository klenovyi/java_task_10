package ru.vsu.cs.course1;

import java.util.ArrayList;
import java.util.List;

public class DistrictAndPricePerSquareMeter {
    private String discrictName;
    private Double pricePerSquareMeter;

    public DistrictAndPricePerSquareMeter(String _discrictName, Double _pricePerSquareMeter) {
        discrictName = _discrictName;
        pricePerSquareMeter = _pricePerSquareMeter;
    }

    public String getDiscrictName() {
        return discrictName;
    }
    public Double getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public static String[][] toStringArray(List<DistrictAndPricePerSquareMeter> districtAndPricePerSquareMeters){
        String str[][] = new String[districtAndPricePerSquareMeters.size()][2];
        for(int i = 0 ; i < districtAndPricePerSquareMeters.size(); i++){
            str[i][0] =  districtAndPricePerSquareMeters.get(i).discrictName;
            str[i][1] =  districtAndPricePerSquareMeters.get(i).pricePerSquareMeter.toString();
        }
        return str;
    }

    public static ArrayList<DistrictAndPricePerSquareMeter> toList(String str[][]){
        ArrayList<DistrictAndPricePerSquareMeter> districtAndPricePerSquareMeters = new ArrayList<>();
        for(int i = 0 ; i < str.length; i++){
            DistrictAndPricePerSquareMeter districtAndPricePerSquareMeter = new DistrictAndPricePerSquareMeter(
                    str[i][0],
                    Double.valueOf(str[i][1])
            );
            districtAndPricePerSquareMeters.add(districtAndPricePerSquareMeter);
        }
        return districtAndPricePerSquareMeters;
    }


    @Override
    public String toString() {
        return discrictName + ": " + pricePerSquareMeter;
    }

}
