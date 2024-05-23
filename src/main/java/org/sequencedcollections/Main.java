package org.sequencedcollections;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(List.of(1,2, 3, 4, 5, 6, 7));

    var first = list.get(0);
    var first2 = list.stream().findFirst().get();

    var last = list.get(list.size() - 1);

    System.out.println(first + " " + first2 + " " + last);

    // methods from SequencedCollection
    first = list.getFirst();
    last = list.getLast();
    var reversed = list.reversed();

    System.out.println(first + " " + last);
    System.out.println(reversed);

    list.addFirst(10);
    System.out.println(list);
    list.removeFirst();
    list.removeFirst();
    System.out.println(list);
  }

}
