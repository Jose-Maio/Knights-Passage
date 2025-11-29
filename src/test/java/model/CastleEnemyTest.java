package model;



import model.entities.characters.enemies.CastleEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastleEnemyTest {

    private CastleEnemy castleEnemy;

    @BeforeEach
    void setUp() {
        castleEnemy = new CastleEnemy(new Position(4, 7), 20, 5);
    }

    @Test
    void testInitialValues() {
        assertEquals(4, castleEnemy.getPosition().getX());
        assertEquals(7, castleEnemy.getPosition().getY());
        assertFalse(castleEnemy.isDead());
    }

    @Test
    void testMove() {
        castleEnemy.move(Direction.DOWN);
        assertEquals(4, castleEnemy.getPosition().getX());
        assertEquals(8, castleEnemy.getPosition().getY());

        castleEnemy.move(Direction.RIGHT);
        assertEquals(5, castleEnemy.getPosition().getX());
        assertEquals(8, castleEnemy.getPosition().getY());
    }

    @Test
    void testTakeDamage() {
        castleEnemy.takeDamage(10);
        assertFalse(castleEnemy.isDead());

        castleEnemy.takeDamage(15);
        assertTrue(castleEnemy.isDead());
    }

    @Test
    void testNoCustomUpdateBehavior() {
        assertDoesNotThrow(() -> castleEnemy.update());
    }
}
