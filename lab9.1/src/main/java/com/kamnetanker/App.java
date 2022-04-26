package com.kamnetanker;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

/**
 * Hello world!
 *
 */
class Fridge{
    private Integer id;
    private String name;
    private String manufacturer;
    private Double price;
    private String color;
    private Double customerMark;

    public Fridge(Integer id, String name, String manufacturer, Double price, String color, Double customerMark) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.color = color;
        this.customerMark = customerMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getCustomerMark() {
        return customerMark;
    }

    public void setCustomerMark(Double customerMark) {
        this.customerMark = customerMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fridge)) return false;
        Fridge fridge = (Fridge) o;
        return getId().equals(fridge.getId()) && getName().equals(fridge.getName()) && getManufacturer().equals(fridge.getManufacturer()) && getPrice().equals(fridge.getPrice()) && getColor().equals(fridge.getColor()) && getCustomerMark().equals(fridge.getCustomerMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getManufacturer(), getPrice(), getColor(), getCustomerMark());
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", customerMark=" + customerMark +
                '}';
    }


}
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Fridge> fridges = List.of(new Fridge(1, "DEXP RF-MN430NHE/S", "DEXP", 39999.0, "серебристый", 4.6),
                new Fridge(2, "DEXP RF-CD170NMA/W", "DEXP", 12999.0, "белый", 4.8),
                new Fridge(3, "LG GA-B459CLWL", "LG", 35999.0, "серебристый", 4.8),
                new Fridge(4, "INDESIT DFN 18", "INDESIT", 21649.0, "белый", 4.5),
                new Fridge(5, "LG GA-B509MLS", "LG", 42999.0, "серый", 4.8),
                new Fridge(6, "Samsung RB30J3000WW/WT", "Samsung", 28999.0, "белый", 4.4),
                new Fridge(7, "LG GA-B509MESL", "LG", 36999.0, "бежевый", 4.8),
                new Fridge(8, "BEKO RCNK310KC0W", "BEKO", 22999.0, "белый", 4.6),
                new Fridge(9, "Bosch KGV39XW22R", "Bosch", 28999.0, "белый", 4.7),
                new Fridge(10, "Samsung RB30J3000SA/WT", "Samsung", 29999.0, "серебристый", 4.4)
        );
        List<Fridge> fridges_sorted_name = fridges.stream()
                .sorted(comparing(Fridge::getName))
                .collect(Collectors.toList());
        System.out.println(fridges_sorted_name);

        List<Fridge> fridges_sorted_price = fridges.stream()
                .sorted(comparing(Fridge::getPrice))
                .collect(Collectors.toList());
        System.out.println(fridges_sorted_name);

        Fridge max_price_fridge = fridges.stream()
                .max(comparing(Fridge::getCustomerMark))
                .get();
        System.out.println(max_price_fridge);

        List<Fridge> fridges_price_between = fridges.stream()
                .filter(x -> x.getPrice()>20000 && x.getPrice()<30000)
                .collect(Collectors.toList());
        System.out.println(fridges_price_between);

        OptionalDouble userMarkAver = fridges.stream()
                .mapToDouble(x->x.getCustomerMark())
                .average();
        System.out.println(userMarkAver.orElse(-1.0));

        Long white_fridges_count = fridges.stream()
                .filter(x->x.getColor().equals("белый"))
                .count();
        System.out.println(white_fridges_count);

        Boolean is_every_fridge_4plus = fridges.stream()
                .anyMatch(x->x.getCustomerMark()<=4.0);
        System.out.println(is_every_fridge_4plus);

        Boolean is_exist_50k_plus = fridges.stream()
                .anyMatch(x->x.getPrice()>50000);
        System.out.println(is_exist_50k_plus);

        Fridge max_price = fridges.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Fridge::getPrice)))
                .get();
        System.out.println(max_price);

        Map<String, List<Fridge>> grouped_by_manufacturer = fridges.stream()
                .collect(groupingBy(Fridge::getManufacturer));
        System.out.println(grouped_by_manufacturer);

        Map<String, Optional<Fridge>> max_price_by_manufacturer = fridges.stream()
                .collect(Collectors.groupingBy(Fridge::getManufacturer, Collectors.maxBy(Comparator.comparing(Fridge::getPrice))));
        System.out.println(max_price_by_manufacturer);

        String s = fridges.stream()
                .filter(x->x.getColor().equals("серебристый"))
                .map(x->x.getName())
                .collect(joining(", ","Модели холодильников серебристого цвета: ","."));
        System.out.println(s);
    }
}
