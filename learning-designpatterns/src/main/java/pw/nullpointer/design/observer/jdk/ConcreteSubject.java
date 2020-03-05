package pw.nullpointer.design.observer.jdk;

import java.util.Observable;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public class ConcreteSubject extends Observable {

    public void change() {
        setChanged();
        this.notifyObservers();
    }
}
