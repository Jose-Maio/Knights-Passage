package controller;

import controller.managers.AttackManager;
import controller.managers.MovementManager;
import model.Direction;
import model.Position;
import model.entities.objects.BloodDrops;
import model.game.level.Level;
import model.entities.characters.Player;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class LevelController {

    private final MovementManager movementManager;
    private final AttackManager attackManager;

    private long lastEnemyUpdate = 0;
    private boolean hasSpawnedPlayer = false;

    public LevelController() {
        this.movementManager = new MovementManager();
        this.attackManager = new AttackManager();
    }

    public void update(Level level, HashSet<Direction> input, Boolean isAttackPressed) throws IOException {

        spawnPlayerIfNeeded(level);

        level.specialBehavior();

        updatePlayer(level, input, isAttackPressed);

        updateEnemies(level);

        checkKeyPickup(level);

    }

    private void updatePlayer(Level level, HashSet<Direction> input, Boolean isAttackPressed) {
        Player player = level.getPlayer();
        player.setAttacking(isAttackPressed && player.canAttack());

        if (player.isDead()) return;

        for(Direction direction : input){
            movementManager.movePlayer(level, direction);
        }

        attackManager.playerAttack(level);
    }

    private void updateEnemies(Level level) {
        long now = System.currentTimeMillis();

        long enemyMoveDelay = 100;
        if (now - lastEnemyUpdate < enemyMoveDelay) return;
        lastEnemyUpdate = now;

        movementManager.moveEnemies(level);

        attackManager.enemyAttack(level);


        List<Position> deadPositions = level.removeDeadEnemies();
        for (Position pos : deadPositions) {
            level.getArena().getDynamicObjectList().add(new BloodDrops(pos));
        }


    }

    private void checkKeyPickup(Level level) {
        if (level.getArena().getKey() == null) {
            return;
        }


        if (level.getPlayer().getHitbox()
                .intersects(level.getArena().getKey().getHitbox())) {

            level.getArena().pickKey();
            level.getPlayer().pickUpKey();
        }
    }

    private void spawnPlayerIfNeeded(Level level){
        if(!hasSpawnedPlayer){
            level.spawnPlayer();
            level.getPlayer().setHasKey(false);
            hasSpawnedPlayer = true;
        }
    }

    public void setHasSpawnedPlayer(boolean value){
        hasSpawnedPlayer = value;
    }
}
