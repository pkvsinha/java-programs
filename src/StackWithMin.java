import java.util.Stack;

public class StackWithMin extends Stack<Integer> {

  private Stack<Integer> minStack;

  public StackWithMin() {
    this.minStack = new Stack<>();
  }

  @Override
  public Integer push(Integer item) {
    if (item < min()) {
      minStack.push(item);
    }
    return super.push(item);
  }

  @Override
  public synchronized Integer pop() {
    if (min() == this.peek()) {
      minStack.pop();
    }
    return super.pop();
  }

  int min() {
    if (this.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return minStack.peek();
  }
}
