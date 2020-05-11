
 public static String lastDayOfMonth(int month, int year) {
        if (month < 0 || month > 11) {
            return "Wrong Month";
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        int lastDate = gc.getActualMaximum(Calendar.DATE);
        gc.set(Calendar.DATE, lastDate);

        return gc.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, java.util.Locale.ENGLISH);
    }
