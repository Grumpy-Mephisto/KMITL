#!/usr/bin/env coffeescript

mutipleMatrix = (a, b) ->
  result = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
  for i in [0...a.length]
    for j in [0...b[0].length]
      for k in [0...b.length]
        result[i][j] += a[i][k] * b[k][j]
  result

printMatrix = (equation, matrix) ->
  console.log("Matrix #{equation}")
  for i in [0...matrix.length]
    for j in [0...matrix[0].length]
      console.log("#{matrix[i][j]} ", end="")
    console.log()

main = ->
  a = [[2, 3, 4], [3, 4, 5], [1, 3, 3]]
  b = [[3, 4, 1], [7, 2, 4], [3, 8, 6]]
  printMatrix("A ", a)
  printMatrix("B ", b)
  printMatrix("A x B ", mutipleMatrix(a, b))
  printMatrix("B x A ", mutipleMatrix(b, a))

main()
