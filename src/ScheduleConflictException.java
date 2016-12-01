/**
 * Created by curti_000 on 12/1/2016.
 */
public class ScheduleConflictException extends RuntimeException {
    private static final long serialVersionUID = 1L;
//initialize
    public ScheduleConflictException() {
        super();
    }

//throws an error message for two conflicting courses
    public ScheduleConflictException(Course course1, Course course2) {
        super(course1.getName() + " conflicts with " + course2.getName() + ".");
    }
}