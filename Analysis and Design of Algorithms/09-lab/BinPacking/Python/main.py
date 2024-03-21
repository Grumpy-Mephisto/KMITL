def first_fit(items, bin_capacity):
    bins = []
    for item in items:
        fitted = False  # Flag to check if item is fitted
        for bin in bins:
            if bin["capacity"] >= item:  # bin.capacity is the remaining capacity
                bin["items"].append(item)  # Add item to bin
                bin["capacity"] -= item  # Update remaining capacity
                fitted = True
                break

        if not fitted:
            bins.append(
                {"capacity": bin_capacity - item, "items": [item]}
            )  # Create new bin

    return bins


def best_fit(items, bin_capacity):
    bins = []
    for item in items:
        best_fit_index = -1
        min_remaining_capacity = bin_capacity + 1  # Initialize with a large value
        for i, bin in enumerate(bins):
            remaining_capacity = (
                bin["capacity"] - item
            )  # Remaining capacity after adding item
            if remaining_capacity >= 0 and remaining_capacity < min_remaining_capacity:
                best_fit_index = i
                min_remaining_capacity = remaining_capacity
        if best_fit_index != -1:
            bins[best_fit_index]["items"].append(item)  # Add item to bin
            bins[best_fit_index]["capacity"] -= item  # Update remaining capacity
        else:
            bins.append({"capacity": bin_capacity - item, "items": [item]})
    return bins


def first_fit_decreasing(items, bin_capacity):
    items.sort(reverse=True)  # Sort items in decreasing order
    return first_fit(items, bin_capacity)


def print_bins(bins):
    for i, bin in enumerate(bins):
        print(f"  • Bin {i+1} (Capacity {bin['capacity']}): {bin['items']}")


def name_to_one_hot(name):
    return [sum(divmod(ord(char) - ord("A") + 1, 10)) for char in name.upper()]


def main():
    name = "Noppakorn"
    items = name_to_one_hot(name)
    bin_capacity = 10

    print("😣 Name:", name)
    print("📦 Items:", items)
    print("📏 Bin Capacity:", bin_capacity)

    # First Fit
    first_fit_bins = first_fit(items, bin_capacity)
    print("\n🥇 First Fit:")
    print_bins(first_fit_bins)

    # Best Fit
    best_fit_bins = best_fit(items, bin_capacity)
    print("\n🥈 Best Fit:")
    print_bins(best_fit_bins)

    # First Fit Decreasing (FFD)
    ffd_bins = first_fit_decreasing(items, bin_capacity)
    print("\n🥉 First Fit Decreasing:")
    print_bins(ffd_bins)


if __name__ == "__main__":
    main()
