#!/usr/bin/env python3

def mutiple_matrix(a: list, b: list) -> list:
    result = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
    for i in range(len(a)):
        for j in range(len(b[0])):
            for k in range(len(b)):
                result[i][j] += a[i][k] * b[k][j]
    return result


def print_matrix(equation: str, matrix: list) -> None:
    print(f"Matrix {equation}")
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(f"{matrix[i][j]:>4}", end=" ")
        print()


def main() -> None:
    a = [[2, 3, 4],
         [3, 4, 5],
         [1, 3, 3]]
    b = [[3, 4, 1],
         [7, 2, 4],
         [3, 8, 6]]
    print_matrix("A ", a)
    print_matrix("B ", b)
    print_matrix("A x B ", mutiple_matrix(a, b))
    print_matrix("B x A ", mutiple_matrix(b, a))


if __name__ == "__main__":
    main()
