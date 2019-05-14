package inthebloodhorse.designpatter.iterator;

public interface MyIterator<T> {
    void first();

    void next();

    boolean hasNext();

    boolean isFirst();

    boolean isLast();

    T getCurrent();
}
