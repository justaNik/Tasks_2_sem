package task_3;

public interface SimpleQueue<T> {
    void add(T value);

    T remove() throws Exception;

    T elemtnt() throws Exception;

    int size();

    default boolean empty() {
        return size() == 0;
    }
}
