/**
 * Created by curti_000 on 11/9/2016.
 */
public class Time {
    protected int hour;
    protected int minute;
    protected boolean PM;

    public Time(int hour, int minute, boolean PM){
        this.hour = hour;
        this.minute = minute;
        this.PM = PM;
    }

    public static Time fromString (String timeString) throws IllegalArgumentException {

        String[] splitParts = timeString.split(":");
       int hour = Integer.parseInt(splitParts[0]);

        String[] secondString = splitParts[1].split(" ");
        int minute = Integer.parseInt(secondString[0]);

        timeString = secondString[1];

        boolean PM;
        if (timeString.charAt(0) == 'a' || timeString.charAt(0) == 'A') {
            PM = false;
        }
        else if (timeString.charAt(0) == 'p' || timeString.charAt(0) == 'P') {
            PM = true;
        }
        return Time(hour, minute, PM);
    }

    public boolean equals (o) throws IllegalArgumentException {
        if (o == new Time(hour, minute, PM)){
        return true;
        }
        else return false;
    }


    public int getHour(){
    return hour;
    }

    public int getMinute(){
    return minute;
    }

    public boolean isPM(){
    return PM;
    }


    public void shift (int minutes) {
        if(minutes < 0) {throw new IllegalArgumentException();
        }

    }



    public String toString(){
        String dayTime;

        if (PM = true){
            dayTime = "PM";
        }

        else if (PM = false){
            dayTime = "AM";
        }
        System.out.println(hour + ":" + minute + "/ " + dayTime);
    }
}
