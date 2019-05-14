package inthebloodhorse.designpatter.responsibilitychain;

public class Client {
    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest("1ni", 9, "有事");
        LeaderOne leaderOne = new LeaderOne("领导1");
        LeaderTwo leaderTwo = new LeaderTwo("领导2");
        leaderOne.setNextLeader(leaderTwo);

        leaderOne.handleRequest(leaveRequest);
    }
}
