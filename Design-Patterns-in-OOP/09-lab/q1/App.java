public class App {
    public static void main(String[] args) {
        IImage myImage = new Image("test.jpg");
        IImage proxyImage = new ProxyImage("test.jpg");

        myImage.display(); // ภาพจะถูกโหลดจากดิสก์ทันที
        proxyImage.display(); // ภาพจะถูกโหลดจากดิสก์เมื่อมีการเรียกใช้งาน display()
    }
}
