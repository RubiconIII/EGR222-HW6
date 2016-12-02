import org.junit.Assert;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by curti_000 on 12/2/2016.
 */
public class CourseTimeComparatorTest {
    @Test
    public void compareTest() {
        CourseTimeComparator test = new CourseTimeComparator();
        Set<Weekday> daysOne = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Set<Weekday> daysTwo = EnumSet.of(Weekday.TUESDAY, Weekday.THURSDAY);
        Time timeOne = new Time(5, 0, true);
        Time timeTwo = new Time(5, 0, true);
        Time timeThree = new Time(6, 0, true);
        Time timeFour = new Time(8, 0, false);
        Course courseOne = new Course("EGR 102", 3, daysOne, timeOne, 60);
        Course courseTwo = new Course("PHY 203", 4, daysTwo, timeTwo, 60);
        Course courseThree = new Course("MAT 255", 2, daysOne, timeThree, 60);
        Course courseFour = new Course("EGR 182", 3, daysTwo, timeFour, 60);

        Assert.assertEquals(0, test.compare(courseOne, courseTwo));
        Assert.assertEquals(1, test.compare(courseThree, courseTwo));
        Assert.assertEquals(-1, test.compare(courseFour, courseTwo));
    }
}

