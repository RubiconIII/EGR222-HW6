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
        Assert.assertEquals("Monday", monday.toString());
        Assert.assertEquals(("Tuesday"), tuesday.toString());
    }

    @Test
    public void toShortNameTest(){
        Weekday monday = Weekday.MONDAY;
        Weekday thurs = Weekday.THURSDAY;
        Weekday fri = Weekday.FRIDAY;

        Assert.assertEquals("M", monday.toShortName());
        Assert.assertEquals("R", thurs.toShortName());
        Assert.assertEquals("F", fri.toShortName());
    }

    @Test
    public void fromStringTest(){
        Weekday mon = Weekday.fromString("MoNdAy");
        Assert.assertEquals(Weekday.MONDAY, mon);
        Weekday thur = Weekday.fromString("R");
        Assert.assertEquals(Weekday.THURSDAY, thur);

    }
}
