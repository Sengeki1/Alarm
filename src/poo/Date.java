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

    public int getDay() {return day;}
    public int getMonth() {return month;}
    public int getYear() {return year;}

    public WeekDay getWeekDay(){
        int q, m, K, J, h;
        q = day;
        m = (month - 3 + 4800) % 4800;
        K = (year + m / 12) % 400;
        J = m % 12;
        h = (q + 13 * (J + 1) / 5 + K + K / 4 + 5) % 7;
        return WeekDay.values()[h];
    }
}
