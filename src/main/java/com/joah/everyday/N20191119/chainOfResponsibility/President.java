package com.joah.everyday.N20191119.chainOfResponsibility;

public class President extends Leader {

    public President(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 15){
            // 小于十五天校长审批
            System.out.println("校长" + name + "审批" + leaveNode.getPerson()
                    + "同学请假条，请假天数" + leaveNode.getNumber() + "天");
        }else {
            System.out.println("请假超过15天，不批准...");
        }
    }
}
