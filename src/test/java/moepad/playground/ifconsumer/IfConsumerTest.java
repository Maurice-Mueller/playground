package moepad.playground.ifconsumer;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class IfConsumerTest {

    @Test
    public void test() {
        BiFunction<Predicate<String>, Consumer<String>, Consumer<String>> curriedConsumer =
                (predicate, actualConsumer) ->
                            string -> {
                                if(predicate.test(string))
                                    actualConsumer.accept(string);
                    };
        Consumer<String> ifConsumer = curriedConsumer.apply(string -> string.equalsIgnoreCase("test"),
                string -> System.out.println("Hurray"));
        ifConsumer.accept("test");
    }
}
