package struct;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Action {
    private Point p;
    private int cost;
    private long time;


    public Action(Point p, int cost) {
        this.p = new Point(p);
        this.cost = cost;
    }

    public Action(int cost) {
        this.cost = cost;
    }

    public Point getP() {
        return p;
    }

    public int getCost() {
        return cost;
    }

    public void setP(Point p) {
        this.p = new Point(p);
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String elapsedTime(){
        long tmp = time;
        long hours = TimeUnit.NANOSECONDS.toHours(tmp);
        tmp -= TimeUnit.HOURS.toNanos(hours);
        long minutes = TimeUnit.NANOSECONDS.toMinutes(tmp);
        tmp -= TimeUnit.MINUTES.toNanos(minutes);
        long seconds = TimeUnit.NANOSECONDS.toSeconds(tmp);
        tmp -= TimeUnit.SECONDS.toNanos(seconds);
        long millis = TimeUnit.NANOSECONDS.toMillis(tmp);
        tmp -= TimeUnit.MILLISECONDS.toNanos(millis);
        long micro = TimeUnit.NANOSECONDS.toMicros(tmp);
        tmp -= TimeUnit.MICROSECONDS.toNanos(micro);
        long nano = tmp;
        String elapsed = "";
        if(hours > 0)
            elapsed += hours + " h,";
        if(minutes > 0)
            elapsed += minutes + " min,";
        if(seconds > 0)
            elapsed += seconds + " s,";
        if(millis > 0)
            elapsed += millis + " ms,";
        if(micro > 0)
            elapsed += micro + " µs,";
        if(nano > 0)
            elapsed += nano + " ns";
        return elapsed;
    }
    @Override
    public String toString() {
        return "[" + p.x +","+ p.y+"] => "+cost;
    }
}
