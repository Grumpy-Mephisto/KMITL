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
        for pivot_row in range(self.n):
            pivot = self.A[pivot_row][pivot_row]
            if pivot == 0:
                raise GaussianEliminationError(
                    "Zero pivot encountered. The matrix may be singular."
                )

            for row in range(pivot_row + 1, self.n):
                factor = self.A[row][pivot_row] / pivot
                for col in range(self.n):
                    self.A[row][col] -= factor * self.A[pivot_row][col]
                self.b[row] -= factor * self.b[pivot_row]

            self.display_step(pivot_row)

    def backward_substitution(self):
        for i in range(self.n - 1, -1, -1):
            if self.A[i][i] == 0:
                raise GaussianEliminationError(
                    "No unique solution exists. The matrix is singular."
                )

            self.x[i] = self.b[i]
            for j in range(i + 1, self.n):
                self.x[i] -= self.A[i][j] * self.x[j]
            self.x[i] /= self.A[i][i]

    def display_original_equations(self):
        print("\nOriginal Equations:")
        for i in range(self.n):
            equation = " + ".join([f"{self.A[i][j]}x{j + 1}" for j in range(self.n)])
            print(f"{equation} = {self.b[i]}")
        print("\n")

    def display_step(self, step):
        print(f"Step {step + 1}:\n")
        for i in range(self.n):
            equation = " + ".join(
                [f"{self.A[i][j]:.4f}x{j + 1}" for j in range(self.n)]
            )
            equation += f" = {self.b[i]:.4f}"
            print(equation)
        print("\n")

    def display_solution(self):
        print("\nSolution:")
        for i, sol in enumerate(self.x):
            print(f"x{i + 1} = {sol:.4f}", end="\t")
        print("\n")

    def solve(self):
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
