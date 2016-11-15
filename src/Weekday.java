/**
 * Created by curti_000 on 11/14/2016.
 */
public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    //converts to first cap string with rest lowercase
    @Override
    public String toString() {
        String orgString = super.toString();
        return orgString.substring(0, 1) + orgString.substring(1).toLowerCase();

    //converts to single letter short string
    }
    public String toShortName() {
        if (this == THURSDAY)
            return "R";

            return super.toString().substring(0, 1);
        }
    //reads string using enum
    public static Weekday fromString (String str){
        if (str == null || str.length() < 1)
            throw new IllegalArgumentException();

        if (str.equalsIgnoreCase("Monday") || str.equalsIgnoreCase("M")){
            return MONDAY;
        }
        else if (str.equalsIgnoreCase("Tuesday") || str.equalsIgnoreCase("T")){
            return TUESDAY;
        }
        else if (str.equalsIgnoreCase("Wednesday") || str.equalsIgnoreCase("W")){
            return WEDNESDAY;
        }
        else if (str.equalsIgnoreCase("Thursday") || str.equalsIgnoreCase("R")) {
            return THURSDAY;
        }
        else if (str.equalsIgnoreCase("Friday") || str.equalsIgnoreCase("F")) {
            return FRIDAY;
        }
        else {
            throw new IllegalArgumentException();
        }




        }
    }

