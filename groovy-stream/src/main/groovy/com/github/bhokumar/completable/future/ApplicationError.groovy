package com.github.bhokumar.completable.future

import java.util.concurrent.CompletableFuture

class ApplicationError {
    static int  compute() {
        throw new RuntimeException('Something went wrong')
    }

    static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync({compute()})
    }

    static handleException(Throwable throwable) {
        println "handleException method ${throwable}"
        100
    }

    static handleException2(Throwable throwable) {
        println "handleException2 method ${throwable}"
        throw  new RuntimeException('Handle2 exception')
    }


    static void main(String[] args) {
        create()
        .thenApply({it*2})
        .exceptionally({handleException2(it)})
        .thenAccept({println it})
        .exceptionally({handleException(it)})
        .thenAccept({println it})

        sleep(100)
    }
}
