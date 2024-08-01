# Laboratory 3th

## การศึกษาภาษา C# เกี่ยวกับ implicit variable declaration และ static/dynamic typing

C# รองรับการประกาศตัวแปรแบบ Implicit และเป็นภาษาแบบ static type โดยมี dynamic type เป็นตัวเลือกเพิ่มเติม

[ตัวอย่าง](csType.cs)

### Implicit variable declaration

- C# รองรับการประกาศตัวแปรแบบ Implicit โดยใช้ `var`
- Complier จะอนุมาน type ของข้อมูลจากค่าที่กำหนดให้

### Static typing

- C# เป็นภาษาแบบ static type
- ตัวแปรต้องมีการกำหนด type ของข้อมูล และไม่สามารถเปลี่ยน type ของข้อมูลได้หลังประกาศ

### Dynamic typing

- C# มีการรองรับ dynamic type ด้วยสำคัญ `dynamic`
- ตัวแปร dynamic สามารถเปลียน type ของข้อมูลได้ในระหว่าง runtime
- การตรวจสอบชนิดของข้อมูล และมีการเรียกใช้ method จะเกิดขึ้นใน runtime

## การศึกษาภาษา Rust เกี่ยวกับ implicit variable declaration และ static/dynamic typing

Rust เป็นภาษาที่มีระบบ type ที่แตกต่างจาก C#

[ตัวอย่าง](rustType.rs)

### Type inference

- Rust ใช้ type inference (คล้ายกับ C# implicit variable declaration) โดยใช้ `let`
- Complier จะอนุมาน type ของข้อมูลจากค่าที่กำหนดให้

### Static typing

- Rust เป็นภาษาแบบ static type
- ตัวแปรต้องมี type ของข้อมูล และไม่สามารถเปลี่ยน type ของข้อมูลได้หลังประกาศ
- การ mutability ต้องระบุด้วย `mut`

### Dynamic typing

- Rust ไม่มีการรองรับ dynamic type
- แต่สามารถใช้ `enum` และ `trait object` เพื่อสร้าง dynamic type
