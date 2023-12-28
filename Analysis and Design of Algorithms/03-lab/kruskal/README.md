<div align="center">
    <h1>Kruskal's Algorithm</h1>
</div>

Kruskal's Algorithm:

1. Create a function to initialize the Union-Find data structure:

   - Initialize each vertex as a separate set.

2. Create a function to find the root/representative of a set:

   - Traverse the parent pointers until the root is found.

3. Create a function to merge two sets based on their representatives:

   - Find the representatives of both sets.
   - If the representatives are different, merge the sets by setting one's parent as the other.

4. Create a function to perform Kruskal's Algorithm:

   - Sort the edges of the graph in ascending order based on their weights.
   - Initialize an empty minimum spanning tree (MST).
   - Initialize a variable to track the total cost of the MST.
   - Iterate through the sorted edges:
     - For each edge:
       - If adding this edge to the MST doesn't create a cycle (i.e., the edge's endpoints belong to different sets):
         - Add the edge to the MST.
         - Merge the sets of the edge's endpoints.
         - Increment the total cost by the edge's weight.
   - Return the total cost of the MST.

5. Main Function:
   - Read the number of vertices and edges from the input.
   - Initialize an empty graph and populate it with edges and weights.
   - Apply Kruskal's Algorithm to find the minimum spanning tree.
   - Output the total cost of the minimum spanning tree.

---

<div align="center">
    <h1>ขั้นตอนวิธีของ Kruskal</h1>
</div>

ขั้นตอนวิธีของ Kruskal:

1. สร้างฟังก์ชันเพื่อเริ่มต้นโครงสร้างข้อมูลยูเนียน-ไฟนด์ (Union-Find):

   - เริ่มต้นทุกโหนดเป็นเซ็ตแยกต่างหาก.

2. สร้างฟังก์ชันเพื่อค้นหาราก/ตัวแทนของเซ็ต:

   - สะสมพอยน์เตอร์โดยใช้ตัวชี้พ่อแม่จนกว่าจะพบราก.

3. สร้างฟังก์ชันเพื่อผสานเซ็ตสองเซ็ตตามตัวแทนของพวกเขา:

   - ค้นหารายแทนของทั้งสองเซ็ต.
   - หากรายแทนแตกต่างกัน ผสานเซ็ตโดยตั้งพ่อแม่ของหนึ่งอันเป็นอีกอันหนึ่ง.

4. สร้างฟังก์ชันเพื่อดำเนินการตามขั้นตอนวิธีของ Kruskal:

   - เรียงลำดับเส้นเชื่อมของกราฟตามน้ำหนักในลำดับเรียงจากน้อยไปมาก.
   - เริ่มต้นที่ต้นไม้สแปนนิงที่น้อยที่สุด (MST) เป็นเปล่า.
   - เริ่มต้นตั้งค่าตัวแปรเพื่อติดตามค่ารวมของ MST.
   - วนลูปผ่านเส้นเชื่อมที่เรียงลำดับแล้ว:
     - สำหรับแต่ละเส้นเชื่อม:
       - หากการเพิ่มเส้นเชื่อมนี้ใน MST ไม่สร้างวงวน (เช่น จุดสิ้นสุดของเส้นเชื่อมอยู่ในเซ็ตต่างกัน):
         - เพิ่มเส้นเชื่อมใน MST.
         - ผสานเซ็ตของจุดสิ้นสุดของเส้นเชื่อม.
         - เพิ่มค่ารวมโดยน้ำหนักของเส้นเชื่อม.
   - ส่งคืนค่ารวมทั้งหมดของ MST.

5. ฟังก์ชันหลัก:
   - อ่านจำนวนโหนดและเส้นเชื่อมจากข้อมูลนำเข้า.
   - เริ่มต้นกราฟเปล่าและเติมด้วยเส้นเชื่อมและน้ำหนัก.
   - ประยุกต์ใช้ขั้นตอนวิธีของ Kruskal เพื่อหาต้นไม้สแปนนิงที่น้อยที่สุด.
   - แสดงผลค่ารวมของต้นไม้สแปนนิงที่น้อยที่สุด.
