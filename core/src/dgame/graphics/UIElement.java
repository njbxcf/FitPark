package dgame.graphics;

import com.badlogic.gdx.graphics.Texture;
import dgame.Entity;

/**
 * Created by jesse on 2/22/15 under the Apache 2.0 license.
 */
public class UIElement extends Entity {

    private int width, height;

    public UIElement(Texture texture) {
        super(texture);
        width = texture.getWidth();
        height = texture.getHeight();
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }

}
