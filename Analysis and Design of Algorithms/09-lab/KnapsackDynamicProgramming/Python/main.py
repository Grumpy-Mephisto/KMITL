def knapsack(items, capacity):
    n = len(items)
    dp = [
        [0] * (capacity + 1) for _ in range(n + 1)
    ]  # specify the maximum value for each item and capacity

    for i in range(1, n + 1):
        for w in range(1, capacity + 1):
            if items[i - 1][0] <= w:
                dp[i][w] = max(
                    dp[i - 1][w], dp[i - 1][w - items[i - 1][0]] + items[i - 1][1]
                )  # if the weight of the item is less than the capacity, we can either take the item or not
            else:
                dp[i][w] = dp[i - 1][
                    w
                ]  # if the weight of the item is greater than the capacity, we can't take the item

    return dp[n][capacity]


def dynamic_programming_table(items, capacity):
    n = len(items)
    dp = [[0] * (capacity + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        for w in range(1, capacity + 1):
            if items[i - 1][0] <= w:
                dp[i][w] = max(
                    dp[i - 1][w], items[i - 1][1] + dp[i - 1][w - items[i - 1][0]]
                )
            else:
                dp[i][w] = dp[i - 1][w]

    return dp


def print_table(table):
    print("🏓 Dynamic Programming Table:")
    for row in table:
        print("".join(f"{val:5}" for val in row))


def name_to_one_hot(name):
    return [ord(char) - ord("A") + 1 for char in name.upper()]


def main():
    name = "Noppako"
    one_hot = name_to_one_hot(name)
    print(f"🔥 One-Hot Encoding for name: {name} to {one_hot}")

    items = [
        (4, one_hot[0]),
        (10, one_hot[1]),
        (6, one_hot[2]),
        (9, one_hot[3]),
        (8, one_hot[4]),
        (1, one_hot[5]),
        (20, one_hot[6]),
    ]
    capacity = 19
    print(f"🎒 Items: {items}, Capacity: {capacity}")

    result = knapsack(items, capacity)
    print(f"🏋️ Maximum Profit: {result}")

    dp_table = dynamic_programming_table(items, capacity)
    print_table(dp_table)


if __name__ == "__main__":
    main()
