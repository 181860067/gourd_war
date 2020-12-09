import javafx.scene.image.Image;

public class CalabashBrother extends Creature implements AttackInterface {

    CalabashBrother(String name, int pos_x, int pos_y, direction Direction, int HitPoint, int Attack, int Defence) {
        super(name, pos_x, pos_y, Direction, HitPoint, Attack, Defence);
        // TODO Auto-generated constructor stub
    }

    // 配置属性
    boolean SetAttribute() {
        return false;

    }

    // 攻击--根据战况调用攻击接口相关函数
    void AutoAttack() {

    }

    // 存档状态--
    String State() {
        return "";

    }

    @Override
    public void LongDistance() {
        // TODO Auto-generated method stub

    }

    @Override
    public void ShortDistance() {
        // TODO Auto-generated method stub

    }

    @Override
    public void SpecialAttack() {
        // TODO Auto-generated method stub

    }

    // 技能
}
