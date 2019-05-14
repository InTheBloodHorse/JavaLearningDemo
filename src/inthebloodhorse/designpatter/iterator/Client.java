package inthebloodhorse.designpatter.iterator;

public class Client {
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<>();
        myCollection.add("Hello");
        myCollection.add("World");
        myCollection.add("Pony");
        MyIterator iterator = myCollection.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getCurrent());
            iterator.next();
        }
    }
}
