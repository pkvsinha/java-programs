import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

  private Node head;

  private class Node {
    T value;
    Node next;

    private Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  public void add(T item) {
    Node oldHead = head;
    head = new Node(item, oldHead);
  }

  @Override
  public Iterator<T> iterator() {
    return new BagIterator();
  }

  private class BagIterator implements Iterator<T> {

    private Node current = head;
    
    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T item = current.value;
      current = current.next;
      return item;
    }
  }
}
