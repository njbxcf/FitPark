package dgame.graphics;

import com.badlogic.gdx.graphics.g2d.Batch;

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
    
    public void Process() {

    }
    
    public void Draw(Batch batch) {
        for (UIElement uiElement : uiElements) {
            batch.draw(uiElement.GetTexture(), uiElement.GetX(), uiElement.GetY());
        }
    }

}
