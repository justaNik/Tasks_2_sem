package task_1;

public class Time {
    private int time;

    public Time(int time) {
        this.time = time;
    }

    public Time(String str) {
        this.time = transform(str);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private int transform(String str) {
        String[] val;
        val = str.split(":|-");
        //подумать на счет проверки
        int h = Integer.parseInt(val[0]);
        if (h < 0) {
            System.out.println("Недопустимое значение часов");
        }
        int m = Integer.parseInt(val[1]);
        if (m >= 60 || m < 0) {
            System.out.println("Недопустимое значение минут");
        }
        int s = Integer.parseInt(val[2]);
        if (s >= 60 || s < 0) {
            System.out.println("Недопустимое значение секунд");
        }

        return h * 3600 + m * 60 + s;
    }

    public Time addition(String str) { // сложение
        int t = getTime() + transform(str);
        return new Time(t);
    }

    public Time subsruction(String str) { // сложение
        int t = getTime() - transform(str);
        return new Time(t);
    }


    public Time comparison(Time valueOfTime1, Time valueOfTime2) { //сравнение
        int flag = 0;
        if (valueOfTime1.getTime() > valueOfTime2.getTime()) {
            flag = 1;
        }
        if (flag == 1) {
            return valueOfTime1;
        } else return valueOfTime2;
    }

    public int[] untransform() {
        int time = getTime();
        int h, m, s;
        h = time / 3600;
        time -= h * 3600;
        m = time / 60;
        time -= m * 60;
        s = time;
        int[] arr = new int[3];
        arr[0] = h;
        arr[1] = m;
        arr[2] = s;
        return arr;
    }

    public String format1() {
        int[] arr = untransform();
        int hour = arr[0];
        int min = arr[1];
        int sec = arr[2];
        return String.format("%d:%d:%d", hour, min, sec);
    }

    public String format2() {
        String strHour;
        String strMin;
        String strSec;
        int[] arr = untransform();
        int hour = arr[0];
        int min = arr[1];
        int sec = arr[2];

        if (hour % 10 == 1) {
            strHour = "час";
        } else if (hour % 10 > 1 && hour % 10 < 5) {
            strHour = "часа";
        } else {
            strHour = "часов";
        }

        if (min % 10 == 1) {
            strMin = "минута";
        } else if (min % 10 > 1 && min % 10 < 5) {
            strMin = "минуты";
        } else {
            strMin = "минут";
        }

        if (sec % 10 == 1) {
            strSec = "секунда";
        } else if (sec % 10 > 1 && sec % 10 < 5) {
            strSec = "секунды";
        } else {
            strSec = "секунд";
        }

        return String.format("%d %s %d %s %d %s", hour, strHour, min, strMin, sec, strSec);
    }
}
