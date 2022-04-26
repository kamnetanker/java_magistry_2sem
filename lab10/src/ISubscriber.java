public interface ISubscriber {
    void recieve(Object obj);
    void subscribeTo(IPublisher publicator);
}
