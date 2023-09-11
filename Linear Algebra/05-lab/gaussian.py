from tabulate import tabulate


class GaussianEliminationError(Exception):
    def __init__(self, message):
        super().__init__(message)


class UserInput:
    @staticmethod
    def get_int(prompt):
        while True:
            try:
                return int(input(prompt))
            except ValueError:
                print("Invalid input. Please enter an integer.")

    @staticmethod
    def get_float(prompt):
        while True:
            try:
                return float(input(prompt))
            except ValueError:
                print("Invalid input. Please enter a float.")


class GaussianElimination:
    def __init__(self, n):
        self.n = n
        self.A = []
        self.b = []
        self.x = [0] * n

    def input_data(self):
        print("Enter the coefficients of the linear equations:")
        for i in range(self.n):
            equation = list(
                map(
                    float,
                    input(f"Equation {i + 1} coefficients (space-separated): ").split(),
                )
            )
            b_value = UserInput.get_float(f"Enter the value of b{i + 1}: ")
            self.A.append(equation)
            self.b.append(b_value)

    def forward_elimination(self):
        """Performs forward elimination on the coefficient matrix A and the constants vector b."""
        for pivot_row in range(self.n):
            max_row = pivot_row
            for i in range(pivot_row + 1, self.n):
                if abs(self.A[i][pivot_row]) > abs(self.A[max_row][pivot_row]):
                    max_row = i

            self.A[pivot_row], self.A[max_row] = self.A[max_row], self.A[pivot_row]
            self.b[pivot_row], self.b[max_row] = self.b[max_row], self.b[pivot_row]

            pivot = self.A[pivot_row][pivot_row]
            if pivot == 0:
                raise GaussianEliminationError(
                    "Zero pivot encountered. The matrix may be singular."
                )

            for row in range(self.n):
                if row != pivot_row:
                    factor = self.A[row][pivot_row] / pivot
                    for col in range(self.n):
                        self.A[row][col] -= factor * self.A[pivot_row][col]
                    self.b[row] -= factor * self.b[pivot_row]

            self.display_step(pivot_row, "Forward Elimination")

    def backward_substitution(self):
        """Performs backward substitution on the coefficient matrix A and the constants vector b."""
        for i in range(self.n - 1, -1, -1):
            if self.A[i][i] == 0:
                raise GaussianEliminationError(
                    "No unique solution exists. The matrix is singular."
                )

            self.x[i] = self.b[i]
            for j in range(i + 1, self.n):
                self.x[i] -= self.A[i][j] * self.x[j]
            self.x[i] /= self.A[i][i]

            self.display_step(i, "Backward Substitution")

    def display_original_equations(self):
        """Displays the original equations."""
        print("\nOriginal Equations:")
        for i in range(self.n):
            equation = " + ".join([f"{self.A[i][j]}x{j + 1}" for j in range(self.n)])
            print(f"{equation} = {self.b[i]}")
        print("\n")

    def display_step(self, step, method):
        """Displays the current coefficient matrix A and the constants vector b."""
        print(f"————— Step {step + 1} ({method}) —————\n")

        coefficient_matrix = [
            [self.A[i][j] for j in range(self.n)] for i in range(self.n)
        ]
        constants_vector = [[self.b[i]] for i in range(self.n)]
        headers = [f"x{i + 1}" for i in range(self.n)]
        coefficient_table = tabulate(coefficient_matrix, headers, tablefmt="fancy_grid")
        constants_table = tabulate(constants_vector, ["b"], tablefmt="fancy_grid")

        print("\n————— Current Coefficient Matrix A —————\n")
        print(coefficient_table)
        print("\n————— Current Constants Vector b —————\n")
        print(constants_table)

        print("\n————— Intermediate Steps —————\n")
        for i in range(self.n):
            print(f"Row {i + 1}:")
            pivot_element = self.A[i][i]
            print(f"Divide Row {i + 1} by {pivot_element:.4f}")
            self.A[i] = [x / pivot_element for x in self.A[i]]
            self.b[i] /= pivot_element

            for j in range(i + 1, self.n):
                factor = self.A[j][i]
                print(f"Subtract {factor:.4f} times Row {i + 1} from Row {j + 1}")
                self.A[j] = [a - factor * b for a, b in zip(self.A[j], self.A[i])]
                self.b[j] -= factor * self.b[i]

            coefficient_table = tabulate(
                coefficient_matrix, headers, tablefmt="fancy_grid"
            )
            constants_table = tabulate(constants_vector, ["b"], tablefmt="fancy_grid")

            print("\nUpdated Coefficient Matrix A:")
            print(coefficient_table)
            print("\nUpdated Constants Vector b:")
            print(constants_table)

        print("\n")

    def display_solution(self):
        """Displays the solution of the system of linear equations."""
        print("\nSolution:")
        for i, sol in enumerate(self.x):
            print(f"x{i + 1} = {sol:.4f}", end="\t")
        print("\n")

    def solve(self):
        """Solves the system of linear equations."""
        self.input_data()
        self.display_original_equations()
        self.forward_elimination()
        self.backward_substitution()
        self.display_solution()


if __name__ == "__main__":
    n = UserInput.get_int("Enter the number of equations: ")
    solver = GaussianElimination(n)
    try:
        solver.solve()
    except GaussianEliminationError as e:
        print(f"Error: {e}")
