package com.joah.everyday.N2019.N201911.N20191119.chainOfResponsibility;

public class Instructor extends Leader {

    public Instructor(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 3){
            // 小于3天辅导员审批
            System.out.println("辅导员" + name + "审批" + leaveNode.getPerson() + "同学的请假条，请假天数为："
                    + leaveNode.getNumber() + "天。");
        }else {
            if (this.successor != null){
                this.successor.handleRequest(leaveNode);
            }
        }
    }
}
