// Leetcode_56
// Merge Intervals

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<>();
        if(intervals.size() == 0) return result;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2){
                if(i1.start != i2.start)
                    return i1.start - i2.start;
                else
                    return i1.end - i2.end;
            }
        });
        
       
        Interval pre = null;
        for(Interval intv : intervals) {
            if(pre == null) {
                pre = intv;
                continue;
            }
            
            if(pre.end < intv.start) {
                result.add(pre);
                pre = intv;
            } else {
                pre = new Interval(pre.start, Math.max(pre.end, intv.end));
            }
        }
        
        result.add(pre);
        
        return result;
    }
}