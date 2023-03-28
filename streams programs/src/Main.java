import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    //public static <T> T;
    public static void main(String[] args) {

        /* 1.Find the first element of a Stream in Java */
        Stream<String> stream1
                = Stream.of("Geek_First", "Geek_2",
                "Geek_3", "Geek_4",
                "Geek_Last");
        String last_element=stream1.reduce((a,b)->b).orElse(null);
       System.out.println(last_element);
           }
}