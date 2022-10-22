class NumDaysFromDate {
    static boolean checkLeapYear (int year) {
        boolean result = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        return result;
    }
    
    static String showResult(int date, int month, int year, int myBD, int fromNumDaysFromDate) {
        String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayFromSun = 0;
        int findDay = fromNumDaysFromDate % 7;
        dayFromSun = dayName.length - findDay;
        String str = String.format("You were born on %s and have been born for %d days (2 Jan 2022). Your program says %s", dayName[myBD], fromNumDaysFromDate, dayName[dayFromSun]);

        return str;
    }

    static void numDaysFromDate (int date, int month, int year, int myBD) {
        int dayBornTil31Dec2021 = 0;
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        daysOfMonth[1] = checkLeapYear(year) ? 29 : 28;

        dayBornTil31Dec2021 += daysOfMonth[month-1] - date;
        
        for(int i = month; i < daysOfMonth.length; i++) {
            dayBornTil31Dec2021 += daysOfMonth[i];
        }


        for(int j = year + 1; j < 2022; j++) {
            dayBornTil31Dec2021 += checkLeapYear(j) ? 366 : 365;
        }

        int dayBornTil2Jan2022 = dayBornTil31Dec2021 + 2; // shift to Sunday Jan 02 2022
        String str = showResult(date, month, year, myBD, dayBornTil2Jan2022);
        System.out.println(str);
    }
    
    public static void main(String[] args) {
        numDaysFromDate(4, 11, 2002, 1);
    }
}
