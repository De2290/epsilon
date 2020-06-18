package com.De2290.Epsilon;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Epsilon requester = new Epsilon("https://www.baeldung.com/java-asynchronous-programming");
        requester.get()
                .thenAccept(response -> System.out.println(response.getBody()))
                .get();

    }
}
