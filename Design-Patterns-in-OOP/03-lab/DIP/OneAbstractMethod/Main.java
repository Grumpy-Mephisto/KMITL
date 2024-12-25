import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person dad = new Person("John");
        Person mom = new Person("Marry");
        Person olderBrother = new Person("Chris");
        Person youngerBrother = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(dad, olderBrother);
        relationships.addParentAndChild(dad, youngerBrother);
        relationships.addParentAndChild(mom, olderBrother);
        relationships.addParentAndChild(mom, youngerBrother);
        relationships.addSibling(olderBrother, youngerBrother);

        List<Person> johnsChildren =
                Research.research(relationships, "John", RelationshipStatus.PARENT);
        for (Person child : johnsChildren) {
            System.out.println("John has a child called " + child.getName());
        }

        List<Person> marrysChildren =
                Research.research(relationships, "Marry", RelationshipStatus.PARENT);
        for (Person child : marrysChildren) {
            System.out.println("Marry has a child called " + child.getName());
        }

        List<Person> chrisParents =
                Research.research(relationships, "Chris", RelationshipStatus.CHILD);
        for (Person parent : chrisParents) {
            System.out.println("Chris has a parent called " + parent.getName());
        }

        List<Person> mattSiblings =
                Research.research(relationships, "Matt", RelationshipStatus.SIBLING);
        for (Person sibling : mattSiblings) {
            System.out.println("Matt has a sibling called " + sibling.getName());
        }
    }
}
