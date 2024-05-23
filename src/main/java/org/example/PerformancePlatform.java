package org.example;

import java.time.Duration;

public class PerformancePlatform {

  public static void main(String[] args) {

    for (int i = 0; i < 1_000_000; i++) {
      Thread.ofPlatform().name("PT-", 1).start(() -> {
        try {
          Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });
    }
  }

}
