package moepad.playground.singlestream;

import org.junit.Test;

public final class SingleStreamTest {

    @Test
    public void test() {
        String stringForStream = "testing";
        SingleStream.of(stringForStream)
                .iff(string -> string.equalsIgnoreCase("testing"))
                .then(string -> System.out.println("String is testing"))
                .eelse(string -> System.out.println("String is not testing"));
    }
}
