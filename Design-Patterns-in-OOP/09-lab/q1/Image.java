public class Image implements IImage {
    private String fileName;
    
    public Image(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    public void loadFromDisk() {
        System.out.println("loading " + fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
    
}
