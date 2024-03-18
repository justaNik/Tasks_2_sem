package task_3;

import java.util.Iterator;

public class QueueTwoStacks<T> implements SimpleQueue<T>, Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyLinkedListItem curr = head;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next()  {
                MyLinkedListItem value = curr;
                curr = curr.next;
                return value.value;
            }
        };
    }

    public class MyLinkedListItem {
        public T value;
        public MyLinkedListItem next;

        public MyLinkedListItem(T value, MyLinkedListItem next) {
            this.value = value;
            this.next = next;
        }
    }

    private MyLinkedListItem head = null;
    private int size = 0;

    SimpleStackImpl<T> inStack = new SimpleStackImpl<>();
    SimpleStackImpl<T> outStack = new SimpleStackImpl<>();

    @Override
    public void add(T value) {
        inStack.push(value);
        size++;
    }

//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        for (T v : this) {
//            str.append(v).append(" ");
//        }
//        return str.toString();
//    }

    @Override
    public T remove() throws Exception {
        if (outStack.empty()) {
            while (inStack.size() > 0) {
                outStack.push(inStack.pop());
            }
        }
        size--;
        return outStack.pop();
    }

    @Override
    public T elemtnt() throws Exception {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
