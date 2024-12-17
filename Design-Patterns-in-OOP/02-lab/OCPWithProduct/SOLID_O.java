import java.util.List;

public class SOLID_O {
        public static void main(String[] args) {
                Product apple = new Product("Apple", Color.GREEN, Size.SMALL, Price.BUDGET);
                Product tree = new Product("Tree", Color.GREEN, Size.LARGE, Price.MEDIUM);
                Product house = new Product("House", Color.BLUE, Size.LARGE, Price.PREMIUM);

                List<Product> products = List.of(apple, tree, house);
                ProductFilter pf = new ProductFilter();

                System.out.println("Premium products:");
                pf.filter(products, new PriceSpecification(Price.PREMIUM))
                                .forEach(p -> System.out.println(" - " + p.name + " is premium"));

                System.out.println("\nBlue, large, and premium products:");
                pf.filter(products,
                                new AndSpecification<>(new ColorSpecification(Color.BLUE),
                                                new SizeSpecification(Size.LARGE),
                                                new PriceSpecification(Price.PREMIUM)))
                                .forEach(p -> System.out.println(
                                                " - " + p.name + " is blue, large, and premium"));

        }
}
