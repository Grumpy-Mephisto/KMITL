from statistics import median


class TextColor:
    GREEN = '\033[92m'
    RED = '\033[91m'
    END = '\033[0m'


def init():
    global num, k, num, data, num_collector


def Subtract(data, i, num):
    if data[num - 1 - i] / 3 == 1:
        data[num - 1 - i] = 0
        data[num - 2 - i] = data[num - 2 - i] + 1


def Solve(data, num, num_collector):
    for i in range(3 ** num):
        clone_array = data.copy()
        clone_array.sort()
        if median(clone_array) == 1:
            num_collector = num_collector + 1

        if data[int(num / 2)] == 1:
            print(f'{TextColor.GREEN}{data}{TextColor.END}')
        else:
            print(f'{data}')

        data[num - 1] = data[num - 1] + 1
        for i in range(num - 1):
            Subtract(data, i, num)

    return num_collector


def main():
    k = int(input("Enter number of digits: "))
    num = (2 * k) + 1
    data = [0] * num
    num_collector = 0
    solve = Solve(data, num, num_collector)
    print(
        f'Probability of getting a reference from the middle is {TextColor.GREEN}{solve}{TextColor.END}/{TextColor.RED}{(3**num)}{TextColor.END}')


if __name__ == "__main__":
    init()
    main()
