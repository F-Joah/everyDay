package com.neo.data.N20200406;

/**
 * 单链表
 * @author Joah
 * @time 2020/4/6 11:10
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        // 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        // 根据编号插入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        // 插入重复的
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
        System.out.println("-------------------------------------------------------");
        // 测试修改
        HeroNode newHeroNode = new HeroNode(2, " 小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        // 显示
        singleLinkedList.list();
        System.out.println("-------------------------------------------------------");
        // 删除节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        // 显示
        singleLinkedList.list();
        // 测试，求单链表的有效链表个数
        System.out.println("有效链表个数:" + getLength(singleLinkedList.getHead()));

        // 测试 查找单链表中的倒数第 k 个节点
        HeroNode result = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("result: " + result);

    }


    /**
     * 题目 查找单链表中的倒数第 k 个节点
     *  1、编写一个方法，接收 head 节点，同时接收一个 index
     *  2、index 表示倒数第 index 个节点
     *  3、先把链表从头到尾遍历，得到链表的总长度  getLength
     *  4、得到 size 后，从链表第一个开始遍历（size - index）个，就可以得到
     *  5、如果找到了，返回该节点，否则返回 null
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index)
    {
        // 如果链表为空，返回 Null
        if ( head.next == null)
        {
            return null;
        }
        // 第一次遍历，得到链表的长度（节点个数）
        int size = getLength(head);
        // 第二次遍历 size - index 位置，就是我们找到的 倒数第 k 个节点
        // 先做一个 Index 的校验
        if ( index <= 0 || index > size)
        {
            return null;
        }
        // 定义一个辅助变量,for 循环到倒数的 index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++)
        {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 题目：获取到单链表的节点的个数（如果是带头节点的链表，不统计头节点）
     * @param head 链表的头节点
     * @return 有效节点的个数
     */
    public static int getLength(HeroNode head)
    {
        if (head.next == null)
        {
            // 链表为空
            return 0;
        }
        int length = 0;
        // 定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null)
        {
            length++;
            // 遍历
            cur = cur.next;
        }
        return length;
    }

}

/**
 * 定义一个  SingleLinkedList 用来管理 【英雄】
 */
class SingleLinkedList
{
    /**
     * 先初始化一个 头节点，头节点不要动
     */
    private HeroNode head = new HeroNode(0,"", "");

    /**
     * 返回头节点
     * @return
     */
    public HeroNode getHead()
    {
        return head;
    }
    /**
     * 添加节点到单向链表
     *      思路：当不考虑编号顺序的时候
     *      1、找到当前链表的最后节点
     *      2、将最后这个节点的 next 指向新的节点
     */
    public void add(HeroNode heroNode)
    {
        // 因为 head 节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        // 遍历链表，找到最后节点
        while (true)
        {
            // 当 next 为空的时候，即找到了最后一个节点
            if ( temp.next == null)
            {
                break;
            }
            // 如果没有找到最后，就将 temp 后移
            temp = temp.next;
        }
        // 当退出 while 循环时，temp 就指向新的节点
        temp.next = heroNode;
    }

    /**
     *  根据排名进行添加
     */
    public void addByOrder(HeroNode heroNode)
    {
        /**
         * 因为头节点不能动，我们依然通过 辅助指针（变量） 来帮助找到添加的位置
         *  因为单链表， 我们找的 temp 是位于添加位置的前一个节点，否则不允许插入
         */
        HeroNode temp = head;
        // 标志，添加的节点编号是否存在，（默认不存在）
        boolean flag = false;
        while (true)
        {
            // 到链表最后，break
            if (temp.next == null)
            {
                break;
            }
            // 找到了链表位置，在 temp 后面插入
            if ( temp.next.no > heroNode.no)
            {
                break;
            }else if (temp.next.no == heroNode.no)
            {
                // 此时，heroNode的编号已经存在了
                flag = true;
                break;
            }
            // 后移
            temp = temp.next;
        }
        // 判断 flag 的值,true 不能添加
        if (flag)
        {
            System.out.printf("准备插入的英雄的编号: %d 已经存在了，不能加入 \n", heroNode.no);
        }else {
            // 插入到链表中.temp 后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点信息，根据 no 编号来修改，即 no 编号不能修改
     */
    public void update(HeroNode newHeroNode)
    {
        // 判断是否为空
        if ( head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点，根据 no 编写
        // 定义一个辅助变量
        HeroNode temp = head.next;
        // 判断是否找到该节点
        boolean flag = false;
        while (true)
        {
            if (temp == null)
            {
                // 表示链表遍历完了
                break;
            }
            if (temp.no == newHeroNode.no)
            {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据 flag 判断是否找到，要修改的节点
        if (flag)
        {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.printf("没有找到 %d ,不能修改\n", newHeroNode.no);
        }
    }

    public void del(int delNo)
    {
        HeroNode temp = head;
        // 判断是否找到待删除的节点
        boolean flag = false;

        while (true)
        {
            if (temp.next == null)
            {
                // 已经到链表最后
                break;
            }
            if (temp.next.no == delNo)
            {
                // 找到了待删除节点的前一个节点 temp
                flag = true;
                break;
            }
            // temp 后移，才能实现遍历
            temp = temp.next;
        }

        if (flag)
        {
            // 找到了要删除的节点
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", delNo);
        }
    }

    /**
     * 显示链表 【遍历】
     */
    public void list()
    {
        // 先判断链表是否为空
        if ( head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点 不能动，因此，我们需要一个 辅助变量 来遍历
        HeroNode temp = head.next;
        while (true)
        {
            // 判断是否到链表最后
            if ( temp == null)
            {
                break;
            }
            // 输出节点信息
            System.out.println(temp.toString());
            // 将 next 后移
            temp = temp.next;
        }
    }

}

/**
 * 定义一个 HeroNode,每个 HeroNode 对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroNode next;

    public HeroNode(int hNo, String hName, String hNickName)
    {
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;
    }

    /**
     * 重新 toString
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\''+
                '}';
    }
}
