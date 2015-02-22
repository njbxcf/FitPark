package dgame.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Renderer {

    private final int givenWidth = 1280, givenHeight = 720;
    private float widthScale, heightScale;
    private int width, height;

    Batch batch;
    Lawn lawn;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
        widthScale = (float)width / (float)givenWidth;
        heightScale = (float)height / (float)givenHeight;

        batch = new SpriteBatch();
        lawn = new Lawn();
    }

    public void DrawLawn(Batch batch) {
        lawn.Draw(batch);
    }

}
