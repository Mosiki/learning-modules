package pw.nullpointer.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("接收到更新");
    }
}
