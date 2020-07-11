public static String getDateAfterToday(int years, int months, int days) {
    
    LocalDate date=LocalDate.now().plusYears(years).plusMonths(months).plusDays(days);
    
    return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
}
