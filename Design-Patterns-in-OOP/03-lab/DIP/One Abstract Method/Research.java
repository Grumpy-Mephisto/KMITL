import java.util.List;

public class Research {
    public static List<Person> research(IRelationshipBrowser browser, String name,
            RelationshipStatus status) {
        return browser.findAllStatusOf(name, status);
    }
}
