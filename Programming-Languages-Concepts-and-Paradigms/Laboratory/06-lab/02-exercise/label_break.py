temp = 0
found = False

for i in range(10):
    for j in range(10):
        temp = i * j
        if temp > 20:
            found = True
            break
    if found:
        break

print("temp =", temp)
