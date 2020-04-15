package com.github.bhokumar.completable.future

import java.util.concurrent.CompletableFuture

class ApplicationWithPipeline {

    static void main(String[] args) {
        CompletableFuture<Integer> future =
                new CompletableFuture<>()

        future
        .thenApply({data -> data * 2})
        .thenApply({data -> data + 1})
        .thenAccept({data -> println data})

        println "Built the pipeline"

        //future.thenAccept({data -> println data})

        println "Prepared to print the data"

        sleep(1000)

        future.complete(2)

        sleep(1000)

    }
}
