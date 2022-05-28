import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IntervalsJava ij = new IntervalsJava();
        List<Interval> inputIntervals = Arrays.asList(
                new Interval(1,10),
                new Interval(1,4),
                new Interval(2,7),
                new Interval(5,8),
                new Interval(1,3),
                new Interval(7,8));

        ij.splitAndCount(inputIntervals).forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
