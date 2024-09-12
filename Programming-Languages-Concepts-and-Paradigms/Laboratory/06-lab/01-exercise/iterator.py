salary_list = [50000, 60000, 55000, 70000]

itr = iter(salary_list)

while True:
    try:
        salary = next(itr)
        print(salary)
    except StopIteration:
        break
