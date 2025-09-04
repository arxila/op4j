# Functions: FnString

## 1. Overview

`FnString` is a *function hub class* containing many static methods returning functions that take a `String` object as input. It includes conversions to numbers, calendar, and escape functions among others.

## 2. Functions

| Function name         | Type                          | Params                        | Description |
|----------------------|-------------------------------|-------------------------------|-------------|
| asciify              | Function<String,String>        |                               | ASCIIfies a String by removing diacritics and performing transformations. Equivalent to asciify(AsciifyMode) with DEFAULT mode. |
| asciify              | Function<String,String>        | AsciifyMode mode              | ASCIIfies a String with transformations determined by AsciifyMode. |
| capitalize           | Function<String,String>        |                               | Converts the first letter of each word to upper case. |
| contains             | Function<String,Boolean>       | String regex                  | Checks if String contains a fragment matching the regex. |
| endsWith             | Function<String,Boolean>       | String suffix                 | Checks if String ends with the specified suffix. |
| eq                   | Function<Object,Boolean>       | String object                 | Performs equals operation with the specified object. |
| escapeCSV            | Function<String,String>        |                               | Escapes String for CSV column value. |
| escapeHTML           | Function<String,String>        |                               | Escapes String using HTML entities. |
| escapeJavaScript     | Function<String,String>        |                               | Escapes String using JavaScript String rules. |
| escapeXML            | Function<String,String>        |                               | Escapes String using XML entities. |
| extractAll           | Function<String,List<String>>  | String regex                  | Extracts all substrings matching the regex. |
| extractFirst         | Function<String,String>        | String regex                  | Extracts the first substring matching the regex. |
| extractLast          | Function<String,String>        | String regex                  | Extracts the last substring matching the regex. |
| fromHexadecimal      | Function<String,String>        | Charset charset               | Converts from Hexadecimal representation to String. |
| greaterOrEqTo        | Function<Object,Boolean>       | String object                 | Checks if target is greater or equal to specified object. |
| greaterThan          | Function<Object,Boolean>       | String object                 | Checks if target is greater than specified object. |
| isAlpha              | Function<String,Boolean>       |                               | Checks if String contains only unicode letters. |
| isAlphaSpace         | Function<String,Boolean>       |                               | Checks if String contains only unicode letters and spaces. |
| isBigDecimal         | Function<String,Boolean>       |                               | Checks if String can be converted to BigDecimal (default locale). |
| isBigDecimal         | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to BigDecimal in given Locale. |
| isBigDecimal         | Function<String,Boolean>       | String locale                 | Checks if String can be converted to BigDecimal in given Locale (String). |
| isBigDecimal         | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to BigDecimal with decimal point config. |
| isBigInteger         | Function<String,Boolean>       |                               | Checks if String can be converted to BigInteger (default locale). |
| isBigInteger         | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to BigInteger in given Locale. |
| isBigInteger         | Function<String,Boolean>       | String locale                 | Checks if String can be converted to BigInteger in given Locale (String). |
| isBigInteger         | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to BigInteger with decimal point config. |
| isBigInteger         | Function<String,Boolean>       | int radix                     | Checks if String can be converted to BigInteger in specified radix. |
| isBlank              | Function<String,Boolean>       |                               | Checks if String is blank (whitespace, empty, or null). |
| isByte               | Function<String,Boolean>       |                               | Checks if String can be converted to Byte (default locale). |
| isByte               | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to Byte in given Locale. |
| isByte               | Function<String,Boolean>       | String locale                 | Checks if String can be converted to Byte in given Locale (String). |
| isByte               | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to Byte with decimal point config. |
| isByte               | Function<String,Boolean>       | int radix                     | Checks if String can be converted to Byte in specified radix. |
| isCalendar           | Function<String,Boolean>       | String pattern                | Checks if String can be converted to Calendar with pattern. |
| isCalendar           | Function<String,Boolean>       | String pattern, Locale locale | Checks if String can be converted to Calendar with pattern and locale. |
| isCalendar           | Function<String,Boolean>       | String pattern, String locale | Checks if String can be converted to Calendar with pattern and locale (String). |
| isDouble             | Function<String,Boolean>       |                               | Checks if String can be converted to Double (default locale). |
| isDouble             | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to Double in given Locale. |
| isDouble             | Function<String,Boolean>       | String locale                 | Checks if String can be converted to Double in given Locale (String). |
| isDouble             | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to Double with decimal point config. |
| isEmpty              | Function<String,Boolean>       |                               | Checks if String is empty ("" or null). |
| isFloat              | Function<String,Boolean>       |                               | Checks if String can be converted to Float (default locale). |
| isFloat              | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to Float in given Locale. |
| isFloat              | Function<String,Boolean>       | String locale                 | Checks if String can be converted to Float in given Locale (String). |
| isFloat              | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to Float with decimal point config. |
| isInteger            | Function<String,Boolean>       |                               | Checks if String can be converted to Integer (default locale). |
| isInteger            | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to Integer in given Locale. |
| isInteger            | Function<String,Boolean>       | String locale                 | Checks if String can be converted to Integer in given Locale (String). |
| isInteger            | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to Integer with decimal point config. |
| isInteger            | Function<String,Boolean>       | int radix                     | Checks if String can be converted to Integer in specified radix. |
| isLong               | Function<String,Boolean>       |                               | Checks if String can be converted to Long (default locale). |
| isLong               | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to Long in given Locale. |
| isLong               | Function<String,Boolean>       | String locale                 | Checks if String can be converted to Long in given Locale (String). |
| isLong               | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to Long with decimal point config. |
| isLong               | Function<String,Boolean>       | int radix                     | Checks if String can be converted to Long in specified radix. |
| isNotNull            | Function<Object,Boolean>       |                               | Checks if target object is not null. |
| isNull               | Function<Object,Boolean>       |                               | Checks if target object is null. |
| isNumeric            | Function<String,Boolean>       |                               | Checks if String contains only unicode digits. |
| isNumericSpace       | Function<String,Boolean>       |                               | Checks if String contains only unicode digits and spaces. |
| isShort              | Function<String,Boolean>       |                               | Checks if String can be converted to Short (default locale). |
| isShort              | Function<String,Boolean>       | Locale locale                 | Checks if String can be converted to Short in given Locale. |
| isShort              | Function<String,Boolean>       | String locale                 | Checks if String can be converted to Short in given Locale (String). |
| isShort              | Function<String,Boolean>       | DecimalPoint decimalPoint     | Checks if String can be converted to Short with decimal point config. |
| isShort              | Function<String,Boolean>       | int radix                     | Checks if String can be converted to Short in specified radix. |
| join                 | Function<List<Object>,String>  |                               | Joins objects in list into a single String (no separator). |
| join                 | Function<List<Object>,String>  | String separator              | Joins objects in list into a single String using separator. |
| joinArray            | Function<Object[],String>      |                               | Joins objects in array into a single String (no separator). |
| joinArray            | Function<Object[],String>      | String separator              | Joins objects in array into a single String using separator. |
| lessOrEqTo           | Function<Object,Boolean>       | String object                 | Checks if target is less or equal to specified object. |
| lessThan             | Function<Object,Boolean>       | String object                 | Checks if target is less than specified object. |
| matchAndExtract      | Function<String,String>        | String regex, int group       | Matches String against regex and extracts group. |
| matchAndExtractAll   | Function<String,List<String>>  | String regex, int... groups   | Matches String against regex and extracts groups. |
| matches              | Function<String,Boolean>       | String regex                  | Checks if String matches regex. |
| notEq                | Function<Object,Boolean>       | String object                 | Performs inverse equals operation. |
| replaceAll           | Function<String,String>        | String regex, String replacement | Replaces all substrings matching regex with replacement. |
| replaceFirst         | Function<String,String>        | String regex, String replacement | Replaces first substring matching regex with replacement. |
| replaceLast          | Function<String,String>        | String regex, String replacement | Replaces last substring matching regex with replacement. |
| reverse              | Function<String,String>        |                               | Reverses the input String. |
| split                | Function<String,List<String>>  |                               | Splits String into list using whitespace. |
| split                | Function<String,List<String>>  | String separator              | Splits String into list using separator. |
| splitAsArray         | Function<String,String[]>      |                               | Splits String into array using whitespace. |
| splitAsArray         | Function<String,String[]>      | String separator              | Splits String into array using separator. |
| startsWith           | Function<String,Boolean>       | String prefix                 | Checks if String starts with prefix. |
| startsWith           | Function<String,Boolean>       | String prefix, int offset     | Checks if substring after offset starts with prefix. |
| strip                | Function<String,String>        |                               | Strips whitespace from both sides. |
| substring            | Function<String,String>        | int start                     | Returns substring from start position. |
| substring            | Function<String,String>        | int start, int end            | Returns substring from start to end position. |
| substringAfter       | Function<String,String>        | String separator              | Returns substring after first occurrence of separator. |
| substringAfterLast   | Function<String,String>        | String separator              | Returns substring after last occurrence of separator. |
| substringBefore      | Function<String,String>        | String separator              | Returns substring before first occurrence of separator. |
| substringBeforeLast  | Function<String,String>        | String separator              | Returns substring before last occurrence of separator. |
| substringBetween     | Function<String,String>        | String tag                    | Returns substring between tag and tag. |
| substringBetween     | Function<String,String>        | String open, String close     | Returns substring between open and close. |
| toBigDecimal         | Function<String,BigDecimal>    |                               | Converts String to BigDecimal (default config). |
| toBigDecimal         | Function<String,BigDecimal>    | Locale locale                 | Converts String to BigDecimal with locale. |
| toBigDecimal         | Function<String,BigDecimal>    | String locale                 | Converts String to BigDecimal with locale (String). |
| toBigDecimal         | Function<String,BigDecimal>    | DecimalPoint decimalPoint     | Converts String to BigDecimal with decimal point config. |
| toBigDecimal         | Function<String,BigDecimal>    | int scale, RoundingMode roundingMode | Converts String to BigDecimal with scale and rounding mode. |
| toBigDecimal         | Function<String,BigDecimal>    | int scale, RoundingMode roundingMode, Locale locale | Converts String to BigDecimal with scale, rounding mode, and locale. |
| toBigDecimal         | Function<String,BigDecimal>    | int scale, RoundingMode roundingMode, String locale | Converts String to BigDecimal with scale, rounding mode, and locale (String). |
| toBigDecimal         | Function<String,BigDecimal>    | int scale, RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to BigDecimal with scale, rounding mode, and decimal point config. |
| toBigInteger         | Function<String,BigInteger>    |                               | Converts String to BigInteger (default config). |
| toBigInteger         | Function<String,BigInteger>    | Locale locale                 | Converts String to BigInteger with locale. |
| toBigInteger         | Function<String,BigInteger>    | String locale                 | Converts String to BigInteger with locale (String). |
| toBigInteger         | Function<String,BigInteger>    | DecimalPoint decimalPoint     | Converts String to BigInteger with decimal point config. |
| toBigInteger         | Function<String,BigInteger>    | int radix                     | Converts String to BigInteger with radix. |
| toBigInteger         | Function<String,BigInteger>    | RoundingMode roundingMode     | Converts String to BigInteger with rounding mode. |
| toBigInteger         | Function<String,BigInteger>    | RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to BigInteger with rounding mode and decimal point config. |
| toBigInteger         | Function<String,BigInteger>    | RoundingMode roundingMode, Locale locale | Converts String to BigInteger with rounding mode and locale. |
| toBigInteger         | Function<String,BigInteger>    | RoundingMode roundingMode, String locale | Converts String to BigInteger with rounding mode and locale (String). |
| toBoolean            | Function<String,Boolean>       |                               | Converts String to Boolean (supports true/false, yes/no, on/off). |
| toByte               | Function<String,Byte>          |                               | Converts String to Byte (default config). |
| toByte               | Function<String,Byte>          | Locale locale                 | Converts String to Byte with locale. |
| toByte               | Function<String,Byte>          | String locale                 | Converts String to Byte with locale (String). |
| toByte               | Function<String,Byte>          | DecimalPoint decimalPoint     | Converts String to Byte with decimal point config. |
| toByte               | Function<String,Byte>          | int radix                     | Converts String to Byte with radix. |
| toByte               | Function<String,Byte>          | RoundingMode roundingMode     | Converts String to Byte with rounding mode. |
| toByte               | Function<String,Byte>          | RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to Byte with rounding mode and decimal point config. |
| toByte               | Function<String,Byte>          | RoundingMode roundingMode, Locale locale | Converts String to Byte with rounding mode and locale. |
| toByte               | Function<String,Byte>          | RoundingMode roundingMode, String locale | Converts String to Byte with rounding mode and locale (String). |
| toCalendar           | Function<String,Calendar>      | String pattern                | Converts String to Calendar with pattern. |
| toCalendar           | Function<String,Calendar>      | String pattern, Locale locale | Converts String to Calendar with pattern and locale. |
| toCalendar           | Function<String,Calendar>      | String pattern, String locale | Converts String to Calendar with pattern and locale (String). |
| toDate               | Function<String,Date>          | String pattern                | Converts String to Date with pattern. |
| toDate               | Function<String,Date>          | String pattern, Locale locale | Converts String to Date with pattern and locale. |
| toDate               | Function<String,Date>          | String pattern, String locale | Converts String to Date with pattern and locale (String). |
| toDouble             | Function<String,Double>        |                               | Converts String to Double (default config). |
| toDouble             | Function<String,Double>        | Locale locale                 | Converts String to Double with locale. |
| toDouble             | Function<String,Double>        | String locale                 | Converts String to Double with locale (String). |
| toDouble             | Function<String,Double>        | DecimalPoint decimalPoint     | Converts String to Double with decimal point config. |
| toDouble             | Function<String,Double>        | int scale, RoundingMode roundingMode | Converts String to Double with scale and rounding mode. |
| toDouble             | Function<String,Double>        | int scale, RoundingMode roundingMode, Locale locale | Converts String to Double with scale, rounding mode, and locale. |
| toDouble             | Function<String,Double>        | int scale, RoundingMode roundingMode, String locale | Converts String to Double with scale, rounding mode, and locale (String). |
| toDouble             | Function<String,Double>        | int scale, RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to Double with scale, rounding mode, and decimal point config. |
| toFloat              | Function<String,Float>         |                               | Converts String to Float (default config). |
| toFloat              | Function<String,Float>         | Locale locale                 | Converts String to Float with locale. |
| toFloat              | Function<String,Float>         | String locale                 | Converts String to Float with locale (String). |
| toFloat              | Function<String,Float>         | DecimalPoint decimalPoint     | Converts String to Float with decimal point config. |
| toFloat              | Function<String,Float>         | int scale, RoundingMode roundingMode | Converts String to Float with scale and rounding mode. |
| toFloat              | Function<String,Float>         | int scale, RoundingMode roundingMode, Locale locale | Converts String to Float with scale, rounding mode, and locale. |
| toFloat              | Function<String,Float>         | int scale, RoundingMode roundingMode, String locale | Converts String to Float with scale, rounding mode, and locale (String). |
| toFloat              | Function<String,Float>         | int scale, RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to Float with scale, rounding mode, and decimal point config. |
| toHexadecimal        | Function<String,String>        | Charset charset               | Converts String to Hexadecimal representation. |
| toInteger            | Function<String,Integer>       |                               | Converts String to Integer (default config). |
| toInteger            | Function<String,Integer>       | Locale locale                 | Converts String to Integer with locale. |
| toInteger            | Function<String,Integer>       | String locale                 | Converts String to Integer with locale (String). |
| toInteger            | Function<String,Integer>       | DecimalPoint decimalPoint     | Converts String to Integer with decimal point config. |
| toInteger            | Function<String,Integer>       | int radix                     | Converts String to Integer with radix. |
| toInteger            | Function<String,Integer>       | RoundingMode roundingMode     | Converts String to Integer with rounding mode. |
| toInteger            | Function<String,Integer>       | RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to Integer with rounding mode and decimal point config. |
| toInteger            | Function<String,Integer>       | RoundingMode roundingMode, Locale locale | Converts String to Integer with rounding mode and locale. |
| toInteger            | Function<String,Integer>       | RoundingMode roundingMode, String locale | Converts String to Integer with rounding mode and locale (String). |
| toLong               | Function<String,Long>          |                               | Converts String to Long (default config). |
| toLong               | Function<String,Long>          | Locale locale                 | Converts String to Long with locale. |
| toLong               | Function<String,Long>          | String locale                 | Converts String to Long with locale (String). |
| toLong               | Function<String,Long>          | DecimalPoint decimalPoint     | Converts String to Long with decimal point config. |
| toLong               | Function<String,Long>          | int radix                     | Converts String to Long with radix. |
| toLong               | Function<String,Long>          | RoundingMode roundingMode     | Converts String to Long with rounding mode. |
| toLong               | Function<String,Long>          | RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to Long with rounding mode and decimal point config. |
| toLong               | Function<String,Long>          | RoundingMode roundingMode, Locale locale | Converts String to Long with rounding mode and locale. |
| toLong               | Function<String,Long>          | RoundingMode roundingMode, String locale | Converts String to Long with rounding mode and locale (String). |
| toLowerCase          | Function<String,String>        |                               | Converts String to lower case. |
| toShort              | Function<String,Short>         |                               | Converts String to Short (default config). |
| toShort              | Function<String,Short>         | Locale locale                 | Converts String to Short with locale. |
| toShort              | Function<String,Short>         | String locale                 | Converts String to Short with locale (String). |
| toShort              | Function<String,Short>         | DecimalPoint decimalPoint     | Converts String to Short with decimal point config. |
| toShort              | Function<String,Short>         | int radix                     | Converts String to Short with radix. |
| toShort              | Function<String,Short>         | RoundingMode roundingMode     | Converts String to Short with rounding mode. |
| toShort              | Function<String,Short>         | RoundingMode roundingMode, DecimalPoint decimalPoint | Converts String to Short with rounding mode and decimal point config. |
| toShort              | Function<String,Short>         | RoundingMode roundingMode, Locale locale | Converts String to Short with rounding mode and locale. |
| toShort              | Function<String,Short>         | RoundingMode roundingMode, String locale | Converts String to Short with rounding mode and locale (String). |
| toUpperCase          | Function<String,String>        |                               | Converts String to upper case. |
| trim                 | Function<String,String>        |                               | Removes control characters from both ends. |
| unCapitalize         | Function<String,String>        |                               | Converts the first letter of each word to lowercase. |
| unescapeCSV          | Function<String,String>        |                               | Removes escaping from a CSV column String. |
| unescapeHTML         | Function<String,String>        |                               | Unescapes HTML entities to Unicode characters. |
| unescapeJavaScript   | Function<String,String>        |                               | Unescapes JavaScript literals in String. |
| unescapeXML          | Function<String,String>        |                               | Unescapes XML entities to Unicode characters. |

