package pw.nullpointer.design.observer.custom;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public class Test {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.add(observer);
        subject.change();
    }
}
