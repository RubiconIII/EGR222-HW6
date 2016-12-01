import java.util.Comparator;

/**
 * Created by curti_000 on 12/1/2016.
 */
public class CourseCreditComparator implements Comparator<Course> {
//initialize
    public CourseCreditComparator() {

    }
    //returns course placement in relation to other courses based on course credits
    public int compare(Course course1, Course course2) {
        if (course1.getCredits() != course2.getCredits()) {
            return course1.getCredits() - course2.getCredits();
        }

        return course1.getName().compareTo(course2.getName());
    }
}
