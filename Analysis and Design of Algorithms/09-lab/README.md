<div align="center">
    <h1><code>🗑️</code> Bin packing problem</h1>
    <p>
        <strong>Bin packing problem</strong> is a combinatorial optimization problem in which items of different sizes must be packed into a finite number of bins or containers each with a fixed capacity. The objective is to pack the items in a way that minimizes the number of bins used.
    </p>
    <p>
        <img src="preview-go.png" alt="Bin packing problem" />
        <img src="preview-swift.png" alt="Bin packing problem" />
    </p>
</div>

## 😣 Name Spelled

|          | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   |
| -------- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Name     | N   | O   | P   | P   | A   | K   | O   | R   | N   |
| Sequence | 14  | 15  | 16  | 16  | 1   | 11  | 15  | 18  | 14  |
| One hot  | 5   | 6   | 7   | 7   | 1   | 2   | 6   | 9   | 5   |

## 📝 Ways to Solve

### First Fit Algorithm

The first-fit algorithm places each item into the first bin in which it will fit. If there is no available bin, a new bin is opened. This algorithm is fast and simple, but it is not guaranteed to produce an optimal solution.

### Best Fit Algorithm

The best-fit algorithm places each item into the bin which will leave the least room left over after the item is packed. This algorithm is also not guaranteed to produce an optimal solution.

### First Fit Decreasing Algorithm (FFD)

The first-fit decreasing algorithm is a variation of the first-fit algorithm. It first sorts the items in decreasing order, then uses the first-fit algorithm to pack the items. This algorithm is guaranteed to produce a solution that is at most 11/9 OPT + 6/9, where OPT is the optimal number of bins.

## 📚 References

- [Wikipedia](https://en.wikipedia.org/wiki/Bin_packing_problem) - Bin packing problem on Wikipedia
- [GeeksforGeeks](https://www.geeksforgeeks.org/bin-packing-problem-minimize-number-of-used-bins/) - Bin packing problem to minimize number of used bins
