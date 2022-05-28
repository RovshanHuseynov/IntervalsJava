import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntervalsJava {
    Map<Interval, Integer> splitAndCount(List<Interval> intervals) {

        intervals.forEach((interval) -> System.out.println(interval.toString()));
        Map<Interval, Integer> result = new HashMap<>();
        return result;
        //throw new IllegalArgumentException("should be implemented");
    }
}


class Interval {
    final int a;
    final int b;

    public Interval(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString(){
        return this.a + " -- " + this.b;
    }
}