import random
import math
import time
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

r = 2.0
N = 5000
d = {"Trials": [], "Pi": []}

for S in range(1, N):
    circle_p = 0
    for i in range(S):
        x = random.uniform(-r, r)
        y = random.uniform(-r, r)

        x_2 = x**2
        y_2 = y**2

        if math.sqrt(x_2 + y_2) <= r:
            circle_p += 1

    d["Trials"].append(S)
    d["Pi"].append(4 * circle_p / S)

df = pd.DataFrame(d)
plt.figure(figsize=(10, 7))
sns.set_style("darkgrid")

while True:
    print("""Select the plot you want to see:
    1. Scatter Plot
    2. Histogram
    3. Exit""")
    choice = int(input("Enter your choice: "))
    if choice == 1:
        choice = "Scatter"
        scatter = sns.scatterplot(
            x="Trials", y="Pi", s=30, marker="o", data=df)
        scatter.set(title='Monte Carlo Simulation to Estimate Value of Pi',
                    xlabel="Number of Trials", ylabel="Value of Pi")
        plt.axhline(y=3.14, color='r', linestyle='-')
        break
    elif choice == 2:
        choice = "Histogram"
        histogram = sns.histplot(
            data=df, x="Pi", color="#003", stat="density")
        histogram.set(xlabel="Value of Pi", ylabel="Count")
        break
    elif choice == 3:
        break
    else:
        print("Invalid input. Try again!")
        print("\033[H\033[J")

save = input("\nDo you want to save the plot? (y/n): ")
if save == "y":
    plt.savefig(f"Plot-{choice}.png")
    print("Plot saved successfully!")
else:
    print("Plot not saved!")

time.sleep(3)

plt.show()

# Author: 65050437
