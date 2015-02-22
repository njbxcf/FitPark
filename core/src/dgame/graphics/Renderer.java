package dgame.graphics;

import com.badlogic.gdx.graphics.g2d.Batch;
import dgame.scenes.Scene;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Renderer {

    private final int givenWidth = 1280, givenHeight = 720;
    public static float widthScale, heightScale;
    private int width, height;

    public Scene scene;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
        widthScale = (float)width / (float)givenWidth;
        heightScale = (float)height / (float)givenHeight;
    }

    public void SetScene(Scene newScene) {
        scene = newScene;
    }

    public void Draw(Batch batch) {
        scene.Draw(batch);
    }

}
