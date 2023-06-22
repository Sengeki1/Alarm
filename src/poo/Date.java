package poo;

public class Date {
    private final int day, month, year;
    public Date(int d, int m, int y) { day = d; month = m; year = y; };

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Date other = (Date)obj;
        return day == other.day && month ==other.month && year == other.year;
    }
    @Override public String toString() {
        return day+"-"+month+"-"+year+" ("+getWeekDay()+")";
    }
    public WeekDay getWeekDay() {

    }
}
