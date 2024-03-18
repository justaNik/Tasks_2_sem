package task_3;

public interface SimpleStack<T> {
    void push(T value);

    T pop() throws Exception; //удаляет первый элемент и возвращает его

    T peek() throws Exception; // возвращает первый элемент

    int size();

    default boolean empty() {
        return size() == 0;
    }

}
