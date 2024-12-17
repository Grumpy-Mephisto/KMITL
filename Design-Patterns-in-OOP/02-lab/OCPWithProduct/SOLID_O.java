import java.util.List;

public class SOLID_O {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products: (new)");
        pf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.name + " is green"));
        pf.filter(products, new SizeSpecification(Size.SMALL))
                .forEach(p -> System.out.println(" - " + p.name + " is small"));

        System.out.println("Blue AND Large products: (new)");
        pf.filter(products,
                new AndSpecification<Product>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE)))
                .forEach(p -> System.out.println(" - " + p.name + " is blue and large"));
    }
}