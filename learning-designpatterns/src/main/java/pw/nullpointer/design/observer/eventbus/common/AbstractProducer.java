package pw.nullpointer.design.observer.eventbus.common;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executors;

/**
 * @author WeJan
 * @since 2020-03-05
 */
public abstract class AbstractProducer<T> {
    public static final AsyncEventBus eventBus = new AsyncEventBus("_event_async_", Executors.newFixedThreadPool(4));

    public void registerAsyncEvent(EventConsumer consumer) {
        eventBus.register(consumer);
    }

    public abstract void post(T event);
}
