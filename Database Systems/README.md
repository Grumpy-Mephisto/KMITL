<div align="center">
    <h1><code>🏬</code> Database Systems</h1>
</div>

<div>
  <h1>Table of Contents</h1>
  <ul role="list" style="color: #ff0000;">
    <li data-icon="📚"><a href="#🧑‍💼-normalization">Normalization</a></li>
  </ul>
</div>

---

## `🧑‍💼` Normalization

| Normal Form | Description                                                                                        |
| ----------- | -------------------------------------------------------------------------------------------------- |
| 1NF         | A relation is in 1NF if and only if all data items are atomic values                               |
| 2NF         | A relation is in 2NF if and only if it is in 1NF and every non-key attribute is fully functionally |
| 3NF         | A relation is in 3NF if and only if it is in 2NF and every non-key attribute is non-transitively   |
| BCNF        | A relation is in BCNF if and only if it is in 3NF and every determinant is a candidate key         |
| 4NF         | A relation is in 4NF if and only if it is in BCNF and has no multi-valued dependencies             |
| 5NF         | A relation is in 5NF if and only if it is in 4NF and every join dependency is a consequence of key |

### `📄` Raw Data

**Supply Parts Database**

| S#  | SNAME | CITY   | STATUS | P#  | PNAME | COLOR | QTY |
| --- | ----- | ------ | ------ | --- | ----- | ----- | --- |
| S1  | Smith | London | 20     | P1  | Nut   | Red   | 200 |
| S2  | Jones | Paris  | 10     | P2  | Screw | Blue  | 400 |
|     |       |        |        | P5  | Cam   | Blue  | 100 |
| S3  | Blake | Paris  | 30     | P3  | Screw | Blue  | 200 |
|     |       |        |        | P4  | Screw | Red   | 500 |
| S4  | Clark | London | 20     | P6  | Cog   | Red   | 300 |
| S5  | Adams | Athens | 30     | P1  | Nut   | Red   | 100 |
|     |       |        |        | P2  | Bolt  | Green | 200 |
|     |       |        |        | P3  | Screw | Blue  | 200 |
|     |       |        |        | P4  | Screw | Red   | 800 |
|     |       |        |        | P5  | Cam   | Blue  | 500 |
|     |       |        |        | P6  | Cog   | Red   | 200 |

### `📚` First Normal Form (1NF)

- A relation **R** is in **1NF** if and only if all data items are atomic values
- ตารางใดที่มีคุณสมบัติ **1NF** จะต้องไม่มีกลุ่มซ้ำของ **Column** ในแต่ละ **Row**

**Supply Parts**

| S#  | SNAME | CITY   | STATUS | P#  | PNAME | COLOR | QTY |
| --- | ----- | ------ | ------ | --- | ----- | ----- | --- |
| S1  | Smith | London | 20     | P1  | Nut   | Red   | 200 |
| S2  | Jones | Paris  | 10     | P2  | Screw | Blue  | 400 |
| S2  | Jones | Paris  | 10     | P5  | Cam   | Blue  | 100 |
| S3  | Blake | Paris  | 30     | P3  | Screw | Blue  | 200 |
| S3  | Blake | Paris  | 30     | P4  | Screw | Red   | 500 |
| S4  | Clark | London | 20     | P6  | Cog   | Red   | 300 |
| S5  | Adams | Athens | 30     | P1  | Nut   | Red   | 100 |
| S5  | Adams | Athens | 30     | P2  | Bolt  | Green | 200 |
| S5  | Adams | Athens | 30     | P3  | Screw | Blue  | 200 |
| S5  | Adams | Athens | 30     | P4  | Screw | Red   | 800 |
| S5  | Adams | Athens | 30     | P5  | Cam   | Blue  | 500 |
| S5  | Adams | Athens | 30     | P6  | Cog   | Red   | 200 |

### `📚` Second Normal Form (2NF)

- A relation **R** is in **2NF** if and only if it is in **1NF** and every non-key attribute is **fully functionally dependent** on the primary key
- ตารางใดที่มีคุณสมบัติ **2NF** จะต้องมีคุณสมบัติ **1NF** และมีความสัมพันธ์ **Fully Functional Dependent** กับ **Primary Key**

> **NOTE**: **Functionally Dependency (FD)**

> **NOTE**: **Fully Functionally Dependency (FFD)** Functional depends on R.x and not on any proper subset of R.x - ค่า Y จะต้องขึ้นกับค่า X เท่านั้น และไม่ขึ้นกับค่าใดๆ ที่เป็นส่วนหนึ่งของ X เมื่อ X, Y ประกอบด้วย Column หลายๆ Column (ขอตัวมันจริงๆ เช่น ✔️ รหัสนักศึกษา ✖️ รหัสนักศึกษา และ ชื่อนักศึกษา)

**Supplier**

| S#  | SNAME | CITY   | STATUS |
| --- | ----- | ------ | ------ |
| S1  | Smith | London | 20     |
| S2  | Jones | Paris  | 10     |
| S3  | Blake | Paris  | 30     |
| S4  | Clark | London | 20     |
| S5  | Adams | Athens | 30     |

**Parts**

| P#  | PNAME | COLOR |
| --- | ----- | ----- |
| P1  | Nut   | Red   |
| P2  | Bolt  | Green |
| P3  | Screw | Blue  |
| P4  | Screw | Red   |
| P5  | Cam   | Blue  |
| P6  | Cog   | Red   |

**Supply**

| S#  | P#  | QTY |
| --- | --- | --- |
| S1  | P1  | 200 |
| S2  | P3  | 400 |
| S2  | P5  | 100 |
| S3  | P3  | 200 |
| S3  | P4  | 500 |
| S4  | P6  | 300 |
| S5  | P1  | 100 |
| S5  | P2  | 200 |
| S5  | P3  | 200 |
| S5  | P4  | 800 |
| S5  | P5  | 500 |
| S5  | P6  | 200 |

> **NOTE**: ตาราง Supplier และ Parts มี Primary Key อยู่แล้ว แต่ตาราง Supply ไม่มี Primary Key จึงต้องทำการสร้าง Primary Key ใหม่ขึ้นมา

### `📚` Third Normal Form (3NF)

- A relation is in **3NF** if and only if it is in **2NF** and every non-key attribute is **non-transitively dependent** on the primary key (Dependencies between non-key attributes)
- ตารางใดที่มีคุณสมบัติ **3NF** จะต้องมีคุณสมบัติ **2NF** และ non-key แต่ละตัว ห้ามมีค่าขึ่นกับค่าของ Column อื่นๆ ที่เป็น non-key ด้วย

**Supplier**

| S#  | SNAME | CITY   |
| --- | ----- | ------ |
| S1  | Smith | London |
| S2  | Jones | Paris  |
| S3  | Blake | Paris  |
| S4  | Clark | London |
| S5  | Adams | Athens |

**Supplier Status**

| CITY   | STATUS |
| ------ | ------ |
| London | 20     |
| Paris  | 10     |
| Athens | 30     |

**Parts**

| P#  | PNAME | COLOR |
| --- | ----- | ----- |
| P1  | Nut   | Red   |
| P2  | Bolt  | Green |
| P3  | Screw | Blue  |
| P4  | Screw | Red   |
| P5  | Cam   | Blue  |
| P6  | Cog   | Red   |

**Supply**

| S#  | P#  | QTY |
| --- | --- | --- |
| S1  | P1  | 200 |
| S2  | P3  | 400 |
| S2  | P5  | 100 |
| S3  | P3  | 200 |
| S3  | P4  | 500 |
| S4  | P6  | 300 |
| S5  | P1  | 100 |
| S5  | P2  | 200 |
| S5  | P3  | 200 |
| S5  | P4  | 800 |
| S5  | P5  | 500 |
| S5  | P6  | 200 |

> **NOTE**: Foreign Key คือ ค่าที่อ้างอิงจากตารางอื่น ๆ และต้องมีค่าที่อ้างอิงอยู่ในตารางที่อ้างอิงด้วย เช่น City.Supplier = City.Supplier Status, S#.Supplier = S#.Supply, P#.Parts = P#.Supply

### `📚` Boyce-Codd Normal Form (BCNF)

- A relation is in **BCNF** if and only if it is in **3NF** and every determinant is a candidate key
- ตารางใดที่มีคุณสมบัติ **BCNF** จะต้องมีคุณสมบัติ **3NF** และมีค่าที่เป็น **Determinant** เป็น **Candidate Key**

**BCNF** จากตาราง [**Supply Parts**](#📄-raw-data) จะเขียน **Functional Dependency** ออกมาได้ดังนี้

| S# is Primary Key | SNAME is Primary Key |
| ----------------- | -------------------- |
| S# → SNAME        | SNAME → S#           |
| S# → FNAME        | SNAME → CITY         |
| ~~S# → STATUS~~   | ~~SNAME → STATUS~~   |
| CITY → STATUS     | CITY → STATUS        |
| P# → PART         | P# → PART            |
| P# → COLOR        | P# → COLOR           |
| (S#, P#) → QTY    | (SNAME, P#) → QTY    |

> **NOTE**: Candidate Key คือ ค่าที่เป็น Primary Key ที่เป็นไปได้ทั้งหมด
