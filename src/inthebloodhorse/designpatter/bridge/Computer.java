package inthebloodhorse.designpatter.bridge;

public class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }
}

class Desktop extends Computer {
    protected Brand brand;

    public Desktop(Brand brand) {
        super(brand);
    }

    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}

class Laptop extends Computer {
    protected Brand brand;

    public Laptop(Brand brand) {
        super(brand);
    }

    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}




