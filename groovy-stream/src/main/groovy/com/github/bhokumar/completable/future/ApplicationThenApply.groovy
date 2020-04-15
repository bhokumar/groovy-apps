package com.github.bhokumar.completable.future

import java.util.concurrent.CompletableFuture
import java.util.concurrent.ForkJoinPool

class ApplicationThenApply {

    static int compute() {
        println "Compute ${Thread.currentThread()}"
        //sleep(1000)
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
        create()
        .thenApply({data -> data *10})
        .thenAccept({println it})

        sleep(1000)

    }
}
