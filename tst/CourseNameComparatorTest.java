import org.junit.Assert;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by curti_000 on 12/2/2016.
 */
public class CourseNameComparatorTest {
    @Test
    public void compareTest() {
        CourseNameComparator test = new CourseNameComparator();
        Set<Weekday> daysOne = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Set<Weekday> daysTwo = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Time timeOne = new Time(5, 0, true);
        Time timeTwo = new Time(5, 0, true);
        Course courseOne = new Course("Mat 245", 3, daysOne, timeOne, 60);
        Course courseTwo = new Course("Mat 245", 3, daysTwo, timeTwo, 60);
        Course courseThree = new Course("Mat 135", 3, daysTwo, timeTwo, 60);
        Course courseFour = new Course("Mat 355", 3, daysTwo, timeTwo, 60);

        Assert.assertEquals(0, test.compare(courseOne, courseTwo));
        Assert.assertEquals(-1, test.compare(courseThree, courseTwo));
        Assert.assertEquals(1, test.compare(courseFour, courseTwo));
    }
}

