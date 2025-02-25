public class App {
    public static void main(String[] args) {
        ImageManager manager = new ImageManager();

        manager.setRenderer(new LaptopRenderer());
        // manager.setRenderer(new SmartphoneRenderer());
        // manager.setRenderer(new TVRenderer());

        manager.show();
    }
}
