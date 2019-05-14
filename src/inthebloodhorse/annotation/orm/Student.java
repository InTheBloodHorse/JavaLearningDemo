package inthebloodhorse.annotation.orm;

@SqlTable("tb_student")
public class Student {
    @SqlField(columnName = "id", type = "int", length = 10)
    private Integer id;
    @SqlField(columnName = "name", type = "varchar", length = 50)
    private String name;
    @SqlField(columnName = "age", type = "int", length = 3)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
