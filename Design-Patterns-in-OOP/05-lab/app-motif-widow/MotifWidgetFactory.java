public class MotifWidgetFactory implements IWidgetFactory {
    private static MotifWidgetFactory factory = new MotifWidgetFactory();
    private MotifWidgetFactory() {

    }
    public static MotifWidgetFactory getMotifWidgetFactory() {
        return factory;
    }
    @Override
    public IScrollBar createScrollBar() {
        return new MotifScrollBar();
    }

    @Override
    public IWindow createWindow() {
        return new MotifWindow();
    }
    
}
