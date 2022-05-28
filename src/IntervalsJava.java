import java.util.*;

public class IntervalsJava {
    Map<Interval, Integer> splitAndCount(List<Interval> intervals) {
        List<Interval> allSubIntervals = generateAllSubIntervals(intervals);
        Map<Interval, Integer> result = new HashMap<>();

        allSubIntervals.forEach(interval -> result.put(interval, count(intervals, interval)));

        result.forEach((k, v) -> System.out.println(k + " -> " + v));

        return result;
        //throw new IllegalArgumentException("should be implemented");
    }

    public int count(List<Interval> intervals, Interval interval){
        int cnt = 0;
        for(Interval cur : intervals){
            if(interval.a >= cur.a && interval.b <= cur.b){
                cnt++;
            }
        }

        //intervals.stream().reduce(new)

        return cnt;
    }

    public List<Interval> generateAllSubIntervals(List<Interval> intervals){
        int min = getMin(intervals);
        int max = getMax(intervals);

        List<Interval> result = new ArrayList<>();
        for(int i=min; i<=max; i++){
            for(int j=i+1; j<=max; j++){
                result.add(new Interval(i, j));
            }
        }

        return result;
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