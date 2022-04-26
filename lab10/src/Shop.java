/** Проект Shop содержит 3 класса:
 * Shop - взаимодействует с покупателем(CLI),
 * Warehouse - склад
 * Accounting - бухгалтерия
 * Из консоли можно купить мебель, посмотреть товары, посмотреть доход, завершить работу программы.
 */

/* TODO:
    1. Используя один из шаблонов проектирования, реорганизуйте код класса бухгалтерии таким образом,
 *  чтобы можно было создать только один экземпляр бухгалтерии;
 *  2. Добавьте в проект класс DeliveryService (Доставка), который также должен получать уведомления о покупках;
 *  3. Используя один из шаблонов проектирования, реорганизуйте код проекта так, чтобы между классами была слабая связь
 *  (возможно, данный шаблон нужно использовать дважды).
 *  4. Проверьте правильность расчета дохода, исправьте при необходимости.
 */

import java.util.*;
// observer publisher realisation
class Notifyer implements IPublisher{
    private ArrayList<ISubscriber> subs = new ArrayList<>();
    @Override
    public void publish(Object obj) {
        for(ISubscriber s : this.subs){
            s.recieve(obj);
        }
    }

    @Override
    public void subscribe(ISubscriber subs) {
        this.subs.add(subs);
    }

    @Override
    public void unsubscribe(ISubscriber un_subs) {
        this.subs.remove(un_subs);
    }
}

/**
 * Класс "Магазин" осуществляет продажу мебели и уведомляет бухгалтерию и склад о новой покупке
 */
public class Shop
{
    public static Notifyer notyfyer = new Notifyer();
    public static void main(String[] args)
    {
        System.out.println("Добро пожаловать в магазин мебели! В наличии столы, диваны, шкафы, кухни, кресла и многое другое!");
        System.out.println("Если Вы хотите совершить покупку, введите название мебели!");
        System.out.println("Для вывода в консоль текущей выручки введите \"income\",\" \"  и пароль администратора");
        System.out.println("Для просмотра количества товара на складе введите \"товары\"");
        System.out.println("Для завершения работы введите \"break\"");

        Accounting acc = Accounting.instantiateAccounting(0);
        acc.subscribeTo(notyfyer);
        DeliveryService ds = new DeliveryService();
        ds.subscribeTo(notyfyer);
        Warehouse wh = new Warehouse();
        String command_l;

        Map <String, Integer> goods_price_map = new HashMap<>(); //ценник
        goods_price_map.put("стол", 10000);
        goods_price_map.put("шкаф", 50000);
        goods_price_map.put("кресло", 7500);
        goods_price_map.put("кухня", 150000);
        goods_price_map.put("диван", 35000);
        goods_price_map.put("кровать", 25000);

        Scanner scanner = new Scanner(System.in);
        while ( !( command_l = scanner.nextLine() ).equals("break") )
        {
            if ( command_l.equals("товары") )
            {
                wh.printWarehouse();
            }
            else
            {
                if ( command_l.indexOf(" ") >= 0 )
                {
                    acc.getIncome(command_l.substring(command_l.indexOf(" ")+1));
                }
                else
                {
                    if ( wh.isGoodsAvailable(command_l) ) {
                        wh.update(command_l);
                        notyfyer.publish((Object)(Integer)goods_price_map.get(command_l) );
                    }
                    else
                    {
                        System.out.println( "Товара \"" + command_l + "\" нет на складе." );
                    }
                }
            }
        }
    }

}
