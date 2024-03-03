import Foundation

struct Bin {
    var id: Int
    var capacity: Int
    var items: [Int]
}

func firstFit(items: [Int], binCapacity: Int) -> [Bin] {
    var bins = [Bin]()

    for item in items {
        var fitted = false

        for i in bins.indices {
            if bins[i].capacity >= item {
                bins[i].items.append(item)
                bins[i].capacity -= item
                fitted = true
                break
            }
        }

        if !fitted {
            let newBin = Bin(
                id: bins.count + 1,
                capacity: binCapacity - item,
                items: [item]
            )
            bins.append(newBin)
        }
    }

    return bins
}

func bestFit(items: [Int], binCapacity: Int) -> [Bin] {
    var bins = [Bin]()

    for item in items {
        var bestFitIndex = -1
        var minRemainingCapacity = binCapacity + 1

        for i in bins.indices {
            let remainingCapacity = bins[i].capacity - item
            if remainingCapacity >= 0 && remainingCapacity < minRemainingCapacity {
                bestFitIndex = i
                minRemainingCapacity = remainingCapacity
            }
        }

        if bestFitIndex != -1 {
            bins[bestFitIndex].items.append(item)
            bins[bestFitIndex].capacity -= item
        } else {
            let newBin = Bin(
                id: bins.count + 1,
                capacity: binCapacity - item,
                items: [item]
            )
            bins.append(newBin)
        }
    }

    return bins
}

func firstFitDecreasing(items: [Int], binCapacity: Int) -> [Bin] {
    let sortedItems = items.sorted(by: >)
    return firstFit(items: sortedItems, binCapacity: binCapacity)
}

func printBins(bins: [Bin]) {
    for bin in bins {
        print("  • Bin \(bin.id) (Capacity \(bin.capacity)): \(bin.items)")
    }
}

func nameToOneHot(name: String) -> [Int] {
    var result = [Int]()

    let uppercasedName = name.uppercased()

    for char in uppercasedName {
        var order = Int(char.asciiValue! - Character("A").asciiValue! + 1)

        if order >= 10 {
            order = order / 10 + order % 10
        }

        result.append(order)
    }

    return result
}

let name = "Noppakorn"
let items = nameToOneHot(name: name)
let binCapacity = 10

print("😣 Name: \(name)")
print("📦 Items: \(items)")
print("📏 Bin Capacity: \(binCapacity)")

// First Fit
let firstFitBins = firstFit(items: items, binCapacity: binCapacity)
print("\n🥇 First Fit:")
printBins(bins: firstFitBins)

// Best Fit
let bestFitBins = bestFit(items: items, binCapacity: binCapacity)
print("\n🥈 Best Fit:")
printBins(bins: bestFitBins)

// First Fit Decreasing (FFD)
let ffdBins = firstFitDecreasing(items: items, binCapacity: binCapacity)
print("\n🥉 First Fit Decreasing:")
printBins(bins: ffdBins)
