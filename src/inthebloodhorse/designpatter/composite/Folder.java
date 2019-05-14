package inthebloodhorse.designpatter.composite;


import java.util.ArrayList;

public class Folder implements AbstractFile {
    public String name;
    private ArrayList<AbstractFile> fileList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile abstractFile) {
        this.fileList.add(abstractFile);
    }


    @Override
    public void kill(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("*** ");
        }
        System.out.println(String.format("开始排查文件夹%s", this.name));
        for (AbstractFile abstractFile : fileList) {
            abstractFile.kill(number + 1);
        }
    }


}

class TextFile implements AbstractFile {

    public String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void kill(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("*** ");
        }
        System.out.println(String.format("开始排查文件%s", this.name));
    }


}