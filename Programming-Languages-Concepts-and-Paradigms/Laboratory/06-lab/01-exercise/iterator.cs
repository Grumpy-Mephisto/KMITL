using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        List<double> salaryList = new List<double> { 50000, 60000, 55000, 70000 };
        IEnumerator<double> itr = salaryList.GetEnumerator();

        while (itr.MoveNext())
        {
            Console.WriteLine(itr.Current);
        }
    }
}
