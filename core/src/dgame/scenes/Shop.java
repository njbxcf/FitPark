package dgame.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import dgame.graphics.Renderer;

/**
 * Created by jesse on 2/22/15 under the Apache 2.0 license.
 */
public class Shop implements Scene {

    Texture bg = new Texture("shop.png");

    @Override
    public void Draw(Batch batch) {
        batch.draw(bg, 0, 0, 1280*Renderer.heightScale, 721*Renderer.widthScale);
    }
}
