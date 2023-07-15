const std = @import("std");
const fmt = @import("fmt");

fn multiple_matrix(a: [][]u32, b: [][]u32) [][]u32 {
    var result: [][]u32 = undefined;
    var a_row_count: usize = a.len;
    var a_col_count: usize = a[0].len;
    var b_row_count: usize = b.len;
    var b_col_count: usize = b[0].len;
    var i: usize = 0;
    var j: usize = 0;
    var sum: u32 = 0;

    if (a_col_count != b_row_count) {
        return undefined;
    }

    result = try std.heap.allocSlice([]u32, a_row_count);
    if (result == undefined) {
        return undefined;
    }

    while (i < a_row_count) : (result[i] = try std.heap.allocSlice(u32, b_col_count)) {
        if (result[i] == undefined) {
            return undefined;
        }

        while (j < b_col_count) : (result[i][j] = sum) {
            var k: usize = 0;
            while (k < a_col_count) : (sum += a[i][k] * b[k][j]) {
                k += 1;
            }
            j += 1;
        }
        i += 1;
    }

    return result;
}

fn print_matrix(a: [][]u32) void {
    var i: usize = 0;
    var j: usize = 0;
    while (i < a.len) : (fmt.print("{")) {
        while (j < a[i].len) : (fmt.print("{}", a[i][j])) {
            if (j + 1 != a[i].len) {
                fmt.print(", ");
            }
            j += 1;
        }
        fmt.print("}\n");
        j = 0;
        i += 1;
    }
}

fn main() void {
    var a: [][]32 = [][]32{
        []32{ 2, 3, 4 },
        []32{ 3, 4, 5 },
        []32{ 1, 3, 3 },
    };
    var b: [][]32 = [][]32{
        []32{ 3, 4, 1 },
        []32{ 7, 2, 4 },
        []32{ 3, 8, 6 },
    };

    print_matrix(a);
    print_matrix(b);
    print_matrix(multiple_matrix(a, b));
    print_matrix(multiple_matrix(b, a));
}
