package com.joah.everyday.N2020.N202002.N20200226;

import java.sql.*;

/**
 * @author Joah
 * @time 2020/2/26 9:06
 */
public class Test {

    /**
     * N-45 JDBC连接数据库步骤（以MYSQL为例）
     *  1、加载 JDBC 驱动程序
     *      通过 Class类的 forName方法实现，并将驱动地址放进去
     *      成功加载后，会将 Driver 类的实例注册到 DriverManager 类中
     *
     *  2、提供 JDBC 连接的 URL，创建数据库的连接
     *      要连接数据库，需要向 java.sql.DriverManager 请求并获得 Connection 对象，该对象就代表一个数据库的连接
     *      使用 DriverManager 的 getConnection() 方法传入指定的欲连接的数据库的路径，数据库的用户名和密码
     *
     *  3、创建一个 Statement
     *      要执行 SQL 语句，必须获得 java.sql.Statement 实例
     *      执行静态 SQL 语句，通常通过 Statement() 实例实现
     *      执行动态 SQL 语句，通常通过 PreparedStatement 实例实现
     *      String sql = "";
     *      Statement st = con.createStatement();
     *      PreparedStatement pst = con.prepareStatement(sql);
     *
     *  4、执行 SQL 语句
     *      Statement 接口提供了 executeQuery 、 executeUpdate、execute三种方法
     *      executeQuery:执行 select 语句，返回 ResultSet 结果集
     *      ResultSet rst = pst.executeQuery();
     *      executeUpdate:执行 insert、update、delete 语句
     *      pst.executeUpdate();
     *
     *  5、关闭JDBC对象
     *      操作完成后要把所有使用的JDBC对象全部关闭，以释放 JDBC 资源
     */
    public static void jdbcDemo() throws SQLException {

        Connection connection = null;

        // 1、加载 JDBC 驱动
        try {
            System.out.println("1、加载 JDBC 驱动 --- 开始");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("1、加载 JDBC 驱动 --- 结束");
        // 2、提供 JDBC 连接的 URL ，创建数据库的连接
            System.out.println("2、提供 JDBC 连接的 URL ，创建数据库的连接 --- 开始");
            connection = DriverManager.getConnection("jdbc:mysql://local:3306/fancy_mail?serverTimezone=GMT%2B8&autoR&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true", "root", "root^");
            System.out.println("2、提供 JDBC 连接的 URL ，创建数据库的连接 --- 结束");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 3、创建一个Statement

        System.out.println("3、创建一个Statement --- 开始");
        Statement statement = connection.createStatement();
        System.out.println("3、创建一个Statement --- 结束");

        // 4、执行SQL

        System.out.println("4、执行SQL --- 开始");
        ResultSet resultSet = statement.executeQuery("select * from cron");
        System.out.println("4、执行SQL --- 结束" +resultSet);
        // 5、关闭连接

        System.out.println("5、关闭连接 --- 开始");
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("数据库连接关闭失败");
            e.printStackTrace();
        }
        System.out.println("5、关闭连接 --- 结束");
    }

    /**
     * N-46 、数据库连接池
     *  数据库连接池优点运行原理：
     *      在我们不使用数据库连接池的时候，每次访问数据库都需要创建连接，使用完成后需要释放关闭连接，而这样是很耗费资源的 ，
     *      当我们使用数据库连接池的时候，在tomcat启动的时候就创建了指定数量的连接，之后当我们程序使用的时候就直接从连接池里面取，而不需要创建
     *      同理，当我们使用完的时候也不需要关闭连接，而是将连接返回到连接池中，供其他请求继续使用
     *
     * 常用的连接池有两个
     *
     *      DBCP 比较稳定
     *      C3P0 性能比较高
     */

    /**
     * N-48、分段批量提交的时候出现异常怎么处理？
     *      通过 Map 来解决性能问题，首先在分段批量提交的时候，我们不采用事务，这样就能保证了合法的数据就自动提交，不合法的数据就自动进行回滚
     *      为了避免不合法数据影响后续合法数据的提交，采用定义业务规则字典表，实现对数据的验证，将不合法的数据记录下来，供用户进行后续处理，
     *      而合法的数据就全部提交
     */

    /**
     * N-49、jdbc批量处理数据
     *
     *  批量处理数据：（代码优化：提高程序执行性能）
     *  降低了 java 程序代码（客户端） 和数据库之间的 网络通信的次数
     *  在 jdbc 中进行批量插入的核心 API 为 addBatch,executeBatch
     *  大数据了的插入问题（jdbc,hibernate,mybatis）
     *      1、每次只插入一条和数据库交互多次（很耗时间）
     *      2、批量插入和数据库交互一次（内存溢出）
     *      3、分段批量插入（推荐）
     *
     *      jdbc 批量处理数据是通过 PreparedStatement 对象的 addbatch(), executebatch(), clearbatch() 进行和数据库的交互
     *      通常我们使用分段批量处理的方式 这样可以提高程序的性能，防止内存溢出
     *          1、每个 sql 语句和数据库交互一次（非批量操作）
     *          2、只和数据库交互一次（批量操作    内存溢出）
     *          3、当数据量达到一定额度的时候就和数据库进行交互，分多次进行（分段批量操作）
     *
     *          （500 和 1000）
     *          pst.addBatch()
     *
     *          if(i > 0 && i%1000 == 0){
     *              pst.executeBatch();
     *              pst.clearBatch();
     *          }
     *
     */

    /**
     * N-50、Oracle分页
     *
     *  select * from (select * from (select s.*,rowNum rn from student s) where rn <= 5) where rn > 0
     *
     */

    /**
     * N-51、Oracle 的 基本数据类型
     *      常用的：
     *          1、字符型
     *              Char 固定长度自付一，占 2000 个字节
     *              Varchar2 可变长度字符串 占 4000个字节
     *              NVarchar2 占 2000个字符（最多能存 2000个字母/中文）
     *          2、大对象型（lob）
     *              Blob:二进制数据 最大长度 4G
     *              Blob:用于存一些图片，视频，文件
     *              比如：当我们在进行文件上传时，我们一般把文件存在硬盘上，可以不占用数据库
     *          下载时，如果项目迁移时，文件也要跟着迁移，因此我们可以把用blob把它存在数据库中。但这样也增加了数据库的负担
     *
     *              Clob:字符数据 最大长度 4G，可以存大字符串
     *              varchar2 和 nvarchar2 都具有一定的局限性，他们长度有限，但是数据库中无论用 varchar2 或 nvarchar2 类型，
     *              还是用 clob，在java 端都使用 String 接收。
     *          3、数值型
     *              Integer 整数类型，小的整数
     *              Float 浮点数类型
     *              Real 实数类型
     *              Number(p.s)包含小数位的数值类型。P 表示精度，s 表示小数后的位数。
     *                  eg: number(10,2)表示小数点之前可有8位数字，小数点后有 2 位
     *           4、日期类型
     *              Date 日期（日-月-年）DD-MM-YY(HH-MI-SS)
     *              Timestamp 根 date 比 它可以精确到微妙，精确范围 0~9 默认为 6
     *
     *
     */

    /**
     * N-52、 id, rowid, rownum 的区别
     *
     *  rowid 物理位置的唯一表示
     *
     *  而id 是逻辑上的唯一表示，所以 rowid查找速度要快于id 是目前最快的定位一条记录的方式
     *
     *  定位一条记录的方式
     *  rowid 和 rownum 都是 “伪数列”
     *      所谓伪数列也就是默认隐藏的一个数列
     *      rownum 用于标记结果集中结果顺序的一个字段
     *      它的特点是按顺序标记，而且是连续的，换句话说就是只有 有 rownum = 1的记录，才可能有 rownum = 2的记录
     *      rownum 关键字只能和 < 或者 <= 直接关联
     *      如果是 > 或者 = 则需要给他起一个别名
     *
     */

    /**
     * N-53 主键和唯一索引的区别？
     *
     *  在创建主键的同时，会生成对应的唯一索引，
     *  主键在保证数据唯一性的同事不允许为空，而唯一可以有一个为空的数据项，
     *  一个表中只能有一个主键，但是一个主键可以有多个字段，一个表中可以有多个唯一索引
     *
     */

    /**
     * N-54、Prepared Statement 和 Statement 的区别？
     *
     *  用 Prepared Statement 进行开发，Prepared Statement 是预编译的，而 statement 不是
     *  在每次执行 sql 语句的增删改时，如果是一条数据两者没差距，但如果数据量大于1，那么每次执行sql语句 statement 都需要重新编译一次
     *  而 Prepared statement 不用，Prepared statement 的运行效率大于 statement；
     *  从代码的可维护性和可阅读性来说，虽然 用 Prepared statement 来代替 statement 会使代码多几行，
     *  但这样的代码无论从可读性还是可维护性来说，都比直接使用 statement 的代码高很多档次；最重要的一点，
     *  从安全角度来说，使用 Prepared Statement 可以大大提高程序的安全性，因为 Prepared statement 是用 '?' 传参，可以防止 sql 注入
     *  具有安全性，而 statement 用的是 '+' 字符串拼接，安全性较低
     *
     */

    /**
     * N-55、数据库三范式
     *
     *      第一范式：数据库表中所有字段值都是不可分解的原子值
     *
     *      第二范式：需要确保数据库表中的每一列都和主键相关，而不能只与主键的某一部分相关（注意真对联合主键而言）
     *
     *      第三范式：需要确保数据表中每一列数据都和主键直接相关，而不能间接相关
     *
     */

}
