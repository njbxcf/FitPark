package dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dgame.fitbark.ApiAccess;
import dgame.graphics.UI;
import dgame.graphics.UIElement;
import dgame.scenes.Lawn;
import dgame.graphics.Renderer;
import dgame.scenes.Shop;

public class Game extends ApplicationAdapter {

    Renderer renderSetup;
    Entities entities;
    Batch batch;
    UI ui;

	@Override
	public void create () {
        Lawn lawn = new Lawn();
        Shop shop = new Shop();
        GameState.lawn = lawn;
        GameState.shop = shop;
        GameState.ToLawn();

        renderSetup = new Renderer(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        entities = new Entities();
        batch = new SpriteBatch();

        ui = new UI();
        UIElement shopBag = new UIElement(new Texture("store-btn.png"));
        shopBag.SetX(25);
        shopBag.SetY(25);
        ui.AddUIElement(shopBag);

        ApiAccess apiAccess = new ApiAccess();
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(0.48f, 0.78f, 0.34f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(GameState.isChanged)
            renderSetup.scene = GameState.current;

        batch.begin();
        batch.enableBlending();
        renderSetup.Draw(batch);
        entities.Draw(batch);
        ui.Draw(batch);
        batch.end();
	}
}
