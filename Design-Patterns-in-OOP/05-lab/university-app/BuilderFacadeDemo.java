public class BuilderFacadeDemo {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder("Prayuth");
        Person person = pb
        .lives()
            .at("123 London Road")
            .in("London")
            .withPostcode("SW12BC")
        .works()
            .at("Fabrikam")
            .asA("Engineer")
            .earning(123000)
        .build();
        System.out.println(person);
        
        //switch between builder subclasses
        /*Person person = pb 
        .lives()
            .at("123 London Road")
            .in("London")
            //.withPostcode("SW12BC")
        .works()
            .at("Fabrikam")
            .asA("Engineer")
            .earning(123000)
        .lives()
            .withPostcode("SW12BC")
        .build();
        System.out.println(person);*/
    }        
}
