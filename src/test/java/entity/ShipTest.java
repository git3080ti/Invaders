package entity;

import engine.DrawManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    Ship ship;

    @BeforeEach
    void init(){
        ship = new Ship(10,10);
    }

    @org.junit.jupiter.api.Test
    void moveRight() {
        ship.moveRight();
        assertEquals(12,ship.getPositionX());
    }

    @org.junit.jupiter.api.Test
    void shoot() throws InterruptedException {
        Set<Bullet> bullets = new HashSet<Bullet>();
        assertEquals(true,ship.shoot(bullets));
        assertEquals(false,ship.shoot(bullets));
        Thread.sleep(750);
        assertEquals(true,ship.shoot(bullets));
    }

    @org.junit.jupiter.api.Test
    void destroy() throws InterruptedException {
        ship.destroy();
        ship.update();
        assertEquals(true, ship.getSpriteType() == DrawManager.SpriteType.ShipDestroyed);
        assertEquals(true, ship.isDestroyed());
        Thread.sleep(1000);

        ship.update();
        assertEquals(false, ship.getSpriteType() == DrawManager.SpriteType.ShipDestroyed);
        assertEquals(false, ship.isDestroyed());

    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        assertEquals(2, ship.getSpeed());

    }

}