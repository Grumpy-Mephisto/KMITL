import java.util.List;
import java.util.stream.Stream;

public interface IFilter<T> {
    Stream<T> filter(List<T> items, ISpecification<T> spec);
}
