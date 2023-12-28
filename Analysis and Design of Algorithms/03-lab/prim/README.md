<div align="center">
   <h1>Prim's Algorithm </h1>
</div>

Prim's Algorithm:

1. Create a function to initialize the following:

   - Initialize a set to store visited vertices (MST vertices).
   - Initialize a list to store the edges of the minimum spanning tree (MST).
   - Initialize an array to store the minimum weights of vertices (key values).
   - Initialize an array to track the parent of each vertex in the MST.

2. Initialize the key values of all vertices to infinity and parent values to NULL.

   - Choose a starting vertex arbitrarily and set its key value to 0.

3. While the MST does not contain all vertices:

   - Find the vertex 'u' not in the MST with the minimum key value.
   - Add 'u' to the MST and mark it as visited.
   - Iterate through each adjacent vertex 'v' of 'u':
     - If 'v' is not in the MST and the weight of edge (u, v) is less than 'v's key value:
       - Update 'v's key value to the weight of edge (u, v).
       - Update 'v's parent as 'u'.
       - Store the edge (u, v) in the MST edges list.

4. Return the list of edges in the MST and their total weight.

Main Function:

1. Read the number of vertices and edges from the input.
2. Initialize an empty graph and populate it with edges and weights.
3. Apply Prim's Algorithm to find the minimum spanning tree and its total weight.
4. Output the edges of the minimum spanning tree and its total weight.

---

<div align="center">
   <h1>วิธีการของ Prim</h1>
</div>

วิธีการของ Prim:

1. สร้างฟังก์ชันเพื่อทำการเริ่มต้นตามขั้นตอนต่อไปนี้:

   - เริ่มต้นตั้งค่าเซ็ตเพื่อเก็บโหนดที่เยี่ยมชมแล้ว (โหนดต้นไม้ที่สร้างค่าน้อยที่สุด)
   - เริ่มต้นตั้งค่าลิสต์เพื่อเก็บเส้นเชื่อมของต้นไม้สแปนนิ่งที่มีค่าน้อยที่สุด (MST)
   - เริ่มต้นตั้งค่าอาร์เรย์เพื่อเก็บน้ำหนักขั้นต่ำของโหนด (ค่าคีย์)
   - เริ่มต้นตั้งค่าอาร์เรย์เพื่อติดตามโหนดแม่ของแต่ละโหนดในต้นไม้สแปนนิ่ง (MST)

2. เริ่มต้นตั้งค่าคีย์ของโหนดทั้งหมดเป็นค่าอินฟินิตีและค่าพ่อแม่เป็น NULL.

   - เลือกโหนดเริ่มต้นโดยอคบีทรอริลี่และตั้งค่าค่าคีย์ของมันเป็น 0.

3. ขณะที่ต้นไม้สแปนนิงยังไม่มีโหนดทั้งหมด:

   - ค้นหาโหนด 'u' ที่ไม่ได้อยู่ในต้นไม้สแปนนิงที่มีค่าคีย์น้อยที่สุด.
   - เพิ่ม 'u' เข้าไปในต้นไม้สแปนนิงและทำเครื่องหมายว่าเยี่ยมชมแล้ว.
   - วนลูปผ่านทุกโหนดที่เชื่อมต่อ 'v' ของ 'u':
     - หาก 'v' ไม่ได้อยู่ในต้นไม้สแปนนิงและน้ำหนักของเส้นเชื่อม (u, v) น้อยกว่าค่าคีย์ของ 'v':
       - ปรับปรุงค่าคีย์ของ 'v' เป็นน้ำหนักของเส้นเชื่อม (u, v).
       - ปรับปรุงโหนดแม่ของ 'v' เป็น 'u'.
       - เก็บเส้นเชื่อม (u, v) ไว้ในลิสต์เส้นเชื่อมของต้นไม้สแปนนิง.

4. ส่งคืนลิสต์ของเส้นเชื่อมในต้นไม้สแปนนิงและน้ำหนักรวมของมัน.

ฟังก์ชันหลัก:

1. อ่านจำนวนโหนดและเส้นเชื่อมจากข้อมูลนำเข้า.
2. เริ่มต้นตั้งค่ากราฟเปล่าและเติมด้วยเส้นเชื่อมและน้ำหนัก.
3. ประยุกต์ใช้วิธีการของ Prim เพื่อหาต้นไม้สแปนนิงที่น้อยที่สุดและน้ำหนักรวมของมัน.
4. แสดงผลเส้นเชื่อมของต้นไม้สแปนนิงและน้ำหนักรวมของมัน.
