fn mutiple_matrix() -> [3][3]i32 {
    var result: [3][3]i32 = undefined;
    for (result) |i, row| {
        for (row) |j, col| {
            var sum: i32 = 0;
            for (0..3) |k| {
                sum += a[i][k] * b[k][j];
            }
            col = sum;
        }
    }
    return result;
}

fn print_matrix(equation: []const u8, matrix: [3][3]i32) void {
    std.debug.print("Matrix {}{}\n", .{equation, matrix});
}

pub fn main() void {
    var a: [3][3]i32 = [_]anytype{[3]i32{2, 3, 4}, [3]i32{3, 4, 5}, [3]i32{1, 3, 3}};
    var b: [3][3]i32 = [_]anytype{[3]i32{3, 4, 1}, [3]i32{7, 2, 4}, [3]i32{3, 8, 6}};
    print_matrix("A ", a);
    print_matrix("B ", b);
    print_matrix("A x B ", mutiple_matrix(a, b));
    print_matrix("B x A ", mutiple_matrix(b, a));
}