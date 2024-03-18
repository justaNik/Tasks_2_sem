package task_3;

import java.util.Iterator;

public class SimpleStackImpl<T> implements SimpleStack<T>, Iterable<T> {
    private static class MyLinkedListItem<T> {
        public T value;
        public MyLinkedListItem<T> next;

        public MyLinkedListItem(T value, MyLinkedListItem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private MyLinkedListItem<T> head = null;
    private int size = 0;

    @Override
    public void push(T value) {
        head = new MyLinkedListItem<>(value, head);
        size++;

    }

    @Override
    public T pop() throws Exception {
        if (head == null) {
            throw new Exception("Stack is empty");
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T peek() throws Exception {
        if (head == null){
            throw new Exception("Stack is empty");
        }
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

        @Override
        public Iterator<T> iterator(){
            return new Iterator<>() {
                MyLinkedListItem<T> curr = head;
                @Override
                public boolean hasNext() {
                    return curr != null;
                }

                @Override
                public T next() {
                    T value = curr.value;
                    curr = curr.next;
                    return value;
                }
            };

        }
}
