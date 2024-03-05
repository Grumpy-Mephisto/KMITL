class Item
  constructor: (@weight, @profit) ->

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

max = (a, b) ->
  if a > b then a else b

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

printTable = (table) ->
  console.log "🏓 Dynamic Programming Table:"
  
  for i, row in table
    console.log String(i).padStart(5) + (String(val).padStart(5) for val in row).join("")

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
  console.log "Error: #{error}"
