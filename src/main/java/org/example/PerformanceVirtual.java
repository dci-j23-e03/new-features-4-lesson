package org.example;

import java.time.Duration;

public class PerformanceVirtual {

  public static void main(String[] args) {

    for (int i = 0; i < 2_000_000; i++) {
      Thread.ofVirtual().name("VT-", 1).start(() -> {
        try {
          Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });
    }
  }

}
