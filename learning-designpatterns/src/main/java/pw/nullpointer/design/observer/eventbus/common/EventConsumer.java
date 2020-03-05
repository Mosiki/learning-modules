package pw.nullpointer.design.observer.eventbus.common;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public interface EventConsumer<T> {
    void consume(T event);
}
