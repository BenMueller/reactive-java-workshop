package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        Mono<List<Integer>> list = ReactiveSources.intNumbersFlux().collectList();
        Mono<Long> counted = ReactiveSources.intNumbersFlux().count();

        list.subscribe(number -> System.out.println(number));
        counted.subscribe(count -> System.out.println("Number of items: " + count));

        // Blocking
/*        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().toList();

        System.out.println("List is: " + numbers);
        System.out.println("Size: " + numbers.size());*/


        System.out.println("Press a key to end");
        System.in.read();
    }

}
