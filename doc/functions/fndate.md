# Functions: FnDate

## 1. Overview

[FnDate](http://www.op4j.org/apidocs/org/op4j/functions/FnDate.html) is a *function hub class* containing many static methods to work with Date objects. These static methods return functions that take a **Date** object as input or output (depending on the function). It includes conversions to String, to Date, and adding days to a Date, among others.

---

## 2. Functions

| Function name      | Type                                   | Params                                                                 | Description |
|--------------------|----------------------------------------|------------------------------------------------------------------------|-------------|
| **add**            | Function<Date,Date>                    | int calendarField<br>int amount                                         | Adds a positive or negative amount to a Date field (e.g., Calendar.DAY_OF_MONTH) |
| **addDays**        | Function<Date,Date>                    | int amount                                                             | Adds days to the Date (Calendar.DATE) |
| **addHours**       | Function<Date,Date>                    | int amount                                                             | Adds hours to the Date (Calendar.HOUR) |
| **addMilliseconds**| Function<Date,Date>                    | int amount                                                             | Adds milliseconds to the Date (Calendar.MILLISECOND) |
| **addMinutes**     | Function<Date,Date>                    | int amount                                                             | Adds minutes to the Date (Calendar.MINUTES) |
| **addMonths**      | Function<Date,Date>                    | int amount                                                             | Adds months to the Date (Calendar.MONTH) |
| **addWeeks**       | Function<Date,Date>                    | int amount                                                             | Adds weeks to the Date (Calendar.WEEK) |
| **addYears**       | Function<Date,Date>                    | int amount                                                             | Adds years to the Date (Calendar.YEAR) |
| **after**          | Function<Date,Boolean>                 | Date date                                                              | Checks if the target Date is after the specified Date |
| **before**         | Function<Date,Boolean>                 | Date date                                                              | Checks if the target Date is before the specified Date |
| **eq**             | Function<Object,Boolean>               | Date object                                                            | Checks if the target and specified Date are equal (equals method) |
| **fieldIntegerArrayToDate** | Function<Integer[], Date>       |                                                                        | Converts Integer[] (year, month, day, etc.) to Date |
| **fieldIntegerListToDate**  | Function<List<Integer>, Date>   |                                                                        | Converts List<Integer> (year, month, day, etc.) to Date |
| **fieldStringArrayToDate**  | Function<String[], Date>        |                                                                        | Converts String[] (year, month, day, etc.) to Date |
| **fieldStringListToDate**   | Function<List<String>, Date>    |                                                                        | Converts List<String> (year, month, day, etc.) to Date |
| **isNotNull**      | Function<Object,Boolean>                |                                                                        | Checks if the target is not null |
| **isNull**         | Function<Object,Boolean>                |                                                                        | Checks if the target is null |
| **notEq**          | Function<Object,Boolean>                | Date object                                                            | Checks if the target and specified Date are NOT equal |
| **round**          | Function<Date,Date>                     | int calendarField                                                      | Rounds the Date, setting the specified field as most significant |
| **set**            | Function<Date,Date>                     | int calendarField<br>int value                                         | Sets a Date field to the specified value |
| **setDay**         | Function<Date,Date>                     | int value                                                              | Sets the day property (Calendar.DATE) |
| **setHour**        | Function<Date,Date>                     | int value                                                              | Sets the hour property (Calendar.HOUR) |
| **setMillisecond** | Function<Date,Date>                     | int value                                                              | Sets the millisecond property (Calendar.MILLISECOND) |
| **setMinute**      | Function<Date,Date>                     | int value                                                              | Sets the minute property (Calendar.MINUTE) |
| **setMonth**       | Function<Date,Date>                     | int value                                                              | Sets the month property (Calendar.MONTH) |
| **setWeek**        | Function<Date,Date>                     | int value                                                              | Sets the week property (Calendar.WEEK_OF_YEAR) |
| **setYear**        | Function<Date,Date>                     | int value                                                              | Sets the year property (Calendar.YEAR) |
| **timeInMillisToDate** | Function<Long,Date>                  |                                                                        | Converts Long (milliseconds) to Date |
| **timeInMillisToDate** | Function<Long,Date>                  | int truncateField                                                      | Converts Long (milliseconds) to Date, truncating by field |
| **timestampToDate** | Function<Timestamp,Date>               |                                                                        | Converts java.sql.Timestamp to Date |
| **timestampToDate** | Function<Timestamp,Date>               | int truncateField                                                      | Converts java.sql.Timestamp to Date, truncating by field |
| **toCalendar**     | Function<Date,Calendar>                 |                                                                        | Converts Date to Calendar |
| **toCalendar**     | Function<Date,Calendar>                 | int truncateField                                                      | Converts Date to Calendar, truncating by field |
| **toStr**          | Function<Date,String>                   | String pattern<br>String pattern + Locale locale<br>String pattern + String locale<br>DateStyle dateStyle + TimeStyle timeStyle<br>DateStyle dateStyle + TimeStyle timeStyle + Locale locale<br>DateStyle dateStyle + TimeStyle timeStyle + String locale | Converts Date to String using pattern or styles, with optional locale |
| **truncate**       | Function<Date,Date>                     | int calendarField                                                      | Truncates the Date, setting the specified field as most significant |
