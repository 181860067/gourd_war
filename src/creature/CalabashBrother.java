package creature;

import javafx.scene.image.Image;

public class CalabashBrother extends Creature implements AttackInterface {

    int RemoteAttackTimes;

    CalabashBrother(final String name, final int pos_x, final int pos_y, final direction Direction, final int HitPoint,
            final int Attack, final int Defence) {
        super(name, pos_x, pos_y, Direction, HitPoint, Attack, Defence);
        // TODO Auto-generated constructor stub
    }

    // 配置属性
    boolean SetAttribute() {
        return false;

    }

    @Override
    public void showImage() {

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

    public void AddRemoteAttack(final int times) {
        RemoteAttackTimes += times;
    }
}
