package inthebloodhorse.designpatter.templatemethod;

public abstract class Eater {

    public final StringBuilder a = new StringBuilder("55");

    public void order() {
        System.out.println("点单");
    }

    // 交给子类实现
    abstract void eat();

    public void goBack() {
        System.out.println("回家");
    }

    public final void doProcess() {
        order();
        eat();
        goBack();
    }
}

