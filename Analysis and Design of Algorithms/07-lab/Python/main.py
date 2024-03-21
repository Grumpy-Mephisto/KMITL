def find_subsets(nums, target_sum):
    N = 1 << len(nums) # 2^len(nums)
    print("index\tx\treverseX\tSum")
    
    for index in range(N):
        total = sum(nums[j] for j in range(len(nums)) if (index >> j) & 1) # shift index by j (0 to len(nums)); iterate through each bit
        binary = format(index, f'0{len(nums)}b')
        reversed_binary = binary[::-1]
        marker = "📌" if total == target_sum else ""
        print(f"{index}\t{binary}\t{reversed_binary}\t\t{total}{marker}")
    
def main():
    nums = [11, 13, 3, 7]
    target_sum = nums[1] + nums[2] + nums[3]

    print("Student ID: 65050437")
    print("Target Sum:", target_sum)
    find_subsets(nums, target_sum)

if __name__ == "__main__":
    main()