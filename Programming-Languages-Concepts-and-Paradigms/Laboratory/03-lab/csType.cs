using System;

class Program
{
    static void Main()
    {
        // Implicit variable declaration
        var implicitInt = 10;
        var implicitString = "Hello";
        
        Console.WriteLine($"implicitInt is of type: {implicitInt.GetType()}");
        Console.WriteLine($"implicitString is of type: {implicitString.GetType()}");
        
        // Static typing
        int staticInt = 20;
        string staticString = "World";
        
        // Uncomment the following lines to see compile-time errors
        // staticInt = "This will not compile";
        // staticString = 30;
        
        // Dynamic typing
        dynamic dynamicVar = 100;
        Console.WriteLine($"dynamicVar is initially: {dynamicVar}");
        
        dynamicVar = "Now I'm a string";
        Console.WriteLine($"dynamicVar is now: {dynamicVar}");
        
        // This will compile but may throw a runtime error
        // dynamicVar.NonExistentMethod();
    }
}