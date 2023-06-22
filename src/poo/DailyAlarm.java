package poo;

import java.util.HashSet;
import java.util.Set;
public class DailyAlarm implements Alarm{
    private String name;
    private int hour;
    private Set<WeekDay> weekDays;

    public DailyAlarm(String name, int hour, WeekDay[] wds) {
        this.name = name;
        this.hour = hour;
        this.weekDays = new HashSet<>();
        for (WeekDay day : wds) {
            this.weekDays.add(day);
        }
    }

    @Override
    public boolean trigger(int hour, Date dt, AlarmSys as) {
        if (this.hour == hour && weekDays.contains(dt.getWeekDay())) {
            as.stop(this); //Remove o alarme do sistema
            return true;
        }
        return false;
    }

    @Override
    public boolean equalName(Alarm al) {
        if (al instanceof DailyAlarm) {
            DailyAlarm otherAlarm = (DailyAlarm) al;
            return this.name.equals(otherAlarm.name);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":").append(hour).append("h{");
        for (WeekDay day: weekDays) {
            sb.append(day).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
