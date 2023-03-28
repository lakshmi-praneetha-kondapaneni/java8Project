package java8OnClass;

import java.util.ArrayList;
import java.util.List;

public class CityMain {
    private static List<City> prepareTemperature()
    {
        List<City> cities = new ArrayList<>();
        cities.add(new City("New Delhi", 33.5));
        cities.add(new City("Mexico", 14));
        cities.add(new City("New York", 13));
        cities.add(new City("Dubai", 43));
        cities.add(new City("London", 15));
        cities.add(new City("Alaska", 1));
        cities.add(new City("Kolkata", 30));
        cities.add(new City("Sydney", 11));
        cities.add(new City("Mexico", 14));
        cities.add(new City("Dubai", 43));
        return cities;
    }

    public static void main(String[] args) {
        List<City> cities=prepareTemperature();
        OperationsOnCityUsingJava8 operations=new OperationsOnCityUsingJava8();
        operations.citiesTempGreaterThan10(cities);
        operations.citiesMaptempGreaterThan10(cities);
        operations.cityWithMaximumTemp(cities);
        operations.countOfEachCity(cities);
    }
}
