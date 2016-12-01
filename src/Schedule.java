import java.util.*;
import java.io.*;

/**
 * Created by curti_000 on 12/1/2016.
 */

    public class Schedule implements Cloneable {
        private List<Course> schedule;
        private int totalCredits;

        //initialize
        public Schedule() {
            this.schedule = new ArrayList<Course>();
            this.totalCredits = 0;
        }

        //adds course to schedule
        public void add(Course c) {
            for (Course c2 : this.schedule) {
                if (c2.conflictsWith(c)) {
                    throw new ScheduleConflictException(c, c2);
                }
            }
            this.schedule.add(c);
            this.totalCredits += c.getCredits();
        }
        //returns a copy of the object
        public Schedule clone() {

            try {
                Schedule copy = (Schedule) super.clone();
                copy.schedule = new ArrayList<Course>(schedule);

                return copy;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        //returns a course if one takes place during given day and time
        public Course getCourse(Weekday day, Time time) {
            for (Course c : this.schedule) {
                if (c.contains(day, time)) {
                    return c;
                }
            }

            return null;
        }

        public void remove(Weekday day, Time time) {
            for (int i = 0; i < this.schedule.size(); i++) {
                Course c = this.schedule.get(i);

                if (c.contains(day, time)) {
                    int credits = c.getCredits();
                    this.totalCredits -= credits;
                    this.schedule.remove(c);
                    break;
                }
            }
        }

        //outputs courses from schedule to given output file
        public void save(PrintStream ps, Comparator<Course> compare) {
            Collections.sort(this.schedule, compare);

            for (Course course : this.schedule) {
                ps.println(course);
            }

            ps.close();
        }

        //returns student's total credits for this semester
        public int totalCredits() {
            return this.totalCredits;
        }

        //returns string of schedule
        public String toString() {
            return this.schedule.toString();
        }
    }

