class TextColor:
    GREEN = '\033[92m'
    RED = '\033[91m'
    END = '\033[0m'


def SwapListElements(List, position_1, position_2):
    List[position_1], List[position_2] = List[position_2], List[position_1]


def Partition(array, low, high):
    pivot = array[high]

    i = low - 1

    for j in range(low, high):
        if array[j] <= pivot:
            i = i + 1
            SwapListElements(array, i, j)
    SwapListElements(array, i + 1, high)

    return i+1


def QuickSort(array, low, high):
    while low < high:
        pi = Partition(array, low, high)
        QuickSort(array, low, pi - 1)
        low = pi + 1


def init():
    global data
    data = []
    # data = [3, 0, 11, 15, 19, 23, 27, 31, 1, 7]
    n = int(input("Enter number of elements : "))
    for i in range(0, n):
        element = int(input(f"Enter element {i + 1} : "))
        data.append(element)
    print(f'\n{TextColor.RED}Before sorting:\t{data}{TextColor.END}')


def main():
    QuickSort(data, 0, len(data) - 1)
    print(f'{TextColor.GREEN}After sorting:\t{data}{TextColor.END}')
    print(
        f'Probability of getting a reference from the middle is {1/(len(data))}')


if __name__ == "__main__":
    init()
    main()
