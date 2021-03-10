package exam.blf;

/**
 * 二叉树最短路径
 * 于下图所示二叉树，2和8的最短路径是2，8和6的最短路径是5。
 * 假定二叉树各个节点值唯一，求由这两个数组构造出的二叉树上，两个节点的最短路径
 * 输入：
 * [[1,2],[1,3],[2,4],[2,5],[4,8],[4,9],[3,6],[3,7]],8,6
 * 输出：
 * 5
 * 最大在店人数
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一份乱序日志文件, 日志文件使用 "|" 分隔, 分隔后的每一条日志是当天门店的顾客进出记录,
 * 代表一次顾客进出便利店的记录, 格式为 [uid, in, ts] 或 [uid, out, ts], 其中 uid
 * 是用户 id, in/out 表示进出门店,  ts 是时间, 代表当天的秒数, 如 ts=0,
 * 则代表当天 00:00, ts=3600, 则代表当天 1:00, 求当天门店内的最大店内人数
 * 查找关联用户
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 在相同设备(device)登陆过的用户(user)称为有关联(如果user1和2有关联,
 * 2和3有关联, 那么1和3也有关联). 请实现一个查询关联用户的功能, 返回userId的关联用户的数量.
 */
public class Main {
    int i;
    int a ;
    public void test(){
        i++;
    }

    public static void main(String[] args) {

        float a = 123456789;
        System.out.println(a);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        float b = -1.0f;
        System.out.println(b);
        System.out.println((b-Float.MIN_VALUE>0));
        String s = new String("a");
    }
}
