package inthebloodhorse.designpatter.flyweight;

// 享元类
public interface Chess {
    String getColor();

    void display(Coordinate coordinate);
}


class ColorChess implements Chess {

    private String color;

    public ColorChess(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println(String.format("颜色为:%s", this.color));
        System.out.println(String.format("X坐标为:%d,Y坐标为:%d", coordinate.getX(), coordinate.getY()));
    }
}