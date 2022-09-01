package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream()
                .forEach(number -> System.out.println("The Number is: " + number));

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("\nPrint numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(number -> System.out.println("The Number is: " + number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("\nPrint the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println("The Number is: " + number));


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("\nPrint the first number in intNumbersStream that's greater than 5.\nIf nothing is found, print -1");
        Integer firstNumber = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);

        System.out.println("The First number is:" + firstNumber);

        // Print first names of all users in userStream
        System.out.println("\nPrint first names of all users in userStream");
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(userFirstName -> System.out.println("FirstName is: " + userFirstName));


        // Print first names in userStream for users that have IDs from number stream
        System.out.println("\nPrint first names in userStream for users that have IDs from number stream");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> id == user.getId()))
                .map(user -> user.getFirstName())
                .forEach(userFirstName -> System.out.println(userFirstName));


        // Just to demonstrate Flatmap
        System.out.println("\nJust to demonstrate Flatmap");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(userFirstName -> System.out.println(userFirstName));


    }

}
