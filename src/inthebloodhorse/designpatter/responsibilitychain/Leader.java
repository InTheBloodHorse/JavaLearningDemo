package inthebloodhorse.designpatter.responsibilitychain;

// 抽象类
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    // 处理请假请求
    public abstract void handleRequest(LeaveRequest leaveRequest);

    protected void accept(LeaveRequest leaveRequest) {
        System.out.println(String.format("%s同意该%s的请求:原因 %s ,天数%d",
                this.name, leaveRequest.getName(), leaveRequest.getReason(),
                leaveRequest.getDay()));
    }

    protected void cancel(LeaveRequest leaveRequest) {
        System.out.println("拒绝请求");
    }

    public Leader(String name) {
        this.name = name;
    }


    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
}
