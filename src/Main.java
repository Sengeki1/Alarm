import poo.*;

public class Main {
    public static void main(String[] args) {
        Alarm a1 = new SingleAlarm("POO", new Date(21,6,2019), 10);
        Alarm a2 = new DailyAlarm("Acordar", 7, WeekDay.WorkDays);
        AlarmSys as = new AlarmSys();
        try {
            as.start(a1).start(a2);
            as.run();
        } catch (AlarmDup e) {
            System.out.println(e.getMessage());
        }
    }
}