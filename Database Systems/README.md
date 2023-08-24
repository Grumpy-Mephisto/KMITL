<div align="center">
    <h1><code>🏬</code> Database Systems</h1>
</div>

## `📚` Table of Contents

- [Normalization](#🧑‍💼-normalization)
  - [Raw Data](#📄-raw-data)
  - [First Normal Form (1NF)](#📚-first-normal-form-1nf)
  - [Second Normal Form (2NF)](#📚-second-normal-form-2nf)
  - [Third Normal Form (3NF)](#📚-third-normal-form-3nf)
  - [Boyce-Codd Normal Form (BCNF)](#📚-boyce-codd-normal-form-bcnf)
  - [Fourth Normal Form (4NF)](#📚-fourth-normal-form-4nf)

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

| 💡 ไม่มีกลุ่มซ้ำของ Column/Attribute ใน Row |
| ------------------------------------------- |

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

| 💡 (FFD) มอง X(Key Attribute) กำหนดค่า(Determine) Y(Non Key) |
| ------------------------------------------------------------ |

> **Note**
> Functionally Dependency (FD) is Functional depends on attribute(s) R.x in Relation R (R.x -> R.y) if and only if given a single value of x, there must be onlyone corresponding value of Y \
> ค่า X เป็นตัวกำหนดค่า Y หรือ ค่า Y ขึ้นอยู่กับค่า X (เช่น รหัสนักศึกษา ขึ้นอยู่กับ ชื่อนักศึกษา)

> **Note**
> Fully Functionally Dependency (FFD) is Functional depends on R.x and not on any proper subset of R.x \
> ค่า Y จะต้องขึ้นกับค่า X เท่านั้น และไม่ขึ้นกับค่าใดๆ ที่เป็นส่วนหนึ่งของ X เมื่อ X, Y ประกอบด้วย Column หลายๆ Column (ขอตัวมันจริงๆ เช่น ✔️ รหัสนักศึกษา ✖️ รหัสนักศึกษา และ ชื่อนักศึกษา)

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

> **Warning**
> ตาราง Supplier และ Parts มี Primary Key อยู่แล้ว แต่ตาราง Supply ไม่มี Primary Key จึงต้องทำการสร้าง Primary Key ใหม่ขึ้นมา

### `📚` Third Normal Form (3NF)

- A relation is in **3NF** if and only if it is in **2NF** and every non-key attribute is **non-transitively dependent** on the primary key (Dependencies between non-key attributes)
- ตารางใดที่มีคุณสมบัติ **3NF** จะต้องมีคุณสมบัติ **2NF** และ non-key แต่ละตัว ห้ามมีค่าขึ่นกับค่าของ Column อื่นๆ ที่เป็น non-key ด้วย

| 💡 มอง Non Key ห้ามมี FFD ระหว่างกัน |
| ------------------------------------ |

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

> **Note**
> Foreign Key คือ ค่าที่อ้างอิงจากตารางอื่น ๆ และต้องมีค่าที่อ้างอิงอยู่ในตารางที่อ้างอิงด้วย เช่น City.Supplier = City.Supplier Status, S#.Supplier = S#.Supply, P#.Parts = P#.Supply

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

> **Note**
> Candidate Key คือ ค่าที่เป็น Primary Key ที่เป็นไปได้ทั้งหมด

### `📚` Fourth Normal Form (4NF)

- A relation R is in **4NF** if and only if, whenever there exist an **MVD (Multi-Valued Dependency)** in R, X ->-> Y, then X is a superkey of R. Fact FDS are a special case of MVDs, so all 4NF relations are also in BCNF
- ตารางใดที่มีคุณสมบัติ **4NF** จะต้องมีคุณสมบัติ **BCNF** และมีค่าที่เป็น **MVD** เป็น **Super Key** ของตาราง

| 💡 ถ้าแยกหรือตารางย่อยออกได้ และไม่มีข้อมูลที่หายไป จากนั้น join กลับมาได้เหมือนเดิม และ 4NF คือตารางที่ไม่สามารถแยกหรือตารางย่อยออกได้ |
| --------------------------------------------------------------------------------------------------------------------------------------- |

> **Note**
> Splitable Check คือ การตรวจสอบว่า ค่าที่อยู่ใน Column นั้นๆ สามารถแยกออกได้หรือไม่

> **Note**
> Multi-Valued Dependency (MVD) คือการแยกค่าใน Column ออกเป็นหลายๆ และเวลา join ตารางกลับมาต้องไม่มีข้อมูลที่หายไป หรือ ตารางเหมือนเดิม เช่น ตาราง Supplier และ Supplier Status สามารถแยกออกได้ และเวลา join กลับมาจะไม่มีข้อมูลที่หายไป หรือ ตารางเหมือนเดิม

> **Warning**
> ในการ split column ควรเลือก column ที่มีจำนวน Row เป็นจำนวนคู่ และไม่นับ จำนวน Row ที่เป็น 1 เป็นเลขคี่

**Example**

| S_No | P_No | Qty |
| ---- | ---- | --- |
| S1   | P1   | 20  |
| S1   | P2   | 15  |
| S2   | P1   | 20  |

**Split 1st**

| S_No | P_No |
| ---- | ---- |
| S1   | P1   |
| S1   | P2   |
| S2   | P1   |

**Split 2nd**

| S_No | Qty |
| ---- | --- |
| S1   | 20  |
| S1   | 15  |
| S2   | 20  |

**Natural Join** ⚠️ ไม่สามารถ join กลับมาและได้ข้อมูลเหมือนเดิมได้

| S_No | P_No | Qty |
| ---- | ---- | --- |
| S1   | P1   | 20  |
| S1   | P1   | 15  |
| S1   | P2   | 20  |
| S1   | P2   | 15  |
| S2   | P1   | 20  |

```

```

```

```
