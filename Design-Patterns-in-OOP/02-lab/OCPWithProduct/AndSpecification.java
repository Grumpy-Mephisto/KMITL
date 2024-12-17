public class AndSpecification<T> implements ISpecification<T> {
    private ISpecification<T> first, second;

    public AndSpecification(ISpecification<T> first, ISpecification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }

}
