package poo;

public class AlarmSys {
    public void start(Alarm al) {

    }
    public void stop(Alarm al) {

    }
    public void run() {
        //...
        for( Alarm al: alarms)
            if (al.trigger(h, d, this))
                System.out.println(d+" "+h+"h -> "+al);
    }
}
