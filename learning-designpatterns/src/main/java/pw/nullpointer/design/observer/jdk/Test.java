package pw.nullpointer.design.observer.jdk;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public class Test {
    public static void main(String[] args) {
        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(concreteObserver);
        subject.change();
    }
}
