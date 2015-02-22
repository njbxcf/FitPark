package dgame.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import dgame.Entity;
import dgame.GameState;
import dgame.graphics.Renderer;

import java.util.ArrayList;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Lawn implements Scene {

    ArrayList<Plant> grass;
    Texture backdrop;
    Texture bone = new Texture("bone.png");
    Texture fence;
    Texture dh = new Texture("doghouse.png");
    Texture t = new Texture("ball.png");
    Texture b = new Texture("shopbone.png");

    public Lawn() {
        grass = new ArrayList<Plant>();
        backdrop = new Texture("skygrass.png");
        fence = new Texture("fence.png");
        Gardener.Garden(this);
    }

    @Override
    public void Draw(Batch batch) {
        batch.draw(backdrop, 0, 0, 1280* Renderer.widthScale, 720*Renderer.heightScale);

        for(int i=0;i<1280;i+=54)
            batch.draw(fence, i*Renderer.widthScale, 510*Renderer.heightScale, 54*Renderer.widthScale, 171*Renderer.heightScale);

        for (Entity gras : grass) {
            batch.draw(gras.GetTexture(), gras.GetX()*Renderer.widthScale, gras.GetY()*Renderer.heightScale,
                    gras.GetTexture().getWidth()*Renderer.widthScale, gras.GetTexture().getHeight()*Renderer.heightScale);
        }
        batch.draw(dh, 990, 230, dh.getWidth()*Renderer.widthScale, dh.getHeight()*Renderer.heightScale);
        batch.draw(t, 200, 130, t.getWidth()*Renderer.widthScale, t.getHeight()*Renderer.heightScale);
        if(GameState.hasBone)
            batch.draw(b, 670, 330, b.getWidth()*Renderer.widthScale, b.getHeight()*Renderer.heightScale);
        batch.draw(bone, 272*Renderer.widthScale+12, -40*Renderer.heightScale);
    }

    public void AddPlant(Plant plant) {
        grass.add(plant);
    }

}
