public class WidgetFactoryCreator {
    public enum WidgetStyle {
        MOTIF, PM
    }

    public static IWidgetFactory createWidgetFactory(WidgetStyle style) {
        return switch (style) {
            case MOTIF -> MotifWidgetFactory.getMotifWidgetFactory();
            case PM -> PMWidgetFactory.getMotifWidgetFactory();
        };
    }
}
