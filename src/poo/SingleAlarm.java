package poo;

public class SingleAlarm implements Alarm{
    private String name;
    private int hour;
    private Date date;
    public SingleAlarm(String name, Date date, int hour) {
        this.date = date;
        this.hour = hour;
        this.name = name;
    }

    @Override
    public boolean trigger(int hour, Date dt, AlarmSys as) {
        if (this.hour == hour && this.date.equals(dt)) {
            as.stop(this); // Remove o alarme do sistema
            return true;
        }
        return false;
    }

    @Override
    public boolean equalName(Alarm al) {
        if (al instanceof SingleAlarm) {
            SingleAlarm otherAlarm = (SingleAlarm) al;
            return this.name.equals(otherAlarm.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name + ":" + hour + "h" + dateToString(date) + "(" + date.getWeekDay() + ")";
    }

    private String dateToString(Date date) {
        int day = date.getDay();
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        return day + "-" + month + "-" + year;
    }
}
