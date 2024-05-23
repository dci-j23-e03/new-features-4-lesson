package org.stringtemplate;

import java.util.List;

public class StringTemplateExample {

  public static void main(String[] args) {

    var p1 = "Hello";
    var p2 = "World";

    var message = "We want to say: " + p1 + " " + p2; // concatenation
    System.out.println(message);

    var formattedMessage = "We want to say: %s %s".formatted(p1, p2); // String formatting
    var formattedMessage2 = String.format("We want to say: %s %s", p1, p2);
    System.out.println(formattedMessage);
    System.out.println(formattedMessage2);

    System.out.printf("We want to say: %s %s%n", p1, p2); // output formatting

    // string templates
    // no need to explicitly import STR
    var interpolatedMessage = STR."We want to say: \{p1} \{p2}";
    System.out.println(interpolatedMessage);

    // "more complex" example - advantage of the interpolation should be seen more clearly
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
    var numberedListString = """
        Here is some example of the text which is using numbered list:
        %s - this is just item %s
        %s - second item
        %s - third item
        %s - item number %s
        %s - fifth item
        %s - item %s
        %s - last item
        """.formatted(numbers.get(0), numbers.get(0), numbers.get(1), numbers.get(2),
        numbers.get(3), numbers.get(3), numbers.get(4), numbers.get(5), numbers.get(5), numbers.get(6));
    System.out.println(numberedListString);

    var numberedListInterpolated = STR."""
        Here is some example of the text which is using numbered list:
        \{numbers.getFirst()} - this is just item \{numbers.get(0)}
        \{numbers.get(1)} - second item
        \{numbers.get(2)} - third item
        \{numbers.get(3)} - item number \{numbers.get(3)}
        \{numbers.get(4)} - fifth item
        \{numbers.get(5)} - item \{numbers.get(5)}
        \{numbers.get(6)} - last item
        """;
    System.out.println(numberedListInterpolated);
  }

}
