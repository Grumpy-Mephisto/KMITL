import matplotlib.pyplot as plt

data = '''
Method: isPrime0
N               Count           Time (ms)
100,000         9,592           158
200,000         17,984          569
300,000         25,997          1,233
400,000         33,860          2,148
500,000         41,538          3,308
600,000         49,098          4,705
700,000         56,543          6,375
800,000         63,951          10,484
900,000         71,274          13,444
1,000,000       78,498          14,583

Method: isPrime1
N               Count           Time (ms)
100,000         9,592           4
200,000         17,984          8
300,000         25,997          8
400,000         33,860          11
500,000         41,538          14
600,000         49,098          18
700,000         56,543          22
800,000         63,951          26
900,000         71,274          33
1,000,000       78,498          37

Method: isPrime2
N               Count           Time (ms)
100,000         9,592           4
200,000         17,984          6
300,000         25,997          8
400,000         33,860          11
500,000         41,538          13
600,000         49,098          18
700,000         56,543          22
800,000         63,951          26
900,000         71,274          31
1,000,000       78,498          36
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

# N vs isPrime0
plt.plot(method_data['isPrime0']['N'], method_data['isPrime0']['Time (ms)'], label="isPrime0")

plt.xticks(range(100000, 1100000, 100000), [f"{x:,}" for x in range(100000, 1100000, 100000)])
plt.xlabel("N (Range 100,000 to 1,000,000)")
plt.ylabel("Time (ms)")
plt.title("Prime Number Counting Execution Time Comparison (isPrime0)")
plt.legend()
plt.grid(True)

plt.tight_layout()
plt.savefig("isPrime0_comparison_chart.png")
plt.show()

# N vs isPrime1 vs isPrime2
plt.figure(figsize=(10, 6))

plt.plot(method_data['isPrime1']['N'], method_data['isPrime1']['Time (ms)'], label="isPrime1")
plt.plot(method_data['isPrime2']['N'], method_data['isPrime2']['Time (ms)'], label="isPrime2")

plt.xticks(range(100000, 1100000, 100000), [f"{x:,}" for x in range(100000, 1100000, 100000)])
plt.xlabel("N (Range 100,000 to 1,000,000)")
plt.ylabel("Time (ms)")
plt.title("Prime Number Counting Execution Time Comparison (isPrime1 vs isPrime2)")
plt.legend()
plt.grid(True)

plt.tight_layout()
plt.savefig("isPrime1_isPrime2_comparison_chart.png")
plt.show()
