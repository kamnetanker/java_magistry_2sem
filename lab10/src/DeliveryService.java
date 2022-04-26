public class DeliveryService implements  ISubscriber{
    @Override
    public void recieve(Object obj) {
        Integer newOrder = (Integer) obj;
        System.out.println("There is deliveryServiceSubscriber"+newOrder);
    }

    @Override
    public void subscribeTo(IPublisher publicator) {
        publicator.subscribe(this);
    }
}
