package com.github.bhokumar.completable.future

import java.util.concurrent.CompletableFuture

class ApplicationCompose {
    static CompletableFuture<Integer> create(int number) {
        return CompletableFuture.supplyAsync({number})
    }

    static CompletableFuture<Integer> inc(int number) {
        return CompletableFuture.supplyAsync({number + 1})
    }

    static void main(String[] args) {
        create(2)
        //.thenApply({inc(it)})
        .thenCompose({inc(it)})
        .thenAccept({println it})
    }
}
