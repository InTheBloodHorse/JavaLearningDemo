package inthebloodhorse.designpatter.composite;

import java.io.File;

public class Client {
    public static void addFile(Folder file, File parent) {
        for (File f : parent.listFiles()) {
            if (f.isDirectory()) {
                Folder childFile = new Folder(f.getName());
                addFile(childFile, f);
                file.add(childFile);
            }
            if (f.isFile()) {
                file.add(new TextFile(f.getName()));
            }
        }
    }

    public static void main(String[] args) {
        String path = "E:\\blog\\BestOfDp.github.io\\source";
        File file = new File(path);
        Folder root = new Folder(file.getName());
        // 读取文件夹目录
        addFile(root, file);

        root.kill(0);


    }
}
