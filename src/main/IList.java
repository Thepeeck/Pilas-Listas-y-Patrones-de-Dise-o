package src.main;
public interface IList<T> {
    void add(T value);
    T remove();
    T get();
    boolean isEmpty();
    int size();
}