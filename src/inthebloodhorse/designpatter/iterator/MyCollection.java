package inthebloodhorse.designpatter.iterator;

import java.util.ArrayList;

public class MyCollection<T> {
    ArrayList<T> list = new ArrayList<>();

    public MyCollection() {
    }

    public void add(T obj) {
        list.add(obj);
    }

    public void remove(T obj) {
        list.remove(obj);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    public MyIterator getIterator() {
        return new Iterator();
    }

    private class Iterator implements MyIterator<T> {

        Integer cursor = 0;

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if (cursor < list.size()) {
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            if(cursor<list.size()){
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor == 0 ? true : false;
        }

        @Override
        public boolean isLast() {
            return cursor == list.size() - 1 ? true : false;
        }

        @Override
        public T getCurrent() {
            return list.get(cursor);
        }
    }
}
