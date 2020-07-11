public static boolean isLeapYear(int year) {
    
    LocalDate date = LocalDate.of(year, 1, 1);
    return date.isLeapYear();

}
