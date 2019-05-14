package inthebloodhorse.designpatter.mediator;

public interface Department {
    void selfAction(); // 做本部门的事情

    void outAction(); // 向中介者发出申请
}

class Development implements Department {
    private Mediator mediator; // 持有中介者对象

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register(this.getClass().getSimpleName(), this);
    }

    @Override
    public void selfAction() {
        System.out.println("开发");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作,需要资金支持");
        mediator.command(Finacial.class.getSimpleName());
    }
}

class Finacial implements Department {
    private Mediator mediator; // 持有中介者对象

    public Finacial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register(this.getClass().getSimpleName(), this);
    }

    @Override
    public void selfAction() {
        System.out.println("计算财务");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作,共有资金XXX");
    }
}