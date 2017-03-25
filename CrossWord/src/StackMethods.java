
import java.util.NoSuchElementException;

public class StackMethods<Item> {

    private Node first;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    public StackMethods() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item){
       Node old = first;
       first = new Node();
       first.item = item;
       first.next = old;
    }

    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack Underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
}