public interface ISpecification<T> {
    boolean isSatisfied(T item);
}
