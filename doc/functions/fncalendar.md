# Functions: FnCalendar

## 1. Overview

[FnCalendar](http://www.op4j.org/apidocs/org/op4j/functions/FnCalendar.html) is a *function hub class* containing many static methods to work with Calendar objects. These static methods return functions that take a **Calendar** object as input or output (depending on the function). It includes conversions to String, to Calendar, and adding days to a Calendar, among others.

---

## 2. Functions

| Function name      | Type                                   | Params                                                                 | Description |
|--------------------|----------------------------------------|------------------------------------------------------------------------|-------------|
| **add**            | Function<Calendar,Calendar>            | int calendarField<br>int amount                                         | Adds a positive or negative amount to a Calendar field (e.g., Calendar.DAY_OF_MONTH) |
| **addDays**        | Function<Calendar,Calendar>            | int amount                                                             | Adds days to the Calendar (Calendar.DATE) |
| **addHours**       | Function<Calendar,Calendar>            | int amount                                                             | Adds hours to the Calendar (Calendar.HOUR) |
| **addMilliseconds**| Function<Calendar,Calendar>            | int amount                                                             | Adds milliseconds to the Calendar (Calendar.MILLISECOND) |
| **addMinutes**     | Function<Calendar,Calendar>            | int amount                                                             | Adds minutes to the Calendar (Calendar.MINUTE) |
| **addMonths**      | Function<Calendar,Calendar>            | int amount                                                             | Adds months to the Calendar (Calendar.MONTH) |
| **addWeeks**       | Function<Calendar,Calendar>            | int amount                                                             | Adds weeks to the Calendar (Calendar.WEEK_OF_YEAR) |
| **addYears**       | Function<Calendar,Calendar>            | int amount                                                             | Adds years to the Calendar (Calendar.YEAR) |
| **after**          | Function<Calendar,Boolean>             | Calendar calendar                                                      | Checks if the target Calendar is after the specified Calendar |
| **before**         | Function<Calendar,Boolean>             | Calendar calendar                                                      | Checks if the target Calendar is before the specified Calendar |
| **eq**             | Function<Object,Boolean>               | Calendar object                                                        | Checks if the target and specified Calendar are equal (equals method) |
| **fieldIntegerArrayToCalendar** | Function<Integer[], Calendar> |                                                                        | Converts Integer[] (year, month, day, etc.) to Calendar |
| **fieldIntegerListToCalendar**  | Function<List<Integer>, Calendar> |                                                                        | Converts List<Integer> (year, month, day, etc.) to Calendar |
| **fieldStringArrayToCalendar**  | Function<String[], Calendar>   |                                                                        | Converts String[] (year, month, day, etc.) to Calendar |
| **fieldStringListToCalendar**   | Function<List<String>, Calendar> |                                                                        | Converts List<String> (year, month, day, etc.) to Calendar |
| **isNotNull**      | Function<Object,Boolean>                |                                                                        | Checks if the target is not null |
| **isNull**         | Function<Object,Boolean>                |                                                                        | Checks if the target is null |
| **notEq**          | Function<Object,Boolean>                | Calendar object                                                        | Checks if the target and specified Calendar are NOT equal |
| **round**          | Function<Calendar,Calendar>             | int calendarField                                                      | Rounds the Calendar, setting the specified field as most significant |
| **set**            | Function<Calendar,Calendar>             | int calendarField<br>int value                                         | Sets a Calendar field to the specified value |
| **setDay**         | Function<Calendar,Calendar>             | int value                                                              | Sets the day property (Calendar.DATE) |
| **setHour**        | Function<Calendar,Calendar>             | int value                                                              | Sets the hour property (Calendar.HOUR) |
| **setMillisecond** | Function<Calendar,Calendar>             | int value                                                              | Sets the millisecond property (Calendar.MILLISECOND) |
| **setMinute**      | Function<Calendar,Calendar>             | int value                                                              | Sets the minute property (Calendar.MINUTE) |
| **setMonth**       | Function<Calendar,Calendar>             | int value                                                              | Sets the month property (Calendar.MONTH) |
| **setWeek**        | Function<Calendar,Calendar>             | int value                                                              | Sets the week property (Calendar.WEEK_OF_YEAR) |
| **setYear**        | Function<Calendar,Calendar>             | int value                                                              | Sets the year property (Calendar.YEAR) |
| **timeInMillisToCalendar** | Function<Long,Calendar>           |                                                                        | Converts Long (milliseconds) to Calendar |
| **timeInMillisToCalendar** | Function<Long,Calendar>           | int truncateField                                                      | Converts Long (milliseconds) to Calendar, truncating by field |
| **timestampToCalendar** | Function<Timestamp,Calendar>        |                                                                        | Converts java.sql.Timestamp to Calendar |
| **timestampToCalendar** | Function<Timestamp,Calendar>        | int truncateField                                                      | Converts java.sql.Timestamp to Calendar, truncating by field |
| **toStr**          | Function<Calendar,String>               | String pattern<br>String pattern + Locale locale<br>String pattern + String locale<br>DateStyle dateStyle + TimeStyle timeStyle<br>DateStyle dateStyle + TimeStyle timeStyle + Locale locale<br>DateStyle dateStyle + TimeStyle timeStyle + String locale | Converts Calendar to String using pattern or styles, with optional locale |
| **truncate**       | Function<Calendar,Calendar>             | int calendarField                                                      | Truncates the Calendar, setting the specified field as most significant |
