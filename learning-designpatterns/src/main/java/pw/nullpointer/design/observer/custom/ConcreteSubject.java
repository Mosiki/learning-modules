package pw.nullpointer.design.observer.custom;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public class ConcreteSubject extends Subject {

    public void change() {
        this.notifyObservers();
    }
}
