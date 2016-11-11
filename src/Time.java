/**
 * Created by curti_000 on 11/9/2016.
 */
public class Time {
    private int hour;
    private int minute;
    private boolean isPM;

    private static void checkFormat(String str) {
        if (str.length() != 8)
            throw new IllegalArgumentException("length has too be 8");
        try {
            Integer.parseInt(str.substring(0,2)); //Hours
            Integer.parseInt(str.substring(3,5)); //Minutes
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("These numbers are wrong");
        }
        if (str.charAt(2) != ':') {
            throw new IllegalArgumentException("requires colon between times");
        }
        if (str.charAt(5) != ' ') {
            throw new IllegalArgumentException("requires space between time and period");
        }
        String mStr = str.substring(6);
        if (!mStr.equals("PM") && !mStr.equals("AM")) {
            throw new IllegalArgumentException("Must be AM or PM");
        }
        }


    public Time(int hour, int minute, boolean isPM) {
        if (hour < 1 || hour > 12)
            throw new IllegalArgumentException("hour should be 1-12");

        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("minute should be 0-59");
        this.hour = hour;
        this.minute = minute;
        this.isPM = isPM;
    }

    public static Time fromString(String str) {
        checkFormat(str);
        int h = Integer.parseInt(str.substring(0, 2));
        int m = Integer.parseInt(str.substring(3, 5));
        String mStr = str.substring(6);
        boolean b = mStr.equals("PM");

        return new Time(h, m, b);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isPM() {
        return isPM;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Time other = (Time) obj;
            return hour == other.hour && minute == other.minute && isPM == other.isPM;
        }
        else
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (isPM ? 1 : 0);
        result = 31 * result + minute;
        result = 31 * result + hour;
        return result;
    }


    public void shift(int minutes) {
        if (minutes < 0)
            throw new IllegalArgumentException("minutes should not be negative");

        minute += minutes;
        int hoursToAdd = minute / 60 % 24;
        minute %= 60;

        if (hoursToAdd == 0) return;

        int adjustedHour = hour;
        if (adjustedHour == 12) adjustedHour = 0;
        adjustedHour += hoursToAdd;

        int numFlip = adjustedHour/12;

        if (numFlip%2 == 1)
            isPM = !isPM;

        hour += hoursToAdd;
        hour %= 12;
        if(hour ==0) hour =12;
    }

    public String toString () {
        String dayTime;

        if (isPM == true)
            dayTime = "PM";

        else
            dayTime = "AM";

        String hourString = String.format("%02d", hour);
        String minString = String.format("%02d", minute);
        return (hourString + ":" + minString + " " + dayTime);
    }
}
