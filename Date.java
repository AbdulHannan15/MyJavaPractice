import java.util.Scanner;

public class Date {
    private int d, month, year;
    private final Scanner scanner = new Scanner(System.in);

    public Date() {
        month = 1;
        d = 1;
        year = 1;
    }

    public Date(int month, int day, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }
    public int getDay() {
        return d;
    }
    public boolean isLeapYear(int year) {
        return (((year % 100) == 0 && (year % 400) == 0) || (year % 4) == 0);
    }
    public void setDay(int day) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                while (day < 1 || day > 31) {
                    System.out.println("Invalid day .\nRe-Enter day : ");
                    day = scanner.nextInt();
                }
                this.d = day;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                while (day < 1 || day > 30) {
                    System.out.println("Invalid day .\nRe-Enter day : ");
                    day = scanner.nextInt();
                }
                this.d = day;
                break;
            case 2:
//                if (((year % 100) == 0 && (year % 400) == 0) || (year % 4) == 0) {
                if (isLeapYear(year)){
                    while (day < 1 || day > 29) {
                        System.out.println("Invalid day .\nRe-Enter day : ");
                        day = scanner.nextInt();
                    }
                } else {
                    while (day < 1 || day > 28) {
                        System.out.println("Invalid day .\nRe-Enter day : ");
                        day = scanner.nextInt();
                    }
                }
                this.d = day;

                break;
        }
    }
    public void newDateDetermine() {
        Date newDate = new Date();
        newDate.setMonth(month);
        newDate.setYear(year);
        newDate.setDay(d);
        System.out.print("Enter total days to define new date : ");
        int num = scanner.nextInt();
        System.out.println("Next date will be after " + num + " days :\n");
        while (num != 0) {
            int daysMonth = daysInMonth(newDate.month, newDate.getYear());
            if (num < daysMonth - newDate.d + 1) {
                newDate.d = newDate.d + num;
                num = 0;
            } else if (num >= daysMonth - newDate.d + 1) {
                num = num - (daysMonth + 1 - newDate.d);
                if (newDate.month == 12) {
                    newDate.month = 1;
                    newDate.year++;
                } else newDate.month++;
                newDate.d = 1;
            }
        }
        System.out.println(newDate.month + " : " + (newDate.d + num) + " : " + newDate.year);

    }
    public int daysInMonth(int month,int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31; // months with 31 days
            case 2 -> {
                if (isLeapYear(year)) {
                    yield 29; // for leap years, February has 29 days
                } else {
                    yield 28; // for non-leap years, February has 28 days
                }
            }
            case 4, 6, 9, 11 -> 30; // months with 30 days
            default -> throw new IllegalArgumentException("Invalid Month..."+scanner.next());
        };
    }

    public int getSpendDays() {
        int daysTotal = 0;
        int months = month;
        for (int i = 1; i < months; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    daysTotal += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    daysTotal += 30;
                    break;
                case 2:
                    if (((year % 100) == 0 && (year % 400) == 0) || (year % 4) == 0) {
                        daysTotal += 29;
                    } else {
                        daysTotal += 28;
                    }
                    break;
            }
        }
        return daysTotal + d;
    }
    public int remainingDays() {
        int remain = 0;
        for (int i = month; i < 13; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    remain += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    remain += 30;
                    break;
                case 2:
                    if (((year % 100) == 0 && (year % 400) == 0) || (year % 4) == 0) {
                        remain += 29;
                    } else {
                        remain += 28;
                    }
                    break;
            }
        }
        return remain - d;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month.\nRe-enter month");
        }
        else this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void showDate() {
        System.out.println(d + ":" + month + ":" + year);
    }

    public String toString() {
        return month + ":" + d + ":" + year + "\n";
    }

    public void makeCopy(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.d = date.d;
    }

    public Date getCopy() {
        Date otherDate = new Date();
        otherDate.year = this.year;
        otherDate.month = this.month;
        otherDate.d = this.d;
        return otherDate;
    }
    public boolean checkDatePresentInMonth(int date,int month,int year){
        switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    return date > 0 && date < 32;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    return date > 0 && date < 31;
                }
                case 2: {
                    if (isLeapYear(year)) return date > 0 && date < 30;
                    else return date > 0 && date < 29;
                }
                default:
                    return false;
            }
    }
}
