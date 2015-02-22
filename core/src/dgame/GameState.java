package dgame;

import dgame.scenes.Lawn;
import dgame.scenes.Scene;
import dgame.scenes.Shop;

/**
 * Created by jesse on 2/22/15 under the Apache 2.0 license.
 */
public class GameState {

    public static int scene = 0;
    public static int points = 0;
    public static boolean hasBone = false;

    public static void ToLawn() {
        scene = 0;
    }

    public static void ToShop() {
        scene = 1;
    }

    public static void ToHood() {
        scene = 2;
    }

}
