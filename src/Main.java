import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(18);
        myList.add(11);
        myList.add(21);
        myList.add(56);

        Integer deletedItemByIndex = myList.remove(4);
        Integer gotInteger = myList.get(3);
        Integer deletedFirstItem = myList.pop();
        Integer deletedLastItem = myList.removeLast();



        System.out.println(deletedItemByIndex);
        System.out.println(gotInteger);
        System.out.println(deletedLastItem);
        System.out.println(deletedFirstItem);
        System.out.println(myList);
        System.out.println(myList.size());
    }
}