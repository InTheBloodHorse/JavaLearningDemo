package inthebloodhorse.designpatter.mediator;

public class Client {
    public static void main(String[] args) {
        // 假设 开发部 要求 财务部 资金支持
        Mediator manager = new Manager();
        Department development = new Development(manager);
        Department finacial = new Finacial(manager);

        development.outAction();
    }
}
