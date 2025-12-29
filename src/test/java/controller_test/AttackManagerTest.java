package controller_test;

import controller.managers.AttackManager;
import model.Direction;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        when(mockLevel.getCloseEnemyList()).thenReturn(new ArrayList<>());
    }

    @Test
    void testPlayerAttackWhenNotAttacking() {
        when(mockPlayer.isAttacking()).thenReturn(false);
        attackManager.playerAttack(mockLevel);
        verify(mockPlayer, never()).attack(any());
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
    void testEnemyAttack() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mockEnemy);

        when(mockEnemy.canAttack()).thenReturn(true);
        when(mockEnemy.getFacing()).thenReturn(Direction.LEFT);
        when(mockEnemy.getAttackRange()).thenReturn(new Rectangle(10, 10, 20, 20));
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(15, 15, 10, 10));
        when(mockLevel.getCloseEnemyList()).thenReturn(enemies);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
        doNothing().when(mockEnemy).attack(any());

        attackManager.enemyAttack(mockLevel);
        verify(mockEnemy, atLeastOnce()).setAttacking(false);
    }
}
