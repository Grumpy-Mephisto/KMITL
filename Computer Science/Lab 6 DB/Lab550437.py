import mysql.connector
myDB = mysql.connector.connect(
    host="remotemysql.com",
    user="bPHiiRCWTe",
    passwd="Ftl2nnrmAp",
    database="bPHiiRCWTe"
)
print('connected!')
cursor = myDB.cursor()

# Activity 1.3
cursor.execute("SELECT * FROM characters  WHERE animeFK = 12")
for x in cursor:
    print(x[0], x, sep=" ")

# Activity 1.4
sql = "Insert into characters (id, fname, lname, popularity, animeFK) Values (%s, %s, %s, %s, %s)"
val = (504371, "Noppakorn", "Kaewsalabnil", 1, 12)
# cursor.execute(sql, val)
# myDB.commit()
print('Insert Success!!')

# Activity 1.5
cursor.execute(
    "SELECT * FROM anime INNER JOIN characters ON anime.id = characters.animeFK WHERE title = 'karakai-jouzu-no-takagi-san'")
for x in cursor:
    print(x[0], x, sep=" ")

# Close SQL
cursor.close()
myDB.close()
