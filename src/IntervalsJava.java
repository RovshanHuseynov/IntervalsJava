import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntervalsJava {
    Map<Interval, Integer> splitAndCount(List<Interval> intervals) {
        List<Interval> allSubIntervals = generateAllSubIntervals(intervals);
        Map<Interval, Integer> result = new HashMap<>();

        allSubIntervals.forEach(subInterval -> result.put(subInterval, countSubIntervals(intervals, subInterval)));

        return result;
    }

    public int countSubIntervals(List<Interval> intervals, Interval subInterval){
        return (int) intervals.stream().filter(cur -> subInterval.a >= cur.a && subInterval.b <= cur.b).count();
    }

    public List<Interval> generateAllSubIntervals(List<Interval> intervals){
        int min = getMin(intervals);
        int max = getMax(intervals);

        return IntStream.rangeClosed(min, max)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, max).mapToObj(j -> new Interval(i, j)))
                .collect(Collectors.toList());
    }

    public int getMin(List<Interval> intervals) {
        return intervals.stream().mapToInt(value -> value.a).min().orElseThrow(() -> new IllegalArgumentException("could not find minimum value"));
    }

    public int getMax(List<Interval> intervals){
        return intervals.stream().mapToInt(value -> value.b).max().orElseThrow(() -> new IllegalArgumentException("could not find maximum value"));
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