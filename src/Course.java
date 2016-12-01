import java.util.Set;

/**
 * Created by curti_000 on 11/26/2016.
 */
public class Course {
   private String name;
   private int credits;
   private Set<Weekday> days;
   private Time startTime;
   private int duration;

    //constructor
    public Course(String n, int c, Set<Weekday> d, Time sT, int dur) {
        if (d == null || c > 5 || c < 1 || n == "" || n == null || !n.contains(" ") || (sT == null ) || dur <= 0)
            throw new IllegalArgumentException();

        name = n;
        credits = c;
        days = d;
        startTime = sT.clone();
        duration = dur;

    }

    //tests for course overlap
    public boolean conflictsWith(Course c) {
   for (Weekday d : c.days){
       if (days.contains(d)){
           if (contains(d, c.getStartTime()) || c.contains(d, getStartTime())){
               return true;
           }
       }
    }
    return false;
    }
    //checks if course is contained within a specific time slot
    public boolean contains(Weekday d, Time t) {
        if (days.contains(d)) {
            if (getStartTime().equals(t))
                return true;
            else if (getEndTime().equals(t))
                return false;
            else
                return getStartTime().compareTo(t) < 0 && getEndTime().compareTo(t) > 0;
        }
        else return false;
    }

    //getter for credits
    public int getCredits() {
        return credits;
    }

    //getter for name
    public String getName() {
        return name;
    }

    //getter for duration
    public int getDuration() {
        return duration;
    }

    //getter for startTime
    public Time getStartTime() {
        return startTime.clone();
    }

    //getter for end
    public Time getEndTime() {
        Time end = getStartTime().clone();
        end.shift(getDuration());
        return end;
    }

    //overrides equals definition
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (credits != course.credits) return false;
        if (duration != course.duration) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (days != null ? !days.equals(course.days) : course.days != null) return false;
        return startTime != null ? startTime.equals(course.startTime) : course.startTime == null;

    }

    //hashcode override
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + credits;
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }

    //toString override for converting input to string
    @Override
    public String toString() {
        return name + "," + credits + "," + days + "," + startTime + "," + duration;
    }
}

