public class MyLinkedList<T> {

    private int size;
    private Node<T> firstItem;
    private Node<T> lastItem;
    private class Node<T> {
        private T item;

        private int index;
        private Node<T> prevueItem;
        private Node<T> nextItem;

        private Node(T item) {
            this.item = item;
            this.nextItem = null;
        }
    }

    public MyLinkedList() {
        this.size = 0;
        this.firstItem = null;
    }

    public void add(T item) {
        Node<T> node = new Node<>(item);
        Node<T> currentNode = firstItem;

        if (firstItem == null) {
            firstItem = node;
            lastItem = firstItem;
            firstItem.index = 0;
            size = 1;
        } else {
            while (currentNode.nextItem != null) {
                currentNode = currentNode.nextItem;
            }
            currentNode.nextItem = node;
            currentNode.nextItem.prevueItem = currentNode;
            lastItem = node;
            lastItem.index = size;
            size++;
        }
    }

    public T pop() {
        T firstElement = firstItem.item;
        firstItem = firstItem.nextItem;
        Node<T> currentItem = firstItem;

        firstItem.prevueItem = null;
        firstItem.index = 0;
        size--;

        while (currentItem.nextItem != null) {
            currentItem.nextItem.index--;
            currentItem = currentItem.nextItem;
        }

        return firstElement;
    }

    public T removeLast() {
        T lastElement = lastItem.item;
        lastItem = lastItem.prevueItem;
        lastItem.nextItem = null;
        size--;

        return lastElement;
    }

    public T remove(int index) {
        Node<T> currentItem = firstItem.nextItem;
        T object = null;

        if (firstItem.index == index) {
            object = pop();
        } else if (lastItem.index == index) {
            object = removeLast();
        } else {
            while (currentItem.nextItem != null) {
                if (currentItem.index == index) {
                    currentItem.prevueItem.nextItem = currentItem.nextItem;
                    currentItem.nextItem.prevueItem = currentItem.prevueItem;
                    currentItem.nextItem.index = currentItem.index;
                    object = currentItem.item;
                    currentItem = currentItem.nextItem;

                    while (currentItem.nextItem != null) {
                        currentItem.nextItem.index = currentItem.index += 1;
                        currentItem = currentItem.nextItem;
                    }
                    size--;
                    return object;
                } else {
                    currentItem = currentItem.nextItem;
                }
            }
        }
        return object;
    }

    public T get(int index) {
        Node<T> currentItem = firstItem.nextItem;
        T object = null;

        if (firstItem.index == index) {
            object = firstItem.item;
        } else if (lastItem.index == index) {
            object = lastItem.item;
        } else {
            while (currentItem.nextItem != null) {
                if (currentItem.index == index) {
                    object = currentItem.item;
                    break;
                } else {
                    currentItem = currentItem.nextItem;
                }
            }
        }
        return object;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> currentNode = firstItem;

        while (currentNode.nextItem != null) {
            result.append(currentNode.item.toString()).append(", ");
            currentNode = currentNode.nextItem;
        }
        result.append(lastItem.item.toString());

        return "[" + result + "]";
    }

    public int size(){
        return size;
    }
}
