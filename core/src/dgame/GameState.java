package dgame;

import dgame.scenes.Lawn;
import dgame.scenes.Scene;
import dgame.scenes.Shop;

/**
 * Created by jesse on 2/22/15 under the Apache 2.0 license.
 */
public class GameState {

    public static Scene current;

    public static Lawn lawn;
    public static Shop shop;

    public static boolean isChanged = true;

    public static void ToLawn() {
        current = lawn;
        isChanged = true;
    }

    public static void ToShop() {
        current = shop;
        isChanged = true;
    }

}
