
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                                                                   
////                                                                                                                    ////
////   Developer: Shubhra Yadav                                                                                         ////
////                                                                                                                    ////
////                                                                                                                    ////
////                                                                                                                    ////
////                                                                                                                    ////
////                                                                                                                    ////
////   Date: 2/18/2018 7:42AM (PST)                                                                                     ////
////                 Editing comments and removing code not being used.                                                 ////
////                 Cleaning the program. Rearranging the methods.                                                     ////
////                                                                                                                    ////
////   Date: 1/9/2018, 1:14PM (PST)                                                                                     ////
////                                                                                                                    ////
////   Modification: To print a Calendar for any AD year. Input is N,year for which Calendar needs printing.            ////
////                 The two applications, printCalendarFuture2018.java and printCalendarPast2018,java, are             ////
////                 being put into this program called printCalendarADYear.java.                                       ////
////                                                                                                                    ////
////                 If the year input is less than 2018(Current Year), then the methods in                             ////
////                 printCalendarPast2018 are called to print a Calendar.                                              ////
////                 If the year input is equal to or greater than 2018(Current Year), then the methods in              ////
////                 printCalendarFuture2018 are called to print a Calendar.                                            ////
////                 Hence, the Calendar for any AD year can be printed by this program.                                ////
////                                                                                                                    ////
////                 Starting with printCalendarFuture2018.java and adding the printCalendarPast2018.java,              ////
////                 in the end. Then removing all the duplicate methods, and changing the 'main' method.               ////
////                                                                                                                    ////     
////                                                                                                                    ////    
////                 Modification Completed: 1/11/2018 2:09PM (PST)                                                     ////
////                                                                                                                    ////
////                                                                                                                    ////
////                                                                                                                    ////
////                                                                                                                    ////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                                                                                                    ////




import java.util.*;        // for Scanner


public class printCalendarADYear {
   public static void main(String[] args) {
      int numberOfYears = 0;
      int calendarYear = 0;
      boolean isInt;
      boolean isInRange;
      
 
                                    
      
      Scanner console = new Scanner(System.in);
      
      for (int i = 0; i < 2; i++)
      {
         isInt = false;                   /////// isInt is set to "false" inside the for loop, change made on 3/8/2017
         isInRange = false;               /////// isInRange is set to "false" inside the for loop, change made on 3/8/2017
        
        
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("Historians can find the 'day of the week' for any date in the AD years,");
         System.out.println("by printing the calendar of the year required.");
         System.out.println();
         System.out.println("For printing the Calendar of a year, give the year as input:"); 
         System.out.println("  (Here, N has to be greater than 0)");
                                
                                
         System.out.println();       


         
         
   

         
        ///////////////////////////////////////////////////////////////////// 
        /////////  Get a valid input, from the user,                /////////
        ///////// i.e. a digit greater than 0                       /////////
        /////////                                                   /////////
        ///////////////////////////////////////////////////////////////////// 
      
      
                
        while ((!isInt) || (!isInRange)) {
            
 
            isInt = console.hasNextInt();
          
         
            if (isInt) {            ///// input is a number
                int number = console.nextInt();
                if (number > 0) {   //// input is a valid positive number
                  isInRange = true;
                  calendarYear = number;
                } //// end if   
                else {     ///// input is not in the range
                  isInRange = false;
                  System.out.println("Enter a valid number, greater than 0: ");
                }      ///// end else
            }  //// end if
            else {               //// input is not a number
                String wrongInput = console.next();
                System.out.println("Enter a valid number, greater than 0: ");
            }      //// end else
            
            
         }      /// end While loop
         

      if (calendarYear < 2018) {                          //// print Calendar from past
         numberOfYears = 2018 - calendarYear;
         getYearForNYearsAgoInFormat(01, 01, "Monday", 2018, numberOfYears);
            
      } else {                                            //// print Calendar from future (or present year)
      
         numberOfYears = calendarYear - 2018;         /// number of years into the future that calendar needs to be printed
         getYearForNYearsInFuture(12, 31, "Sunday", 2017, numberOfYears);
      
      }            //// end else   
         
                  

               
      } // end FOR loop
      
      
      
      
   }    // end main
   
   
   
   

   
   
   
   
   
         ///////////  This method prints out the dates, for 1 year, which is  
         ///////////   numOfYears after the date and day given, in Calendar format.
   
   public static void getYearForNYearsInFuture(int month, int day, String whichDay, int year, int numOfYears) { 
      int numberOfDays = 0;
      int firstYear = year;
      int nextYear = year + 1;
      int startDay = getStartDay(whichDay);
      int dayOfWeek = startDay;
      int prevYear = year;
   
      
      
      ///////////  get the number of days, in the next year
      
      if (((nextYear)%4) == 0) {                ////////////// leap year
            numberOfDays =  366;       
      } else {                            ////////////// non leap year
            numberOfDays =  365;       
      }




      if (numOfYears > 0) {
   
         for (int i = 0; i < numOfYears; i++) {       
                     
         
            
            
            
         ///////////////// get dayOfWeek for 12/31 of the next year.         
            String startDate = getBeginningDay(month, day, prevYear, numberOfDays, dayOfWeek);
  
            dayOfWeek = stringToInt(startDate.substring(11,12));
      
      
            nextYear = nextYear + 1;
            prevYear = prevYear + 1;
            
             ///////////  get the number of days, in the next year
      
            if (((nextYear)%4) == 0) {                ////////////// leap year
               numberOfDays =  366;       
            } else {                            ////////////// non leap year
               numberOfDays =  365;       
            }
       
            
                
         } ////// end FOR loop
      
         
      } /////// end IF 
      
   
         
      getNextNDaysInFormat(month, day, dayOfWeek, prevYear, numberOfDays);
      
     
      }     /////////  end  getYearForNYearsInFuture
   
   
   
   
         /////////// This method prints out the date and day of the week 
   /////////// for numOfDays days after the date and day given, in format.
   
   public static void getNextNDaysInFormat(int month, int day, int startDay, int year, int numOfDays) { 
      int beginMonth = month;
      int beginDay = day + 1;

      
      int dayOfWeek = startDay + 1;


      String startDate = "" + month + " " + day + " " + year + " " + startDay;      
   
      int beginYear = year;      
      
           
      int nextMonth = beginMonth;
      int nextDay = beginDay;
      int nextYear = beginYear;
         
         
         
            
      for (int i = 1; i <= (numOfDays/7); i++) {
            
                     
            
         String nextDate = printSevenDaysInFormat(nextMonth, nextDay, dayOfWeek, nextYear);
      
   
         nextMonth = stringToInt(nextDate.substring(0,2));
         nextDay = stringToInt(nextDate.substring(3,5));
         nextYear = stringToInt(nextDate.substring(6,10));
      
      }    //// end for loop
      
      
      
      
      ///// Print the rest of the dates
      
      
     if ((numOfDays%7) > 0) {
                  
         for (int i = 1; i <= (numOfDays%7); i++) {
               
            String date = resetDay(nextMonth,nextDay, nextYear, dayOfWeek);   
         
            System.out.print(date.substring(3,5));
            
            nextMonth = stringToInt(date.substring(0,2));
            nextDay = stringToInt(date.substring(3,5));
            nextYear = stringToInt(date.substring(6,10));
            dayOfWeek = stringToInt(date.substring(11,12));
   
           if (dayOfWeek < 6) {                                         //////// it is not Saturday, print spaces
               
               System.out.print("  ");                            //////// print spaces in between days to format
            } else if (dayOfWeek == 6) {                                  ////////// it is Saturday, get to next line.
               
               System.out.println();
            }   /////// end if

            nextDay = nextDay + 1;
            
            dayOfWeek = dayOfWeek + 1;
         }  //// end for loop
      
      } ///// end If statement

         
      
      
      
      
   }  ///////////// end getNextNDaysInFormat 

   
   
   
  
   
   /////////// This method prints out the date and day of the week 
   /////////// for 7 days from the date and day given, in format.
   
   public static String printSevenDaysInFormat(int month, int day, int startDay, int year) { 
      
      int nextDay = day;
      
      String date = "" + month + " " + day + " " + year;
      String monthStr;
      String nextDayStr;
      String yearStr;
      int dayOfWeek = startDay;
                        
            
         for (int i = (1 + startDay); i <= 7; i++) {
            
            
            date =  resetDay(month, nextDay, year,dayOfWeek);
               

           System.out.print(date.substring(3,5));  /////// print the day of the month     
   
                        
            month = stringToInt(date.substring(0,2));
            nextDay = stringToInt(date.substring(3,5));
            year = stringToInt(date.substring(6,10));
            dayOfWeek = stringToInt(date.substring(11,12));
            
            if (dayOfWeek < 6) {                 ////// do formatting 
               System.out.print("  "); 
            } else if ( dayOfWeek == 6) {
               System.out.println();
            }   /////// end if

            
            nextDay = (nextDay + 1);
            dayOfWeek = dayOfWeek + 1;       
         }                                /////// end FOR loop

         

         if (startDay > 0) {
            for (int i = 1; i <= startDay; i++) {
               
               
               
                  
               date = resetDay(month,nextDay, year, dayOfWeek);   
         
               System.out.print(date.substring(3,5));                ///////// print out the day
                    
               month = stringToInt(date.substring(0,2));
               nextDay = stringToInt(date.substring(3,5));
               year = stringToInt(date.substring(6,10));
               dayOfWeek = stringToInt(date.substring(11,12));
         
               if (dayOfWeek < 6) {                                         //////// it is not Saturday, print spaces
               
                  System.out.print("  ");                            //////// print spaces in between days to format
               } else if (dayOfWeek == 6) {                                  ////////// it is Saturday, get to next line.
               
                  System.out.println();
               }   /////// end if
            
               
               nextDay = nextDay + 1;
               dayOfWeek = dayOfWeek + 1;                      
            }                                 //////// end FOR loop
            
         } else if (startDay < 0) {           //////// error, proper Day not given
            return(" The day given is invalid.");
         }
         
         
         
             
         if (intLength(year) == 3){                    ///// It is a 3 digit long year, eg. 989 AD
            yearStr = "0" + year;                      ///// add a 0, to make it 4 digits long
         }  
         else if (intLength(year) == 2) {              ////// It is a 2 digit long year, eg. 78 AD
            yearStr = "00" + year;                     ////// add two 0's, to make it a 4 digit long year  
         }
         else if (intLength(year) == 1)  {            ////// It is a 1 digit long year, eg. 9 AD
            yearStr = "000" + year;                   ////// add three 0's, to make it a 4 digit year
         }
         else {                                       ////// It is a 4 digit long year, eg. 2010 AD
            yearStr = "" + year;                      ////// there is no need to add any 0's
         }                                            

         
         if (intLength(nextDay) == 1) {
               nextDayStr = "" + "0"  + nextDay;
         } else {
               nextDayStr = "" + nextDay;    
         }
                
         if (intLength(month) == 1) {
               monthStr = "" + "0"  + month;
         } else {
               monthStr = "" + month;
         }
                
   
      
      
         return("" + monthStr + " " + nextDayStr  + " " + yearStr);
                  
   }              ///// printSevenDaysInFormat
              
   
   

        
   ///////////          
   /////////// This method prints spaces to get to the right day of the week. 
   /////////// 
   
   public static void formatDay(int startDay) { 
      
      if (startDay != 0) {                        /////////// startDay is Sunday, no formatting is required
         for (int i = 0; i < (startDay); i++) {  
            System.out.print("    ");
         }
      }       //// end if
   
   
   }  ///////// end formatDay             
   



            
   /////////// This method prints the days of the week, 
   /////////// as Sun Mon Tue Wed Thu Fri Sat.
   
   public static void printDaysOfWeek() { 
      
      System.out.println("Sun Mon Tue Wed Thu Fri Sat");
   }
      
      
      
         
            
   /////////// This method prints the month of the year, 
   /////////// given the number of the month and the year.
   
   public static void printMonthOfTheYear(int month, int year) { 
      
      
      System.out.println();                        /////// get to a new line
      System.out.println();                        /////// print a blank line
      System.out.println("         " + year + " AD");
      
      
      if (month == 1) {
         System.out.println("         JANUARY");
      
      } else if (month == 2) {
         System.out.println("         FEBRUARY");
      
      } else if (month == 3) {
         System.out.println("         MARCH");
         
      } else if (month == 4) {
         System.out.println("         APRIL");
      
      } else if (month == 5) {
         System.out.println("         MAY");
         
      } else if (month == 6) {
         System.out.println("         JUNE");
      
      } else if (month == 7) {
         System.out.println("         JULY");
         
      } else if (month == 8) {
         System.out.println("         AUGUST");
      
      } else if (month == 9) {
         System.out.println("         SEPTEMBER");
         
      } else if (month == 10) {
         System.out.println("         OCTOBER");
      
      } else if (month == 11) {
         System.out.println("         NOVEMBER");
         
      } else if (month == 12) {
         System.out.println("         DECEMBER");
      
      }    ///////// end else if

   }       //////// printMonthOfTheYear
   
   
         
         
     ///////// returns a number 1 through 7. If the day given (whichDay) is "Sunday"
   ///////// it returns 7, for "Monday" it returns 1 and so on till "Saturday" for which it returns 6 
   /////////
   ///////// It is used to get a number corressponding to the day of week given, for the 
   ///////// calculation of the next Days of the week.

   
   public static int getStartDay(String whichDay) {   
      int day = -1;
      
   
      
      if (whichDay.startsWith("Monday")) {
      
         day = 1;
      } else if (whichDay.startsWith("Tuesday")) {
      
         day = 2;
      } else if (whichDay.startsWith("Wednesday")) {
      
         day = 3;
      } else if (whichDay.startsWith("Thursday")) {
      
         day = 4;
      } else if (whichDay.startsWith("Friday")) {
      
         day = 5;
      } else if (whichDay.startsWith("Saturday")) {
         
         day = 6;
      } else if (whichDay.startsWith("Sunday")) {
         
         day = 0;
      }

      return day;
   

   }                                /////////////// end getStartDay
   
   
   
   
   
   
   /////////// This method returns the day of the month that 
   /////////// the printing needs to start with.
   ////////// get the Start Date to print the next numberOfDays dates.
   
public static String getBeginningDay(int month, int day, int year, int numberOfDays, int startDay)  {
         
     String beginDate = "" + month + " " + day + " " + year + " " + startDay;
      int count = 0;
      String dayStr = "" + day;
      String monthStr = "" + month; 
      String yearStr  = "" + year;  
      

      int dayOfWeek = startDay;



      for (int i = 1; i <= numberOfDays; i++) {
            day = day + 1;
            dayOfWeek = dayOfWeek + 1;
      
            beginDate = resetDayNoPrinting(month,day,year, dayOfWeek);
            
            month = stringToInt(beginDate.substring(0,2));
           
            monthStr = (beginDate.substring(0,2));
            
            day = stringToInt(beginDate.substring(3,5));
            year = stringToInt(beginDate.substring(6,10));
            
            yearStr = (beginDate.substring(6,10));
            
            dayOfWeek = stringToInt(beginDate.substring(11,12));
         
      }
    
      if (intLength(day) == 1) {
          return("" + monthStr + "  " + day + " " + yearStr + " " + dayOfWeek);
      }
      
      return("" + monthStr + " " + day + " " + yearStr + " " + dayOfWeek);

   
}       /////////// getBeginningDay


   
   




       
   
   
   
/////////// The resetDay method sets the day to 1,
/////////// if it is at the end of the month.
/////////// Sets the month to 1 and increments the year, if it is the end of the year(i.e. 12/31/yyyy).
/////////// Reset day, month and year if needed.
///////////
/////////// Formats for the beginning of the month.
/////////// 
///////////
/////////// It returns the date, (that has been reset) as mm/dd/yyyy.
///////////
/////////// This method is used in the getNextSevenDays method.
///////////

   public static String resetDay(int month, int day, int year, int whichDay) {

   
   
      
   
   
      String dayStr = String.valueOf(day);
      String monthStr = String.valueOf(month);
      String yearStr = String.valueOf(year);
      String dayOfWeekStr = String.valueOf(whichDay);
      int dayOfWeek = whichDay;
      
   
      if (whichDay == 7) { ///// reset dayOfWeek back to Sunday
         dayOfWeek = 0;
         dayOfWeekStr = String.valueOf(dayOfWeek);
      }        


   
      if (month == 2)  {       ////// February
         if ((((year%4) != 0) && (day == 29)) || (((year%4) == 0) && (day == 30))) {   ////// non Leap Year, or LEAP Year
            day = 1;
            dayStr = String.valueOf(day);
            month = month + 1;   
            monthStr = String.valueOf(month);
            
            printMonthOfTheYear(month, year);
            printDaysOfWeek();
            formatDay(dayOfWeek);

         }
      } else if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10))
                 && (day == 32)) {    ////// Jan, March, May, July, Aug, Oct
            day = 1;
            dayStr = String.valueOf(day);
            month = month + 1;
            monthStr = String.valueOf(month);
            
           printMonthOfTheYear(month, year);
            printDaysOfWeek();
            formatDay(dayOfWeek);
         


      } else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day == 31)) {
            day = 1;           ////// April, June, Sep , Nov
            dayStr = String.valueOf(day);
            month = month + 1;
            monthStr = String.valueOf(month);
                        
            printMonthOfTheYear(month, year);
            printDaysOfWeek();
            formatDay(dayOfWeek);
            
 
      } else if ((month == 12) && (day == 32)) {  /// Dec, reset month to 1, i.e. Jan and year to the next year
            day = 1;
            dayStr = String.valueOf(day);
            month = 1;
            monthStr = String.valueOf(month);
            year = year + 1;
            yearStr = String.valueOf(year);
                        
            printMonthOfTheYear(month, year);
            printDaysOfWeek();
            formatDay(dayOfWeek);
            


      }
      
      
          
      if (yearStr.length() == 3)                    ///// It is a 3 digit long year, eg. 989 AD
         yearStr = "0" + yearStr;                   ///// add a 0, to make it 4 digits long
         
      if (yearStr.length() == 2)                   ////// It is a 2 digit long year, eg. 78 AD
         yearStr = "00" + yearStr;                 ////// add two 0s, to make it a 4 digit long year  
      
      if (yearStr.length() == 1)                   ////// It is a 1 digit long year, eg. 9 AD
         yearStr = "000" + yearStr;                ////// add three 0s, to make it a 4 digit long year   
   
      
      if (monthStr.length() == 1)                   ///// month is given as 1 digit,
         monthStr = "" + "0" + monthStr;               ///// add a 0, to make it 2 digits long.
         
      if (dayStr.length() == 1)                   ///// day is given as 1 digit,
         dayStr = " " + dayStr;                 ///// add a space, to make it 2 digits long.
         
      
   
   
      return (  monthStr + "/" + dayStr + "/" + yearStr + " " + dayOfWeekStr);   
      
      
         
   }                             ////// end of resetDay
   
      
   
      
   
   
/////////// This method is like resetDay, except that it does not print anything, or do any formatting.
/////////// It is used in getBeginningDay, method.
///////////   
/////////// The resetDayNoPrinting method sets the day to 1,
/////////// if it is at the end of the month.
/////////// Sets the month to 1 and increments the year, if it is the end of the year(i.e. 12/31/yyyy).
/////////// Reset day, month and year if needed.
///////////
/////////// 
/////////// 
///////////
/////////// It returns the date, (that has been reset) as mm/dd/yyyy.
///////////
/////////// (This method is used in the getNextSevenDays method.)
///////////

   public static String resetDayNoPrinting(int month, int day, int year, int whichDay) {

   
      String dayStr = String.valueOf(day);
      String monthStr = String.valueOf(month);
      String yearStr = String.valueOf(year);
      String dayOfWeekStr = String.valueOf(whichDay);
      int dayOfWeek = whichDay;
      
   
      if (whichDay == 7) { ///// reset dayOfWeek back to Sunday
         dayOfWeek = 0;
         dayOfWeekStr = String.valueOf(dayOfWeek);
      }        


   
      if (month == 2)  {       ////// February
         if ((((year%4) != 0) && (day == 29)) || (((year%4) == 0) && (day == 30))) {   ////// non Leap Year, or LEAP Year
            day = 1;
            dayStr = String.valueOf(day);
            month = month + 1;   
            monthStr = String.valueOf(month);
            
 
         }
      } else if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10))
                 && (day == 32)) {    ////// Jan, March, May, July, Aug, Oct
            day = 1;
            dayStr = String.valueOf(day);
            month = month + 1;
            monthStr = String.valueOf(month);
            

      } else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day == 31)) {
            day = 1;           ////// April, June, Sep , Nov
            dayStr = String.valueOf(day);
            month = month + 1;
            monthStr = String.valueOf(month);
                        
 
      } else if ((month == 12) && (day == 32)) {  /// Dec, reset month to 1, i.e. Jan and year to the next year
            day = 1;
            dayStr = String.valueOf(day);
            month = 1;
            monthStr = String.valueOf(month);
            year = year + 1;
            yearStr = String.valueOf(year);
                        

      }
      
      
          
      if (yearStr.length() == 3)                    ///// It is a 3 digit long year, eg. 989 AD
         yearStr = "0" + yearStr;                   ///// add a 0, to make it 4 digits long
         
      if (yearStr.length() == 2)                   ////// It is a 2 digit long year, eg. 78 AD
         yearStr = "00" + yearStr;                 ////// add two 0s, to make it a 4 digit long year  
      
      if (yearStr.length() == 1)                   ////// It is a 1 digit long year, eg. 9 AD
         yearStr = "000" + yearStr;                ////// add three 0s, to make it a 4 digit long year   
   
      
      if (monthStr.length() == 1)                   ///// month is given as 1 digit,
         monthStr = "" + "0" + monthStr;               ///// add a 0, to make it 2 digits long.
         
      if (dayStr.length() == 1)                   ///// day is given as 1 digit,
         dayStr = " " + dayStr;                 ///// add a space, to make it 2 digits long.
         
      
   
   
      return (  monthStr + "/" + dayStr + "/" + yearStr + " " + dayOfWeekStr);   
      
      
         
   }                             ////// end of resetDayNoPrinting
   
      
   
      
   
      
      
      
/////////// This method returns the integer value of a String s1.
   
   public static int stringToInt(String s1) { 
      Scanner data = new Scanner(s1);
      int integerValue = data.nextInt();
      
      return integerValue;
   }                         //// end stringToInt





   /////////// This method returns the string that contains the number in it.
   /////////// Here number can be negative or positive.
   
   
   public static String intToString(int number) {
      
      String s1 = String.valueOf(number);
      return s1;
   }                       //// end intToString




     ////////// This method returns the length i.e. the number of digits in an integer.
   public static int intLength(int num) {
   
     int absoluteValue = Math.abs(num);
      String s1 = intToString(absoluteValue);
      
      int length = s1.length();           
            
      return length;
   }                          //// end intLength
   






/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
//
// ADDING the Code from printCalendarPast2018.java, for printing a Calendar year in the past
//
// Removing duplicate methods
//
//  Date: 1/9/2018 1:06PM (PST)
//
//
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////




   
         ///////////  This method prints out the dates, for 1 year, which is  
         ///////////   numOfYears before the date and day given, in Calendar format.
   
   public static void getYearForNYearsAgoInFormat(int month, int day, String whichDay, int year, int numOfYears) { 
      int numberOfDays = 0;
      int firstYear = year;
      int nextYear = firstYear - 1;
      int startDay = getStartDay(whichDay);
      int dayOfWeek = startDay;
      int prevYear = year;
   
      
      
      ///////////  get the number of days, in the previous year
      
      if (((nextYear)%4) == 0) {                ////////////// leap year
            numberOfDays =  366;       
      } else {                            ////////////// non leap year
            numberOfDays =  365;       
      }




      if (numOfYears > 1) {
   
         for (int i = 1; i < numOfYears; i++) {       
                     
         
         ///////////////// get dayOfWeek for the previous year.         
            String startDate = getBeginningDayPast(month, day, prevYear, numberOfDays, dayOfWeek);
  
            dayOfWeek = stringToInt(startDate.substring(11,12));
      
         
            prevYear = prevYear - 1;
            nextYear = nextYear - 1;
            
            
         ///////////  get the number of days, in the previous year
      
            if (((nextYear)%4) == 0) {                ////////////// leap year
               numberOfDays =  366;       
            } else {                            ////////////// non leap year
               numberOfDays =  365;       
            }

         
         } ////// end FOR loop
      
         
      } /////// end IF 
      
   
         
      getPrevNDaysInFormat(month, day, dayOfWeek, prevYear, numberOfDays);
      
     
      }     /////////  end  getYearForNYearsAgoInFormat
   
   
   
   
         /////////// This method prints out the date and day of the week 
   /////////// for numOfDays days before the date and day given, in format.
   
   public static void getPrevNDaysInFormat(int month, int day, int startDay, int year, int numOfDays) { 
      int beginMonth = month;
      int beginDay = day;

      
      int dayOfWeek = startDay;


      String startDate = "" + month + " " + day + " " + year + " " + startDay;      
   
      int beginYear = year;
      
        
      
      ///////////  get the date to start the printing with
      
         
      startDate = getBeginningDayPast(month, day, year, numOfDays, startDay );
   

      beginMonth = stringToInt(startDate.substring(0,2));
         
         
      beginDay = stringToInt(startDate.substring(3,5));
         
         
      beginYear = stringToInt(startDate.substring(6,10));
         
         
      dayOfWeek = stringToInt(startDate.substring(11,12));
         
         
////////// print the year, month and days of week header

      printMonthOfTheYear(beginMonth, beginYear);
      printDaysOfWeek();


      
      formatDay(dayOfWeek);                             //////////// add spaces if startDay is not Sunday
      
      
      int nextMonth = beginMonth;
      int nextDay = beginDay;
      int nextYear = beginYear;
         
         
         
            
      for (int i = 1; i <= (numOfDays/7); i++) {
            
                     
            
         String prevDate = printSevenDaysInFormat(nextMonth, nextDay, dayOfWeek, nextYear);
      
   
         nextMonth = stringToInt(prevDate.substring(0,2));
         nextDay = stringToInt(prevDate.substring(3,5));
         nextYear = stringToInt(prevDate.substring(6,10));
      
      }    //// end for loop
      
      
      
      
      ///// Print the rest of the dates
      
      
     if ((numOfDays%7) > 0) {
                  
         for (int i = 1; i <= (numOfDays%7); i++) {
               
            String date = resetDay(nextMonth,nextDay, nextYear, dayOfWeek);   
         
            System.out.print(date.substring(3,5));
            
            nextMonth = stringToInt(date.substring(0,2));
            nextDay = stringToInt(date.substring(3,5));
            nextYear = stringToInt(date.substring(6,10));
            dayOfWeek = stringToInt(date.substring(11,12));
   
           if (dayOfWeek < 6) {                                   //////// it is not Saturday, print spaces
               
               System.out.print("  ");                            //////// print spaces in between days to format
            } else if (dayOfWeek == 6) {                          ////////// it is Saturday, get to next line.
               
               System.out.println();
            }   /////// end if

            nextDay = nextDay + 1;
            
            dayOfWeek = dayOfWeek + 1;
         }  //// end for loop
      
      } ///// end If statement
   
      
   }  ///////////// end getPrevNDaysInFormat 

             
    
   
   /////////// This method returns the day of the month that 
   /////////// the printing needs to start with.
   ////////// get the Start Date to print the previous numberOfDays dates.
   
public static String getBeginningDayPast(int month, int day, int year, int numberOfDays, int startDay)  {
         
     String beginDate = "" + month + " " + day + " " + year + " " + startDay;
      int count = 0;
      String dayStr = "" + day;
      String monthStr = "" + month; 
      String yearStr  = "" + year;  
      

      int dayOfWeek = startDay;



      for (int i = 1; i <= numberOfDays; i++) {
            day = day - 1;
            dayOfWeek = dayOfWeek - 1;
      
            beginDate = resetDayPrev(month,day,year, dayOfWeek);
            
            month = stringToInt(beginDate.substring(0,2));
           
            monthStr = (beginDate.substring(0,2));
            
            day = stringToInt(beginDate.substring(3,5));
            year = stringToInt(beginDate.substring(6,10));
            
            yearStr = (beginDate.substring(6,10));
            
            dayOfWeek = stringToInt(beginDate.substring(11,12));
         
      }
    
      if (intLength(day) == 1) {
          return("" + monthStr + "  " + day + " " + yearStr + " " + dayOfWeek);
      }
      
      return("" + monthStr + " " + day + " " + yearStr + " " + dayOfWeek);

   
}       /////////// getBeginningDayPast


 
 
      
      
/////////// It returns a String with "mm dd yyyy n", where n is a number ranging from 0 to 6,
/////////// where 0 is Sunday,1 is Monday, 2 is Tuesday, and so on till 6 is Saturday.
/////////// 
///////////
/////////// It is used in the method getBeginningDayPast, in the printCalendarPast2018 program.
/////////// 
/////////// The resetDayPrev method sets the day to the end of the previous month,
/////////// if it is at the beginning of the month(i.e. day = 0).It sets the month to the previous month.
/////////// Sets the month to 12 and decrements the year, if it is the beginning of the year.
/////////// Reset day, month, year and dayOfWeek if needed.
///////////
/////////// 
///////////
///////////


   public static String resetDayPrev(int month, int day, int year, int dayOfWeek) {
      String dayStr = String.valueOf(day);
      String monthStr = String.valueOf(month);
      String yearStr = String.valueOf(year);
      String dayOfWeekStr = String.valueOf(dayOfWeek);
   
      
   
   
      if (dayOfWeek == -1) { ///// reset dayOfWeek back to Saturday
         dayOfWeek = 6;
         dayOfWeekStr = String.valueOf(dayOfWeek);
      }        
      
  
      
   
      
   
      if (month == 3)  {       ////// beginning of March
         if (((year%4) != 0) && (day == 0))   {   ////// non Leap Year
            day = 28;
            dayStr = String.valueOf(day);
            month = month - 1;   
            monthStr = String.valueOf(month);
         } else if (((year%4) == 0) && (day == 0)) {   /////// Leap Year
            day = 29;
            dayStr = String.valueOf(day);
            month = month - 1;   
            monthStr = String.valueOf(month);

         
         
         }  
         
      } else if (((month == 2) || (month == 4) || (month == 6) || (month == 8) || (month == 9) || (month == 11))
                 && (day == 0)) {    ////// beginning of Feb, April, June, August, September, November
            day = 31;
            dayStr = String.valueOf(day);
            month = month - 1;
            monthStr = String.valueOf(month);
            
         
      } else if (((month == 5) || (month == 7) || (month == 10) || (month == 12)) && (day == 0)) {
            day = 30;           ////// beginning of May, July, October, December
            dayStr = String.valueOf(day);
            month = month - 1;
            monthStr = String.valueOf(month);
                        
          
      } else if ((month == 1) && (day == 0)) {  /// beginning of Jan,reset day to 31, reset month to 12, i.e. Dec and year to the prev year
            day = 31;
            dayStr = String.valueOf(day);
            month = 12;
            monthStr = String.valueOf(month);
            year = year - 1;
      
                       
      }
      
      yearStr = String.valueOf(year);
      
      if (yearStr.length() == 3)                    ///// It is a 3 digit long year, eg. 989 AD
         yearStr = "0" + yearStr;                   ///// add a 0, to make it 4 digits long
         
      if (yearStr.length() == 2)                   ////// It is a 2 digit long year, eg. 78 AD
         yearStr = "00" + yearStr;                 ////// add two 0s, to make it a 4 digit long year 
         
      if (yearStr.length() == 1)                   ////// It is a 1 digit long year, eg. 9 AD
         yearStr = "000" + yearStr;                ////// add three 0s, to make it 4 digits long   
          
         
     if (monthStr.length() == 1)                   ///// month is given as 1 digit,
         monthStr = "" + "0" + monthStr;               ///// add a 0, to make it 2 digits long.
         
      if (dayStr.length() == 1)                   ///// day is given as 1 digit,
         dayStr = "" + "0" + dayStr;                 ///// add a 0, to make it 2 digits long.
         
      
      return (  monthStr + " " + dayStr + " " + yearStr + " " + dayOfWeekStr);   
        
         
   }                             ////// end of resetDayPrev
   

       
        
}       // end printCalendarADYear 
      
            
