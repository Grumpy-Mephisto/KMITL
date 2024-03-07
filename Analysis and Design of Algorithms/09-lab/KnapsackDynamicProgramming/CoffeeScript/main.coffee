class Item
  constructor: (@weight, @profit) ->

# Calculates the maximum profit that can be achieved within the given capacity.
# Args:
#   items: list - List of 'Item' objects representing the available items.
#   capacity: int - Maximum capacity of the knapsack.
# Returns:
#   int - Maximum achievable profit within the given capacity.
knapsack = (items, capacity) ->
  n = items.length
  dp = new Array(n + 1)
  for i in [0..n]
    dp[i] = new Array(capacity + 1).fill(0)

  for i in [1..n]
    for w in [1..capacity]
      if items[i-1].weight <= w
        dp[i][w] = Math.max(dp[i-1][w], items[i-1].profit + dp[i-1][w - items[i-1].weight])
      else
        dp[i][w] = dp[i-1][w]

  dp[n][capacity]

# Returns the maximum of two numbers.
# Args:
#   a: int - First number.
#   b: int - Second number.
# Returns:
#   int - Maximum of the two numbers.
max = (a, b) ->
  if a > b then a else b

# Creates a dynamic programming table for the given items and capacity.
# Args:
#   items: list - List of 'Item' objects representing the available items.
#   capacity: int - Maximum capacity of the knapsack.
# Returns:
#   list - 2D list representing the dynamic programming table.
dynamicProgrammingTable = (items, capacity) ->
  n = items.length
  dp = new Array(n + 1)
  for i in [0..n]
    dp[i] = new Array(capacity + 1).fill(0)

  for i in [1..n]
    for w in [1..capacity]
      if items[i-1].weight <= w
        dp[i][w] = Math.max(dp[i-1][w], items[i-1].profit + dp[i-1][w - items[i-1].weight])
      else
        dp[i][w] = dp[i-1][w]

  dp

# Prints the dynamic programming table.
# Args:
#   table: list - 2D list representing the dynamic programming table.
# Returns:
#   None
printTable = (table) ->
  console.log "🏓 Dynamic Programming Table:"
  
  for i, row in table
    console.log String(i).padStart(5) + (String(val).padStart(5) for val in row).join("")

# Encodes the input name to a one-hot vector.
# Args:
#   name: str - Input name to be encoded.
# Returns:
#   list - Encoded one-hot vector for the input name.
nameToOneHot = (name) ->
  result = []
  name = name.toUpperCase()
  for char in name
    order = char.charCodeAt(0) - "A".charCodeAt(0) + 1
    result.push(order) if order > 0
  throw "empty result for name: #{name}" if result.length == 0
  result

name = "Noppako"
try
  oneHot = nameToOneHot(name)
  console.log "🔥 One-Hot Encoding for name: #{name} to #{oneHot}"

  items = [
    new Item(4, oneHot[0])
    new Item(10, oneHot[1])
    new Item(6, oneHot[2])
    new Item(9, oneHot[3])
    new Item(8, oneHot[4])
    new Item(1, oneHot[5])
    new Item(20, oneHot[6])
  ]
  capacity = 19
  console.log "🎒 Items: #{JSON.stringify(items)}, Capacity: #{capacity}"

  result = knapsack(items, capacity)
  console.log "🏋️ Maximum Profit: #{result}"

  dpTable = dynamicProgrammingTable(items, capacity)
  printTable(dpTable)
catch error
  # Handles and logs the error message.
# Args:
#   error: str - Error message to be handled and logged.
# Returns:
#   None
console.log "Error: #{error}"
