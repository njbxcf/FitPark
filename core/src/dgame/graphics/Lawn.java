package dgame.graphics;

import com.badlogic.gdx.graphics.g2d.Batch;
import dgame.Entity;

import java.util.ArrayList;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Lawn {

    ArrayList<Entity> grass;

    public Lawn() {
        grass = new ArrayList<Entity>();
    }

    public void Draw(Batch batch) {
        for (Entity gras : grass) {
            batch.draw(gras.GetTexture(), gras.GetX(), gras.GetY());
        }
    }

}
