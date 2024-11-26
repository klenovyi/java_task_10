package ru.vsu.cs.course1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task {


    private static List<String> findUniqueDistrictNames(List<Apartament> apartaments){
        return apartaments.stream().map(apartament -> apartament.getDiscrictName()).distinct().collect(Collectors.toList());
    }

    static public List<DistrictAndPricePerSquareMeter> averageSquareInDistrict(List<Apartament> apartaments) {
        List<String> uniqueDistrictNames = findUniqueDistrictNames(apartaments);
        ArrayList<DistrictAndPricePerSquareMeter> districtAndPricePerSquareMeters = new ArrayList<>();
        for (String districtName : uniqueDistrictNames) {
            Double totalDistrictSquare = 0.0;
            Double totalDistrictPrice = 0.0;
            for (Apartament apartament : apartaments) {
                if (apartament.getDiscrictName().equals(districtName) ) {
                    totalDistrictSquare += apartament.getTotalSquare();
                    totalDistrictPrice += apartament.getPrice();
                }
            }
            Double pricePerSquareMeter = totalDistrictPrice / totalDistrictSquare;
            DistrictAndPricePerSquareMeter districtAndPricePerSquareMeter = new DistrictAndPricePerSquareMeter(districtName, pricePerSquareMeter);
            districtAndPricePerSquareMeters.add(districtAndPricePerSquareMeter);
        }
        return districtAndPricePerSquareMeters;
    }

}