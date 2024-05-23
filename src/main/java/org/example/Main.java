package org.example;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {

    int numOfCores = 16;

    ThreadFactory factory = Thread.ofPlatform().name("vt-", 0).factory();
    try(ExecutorService executor = Executors.newThreadPerTaskExecutor(factory)) {
      IntStream.range(0, numOfCores + 1)
          .forEach(i -> executor.submit(() -> {
            Thread thread = Thread.currentThread();
            System.out.println("[" + thread + "]  VT number: " + i);
            try {
              Thread.sleep(Duration.ofSeconds(5));
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }));
    }
  }
}