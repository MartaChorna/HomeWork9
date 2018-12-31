package utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yevhen.Bilevych on 27.02.2018.
 */
public class TimeWatch {

    private long starts;

    private TimeWatch() {
        reset();
    }

    public static TimeWatch start() {
        return new TimeWatch();
    }

    public TimeWatch reset() {
        starts = System.nanoTime();
        return this;
    }

    public long time() {
        long ends = System.nanoTime();
        return ends - starts;
    }

    public long time(TimeUnit unit) {
        return unit.convert(time(), TimeUnit.NANOSECONDS);
    }

    public String toMinuteSeconds() {
        return String.format("%d min, %d sec", time(TimeUnit.MINUTES),
                time(TimeUnit.SECONDS) - time(TimeUnit.MINUTES));
    }
    public String toMillis() {
        return String.format("%d milliseconds", time(TimeUnit.MILLISECONDS));
    }
}
