import org.junit.Assert;
import org.junit.Test;

/**
 * Created by curti_000 on 11/14/2016.
 */
public class WeekdayTest {
    @Test
    public void toStringTest(){
        Weekday monday = Weekday.MONDAY;
        Weekday tuesday = Weekday.TUESDAY;
        Weekday thurs = Weekday.THURSDAY;
        Assert.assertEquals("Monday", monday.toString());
        Assert.assertEquals(("Tuesday"), tuesday.toString());
        Assert.assertEquals(("Thursday"), thurs.toString());
    }

    @Test
    public void toShortNameTest(){
        Weekday monday = Weekday.MONDAY;
        Weekday thurs = Weekday.THURSDAY;
        Weekday fri = Weekday.FRIDAY;
        Weekday wednesday = Weekday.WEDNESDAY;

        Assert.assertEquals("M", monday.toShortName());
        Assert.assertEquals("R", thurs.toShortName());
        Assert.assertEquals("F", fri.toShortName());
        Assert.assertEquals("W", wednesday.toShortName());
    }

    @Test
    public void fromStringTest(){
        Weekday mon = Weekday.fromString("MoNdAy");
        Assert.assertEquals(Weekday.MONDAY, mon);
        Weekday thur = Weekday.fromString("R");
        Assert.assertEquals(Weekday.THURSDAY, thur);
        Weekday wednesday = Weekday.fromString("wedNESDAY");
        Assert.assertEquals(Weekday.WEDNESDAY, wednesday);

    }
}
