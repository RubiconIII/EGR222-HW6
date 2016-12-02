import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by curti_000 on 11/29/2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseInstructorTest.class,
        CourseTest.class,
        TimeInstructorTest.class,
        TimeTest.class,
        WeekdayInstructorTest.class,
        WeekdayTest.class,
        ScheduleTest.class,
        CourseNameComparatorTest.class,
        CourseCreditComparatorTest.class,
        CourseTimeComparatorTest.class
})
public class HW6TestSuite {
}
