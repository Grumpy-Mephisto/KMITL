try:
    import sys
    import numpy as np
except ImportError:
    print("NumPy is not installed. Please install NumPy before running this script.")
    sys.exit(1)


class Vector:
    """คลาส Vector สำหรับแทนเวกเตอร์"""

    def __init__(self, vector) -> None:
        """
        กำหนดค่าเริ่มต้นของวัตถุ Vector

        Args:
            vector (any): รายการของค่าเวกเตอร์
        """
        self.vector = np.array(vector)

    def __str__(self) -> str:
        """
        แสดงค่าเวกเตอร์เป็นสตริง

        Returns:
            str: ค่าเวกเตอร์เป็นสตริง
        """
        return str(self.vector)


class VectorMethod:
    """คลาสสำหรับการดำเนินการเวกเตอร์"""

    def __init__(self, vector: Vector) -> None:
        """
        กำหนดค่าเริ่มต้นของวัตถุ VectorMethod

        Args:
            vector (Vector): วัตถุ Vector
        """
        if not isinstance(vector, Vector):
            raise ValueError("Input must be a Vector object")
        self.vector = vector.vector

    @staticmethod
    def add(vec1: Vector, vec2: Vector) -> Vector:
        """
        การบวกเวกเตอร์สองเวกเตอร์

        Args:
            vec1 (Vector): เวกเตอร์แรก
            vec2 (Vector): เวกเตอร์ที่สอง

        Returns:
            Vector: ผลลัพธ์ของการบวกเวกเตอร์
        """
        return Vector(np.add(vec1.vector, vec2.vector))

    @staticmethod
    def subtract(vec1: Vector, vec2: Vector) -> Vector:
        """
        การลบเวกเตอร์สองเวกเตอร์

        Args:
            vec1 (Vector): เวกเตอร์แรก
            vec2 (Vector): เวกเตอร์ที่สอง

        Returns:
            Vector: ผลลัพธ์ของการลบเวกเตอร์
        """
        return Vector(np.subtract(vec1.vector, vec2.vector))

    @staticmethod
    def dot_product(vec1: Vector, vec2: Vector) -> float:
        """
        คำนวณผลลัพธ์จากการคูณเวกเตอร์สองเวกเตอร์แบบสเกลาร์

        Args:
            vec1 (Vector): เวกเตอร์แรก
            vec2 (Vector): เวกเตอร์ที่สอง

        Returns:
            float: ผลลัพธ์จากการคูณเวกเตอร์สองเวกเตอร์แบบสเกลาร์
        """
        return np.dot(vec1.vector, vec2.vector)

    @staticmethod
    def cross_product(vec1: Vector, vec2: Vector) -> Vector:
        """
        คำนวณผลลัพธ์จากการคูณเวกเตอร์สองเวกเตอร์แบบเวกเตอร์

        Args:
            vec1 (Vector): เวกเตอร์แรก
            vec2 (Vector): เวกเตอร์ที่สอง

        Returns:
            Vector: ผลลัพธ์จากการคูณเวกเตอร์สองเวกเตอร์แบบเวกเตอร์
        """
        return Vector(np.cross(vec1.vector, vec2.vector))

    @staticmethod
    def elementwise_multiply(vec1: Vector, vec2: Vector) -> Vector:
        """
        คูณเวกเตอร์สองเวกเตอร์แบบสมาชิก

        Args:
            vec1 (Vector): เวกเตอร์แรก
            vec2 (Vector): เวกเตอร์ที่สอง

        Returns:
            Vector: ผลลัพธ์จากการคูณเวกเตอร์สองเวกเตอร์แบบสมาชิก
        """
        return Vector(np.multiply(vec1.vector, vec2.vector))

    @staticmethod
    def elementwise_divide(vec1: Vector, vec2: Vector) -> Vector:
        """
        หารเวกเตอร์สองเวกเตอร์แบบสมาชิก

        Args:
            vec1 (Vector): เวกเตอร์แรก
            vec2 (Vector): เวกเตอร์ที่สอง

        Returns:
            Vector: ผลลัพธ์จากการหารเวกเตอร์สองเวกเตอร์แบบสมาชิก
        """
        if np.any(vec2.vector == 0):
            raise ValueError("Division by zero is not allowed")
        return Vector(np.divide(vec1.vector, vec2.vector))

    @staticmethod
    def magnitude(vector: Vector) -> float:
        """
        คำนวณความยาวของเวกเตอร์

        Args:
            vector (Vector): เวกเตอร์

        Returns:
            float: ความยาวของเวกเตอร์
        """
        return np.sqrt(VectorMethod.dot_product(vector, vector))


if __name__ == "__main__":
    u = Vector([2, -5, 7])  # u = 2i - 5j + 7k
    v = Vector([-1, 4, -3])  # v = -i + 4j - 3k
    w = Vector([5, 2, 4])  # w = 5i + 2j + 4k

    # Perform vector operations
    a = VectorMethod.add(u, v)  # a = u + v
    b = VectorMethod.elementwise_multiply(u, v)  # b = u * v
    c = VectorMethod.dot_product(u, v)  # c = u • v
    d = VectorMethod.cross_product(u, v)  # d = u x v
    e = VectorMethod.dot_product(a, u)  # e = (u + v) • u
    f = VectorMethod.cross_product(VectorMethod.subtract(u, v), v)  # f = (u - v) x v
    g = VectorMethod.elementwise_divide(
        VectorMethod.subtract(v, u),
        Vector([VectorMethod.magnitude(u)]),
    )  # g = (v - u) / sqr(u • u)
    h = VectorMethod.elementwise_multiply(
        Vector([VectorMethod.dot_product(u, v) / VectorMethod.dot_product(v, v)]), w
    )  # h = ((u • v) / (v • v)) * w

    # Print results
    print(f"a = {a}")
    print(f"b = {b}")
    print(f"c = {c}")
    print(f"d = {d}")
    print(f"e = {e}")
    print(f"f = {f}")
    print(f"g = {g}")
    print(f"h = {h}")
