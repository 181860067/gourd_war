
public class Creature {
    boolean isAlive;// 判断是否活着
    direction Direction;// 判断方向，用于选择形象
    String name;
    int Speed;
    int HitPoint;// 生命值
    int Attack;// 攻击力
    int Defence;// 防御力
    // 位置相关数据结构--TODO

    enum direction {
        UP, DOWN, LEFT, RIGHT;
    }

    Creature() {
        this.name = "";
        this.isAlive = true;
        // 初始化位置--TODO
        this.Direction = direction.UP;
        this.Attack = 0;
        this.Defence = 0;
    }

    Creature(String name, int pos_x, int pos_y, direction Direction, int HitPoint, int Attack, int Defence) {
        this.name = name;
        this.isAlive = true;
        // 初始化位置--TODO
        this.Direction = Direction;
        this.Attack = Attack;
        this.Defence = Defence;
    }

    // 移动
    public boolean Move(direction moveDirection, int x, int y) {

        return true;

    }

    public boolean IsDied() {
        return !(this.isAlive);
    }

    public String getName() {
        return name;
    }

}
// 属性：
// 是否还活着
// 生命值
// 速度
// 攻击力
// 防御力
// 图片