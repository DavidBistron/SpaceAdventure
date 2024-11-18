package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

// Class for handling collisions with collectibles and meteorites
public abstract class CollisionHandler {
    protected Timer timer;
    protected int temp = 0;

    // Common method for collision detection
    public void startCollisionDetection(int[] objectX, int[] objectY, int objectCount, int hitRadiusX, int hitRadiusY, int hitOffsetY) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                for (int i = 0; i < objectCount; i++) {
                    if (temp == 0) {
                        // Collision detection
                        if (Variables.ufoX >= objectX[i] - hitRadiusX
                                && Variables.ufoX <= objectX[i] + hitRadiusX
                                && Variables.ufoY >= objectY[i] - hitRadiusY
                                && Variables.ufoY <= objectY[i] + hitOffsetY) {
                            handleCollision(i); // Abstract method for collision handling
                            objectY[i] = -100;  // Reset the object position
                            temp++;
                        }
                    }
                }
                updateTimer();
            }
        }, 0, 15);
    }

    // Abstract method for collision handling, implemented by subclasses
    protected abstract void handleCollision(int objectIndex);

    // Timer-Update logic
    private void updateTimer() {
        if (temp >= 1 && temp <= 10) {
            temp++;
        } else if (temp == 11) {
            temp = 0;
        }
    }
}