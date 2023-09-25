def matrix_create(rows, cols) -> list:
    if rows <= 0 or cols <= 0:
        return None

    matrix = [[0 for _ in range(cols)] for _ in range(rows)]
    return matrix

def matrix_multiply(matrix1, matrix2) -> list:
    rows1 = len(matrix1)
    cols1 = len(matrix1[0])
    rows2 = len(matrix2)
    cols2 = len(matrix2[0])

    if cols1 != rows2:
        return None

    product = matrix_create(rows1, cols2)

    for i in range(rows1):
        for j in range(cols2):
            product[i][j] = sum(matrix1[i][k] * matrix2[k][j] for k in range(cols1))

    return product

def matrix_transpose(matrix) -> list:
    rows = len(matrix)
    cols = len(matrix[0])

    transposed = matrix_create(cols, rows)

    for i in range(rows):
        for j in range(cols):
            transposed[j][i] = matrix[i][j]

    return transposed

def matrix_print(matrix) -> None:
    for row in matrix:
        print(" ".join(str(elem) for elem in row))
    print()

def main() -> None:
    matrices = []
    matrix_count = int(input("===== Number of matrices =====\n" "Enter number of matrices: "))

    for i in range(matrix_count):
        print(f"\n===== Matrix {i+1} =====")
        rows = int(input("Enter number of rows: "))
        cols = int(input("Enter number of columns: "))

        matrix = matrix_create(rows, cols)

        print(f"\n===== Enter values for matrix {i+1} =====")
        for i in range(rows):
            for j in range(cols):
                matrix[i][j] = int(input(f"Enter value for row {i} and column {j}: "))

        matrices.append(matrix)

    print("\n===== Matrices =====")
    for i, matrix in enumerate(matrices):
        print(f"Matrix {i+1}:")
        matrix_print(matrix)
        print()

    print("\n===== Product of Matrices =====")
    for i in range(matrix_count):
        for j in range(matrix_count):
            if i != j:
                print(f"Matrix {i+1} * Matrix {j+1}:")
                product = matrix_multiply(matrices[i], matrices[j])
                matrix_print(product)

    print("\n===== Transpose of Matrices =====")
    for i, matrix in enumerate(matrices):
        print(f"Matrix {i+1}T:")
        transposed_matrix = matrix_transpose(matrix)
        matrix_print(transposed_matrix)

    print("\n===== Product of Transposed Matrices =====")
    for i in range(matrix_count):
        for j in range(matrix_count):
            if i != j:
                print(f"Matrix {i+1}T * Matrix {j+1}T:")
                productT = matrix_multiply(matrix_transpose(matrices[i]), matrix_transpose(matrices[j]))
                matrix_print(productT)

if __name__ == "__main__":
    main()
