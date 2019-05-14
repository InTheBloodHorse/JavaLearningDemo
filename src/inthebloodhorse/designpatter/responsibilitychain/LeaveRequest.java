package inthebloodhorse.designpatter.responsibilitychain;

// 封装请假基本信息
public class LeaveRequest {
    private String name;
    private Integer day;
    private String reason;

    public LeaveRequest(String name, Integer day, String reason) {
        this.name = name;
        this.day = day;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }


    public Integer getDay() {
        return day;
    }

    public String getReason() {
        return reason;
    }

}
