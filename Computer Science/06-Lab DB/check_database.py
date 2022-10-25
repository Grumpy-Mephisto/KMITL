import mysql.connector
my_con = mysql.connector.connect(
    host="remotemysql.com",
    user="bPHiiRCWTe",
    passwd="Ftl2nnrmAp",
    database="bPHiiRCWTe"
)
print('connected!')
cursor = my_con.cursor()

print('\nprinting character names showing only lastname')
cursor.execute("SELECT * FROM characters")
for x in cursor:
    id = x[0]
    print(id, x[2], sep=" ")

print('\nprinting anime names')
cursor.execute("SELECT * FROM anime")
for y in cursor:
    id = y[0]
    print(id, y[1], sep=" ")

cursor.close()
my_con.close()
