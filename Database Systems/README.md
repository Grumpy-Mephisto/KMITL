<div align="center">
    <h1><code>🏬</code> Database Systems</h1>
</div>

## `📚` Table of Contents

- [Transaction Processing](#-transaction-processing)
- [ER Diagrams](#-er-diagrams)
- [Advanced SQL](#-advanced-sql)

## `📊` ER Diagrams

### `❓` What is ER Diagrams?

แผนภาพที่ใช้ในการแสดงความสัมพันธ์ระหว่าง Entity และ Relationship ของ Database โดยที่ Entity จะเป็นตัวแทนของ Object ที่มีความหมายในโลกจริง และ Relationship คือ ความสัมพันธ์ระหว่าง Entity ที่เกิดขึ้นในโลกจริง

### `❓` ER Diagrams Symbols

- Entity

  ![Entity](https://www.functionly.com/hs-fs/hubfs/ER-Diagram-Entities.jpg?width=390&name=ER-Diagram-Entities.jpg)

- Relationship

  ![Relationship](https://d2slcw3kip6qmk.cloudfront.net/marketing/pages/chart/erd-symbols/ERD-Notation.PNG)

### `❓` ER Diagrams Example

![ER Diagrams Example](https://miro.medium.com/v2/resize:fit:1168/1*QkIeA-uwU244QoG0jF3FBg.png)

## `🚇` Transaction Processing

### `❓` What is Transaction Processing?

การประมวลผลที่เกิดขึ้นในระบบฐานข้อมูล โดยที่การประมวลผลจะเป็นการเขียนข้อมูลลงในฐานข้อมูล หรือ การอ่านข้อมูลจากฐานข้อมูล โดยที่การประมวลผลจะเป็นการทำงานที่เป็นระบบ และ ต้องทำงานในลักษณะที่ถูกต้องและครบถ้วน

### `❓` Transaction Processing Properties

#### `📝` ACID

- Atomicity (อะตอมิซิชั่น)

Transaction จะให้ผลการทำงานเป็นหนึ่งเดียว หรือการทำงานเสร็จอย่างสมบูรณ์ ไม่ว่า Transaction จะทำงานปกติ หรือมีปัญหาก็ตาม หมายความว่า ทุกขั้นตอนของ Transaction จะต้องมีการทำงานที่เสร็จสมบูรณ์ หรือไม่ เช่นนั้นก็ต้องยกเลิกทุกขั้นตอนใน Transaction นั้น หากมีงานบางส่วนใน Transaction ไม่สมบูรณ์จะถูกยกเลิก (Aborted) และจะย้อนกลับ (Rollback) ไปจุด milestone ก่อนหน้านั้น

- Consistency (คอนซิสเทนซี)

ระบบจะรักษาข้อมูลที่เกิดจากการทำงานของ Transaction ให้ถูกต้อง และสอดคล้องกันเสมอ นั่นคือหลังจากการทำงานของ Transaction เสร็จสมบูรณ์ ทุก Transaction จะต้องก่อให้เกิดข้อมูลใน Database ที่มีความถูกต้องเสมอ

- Isolation (ไอโซเลชั่น)

การทำงานของ Transaction จะต้องไม่มีผลกระทบกับ Transaction อื่น ๆ ที่ทำงานพร้อมกัน หรือ ทำงานต่อเนื่องกัน นั่นคือ การทำงานของ Transaction จะต้องไม่มีผลกระทบกับ Transaction อื่น ๆ ที่ทำงานพร้อมกัน หรือ ทำงานต่อเนื่องกัน นั่นคือ การทำงานของ Transaction จะต้องไม่มีผลกระทบกับ Transaction อื่น ๆ ที่ทำงานพร้อมกัน หรือ ทำงานต่อเนื่องกัน

- Durability (ดิวราบิลิตี้)

การทำงานของ Transaction จะต้องมีผลต่อข้อมูลใน Database ในทุก ๆ กรณี นั่นคือ หลังจากที่ Transaction ทำงานเสร็จสมบูรณ์แล้ว ข้อมูลที่เกิดจากการทำงานของ Transaction นั้น ๆ จะต้องถูกเก็บไว้ใน Database อย่างถาวร

#### `📝` Transaction States

![Transaction States](assets/transaction_state.png)

- Active

Transaction ที่กำลังทำงานอยู่

- Partially Committed

Transaction ที่ทำงานเสร็จสมบูรณ์แล้ว แต่ยังไม่ได้ Commit ข้อมูลลงใน Database

- Committed

Transaction ที่ทำงานเสร็จสมบูรณ์แล้ว และ Commit ข้อมูลลงใน Database เรียบร้อยแล้ว

- Failed

Transaction ที่ทำงานไม่สมบูรณ์ หรือ ทำงานไม่สำเร็จ

- Aborted

Transaction ที่ทำงานไม่สมบูรณ์ และถูกยกเลิกการทำงาน

#### `📝` Transaction Operations

- Begin Transaction

เป็นการเริ่มต้น Transaction ใหม่

- Commit

เป็นการยืนยัน Transaction ที่ทำงานเสร็จสมบูรณ์ และ Commit ข้อมูลลงใน Database

- Rollback

เป็นการยกเลิก Transaction ที่ทำงานไม่สมบูรณ์ และย้อนกลับไปที่จุดเริ่มต้นของ Transaction นั้น

### `❓` Transaction Processing Example SQL

```sql
BEGIN TRANSACTION;

-- ฝากเงิน
UPDATE saving_accounts
  SET balance = balance - 1000
  WHERE account_number = 3209;

-- ถอนเงิน
UPDATE check_accounts
  SET balance = balance + 1000
  WHERE account_number = 3208;

-- บันทึกข้อมูลการทำรายการ ลงใน journal
INSERT INTO journal VALUES
  (journal_seq.NEXTVAL, '1B'
    3209, 3208, 500);

COMMIT WORK;
```

## `📚` Advanced SQL
