//This is a Facade Builder
public class PersonBuilder {
    // the object we're going to build
  protected Person person;  
  public PersonBuilder() {
  }
  public PersonBuilder(String name) {
    person = new Person(name);
  }
  public PersonJobBuilder works()
  {
    return new PersonJobBuilder(person);
  }

  public PersonAddressBuilder lives()
  {
    return new PersonAddressBuilder(person);
  }

  public Person build()
  {
    return person;
  }        
}
