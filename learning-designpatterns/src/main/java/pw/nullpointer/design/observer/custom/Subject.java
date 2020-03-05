package pw.nullpointer.design.observer.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
