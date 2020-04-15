package com.github.bhokumar.completable.future

import java.util.concurrent.CompletableFuture

class ApplicationCombine {
    static CompletableFuture<Integer> create(int number) {
        return CompletableFuture.supplyAsync({number})
    }

    static void main(String[] args) {
        create(2).thenCombine(create(3), {result1, result2 -> result1 + result2})
        .thenAccept({println it})
    }


}
