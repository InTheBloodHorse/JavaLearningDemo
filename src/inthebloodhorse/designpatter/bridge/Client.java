package inthebloodhorse.designpatter.bridge;

public class Client {
    public static void main(String[] args) {
        // 联想笔记本
        Brand brand = new Lenovo();
        Laptop laptop = new Laptop(brand);
        laptop.sale();
    }
}
