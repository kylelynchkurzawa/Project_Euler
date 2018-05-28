using ConsoleApp1.Project_Euler;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Project_Euler
{

    class PE_prob17
    {

        private String[] singles =
        {"one", "two",
            "three", "four",
            "five", "six",
            "seven", "eight",
            "nine"};
        private String[] teens =
        {"ten",
            "eleven", "twelve",
            "thirteen", "fourteen",
            "fifteen", "sixteen",
            "seventeen", "eighteen",
            "nineteen"};
        private String[] tens =
                {"twenty", "thirty",
            "forty", "fifty",
            "sixty", "seventy",
            "eighty", "ninety"};
        private String and = "and";
        private String hundred = "hundred";
        private String thousand = "thousand";

        public PE_prob17()
        {
            Console.WriteLine("Number Letter Counts");
        }

        public void run()
        {
            long start = DateTime.Now.Ticks;
            Console.WriteLine("Started at " + start);

            //int ending = 5;
            int ending = 1000;
            int num_char_sum = 0;
            int returned = -1;

            for (int i = 1; i <= ending; i++)
            {
                returned = returnEnglishNumLength(i);
                Console.WriteLine("Number of characters for number: " + i + " is: " + returned);

                num_char_sum = num_char_sum + returned;
            }

            Console.WriteLine("Total characters for number between 1 and " + ending + " inclusive is: " + num_char_sum);

            long finish = DateTime.Now.Ticks;
            long time = finish - start;
            Console.WriteLine("Finished at " + finish);
            Console.WriteLine("Executed in " + time);
        }

        private int returnEnglishNumLength(int x)
        {
            if (x <= 0)
            {
                return 0;
            }
            String value = x.ToString();
            int length = value.Length;
            int digit = -1;

            int return_length = 0;
            switch (length)
            {
                case (4)://thousands
                    digit = Int32.Parse(value.Substring(0, value.Length - 3));
                    return_length = this.singles[digit - 1].Length + this.thousand.Length + returnEnglishNumLength(Int32.Parse(value.Substring(1, value.Length - 1)));
                    break;
                case (3)://hundreds
                    digit = Int32.Parse(value.Substring(0, value.Length - 2));
                    return_length = this.singles[digit - 1].Length + this.hundred.Length;

                    if (Int32.Parse(value.Substring(1, value.Length - 1)) != 0)
                    {//account for 'and's in non hundred numbers
                        return_length = return_length + this.and.Length + returnEnglishNumLength(Int32.Parse(value.Substring(1, value.Length - 1)));
                    }
                    else
                    {
                        return_length = return_length + returnEnglishNumLength(Int32.Parse(value.Substring(1, value.Length - 1)));
                    }

                    break;
                case (2)://tens and teens
                    if (x > 19)
                    {//twenties and above
                        digit = Int32.Parse(value.Substring(0, value.Length - 1));
                        return_length = this.tens[digit - 2].Length + returnEnglishNumLength(Int32.Parse(value.Substring(1, value.Length - 1)));
                    }
                    else
                    {//teens and pre-teens including ten
                        digit = Int32.Parse(value.Substring(1, value.Length - 1));
                        return_length = this.teens[digit].Length;
                    }
                    break;
                case (1)://singles
                    digit = Int32.Parse(value.Substring(0, 1));
                    return_length = this.singles[digit - 1].Length;
                    break;
                default:
                    Console.WriteLine("Something weird happened");
                    break;
            }
            return return_length;
        }
    }
}
