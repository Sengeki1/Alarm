package poo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class AlarmSys implements Iterable<Alarm> {
    private List<Alarm> alarms = new ArrayList<>();

    public AlarmSys start(Alarm al) throws AlarmDup {
        for (Alarm existingAlarm : alarms) {
            if (existingAlarm.equalName(al)) {
                throw new AlarmDup(existingAlarm.toString());
            }
        }
        alarms.add(al);
        return this;
    }

    public void stop(Alarm al) {
        alarms.remove(al);
    }

    public void run() {
        int currentHour = getCurrentHour();
        Date currentDate = getCurrentDate();

        List<Alarm> triggeredAlarms = new ArrayList<>();

        for (Alarm al : alarms) {
            if (al.trigger(currentHour, currentDate, this)) {
                triggeredAlarms.add(al);
            }
        }

        for (Alarm al : triggeredAlarms) {
            System.out.println(currentDate + " " + currentHour + "h -> " + al);
            stop(al);
        }
    }

    private static int getCurrentHour() {
        Calendar calendar = new GregorianCalendar();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        return currentHour;
    }

    private static Date getCurrentDate() {
        Calendar calendar = new GregorianCalendar();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Os meses em Calendar são indexados a partir de zero
        int currentYear = calendar.get(Calendar.YEAR);
        Date currentDate = new Date(currentDay, currentMonth, currentYear);
        return currentDate;
    }

    @Override
    public Iterator<Alarm> iterator() {
        return alarms.iterator();
    }
}
