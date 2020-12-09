package Treasure;

import creature.*;

public class Treasure {
    int HP;
    int strengthAttack;
    int strengthDefence;
    int times;// 远程攻击
    int speed;
    // TODO-image

    Treasure() {
        HP = 0;
        strengthAttack = 0;
        strengthDefence = 0;
        times = 0;
        speed = 0;
    }

    Treasure(int hp, int attack, int defence, int times, int speed_x) {
        HP = hp;
        strengthAttack = attack;
        strengthDefence = defence;
        speed += speed_x;
    }

    public void showImage() {

    }

    // 好像用不到
    public int getHP() {
        return HP;
    }

    public int getAttack() {
        return strengthAttack;
    }

    public int getDefence() {
        return strengthDefence;
    }

    public void Reward(Creature creature) {
        creature.getTreasure(HP, strengthAttack, strengthDefence, times, speed);
    }
}