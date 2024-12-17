import java.util.List;
import java.util.stream.Stream;

public class ProductFilter implements IFilter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, ISpecification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}
