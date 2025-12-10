package controller;

import controller.managers.AttackManager;
import controller.managers.MovementManager;
import model.Direction;
import model.game.Level;
import model.entities.characters.Player;
import java.io.IOException;
import java.util.HashSet;

public class LevelController {

    private long lastEnemyUpdate = 0;

    public void update(Level level, HashSet<Direction> input, Boolean isAttackPressed) throws IOException {

        updatePlayer(level, input, isAttackPressed);

        updateEnemies(level);

        checkKeyPickup(level);

    }

    private void updatePlayer(Level level, HashSet<Direction> input, Boolean isAttackPressed) {
        Player player = level.getPlayer();
        player.setAttacking(isAttackPressed);
        if (player.isDead()) return;

        for(Direction direction : input){
            MovementManager.movePlayer(level, direction);
        }

        AttackManager.playerAttack(level);
    }

    private void updateEnemies(Level level) {
        long now = System.currentTimeMillis();

        long enemyMoveDelay = 100;
        if (now - lastEnemyUpdate < enemyMoveDelay) return;
        lastEnemyUpdate = now;

        MovementManager.moveEnemies(level);

        AttackManager.enemyAttack(level);


        level.removeDeadEnemies();
    }

    private void checkKeyPickup(Level level) {
        if (level.getArena().getKey() == null) return;

        if (level.getPlayer().getHitbox()
                .intersects(level.getArena().getKey().getHitbox())) {

            level.getArena().pickKey();
            level.getPlayer().pickUpKey();
        }
    }
}
