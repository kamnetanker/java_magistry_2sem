/**
 * Склад
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Класс "Склад"
 */
public class Warehouse {
    Map<String, Integer> quantity = new HashMap<>();

    public Warehouse()
    {
        quantity.put("стол", 10);
        quantity.put("шкаф", 5);
        quantity.put("кресло", 5);
        quantity.put("кухня", 2);
        quantity.put("диван", 3);
        quantity.put("кровать", 2);
    }
    public boolean isGoodsAvailable(String goods_name)
    { // доступен ли товар для покупки
        return quantity.containsKey(goods_name) && quantity.get(goods_name) > 0;
    }

    public void update( String goods_name )
    {                    //обрабаьывает запрос на покупку
        if( isGoodsAvailable(goods_name) )
        {
            quantity.put(goods_name, quantity.get(goods_name)-1);
            System.out.println("Спасибо за покупку!");
        }
        else
        {
            System.out.println("Товара \"" + goods_name + "\" нет на складе.");
        }
    }

    public void printWarehouse()
    {  //распечатывает список товаров на складе
        for (Map.Entry<String, Integer> pr: quantity.entrySet())
        {
            System.out.println(pr + " шт.");
        }
    }
}
