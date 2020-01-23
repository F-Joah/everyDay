package com.joah.everyday.N2019.N201911.N20191119.chainOfResponsibility;

public class Client {

    public static void main(String[] args) {
        Leader instructor = new Instructor("张三");
        Leader departmentHead = new DepartmentHead("李四");
        Leader dean = new Dean("王五");
        Leader president = new President("赵六");

        instructor.setSuccessor(departmentHead);
        departmentHead.setSuccessor(dean);
        dean.setSuccessor(president);

        //请假三天
        LeaveNode leaveNode = new LeaveNode("甲乙",3);
        instructor.handleRequest(leaveNode);

        //请假九天
        LeaveNode leaveNode1 = new LeaveNode("丙丁",9);
        instructor.handleRequest(leaveNode1);

        //请假十五天
        LeaveNode leaveNode2 = new LeaveNode("戊己",15);
        instructor.handleRequest(leaveNode2);

        //请假二十天
        LeaveNode leaveNode3 = new LeaveNode("庚欣",20);
        instructor.handleRequest(leaveNode3);
    }
}
