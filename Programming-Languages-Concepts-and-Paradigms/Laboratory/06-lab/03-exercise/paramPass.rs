fn swap(a: &mut i32, b: &mut i32) {
    let temp = *a;
    *a = *b;
    *b = temp;
}

fn main() {
    let mut a = 4;
    let mut b = 5;

    swap(&mut a, &mut b);

    println!("a = {}, b = {}", a, b);
}
