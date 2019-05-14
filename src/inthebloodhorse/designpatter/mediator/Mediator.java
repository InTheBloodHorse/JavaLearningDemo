package inthebloodhorse.designpatter.mediator;

import java.util.HashMap;

public interface Mediator {
    void register(String dname, Department department);

    void command(String dname);
}

class Manager implements Mediator {

    private HashMap<String, Department> map = new HashMap<>();

    @Override
    public void register(String dname, Department department) {
        map.put(dname, department);
    }

    @Override
    public void command(String dname) {
        Department target = map.get(dname);
        if (target == null) {
            throw new RuntimeException("没有该部门");
        } else {
            target.selfAction();
        }
    }
}
