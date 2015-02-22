package dgame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Entity {

    private Texture Tex;
    private int X=0, Y=0;
    public int cost = 0;

    public Entity(Texture texture) {
        Tex = texture;
    }

    public Texture GetTexture() {
        return Tex;
    }

    public int GetX() {
        return X;
    }

    public int GetY() {
        return Y;
    }

    public void SetX(int x) {
        X = x;
    }

    public void SetY(int y) {
        Y = y;
    }

}
