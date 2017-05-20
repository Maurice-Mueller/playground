package moepad.playground.singlestream;

import java.util.function.Consumer;
import java.util.function.Predicate;

public final class SingleStreamImpl<T> implements SingleStream<T> {

    private final T object;

    SingleStreamImpl(final T object) {
        this.object = object;
    }

    @Override
    public SingleStreamIf<T> iff(final Predicate<T> predicate) {
        return new SingleStreamIfImpl<>(predicate.test(object), object);
    }

    class SingleStreamIfImpl<T> implements SingleStreamIf<T> {

        private final boolean executeConsumer;
        private final T object;

        SingleStreamIfImpl(final boolean conditionWasTrue, final T object) {
            this.executeConsumer = conditionWasTrue;
            this.object = object;
        }

        @Override
        public SingleStreamThen<T> then(final Consumer<T> consumer) {
            if(executeConsumer)
                consumer.accept(object);
            return new SingleStreamThenImpl<>(!executeConsumer, object);
        }
    }

    class SingleStreamThenImpl<T> implements SingleStreamThen<T> {

        private final T object;
        private final boolean executeConsumer;

        SingleStreamThenImpl(final boolean executeConsumer, final T object) {
            this.executeConsumer = executeConsumer;
            this.object = object;
        }

        @Override
        public SingleStream<T> eelse(final Consumer<T> consumer) {
            if(executeConsumer)
                consumer.accept(object);
            return new SingleStreamImpl<>(object);
        }
    }
}
