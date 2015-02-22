package dgame.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import dgame.Entity;

import java.util.ArrayList;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Lawn {

    ArrayList<Plant> grass;
    Texture backdrop;
    Texture fence;

    public Lawn() {
        grass = new ArrayList<Plant>();
        backdrop = new Texture("skygrass.png");
        fence = new Texture("fence.png");
    }

    public void Draw(Batch batch) {
        batch.draw(backdrop, 0, 0, 1280*Renderer.widthScale, 720*Renderer.heightScale);

        for(int i=0;i<1280;i+=54)
            batch.draw(fence, i*Renderer.widthScale, 510*Renderer.heightScale, 54*Renderer.widthScale, 171*Renderer.heightScale);

        for (Entity gras : grass) {
            batch.draw(gras.GetTexture(), gras.GetX()*Renderer.widthScale, gras.GetY()*Renderer.heightScale,
                    gras.GetTexture().getWidth()*Renderer.widthScale, gras.GetTexture().getHeight()*Renderer.heightScale);
        }
    }

    public void AddPlant(Plant plant) {
        grass.add(plant);
    }

}
