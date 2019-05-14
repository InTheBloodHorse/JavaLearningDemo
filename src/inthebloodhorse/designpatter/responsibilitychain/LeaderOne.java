package inthebloodhorse.designpatter.responsibilitychain;

public class LeaderOne extends Leader {

    public LeaderOne(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getDay() < 3) {
            accept(leaveRequest);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            } else {
                cancel(leaveRequest);
            }
        }
    }
}

class LeaderTwo extends Leader {

    public LeaderTwo(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getDay() < 10) {
            accept(leaveRequest);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            } else {
                cancel(leaveRequest);
            }
        }
    }
}