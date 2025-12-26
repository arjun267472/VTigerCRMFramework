package genericutility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtil {
    /**
     * generates random number till max bound
     * @return random number
     */
    public int randomNum(){
        Random num= new Random();
        return num.nextInt(5000);
    }

    /**
     * Retrieves name alone from the information page message.
     * @param msg
     * @return name of the creation
     */
    public String retrieveName(String msg){
        String msg1=msg.substring(msg.indexOf(']')+1).trim();
        String msg2=msg1.substring(0,msg1.indexOf('-')).trim();
        String msg3=msg2.replace(" ","");
        return msg3;
    }

    /**
     * generates current date and time in a given format
     * @return date and time
     */
    public String getDateTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * generates current date in a given format
     * @return date
     */
    public String getDate(){
        LocalDate date= LocalDate.now();
        DateTimeFormatter d=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return d.format(date);
    }
    /**
     * generates future date in a given format using Calendar class
     * @return future date
     */
    public String getFutureDate(int amount){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.format(date);
        Calendar calendar=simpleDateFormat.getCalendar();
        calendar.add(Calendar.DAY_OF_MONTH,amount);
        String expecteddate= simpleDateFormat.format(calendar.getTime());
        return expecteddate;
    }

    /**
     * generates future date in a given format with months using LocateDate&DateTimeFormatter classes
     * @param futuremon
     * @return future date
     */
    public String getFutureMonth(long futuremon){
        LocalDate date= LocalDate.now();
        LocalDate future=date.plusMonths(futuremon);
        DateTimeFormatter d= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return d.format(future);
    }

    /**
     * generates future date in a given format with days using LocateDate&DateTimeFormatter classes
     * @param futureday
     * @return date
     */
    public String getFutureDay(long futureday){
        LocalDate date= LocalDate.now();
        LocalDate future=date.plusDays(futureday);
        DateTimeFormatter d= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return d.format(future);
    }

}
