package org.example;

public class OnePlatformThread {

  public static void main(String[] args) {

    // making sure that we will have only single os thread used, and always having something executed in it
    System.setProperty("jdk.virtualThreadScheduler.parallelism", "1");
    System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "1");
    System.setProperty("jdk.virtualThreadScheduler.minRunnable", "1");

    Thread v1 = Thread.ofVirtual().name("long-running-thread").start(
        () -> {
          var thread = Thread.currentThread();
          // infinite loop, shut down the app manually
          while (true) {
            try {
              Thread.sleep(100);
              System.out.println(thread + " executing it's log task...");
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
        }
    );

    Thread v2 = Thread.ofVirtual().name("small-entertainment-thread").start(
        () -> {
          // making sure this onw will start after long-running-thread
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println(Thread.currentThread() + " executing when 'long-running-thread' hit 'sleep' function");
        }
    );

    try {
      v1.join();
      v2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
