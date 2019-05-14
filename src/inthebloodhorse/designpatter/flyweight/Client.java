package inthebloodhorse.designpatter.flyweight;

public class Client {
    public static void main(String[] args) {
        Chess chess1 = ChessFactory.getChess("黑色");
        Chess chess2 = ChessFactory.getChess("黑色");
        System.out.println(chess1 == chess2); // true

        // 增加外部状态的处理
        chess1.display(new Coordinate(20, 20));
        chess2.display(new Coordinate(10, 10));
    }
}
