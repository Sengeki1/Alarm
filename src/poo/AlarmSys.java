package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class AlarmSys implements Iterable<Alarm>{
    private List<Alarm> alarms = new ArrayList<>();
    public void start(Alarm al) throws AlarmDup{
        for (Alarm existingAlarm : alarms) {
            if (existingAlarm.equalName(al)){
                throw new AlarmDup();
            }
        }
        alarms.add(al);
    }
    public void stop(Alarm al) {
        alarms.remove(al);
    }
    public void run(int h, Date dt) {
        for (Alarm al : alarms) {
            if (al.trigger(h, dt, this))
                System.out.println(dt + " " + h + "h -> " + al);
        }
    }
    @Override
    public Iterator<Alarm> iterator() {
        return alarms.iterator();
    }
}
