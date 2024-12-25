import java.util.List;

public interface IRelationshipBrowser {
    List<Person> findAllStatusOf(String name, RelationshipStatus status);
}
