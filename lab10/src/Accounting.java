/**
 * Класс "Бухгалтерия"
 */
public class Accounting implements ISubscriber{
    // Singleton for unique instantiation of accounting
    private static boolean initialised = false;

    private Accounting(int income) {
        this.income = income;
    }

    public static Accounting instantiateAccounting(int income){
        return ( Accounting.initialised && ( Accounting.initialised=true ) )? null : new Accounting(income);
    }
    // end of singleton
    // Observer realisation, subscriber
    @Override
    public void recieve(Object obj){
        Integer newOrder = (Integer)obj;
        income += newOrder;
    }
    @Override
    public void subscribeTo(IPublisher publicator){
        publicator.subscribe(this);
    }
    // end of observer realisation
    private int income = 0;
    private final String PASSWORD = "admin";

    /**
     * Метод распечатывает доход по паролю
     * @param psw - пароль
     */
    public void getIncome(String psw)
    {
        if ( psw.equals(PASSWORD) )
        {
            System.out.println("Your income is " + income);
        }
        else
        {
            System.out.println("Неверный пароль");
        }
    }

    /**
     * Метод считает общий доход
     * @param newOrder - сумма нового заказа
     */
    public void update(int newOrder)
    {
        income += newOrder;
    }


}
