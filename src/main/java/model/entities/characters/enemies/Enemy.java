package model.entities.characters.enemies;

import model.Direction;
import model.Position;
import model.entities.characters.Character;

import java.awt.*;

public abstract class Enemy implements Character {
    public static final int HITBOX_OFFSET = 2;
    protected static final int VISION_SIZE = 100;
    protected static final int ATTACK_RANGE_EXTENSION = 1;

    protected Position position;
    protected Direction facing;
    private int health;
    private final int maxHealth;
    private final int damage;
    protected Rectangle hitbox;
    protected Rectangle attackRange;
    protected final int hitboxWidth;
    protected final int hitboxHeight;
    public long attackDelay;

    private final Rectangle vision;
    protected boolean attacking = false;
    public long lastAttack = 0;

    public Enemy(Position startPosition, int health, int damage, int hitboxWidth, int hitboxHeight, long attackDelay) {
        this.position = startPosition;
        this.maxHealth = health;
        this.health = maxHealth;
        this.damage = damage;
        this.facing = Direction.RIGHT;

        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
        this.attackDelay = attackDelay;

        this.hitbox = new Rectangle(position.getX() + HITBOX_OFFSET, position.getY() + HITBOX_OFFSET, hitboxWidth,
                hitboxHeight);
        this.vision = new Rectangle(position.getX() - (VISION_SIZE / 2), position.getY() - (VISION_SIZE / 2),
                VISION_SIZE, VISION_SIZE);
        this.attackRange = new Rectangle(hitbox.x - ATTACK_RANGE_EXTENSION, hitbox.y - ATTACK_RANGE_EXTENSION,
                hitboxWidth + 2 * ATTACK_RANGE_EXTENSION, hitboxHeight + 2 * ATTACK_RANGE_EXTENSION);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.hitbox.setBounds(position.getX() + HITBOX_OFFSET, position.getY() + HITBOX_OFFSET, hitboxWidth,
                hitboxHeight);
        this.vision.setBounds(position.getX() - VISION_SIZE / 2, position.getY() - VISION_SIZE / 2, VISION_SIZE,
                VISION_SIZE);
        this.attackRange.setBounds(hitbox.x - ATTACK_RANGE_EXTENSION, hitbox.y - ATTACK_RANGE_EXTENSION,
                hitboxWidth + 2 * ATTACK_RANGE_EXTENSION, hitboxHeight + 2 * ATTACK_RANGE_EXTENSION);
    }

    @Override
    public void move(Direction direction) {
        setFacing(direction);
        setPosition(nextPos(direction));
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void takeDamage(int amount) {
        health -= amount;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setAttacking(boolean value) {
        this.attacking = value;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Rectangle getAttackRange() {
        return attackRange;
    }

    public Rectangle getVision() {
        return vision;
    }

    @Override
    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    @Override
    public abstract String toStringImg();

    public boolean canAttack() {
        long now = System.currentTimeMillis();

        return now - lastAttack >= attackDelay;
    }

    public void attack(Character character) {
        lastAttack = System.currentTimeMillis();
        attacking = true;
        character.takeDamage(damage);

    }

}
