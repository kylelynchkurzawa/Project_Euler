using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Project_Euler
{
    class PE_prob19
    {
        public PE_prob19()
        {
            Console.WriteLine("Counting Sundays");
        }

        public void run()
        {
            long start = DateTime.Now.Ticks;
            Console.WriteLine("Started at " + start);

            int sundayCount = 0;
            int fyear = 1901;
            int fmonth = 1;
            int fday = 1;
            int lyear = 2000;
            int lmonth = 12;
            int lday = 31;
            DateTime currentDate = new DateTime(fyear, fmonth, fday);
            DateTime lastDate = new DateTime(lyear, lmonth, lday);
                        
            while (currentDate < lastDate)
            {
                if ((currentDate.Day == 1)&&(currentDate.DayOfWeek == DayOfWeek.Sunday))
                {
                    //Console.WriteLine(currentDate.ToString()+": Sunday on the first of the month");
                    sundayCount++;
                }

                currentDate = incrementDateByOneMonth(currentDate);
            }
            
            Console.WriteLine("Sundays that fall on the first of the month in the 20th centuary: "+sundayCount);

            long finish = DateTime.Now.Ticks;
            long time = finish - start;
            Console.WriteLine("Finished at " + finish);
            Console.WriteLine("Executed in " + time);
        }
        private DateTime incrementDateByOneMonth(DateTime dt)
        {
            if (dt.Month == 12)
            {
                return new DateTime(dt.Year+1, 1, dt.Day);
            }
            else
            {
                return new DateTime(dt.Year, dt.Month+1, dt.Day);
            }
        }
    }
}
