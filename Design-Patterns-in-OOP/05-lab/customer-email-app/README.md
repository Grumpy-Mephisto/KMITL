# Explaining the use of Design Patterns in customer emails

## Design Patterns used in the system

### 1. Template Method Pattern

#### Usage

Pattern นี้ถูกใช้ในคลาส `Customer` เพื่อกำหนดโครงสร้างการสร้างการสื่อสารกับลูกค้า

#### Components

- **Template Method**: `createCommunication()` ในคลาส `Customer`

  - กำหนดลำดับขั้นตอนการทำงานหลัก
  - เรียกใช้ `createMail()` และ `createBrochure()`
  - ควบคุมการแสดงผลรวม

- **Abstract Methods**:

  - `createMail()` - เมธอดที่คลาสลูกต้องกำหนดวิธีการสร้างจดหมาย
  - `createBrochure()` - เมธอดที่คลาสลูกต้องกำหนดวิธีการสร้างโบรชัวร์

- **Hook Method**:
  - `shouldIncludeBrochure()` - ให้คลาสลูกควบคุมว่าจะรวมโบรชัวร์หรือไม่
  - ตัวอย่างการใช้: คลาส `DelinquentCustomer` override เพื่อไม่ส่งโบรชัวร์

#### Benefits

- แยกส่วนที่เหมือนกันไว้ใน parent class ลดการเขียนโค้ดซ้ำ
- child class สามารถปรับเปลี่ยนเฉพาะส่วนที่ต้องการได้
- รักษาโครงสร้างการทำงานหลักให้เหมือนกันทุกประเภทลูกค้า

### 2. Factory Pattern

#### Usage

Pattern นี้ถูกใช้ในคลาส `CustomerFactory` เพื่อจัดการการสร้างอ็อบเจกต์ลูกค้าประเภทต่างๆ

#### Components

- **Factory Class**: `CustomerFactory`
  - มีเมธอด `createCustomer()` สำหรับสร้างอ็อบเจกต์ลูกค้า
  - ใช้ Map เก็บความสัมพันธ์ระหว่างประเภทลูกค้ากับวิธีการสร้าง
  - มีเมธอด `registerCustomerType()` สำหรับเพิ่มประเภทลูกค้าใหม่

#### Benefits

- แยกการสร้างอ็อบเจกต์ออกจาก Usage
- รองรับการเพิ่มประเภทลูกค้าใหม่โดยไม่ต้องแก้ไขโค้ดเดิม
- ลดการเชื่อมโยงระหว่างโค้ดที่ใช้งานกับคลาสลูกค้าแต่ละประเภท

## How Design Patterns work together

Design Patterns ทั้งสองทำงานร่วมกันดังนี้:

1. `CustomerFactory` สร้างอ็อบเจกต์ลูกค้าประเภทที่ต้องการ
2. อ็อบเจกต์ที่สร้างขึ้นใช้ Template Method Pattern ในการสร้างการสื่อสาร
3. แต่ละประเภทลูกค้ากำหนดรายละเอียดเฉพาะของตนเองผ่าน abstract methods
4. การควบคุมพิเศษ (เช่น การไม่ส่งโบรชัวร์) ทำได้ผ่าน hook method
