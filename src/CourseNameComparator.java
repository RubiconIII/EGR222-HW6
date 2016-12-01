import java.util.Comparator;

/**
 * Created by curti_000 on 12/1/2016.
 */
public class CourseNameComparator implements Comparator<Course> {
//initialize
    public CourseNameComparator() {

    }
    //returns course placement in relation to other courses based on alphabetical order
    public int compare(Course course1, Course course2) {
        return course1.getName().compareTo(course2.getName());
    }

}
