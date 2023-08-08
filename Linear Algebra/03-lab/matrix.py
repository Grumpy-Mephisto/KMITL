#!/usr/bin/env python3


class Matrix:
    def __init__(self, matrix_string) -> None:
        self.matrix = [
            [int(num) for num in row.split()] for row in matrix_string.splitlines()
        ]

    def create(rows, cols) -> list:
        matrix = [[0 for _ in range(cols)] for _ in range(rows)]
        return matrix

    def minor(matrix, i, j) -> list:
        minor = Matrix.create(len(matrix) - 1, len(matrix[0]) - 1)
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if row != i and col != j:
                    minor_row = row if row < i else row - 1
                    minor_col = col if col < j else col - 1
                    minor[minor_row][minor_col] = matrix[row][col]
        return minor

    def determinant(matrix) -> int:
        if not Matrix.square(matrix):
            return None

        size = len(matrix)
        if size == 1:
            return matrix[0][0]
        else:
            det = 0
            for j in range(size):
                det += matrix[0][j] * Matrix.cofactor(matrix, 0, j)
            return det

    def square(matrix) -> bool:
        return len(matrix) == len(matrix[0])

    def cofactor(matrix, i, j) -> int:
        if not Matrix.square(matrix):
            return None

        sign = 1 if (i + j) % 2 == 0 else -1
        return sign * Matrix.determinant(Matrix.minor(matrix, i, j))

    def inverse(matrix) -> list:
        det = Matrix.determinant(matrix)
        if det == 0:
            return None

        size = len(matrix)
        cofactors = Matrix.create(size, size)
        for i in range(size):
            for j in range(size):
                cofactors[i][j] = Matrix.cofactor(matrix, i, j)

        adjoint = Matrix.transpose(cofactors)
        inverse = Matrix.multiply(adjoint, 1 / det)

        return inverse

    def multiply(matrix, scalar) -> list:
        return [[value * scalar for value in row] for row in matrix]

    def transpose(matrix) -> list:
        return [[matrix[j][i] for j in range(len(matrix))] for i in range(len(matrix))]

    def print_matrix(matrix) -> None:
        for row in matrix:
            print(" ".join(str(value) for value in row))


def get_input_matrices() -> list:
    matrices = []
    try:
        count = int(
            input("===== Number of matrices =====\n" "Enter number of matrices: ")
        )

        for i in range(count):
            print(f"\n===== Matrix {i+1} =====")
            rows = int(input("Enter number of rows: "))
            cols = int(input("Enter number of columns: "))

            matrix = Matrix.create(rows, cols)

            print(f"\n===== Enter values for matrix {i+1} =====")
            for i in range(rows):
                for j in range(cols):
                    matrix[i][j] = int(
                        input(f"Enter value for row {i} and column {j}: ") or 0
                    )
            matrices.append(matrix)
    except ValueError or TypeError or KeyboardInterrupt:
        print("Invalid input")
        exit(1)

    return matrices


def main() -> None:
    matrices = get_input_matrices()

    print("\n===== Matrices =====")
    for i, matrix in enumerate(matrices):
        print(f"Matrix {i+1}:")
        Matrix.print_matrix(matrix)

    print("\n===== Square =====")
    for i, matrix in enumerate(matrices):
        print(f"Matrix {i+1} is square: {Matrix.square(matrix)}")

    print("\n===== Determinants, Cofactors, and Inverses =====")
    if not Matrix.square(matrices[0]):
        print("Cannot calculate determinant, cofactor, and inverse")
        exit(0)

    print("\n===== Determinants =====")
    for i, matrix in enumerate(matrices):
        print(f"Determinant of matrix {i+1}:")
        print(Matrix.determinant(matrix))

    print("\n===== Cofactors =====")
    for i, matrix in enumerate(matrices):
        print(f"Cofactors of matrix {i+1}:")
        for j in range(len(matrix)):
            for k in range(len(matrix[0])):
                print(Matrix.cofactor(matrix, j, k), end=" ")
            print()

    print("\n===== Inverses =====")
    for i, matrix in enumerate(matrices):
        print(f"Inverse of matrix {i+1}:")
        inverse = Matrix.inverse(matrix)
        if inverse is None:
            print("Inverse does not exist")
        else:
            Matrix.print_matrix(inverse)


if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("\nGoodbye!")
        exit(0)
