fn main() {
    // Type inference (similar to implicit declaration)
    let inferred_integer = 42;
    let inferred_float = 3.14;
    
    println!("inferred_integer is: {}", inferred_integer);
    println!("inferred_float is: {}", inferred_float);
    
    // Explicit type annotation
    let explicit_integer: i32 = 100;
    let explicit_float: f64 = 2.71828;
    
    println!("explicit_integer is: {}", explicit_integer);
    println!("explicit_float is: {}", explicit_float);
    
    // Static typing
    let mut mutable_var = 10;
    println!("mutable_var is initially: {}", mutable_var);
    
    mutable_var = 20;
    println!("mutable_var is now: {}", mutable_var);
    
    // This will not compile:
    // mutable_var = "This is a string";
    
    // Rust doesn't have direct dynamic typing, but it has traits for dynamic dispatch
    trait Printable {
        fn print(&self);
    }
    
    struct IntPrinter(i32);
    impl Printable for IntPrinter {
        fn print(&self) {
            println!("IntPrinter: {}", self.0);
        }
    }
    
    struct FloatPrinter(f64);
    impl Printable for FloatPrinter {
        fn print(&self) {
            println!("FloatPrinter: {}", self.0);
        }
    }
    
    let printers: Vec<Box<dyn Printable>> = vec![
        Box::new(IntPrinter(42)),
        Box::new(FloatPrinter(3.14)),
    ];
    
    for printer in printers {
        printer.print();
    }
}