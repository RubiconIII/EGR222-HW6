import org.junit.Assert;

import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by curti_000 on 12/2/2016.
 */
public class CourseCreditComparatorTest {
    @Test
    public void compareTest() {
        CourseCreditComparator test = new CourseCreditComparator();
        Set<Weekday> daysOne = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Set<Weekday> daysTwo = EnumSet.of(Weekday.TUESDAY, Weekday.THURSDAY);
        Time timeOne = new Time(5, 0, true);
        Time timeTwo = new Time(3, 0, true);
        Course courseOne = new Course("EGR 222", 3, daysOne, timeOne, 60);
        Course courseTwo = new Course("EGR 122", 4, daysTwo, timeTwo, 60);

        Assert.assertEquals(-1, test.compare(courseOne, courseTwo));
        Assert.assertEquals(0, test.compare(courseOne, courseOne));
        Assert.assertEquals(1, test.compare(courseTwo, courseOne));
    }
}
