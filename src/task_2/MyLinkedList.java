package task_2;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private class MyLinkedListItem<T> {
        public T value;
        public MyLinkedListItem<T> next;

        public MyLinkedListItem(T value, MyLinkedListItem<T> next) {
            this.value = value;
            this.next = next;
        }

        public MyLinkedListItem(T value) {
            this(value, null);
        }

        public MyLinkedListItem() {
            this(null, null);
        }
    }

    private MyLinkedListItem<T> head = null;
    private MyLinkedListItem<T> tail = null;
    private int count = 0;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void checkEmpty() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }

    public T remove(int index) throws Exception {
        T value;
        if (index == 0) {
            return removeFirst();
        } else {
            MyLinkedListItem<T> prev = getItem(index - 1);
            value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        count--;
        return value;
    }

//    public T removeLast(){
//
//    }

    public T removeFirst() throws Exception { //удаляет 1 эелемент и возвращает его значение
        checkEmpty();
        T value = getFirst();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
        return value;
    }

    public void insert(int index, T value) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Incorrect index");
        }
        if (index == 0) {
            addFirst(value);
        } else {
            MyLinkedListItem<T> prev = getItem(index - 1);
            prev.next = new MyLinkedListItem<>(value, prev.next);
            if (prev.next.next == null) {
                tail = prev.next;
            }
            count++;
        }
    }

    public void addFirst(T value) {
        head = new MyLinkedListItem<>(value, head);
        if (tail == null) {
            tail = head;
        }
        count++;
    }

    public void addLast(T value) {
        if (tail == null) {
            head = tail = new MyLinkedListItem<>(value);
        } else {
            tail = tail.next = new MyLinkedListItem<>(value);
        }
        count ++;
    }

    public T get(int index) throws Exception{
        return getItem(index).value;
    }

    private MyLinkedListItem<T> getItem(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Incorrect index");
        }
        MyLinkedListItem<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T getLast() throws Exception {
        checkEmpty();
        return tail.value;
    }

    public T getFirst() throws Exception {
        checkEmpty();
        return head.value;
    }

    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
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
