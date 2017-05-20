package moepad.playground.singlestream;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SingleStream<T> {

    static <T> SingleStream<T> of(T t) {
        return new SingleStreamImpl<>(t);
    }

    SingleStreamIf<T> iff(Predicate<T> predicate);


    interface SingleStreamIf<T> {

        SingleStreamThen<T> then(Consumer<T> consumer);
    }

    interface SingleStreamThen<T> {

        SingleStream<T> eelse(Consumer<T> consumer);

    }
}
