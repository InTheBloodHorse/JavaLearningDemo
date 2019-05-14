package inthebloodhorse.designpatter.prototype;

import java.io.Serializable;
import java.util.Date;

public class CloneSheep implements Cloneable, Serializable {
    private String name;
    private Date date;

    public CloneSheep() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneSheep cloneSheep = (CloneSheep) super.clone();

        // 深拷贝
        cloneSheep.date = (Date) this.date.clone(); // 浅拷贝的话 去掉本行
        return cloneSheep;
    }
}
