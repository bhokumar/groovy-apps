package com.github.bhokumar.completable.future

import java.util.concurrent.CompletableFuture
import java.util.concurrent.ForkJoinPool

class Application {

    static int compute() {
        println "Compute ${Thread.currentThread()}"
        sleep(1000)
        2
    }
    static  CompletableFuture<Integer> create() {
        ForkJoinPool pool = new ForkJoinPool(10)
        return CompletableFuture.supplyAsync({compute()}, pool)
    }

    static void printIt(int item) {
        println "${item} ${Thread.currentThread()}"
    }
    static void main(String[] args) {
        println "In main method ${Thread.currentThread()}"

        CompletableFuture<Integer> future = create()

        sleep(100)
        future.thenAccept({data -> printIt(data)})

        sleep(1000)
        // Famous or popular functional interfaces
        // Supplier<T> T get() - factories
        // Predicate<T> boolean test() - filter
        // Function<T, R> R apply(T)  - map
        // Consumer<T> void accept(T) - forEach

        //println future.get()
        //future.thenAccept({e -> println e})

        println "Here"

    }
}
