
//interfaces,攻击接口
public interface AttackInterface {
    void LongDistance();// 远程攻击

    void ShortDistance();// 进程攻击

    void SpecialAttack();// 特殊攻击方法

    default void DefaultAttack() {
        System.out.println("default method");
    }
}
