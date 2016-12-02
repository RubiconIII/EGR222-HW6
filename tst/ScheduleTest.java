import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.*;


// Created by curti_000 on 12/1/2016.

public class ScheduleTest {

        static Set<Weekday> toEnumSet(String days) {
            Set<Weekday> set = null;
            for (int i = 0; i < days.length(); i++) {
                if (set == null)
                    set = EnumSet.of(Weekday.fromString(days.charAt(i) + ""));
                else
                    set.add(Weekday.fromString(days.charAt(i) + ""));
            }
            return set;
        }

        private Schedule helper(String d1, String d2, String t1, String t2, int m1, int m2) throws
                ScheduleConflictException {
            Schedule s = new Schedule();


            Set<Weekday> days1 = toEnumSet(d1);
            Set<Weekday> days2 = toEnumSet(d2);

            Course c1 = new Course("EGR 182", 3, days1, Time.fromString(t1), m1);
            Course c2 = new Course("EGR 222", 3, days2, Time.fromString(t2), m2);
            s.add(c1);
            try {
                s.add(c2);
            }catch (ScheduleConflictException e){
            }

            return s;


        }

        @Test
        public void addTest() {
            Time ta = new Time(2, 00, true);
            Set<Weekday> d1 = EnumSet.of(Weekday.WEDNESDAY);
            Course ca = new Course("CHID 217", 1, d1, ta, 30);
            Schedule sa = new Schedule();
            sa.add(ca);
            Collection<Course> allC = sa.getAllCourses();
            Assert.assertTrue(allC.contains(ca));

            Time tb = new Time(9, 30, false);
            Set<Weekday> d2 = EnumSet.of(Weekday.MONDAY);
            Course cb = new Course("EGR 182", 3, d2, tb, 60);
            sa.add(cb);
            Assert.assertTrue(allC.contains(cb));
        }

        @Test
        public void cloneTest() throws ScheduleConflictException, CloneNotSupportedException {
            Time tt2 = new Time(12,0,true);
            Comparator<Course> comp = new CourseTimeComparator();
            Schedule s = helper("F", "F", "12:00 PM", "12:00 PM", 60, 60);
            Schedule s2 = s.clone();
            Course c1 = s.getCourse(Weekday.FRIDAY, tt2);
            Course c2 = s2.getCourse(Weekday.FRIDAY, tt2);
            Assert.assertEquals(0, comp.compare(c1,c2));
        }

        @Test
        public void removeTest() throws ScheduleConflictException {
            Time testTime2 = new Time(12,0,true);
            Schedule s = helper("T", "T", "12:00 PM", "12:00 PM", 60, 60);
            s.remove(Weekday.TUESDAY, testTime2);
            Assert.assertEquals(null,s.getCourse(Weekday.TUESDAY, testTime2));
        }
        @Test
        public void totalCreditsTest() throws ScheduleConflictException{
            Schedule s = helper("T", "T", "12:00 PM", "12:00 PM", 60, 60);
            Assert.assertEquals(3,s.totalCredits());
            Time testTime2 = new Time(12,0,true);
            Set<Weekday> days1 = toEnumSet("M");
            Course c1 = new Course("EGR 111", 3, days1 , testTime2, 60);
            s.add(c1);
            Assert.assertEquals(6,s.totalCredits());
        }

        @Test
        //Tests save and various comparators.
        public void saveTest()throws ScheduleConflictException{
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(bOut);
            Time testTime2 = new Time(10,0,true);
            Set<Weekday> days1 = toEnumSet("M");
            Schedule s = helper("T", "T", "12:00 PM", "12:00 PM", 60, 60);
            Course ca = new Course("GGR 122", 4, days1 , testTime2, 60);
            s.add(ca);
            Comparator<Course> comp = new CourseCreditComparator();
            s.save(ps, comp);
            String string = new String(bOut.toByteArray(), StandardCharsets.UTF_8);
            Scanner scanner = new Scanner(string);

            Assert.assertEquals("EGR 182,3,[Tuesday],12:00 PM,60", scanner.nextLine());

            Comparator<Course> comp2 = new CourseNameComparator();
            s.save(ps,comp2);

            Assert.assertEquals("GGR 122,4,[Monday],10:00 PM,60", scanner.nextLine());


        }

    }






