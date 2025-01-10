# Explaining the use of Design Patterns in customer emails

## Design Pattern used in the system

### Factory Method Pattern

#### Usage

Pattern นี้ถูกใช้ในการสร้างออบเจ็กต์ของ Customer แต่ละประเภท โดยแยกส่วนการสร้างออบเจ็กต์ออกจากส่วนที่ใช้งาน

#### Components

- **Abstract Product**: `Customer` (Abstract Class)

  - กำหนด abstract method `createMail()` ที่ลูกทุกคลาสต้องนำไป implement

- **Concrete Products**:

  - `RegularCustomer` - สำหรับลูกค้าทั่วไป
  - `MountainCustomer` - สำหรับลูกค้าแถบภูเขา
  - `DelinquentCustomer` - สำหรับลูกค้าที่ค้างชำระ

- **Factory Class**: `CustomerMailApplication`
  - มีเมธอด `getCustomerTypeFromUser()` สำหรับรับประเภทลูกค้าจากผู้ใช้
  - สร้างออบเจ็กต์ Customer ตามประเภทที่ผู้ใช้เลือก

#### Benefits

- แยกการสร้างออบเจ็กต์ออกจากส่วนที่ใช้งาน ทำให้โค้ดมีความยืดหยุ่น
- สามารถเพิ่มประเภทลูกค้าใหม่ได้โดยไม่ต้องแก้ไขโค้ดเดิม
- โค้ดส่วนที่ใช้งานไม่จำเป็นต้องรู้รายละเอียดการสร้างออบเจ็กต์
- ทำให้ระบบรองรับการขยายตัวในอนาคตได้ง่าย

#### How the system works

1. ผู้ใช้เลือกประเภทลูกค้าผ่านเมธอด `getCustomerTypeFromUser()`
2. ระบบสร้างออบเจ็กต์ Customer ตามประเภทที่เลือก
3. เรียกใช้เมธอด `createMail()` เพื่อสร้างข้อความสำหรับลูกค้าแต่ละประเภท
4. แสดงผลข้อความที่สร้างขึ้น
