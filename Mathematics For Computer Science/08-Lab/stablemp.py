check_table = int(input())

while check_table:
    # receive the number of Men and Women
    n = int(input())

    # create marriage list
    marriages = []
    for j in range(n):
        marriages.append(-1)

    # create Men and Women list
    men = []
    women = []
    # Men list
    for i in range(n):
        # split the input
        men_value = list(map(int, input().split()))
        # remove the first element (position)
        men_value.pop(0)
        men.append(men_value)
    # Women list
    for i in range(n):
        # split the input
        women_value = list(map(int, input().split()))
        # remove the first element (position)
        women_value.pop(0)
        women.append(women_value)

    # create free_men list
    free_men = []
    for i in range(n):
        # Add the position
        free_men.append(i+1)

    # create proposal list
    proposal = []
    for i in range(n):
        proposal.append(0)

    # check stable marriage
    while len(free_men) > 0:  # check singles
        man = free_men.pop()  # get the first single
        proposal_to = men[man-1][proposal[man-1]]  # get the first proposal
        proposal[man-1] += 1  # update the proposal
        index = proposal_to-1  # get the index
        if marriages[index] == -1:  # check marriage list
            marriages[index] = man  # update the marriage list
        elif women[index].index(marriages[index]) < women[index].index(man):
            free_men.insert(len(free_men), man)  # update the free_men list
        else:
            old_poppy = marriages[index]  # get the old_poppy position
            marriages[index] = man  # update the marriage list
            # update the free_men list
            free_men.insert(len(free_men), old_poppy)

    # print the result
    for i in range(n):
        print(i+1, marriages[i])

    # check the next table
    check_table = check_table-1
