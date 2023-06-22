package poo;

import java.util.ArrayList;
import java.util.List;

public class AlarmSys {
    private List<Alarm> alarms;
    public AlarmSys() {
        alarms = new ArrayList<>();
    }
    public void start(Alarm al) throws AlarmDup{
        for (Alarm existingAlarm : alarms) {
            if (existingAlarm.equalName(al)){
                throw new AlarmDup();
            }
        }
    }
    public void stop(Alarm al) {

    }
    public void run() {
        for (Alarm al : alarms) {
            if (al.trigger(h, d, this))
                System.out.println(d + " " + h + "h -> " + al);
        }
    }
}
