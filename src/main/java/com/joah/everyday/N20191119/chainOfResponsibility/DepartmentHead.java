package com.joah.everyday.N20191119.chainOfResponsibility;

public class DepartmentHead extends Leader{

    public DepartmentHead(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 7){
            // 小于七天系主任审批
            System.out.println("系主任" + name + "审批" + leaveNode.getPerson()
                    + "同学的请假条，请假天数为" + leaveNode.getNumber() + "天。");
        }else {
            if (this.successor != null){
                this.successor.handleRequest(leaveNode);
            }
        }
    }
}
