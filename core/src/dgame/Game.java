package dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dgame.fitbark.ApiAccess;
import dgame.graphics.Renderer;

public class Game extends ApplicationAdapter {

    Renderer renderSetup;
    Entities entities;
    Batch batch;
    UI ui;

	@Override
	public void create () {
        renderSetup = new Renderer(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        entities = new Entities();
        batch = new SpriteBatch();
        ui = new UI();
        UIElement shop = new UIElement(new Texture("store-btn.png"));
        shop.SetX(25);
        shop.SetY(25);
        ui.AddUIElement(shop);
        ApiAccess apiAccess = new ApiAccess();
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(0.48f, 0.78f, 0.34f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.enableBlending();
        renderSetup.DrawLawn(batch);
        entities.Draw(batch);
        ui.Draw(batch);
        batch.end();
	}
}
