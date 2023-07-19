import matplotlib.pyplot as plt

data = '''
Method: isPrime0
N               Count           Time (ms)
100,000         9,592           39
200,000         17,984          112
300,000         25,997          218
400,000         33,860          383
500,000         41,538          603
600,000         49,098          824
700,000         56,543          1,216
800,000         63,951          1,511
900,000         71,274          1,867
1,000,000       78,498          2,261

Method: isPrime1
N               Count           Time (ms)
100,000         9,592           11
200,000         17,984          10
300,000         25,997          5
400,000         33,860          5
500,000         41,538          5
600,000         49,098          5
700,000         56,543          7
800,000         63,951          9
900,000         71,274          9
1,000,000       78,498          11

Method: isPrime2
N               Count           Time (ms)
100,000         9,592           8
200,000         17,984          8
300,000         25,997          9
400,000         33,860          23
500,000         41,538          5
600,000         49,098          7
700,000         56,543          7
800,000         63,951          7
900,000         71,274          11
1,000,000       78,498          10
'''

def parse_data(data):
    method_data = {}
    method_lines = data.strip().split('Method: ')
    for method_line in method_lines[1:]:
        lines = method_line.strip().split('\n')
        method_name = lines[0].strip()
        method_data[method_name] = {'N': [], 'Count': [], 'Time (ms)': []}
        for line in lines[2:]:
            n, count, time_ms = line.strip().split()
            method_data[method_name]['N'].append(int(n.replace(',', '')))
            method_data[method_name]['Count'].append(int(count.replace(',', '')))
            method_data[method_name]['Time (ms)'].append(int(time_ms.replace(',', '')))
    return method_data

method_data = parse_data(data)

plt.figure(figsize=(10, 6))

for method_name, method_stats in method_data.items():
    plt.plot(method_stats['N'], method_stats['Time (ms)'], label=f"{method_name}")

plt.xticks(range(100000, 1100000, 100000), [f"{x:,}" for x in range(100000, 1100000, 100000)])
plt.xlabel("N (Range 100,000 to 1,000,000)")
plt.ylabel("Time (ms)")
plt.title("Prime Number Counting Execution Time Comparison")
plt.legend()
plt.grid(True)

plt.tight_layout()
plt.savefig("prime_comparison_chart.png")
plt.show()
