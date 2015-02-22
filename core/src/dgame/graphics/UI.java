package dgame.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import dgame.Entities;
import dgame.Entity;
import dgame.GameState;

import java.util.ArrayList;

/**
 * Created by jesse on 2/22/15 under the Apache 2.0 license.
 */
public class UI {

    private ArrayList<UIElement> uiElements;

    public UI() {
        uiElements = new ArrayList<UIElement>();
    }

    public void AddUIElement(UIElement element) {
        uiElements.add(element);
    }
    
    public void Process(Entities ents) {
        if(Gdx.input.justTouched()) {
            int x = Gdx.input.getX(), y = Gdx.input.getY();
            y = Gdx.graphics.getHeight() - y;

            for (UIElement uiElement : uiElements) {
                if(x >= uiElement.GetX() && x <= uiElement.GetX()+uiElement.GetWidth() &&
                        y >= uiElement.GetY() && y <= uiElement.GetY() + uiElement.GetHeight()) {
                    uiElement.Action();
                }
            }
            if(GameState.scene==1)
                for (Entity ent : ents.entities) {
                    if(x >= ent.GetX() && x <= ent.GetX()+ent.GetTexture().getWidth() &&
                            y >= ent.GetY() && y <= ent.GetY() + ent.GetTexture().getHeight() && ent.cost <= GameState.points) {
                        GameState.points -= ent.cost;
                        ent.SetX(10000);
                        if(ent.cost==1000) {
                            GameState.hasBone = true;
                        }
                    }
                }

        }
    }
    
    public void Draw(Batch batch) {
        for (UIElement uiElement : uiElements) {
            batch.draw(uiElement.GetTexture(), uiElement.GetX(), uiElement.GetY());
        }
    }

}
