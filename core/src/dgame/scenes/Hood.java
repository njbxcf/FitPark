package dgame.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import dgame.graphics.Renderer;

/**
 * Created by jesse on 2/22/15 under the Apache 2.0 license.
 */
public class Hood implements Scene {

    Texture bg = new Texture("neighboorhood.png");

    @Override
    public void Draw(Batch batch) {
        batch.draw(bg, 0, 0, 1280* Renderer.widthScale, 721*Renderer.heightScale);
    }

}
