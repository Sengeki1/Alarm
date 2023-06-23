package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DailyAlarm extends BaseAlarm {
    private List<WeekDay> weekDays;

    public DailyAlarm(String name, int hour, WeekDay[] wds) {
        super(name, hour);
        weekDays = new ArrayList<>();
        for (WeekDay day : wds) {
            weekDays.add(day);
        }
        Collections.sort(weekDays);
    }

    @Override
    public boolean trigger(int hour, Date dt, AlarmSys as) {
        if (getHour() == hour && weekDays.contains(dt.getWeekDay())) {
            as.stop(this); // Remove o alarme do sistema
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + " {");
        for (WeekDay day : weekDays) {
            sb.append(day).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
