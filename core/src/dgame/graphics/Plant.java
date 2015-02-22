package dgame.graphics;

import com.badlogic.gdx.graphics.Texture;
import dgame.Entity;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Plant extends Entity {

    private int Width, Height;

    public Plant(Texture texture) {
        super(texture);
        Width = texture.getWidth();
        Height = texture.getHeight();
    }

    public int GetWidth() {
        return Width;
    }

    public int GetHeight() {
        return Height;
    }

}
