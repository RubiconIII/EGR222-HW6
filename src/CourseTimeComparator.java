import java.util.Comparator;

/**
 * Created by curti_000 on 12/1/2016.
 */
public class CourseTimeComparator implements Comparator<Course> {
//initialize
    public CourseTimeComparator() {

    }
    //returns course placement in relation to other courses based on time of course
    public int compare(Course course1, Course course2) {
        Time t1 = course1.getStartTime();
        Time t2 = course2.getStartTime();

        if (!t1.equals(t2))
            return t1.compareTo(t2);

        else if (course1.getDuration() != course2.getDuration())
            return course1.getDuration() - course2.getDuration();


        return course1.getName().compareTo(course2.getName());
    }
}