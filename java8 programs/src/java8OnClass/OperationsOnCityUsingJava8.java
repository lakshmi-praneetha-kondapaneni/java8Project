package java8OnClass;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationsOnCityUsingJava8 {
    /* 1) Find list of cities whose temperature greater than 10 */
    void citiesTempGreaterThan10(List<City> cities)
    {
        List<String> citiesList=cities.stream().filter(city->city.getTemperature()>10)
                .map(city->city.getName())
                .collect(Collectors.toList());
        System.out.println(citiesList);
    }
    /* 2) Find cities whose temperature>10 as map with key being city name and value being temperatue */
    void citiesMaptempGreaterThan10(List<City> cities)
    {
        Map<String,Double> map=cities.stream()
                .filter(city -> city.getTemperature() > 10)
                .collect(Collectors.toMap(
                        City::getName,
                        City::getTemperature,
                        (key, value) -> key));
        System.out.println(map);
    }
    /* 3) Find city with max temperature */
    void cityWithMaximumTemp(List<City> cities)
    {
        String cityWithMaxTemp=cities.stream().reduce((city1, city2) -> city1.getTemperature()>city2.getTemperature()?city1:city2)
                .map(city->city.getName()).orElse(null);
        System.out.println(cityWithMaxTemp);
    }
    /* 4) find no of occurrence of each city */
    void countOfEachCity(List<City> cities)
    {
        Map<String, Long> eachCityCount=cities.stream().collect(Collectors.groupingBy(
                City::getName,Collectors.counting()));
        System.out.println(eachCityCount);
    }
}
