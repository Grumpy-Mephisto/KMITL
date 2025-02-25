public class ProxyImage implements IImage {
    private String fileName;
    private Image realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new Image(fileName); // lazy loading
        }
        realImage.display();
    }
}
