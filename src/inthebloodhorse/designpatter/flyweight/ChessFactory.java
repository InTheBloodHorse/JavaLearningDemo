package inthebloodhorse.designpatter.flyweight;

import java.util.HashMap;
import java.util.Map;

// 享元工厂类
public class ChessFactory {
    private static Map<String, Chess> map = new HashMap<>();

    public static Chess getChess(String color) {
        Chess chess = map.get(color);
        if (chess == null) {
            chess = new ColorChess(color);
            map.put(color, chess);
        }
        return chess;
    }
}
