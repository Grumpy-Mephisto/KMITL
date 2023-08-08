#!/usr/bin/env python3


import pytest
from matrix import Matrix


@pytest.fixture
def matrix_constructor():
    matrix_string = "2 3 4 5\n3 4 3 7\n1 3 7 8\n2 3 4 5"
    return Matrix(matrix_string)


def test_matrix_constructor(matrix_constructor):
    expected_matrix = [[2, 3, 4, 5], [3, 4, 3, 7], [1, 3, 7, 8], [2, 3, 4, 5]]
    assert matrix_constructor.matrix == expected_matrix


def test_create_matrix():
    matrix = Matrix.create(3, 3)
    assert matrix == [[0, 0, 0], [0, 0, 0], [0, 0, 0]]


def test_determinant(matrix_constructor):
    det = Matrix.determinant(matrix_constructor.matrix)
    assert det == 0


def test_minor(matrix_constructor):
    minor = Matrix.minor(matrix_constructor.matrix, 0, 0)
    assert minor == [[4, 3, 7], [3, 7, 8], [3, 4, 5]]


def test_multiply(matrix_constructor):
    multiplied = Matrix.multiply(matrix_constructor.matrix, 2)
    assert multiplied == [[4, 6, 8, 10], [6, 8, 6, 14], [2, 6, 14, 16], [4, 6, 8, 10]]


def test_transpose(matrix_constructor):
    transposed = Matrix.transpose(matrix_constructor.matrix)
    assert transposed == [[2, 3, 1, 2], [3, 4, 3, 3], [4, 3, 7, 4], [5, 7, 8, 5]]


def test_cofactor(matrix_constructor):
    cofactor = Matrix.cofactor(matrix_constructor.matrix, 0, 0)
    assert cofactor == -24


def test_inverse(matrix_constructor):
    inverse = Matrix.inverse(matrix_constructor.matrix)
    assert inverse is None


def test_square(matrix_constructor):
    assert Matrix.square(matrix_constructor.matrix) == True


def test_square_false():
    matrix = Matrix.create(3, 4)
    assert Matrix.square(matrix) == False
