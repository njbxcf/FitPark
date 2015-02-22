package dgame;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Entities {

    public ArrayList<Entity> entities;

    public Entities() {
        entities = new ArrayList<Entity>();
    }

    public void AddEntity(Entity newEntity) {
        entities.add(newEntity);
    }

    public void Draw(Batch batch) {
        for (Entity entity : entities) {
            batch.draw(entity.GetTexture(), entity.GetX(), entity.GetY());
        }
    }

}
