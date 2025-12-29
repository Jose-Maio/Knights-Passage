package controller_test;

import controller.managers.AttackManager;
import model.Direction;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

class AttackManagerTest {
    private AttackManager attackManager;
    private Level mockLevel;
    private Player mockPlayer;
    private Enemy mockEnemy;

    @BeforeEach
    void setUp() {
        attackManager = new AttackManager();
        mockLevel = mock(Level.class);
        mockPlayer = mock(Player.class);
        mockEnemy = mock(Enemy.class);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
    }

    @Test
    void testPlayerAttack() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mockEnemy);

        when(mockPlayer.isAttacking()).thenReturn(true);
        when(mockPlayer.getFacing()).thenReturn(Direction.RIGHT);
        when(mockPlayer.getAttackRange()).thenReturn(new Rectangle(10, 10, 30, 20));
        when(mockEnemy.getHitbox()).thenReturn(new Rectangle(35, 15, 10, 10));
        when(mockLevel.getCloseEnemyList()).thenReturn(enemies);
        doNothing().when(mockPlayer).attack(any());

        attackManager.playerAttack(mockLevel);
        verify(mockPlayer, atLeastOnce()).attack(mockEnemy);
    }

    @Test
    void testEnemyAttackSuccess() {
        Enemy mockEnemy = mock(Enemy.class);
        when(mockLevel.getCloseEnemyList()).thenReturn(List.of(mockEnemy));
        when(mockEnemy.getFacing()).thenReturn(Direction.LEFT);
        when(mockEnemy.canAttack()).thenReturn(true);

        when(mockEnemy.getAttackRange()).thenReturn(new Rectangle(10, 10, 10, 10));
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(5, 10, 6, 10));

        attackManager.enemyAttack(mockLevel);

        verify(mockEnemy).attack(mockPlayer);
    }

    @Test
    void testAttackFailsWhenNoIntersection() {
        when(mockPlayer.isAttacking()).thenReturn(true);
        when(mockLevel.getCloseEnemyList()).thenReturn(List.of(mock(Enemy.class)));

        when(mockPlayer.getAttackRange()).thenReturn(new Rectangle(0, 0, 5, 5));
        when(mockLevel.getCloseEnemyList().get(0).getHitbox()).thenReturn(new Rectangle(50, 50, 5, 5));

        attackManager.playerAttack(mockLevel);

        verify(mockPlayer, never()).attack(any());
    }
}