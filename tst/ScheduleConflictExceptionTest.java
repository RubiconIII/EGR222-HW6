import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by curti_000 on 12/2/2016.
 */
public class ScheduleConflictExceptionTest {
    @Test (expected = ScheduleConflictException.class)
    public void ScheduleConflictExceptionTest() {
        Schedule a = new Schedule();
        Set<Weekday> daysOne = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Set<Weekday> daysTwo = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Time timeOne = new Time(5, 0, true);
        Time timeTwo = new Time(5, 0, true);
        Course courseOne = new Course("EGR 222", 3, daysOne, timeOne, 60);
        Course courseTwo = new Course("EGR 222", 3, daysTwo, timeTwo, 60);
        a.add(courseOne);
        a.add(courseTwo);
    }

}
