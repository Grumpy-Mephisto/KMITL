public class AndSpecification<T> implements ISpecification<T> {
    private ISpecification<T>[] specs;

    @SafeVarargs
    public AndSpecification(ISpecification<T>... specs) {
        this.specs = specs;
    }

    @Override
    public boolean isSatisfied(T item) {
        for (ISpecification<T> spec : specs) {
            if (!spec.isSatisfied(item)) {
                return false;
            }
        }
        return true;
    }
}
