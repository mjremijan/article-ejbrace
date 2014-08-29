package org.ferris.ejbrace.web.util;

import java.util.Stack;
/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Stopwatch {

    public int getMaxTime() {
        long max = Integer.MIN_VALUE;
        for (Interval i : this.intervals) {
            max = Math.max(max, i.diff());
        }
        return (int)max;
    }

    public int getMinTime() {
        long min = Integer.MAX_VALUE;
        for (Interval i : this.intervals) {
            min = Math.min(min, i.diff());
        }
        return (int)min;
    }

    class Interval {
        long start, stop;

        Interval() {
            this.start = System.currentTimeMillis();
        }

        long diff() {
            return stop - start;
        }

        void stop() {
            this.stop = System.currentTimeMillis();
        }
    }

    private Stack<Interval> intervals;

    public Stopwatch() {
        this.intervals = new Stack<>();
    }

    public double getAverageTime() {
        return (double) getTotalTime() / size();
    }

    /**
     * @return
     */
    public long getTotalTime() {
        long totalTime = 0;
        for (Interval i : this.intervals) {
            totalTime += i.diff();
        }
        return totalTime;
    }

    public int size() {
        return this.intervals.size();
    }

    public void start() {
        this.intervals.push(new Interval());
    }

    public void stop() {
        this.intervals.peek().stop();
    }
}
