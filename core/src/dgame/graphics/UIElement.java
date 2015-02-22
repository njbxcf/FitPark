package dgame.graphics;

import com.badlogic.gdx.graphics.Texture;
import dgame.Entity;
import dgame.GameState;

/**
 * Created by jesse on 2/22/15 under the Apache 2.0 license.
 */
public class UIElement extends Entity {

    private int width, height;

    public int action;

    public UIElement(Texture texture, int act) {
        super(texture);
        width = texture.getWidth();
        height = texture.getHeight();
        action = act;
    }

    public void Action() {
        if(action == 0) {
            GameState.ToShop();
        } else if(action == 1) {
            GameState.ToHood();
        } else if(action == 2) {
            GameState.ToLawn();
        }
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }

}
