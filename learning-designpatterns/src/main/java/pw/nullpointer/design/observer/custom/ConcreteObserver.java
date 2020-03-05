package pw.nullpointer.design.observer.custom;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("接收到更新");
    }
}
