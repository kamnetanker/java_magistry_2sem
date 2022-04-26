public interface IPublisher {
    void publish(Object obj);
    void subscribe(ISubscriber subs);
    void unsubscribe(ISubscriber un_subs);
}
