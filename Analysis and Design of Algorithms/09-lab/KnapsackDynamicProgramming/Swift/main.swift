import Foundation

struct Item {
    var weight: Int
    var profit: Int
}

func knapsack(items: [Item], capacity: Int) -> Int {
    let n = items.count
    var dp = [[Int]](repeating: [Int](repeating: 0, count: capacity + 1), count: n + 1)

    for i in 1...n {
        for w in 1...capacity {
            if items[i - 1].weight <= w {
                dp[i][w] = max(dp[i - 1][w], items[i - 1].profit + dp[i - 1][w - items[i - 1].weight])
            } else {
                dp[i][w] = dp[i - 1][w]
            }
        }
    }

    return dp[n][capacity]
}

func max(_ a: Int, _ b: Int) -> Int {
    return a > b ? a : b
}

func dynamicProgrammingTable(items: [Item], capacity: Int) -> [[Int]] {
    let n = items.count
    var dp = [[Int]](repeating: [Int](repeating: 0, count: capacity + 1), count: n + 1)

    for i in 1...n {
        for w in 1...capacity {
            if items[i - 1].weight <= w {
                dp[i][w] = max(dp[i - 1][w], items[i - 1].profit + dp[i - 1][w - items[i - 1].weight])
            } else {
                dp[i][w] = dp[i - 1][w]
            }
        }
    }

    return dp
}

func printTable(table: [[Int]]) {
    print("🏓 Dynamic Programming Table:")
    for row in table {
        for val in row {
            print(String(format: "%5d", val), terminator: "")
        }
        print()
    }
}

func nameToOneHot(name: String) throws -> [Int] {
    let name = name.uppercased()
    guard !name.isEmpty else {
        throw NSError(domain: "NameToOneHot", code: 1, userInfo: [NSLocalizedDescriptionKey: "Empty result for name: \(name)"])
    }

    return name.compactMap { Int($0.asciiValue! - Character("A").asciiValue! + 1) }
}

let name = "Noppako"
do {
    let oneHot = try nameToOneHot(name: name)
    print("🔥 One-Hot Encoding for name: \(name) to \(oneHot)")

    let items = [
        Item(weight: 4, profit: oneHot[0]),
        Item(weight: 10, profit: oneHot[1]),
        Item(weight: 6, profit: oneHot[2]),
        Item(weight: 9, profit: oneHot[3]),
        Item(weight: 8, profit: oneHot[4]),
        Item(weight: 1, profit: oneHot[5]),
        Item(weight: 20, profit: oneHot[6])
    ]
    let capacity = 19
    print("🎒 Items: \(items), Capacity: \(capacity)")

    let result = knapsack(items: items, capacity: capacity)
    print("🏋️ Maximum Profit that can be obtained is: \(result)")

    let dpTable = dynamicProgrammingTable(items: items, capacity: capacity)
    printTable(table: dpTable)
} catch {
    print("Error: \(error)")
}
