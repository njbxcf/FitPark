package dgame;

import com.badlogic.gdx.graphics.Texture;

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
