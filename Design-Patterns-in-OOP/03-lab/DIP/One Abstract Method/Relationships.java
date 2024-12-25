import java.util.ArrayList;
import java.util.List;

public class Relationships implements IRelationshipBrowser {
    private List<Triplet<Person, RelationshipStatus, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, RelationshipStatus.PARENT, child));
        relations.add(new Triplet<>(child, RelationshipStatus.CHILD, parent));
    }

    public void addSibling(Person person1, Person person2) {
        relations.add(new Triplet<>(person1, RelationshipStatus.SIBLING, person2));
        relations.add(new Triplet<>(person2, RelationshipStatus.SIBLING, person1));
    }

    @Override
    public List<Person> findAllStatusOf(String name, RelationshipStatus status) {
        List<Person> result = new ArrayList<>();
        for (Triplet<Person, RelationshipStatus, Person> relation : relations) {
            if (relation.first.getName().equals(name) && relation.second == status) {
                result.add(relation.third);
            }
        }
        return result;
    }
}
