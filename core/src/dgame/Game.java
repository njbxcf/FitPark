package dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dgame.fitbark.ApiAccess;
import dgame.graphics.Renderer;

public class Game extends ApplicationAdapter {

    Renderer renderSetup;
    Entities entities;
    Batch batch;

	@Override
	public void create () {
        renderSetup = new Renderer(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        entities = new Entities();
        batch = new SpriteBatch();
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
        batch.end();
	}
}
