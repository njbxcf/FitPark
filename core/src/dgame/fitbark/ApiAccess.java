package dgame.fitbark;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class ApiAccess {

    private String AuthCode;
    private String AppID;
    private String AppKey;
    private Net.HttpResponseListener listener;

    public ApiAccess() {
        AuthCode = "08bb0ba971d4a7efc18b62d455a32261e49ea7e248326a118e75c2fb4a8b42c2";
        AppID = "26dd4dd2c221dabfa3656cfa40ef0d703708aa656583cf79d8825c2a8cb30006";
        AppKey = "d63e2bc8ff399af838e0758ee6dea150876f8e685428d24253a5d7bd9b05e4eb";
        MakeRequest();
    }

    public void MakeRequest() {
        listener = new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                Gdx.app.log("Response", httpResponse.getResultAsString());
                Gdx.app.exit();
            }

            @Override
            public void failed(Throwable t) {
                Gdx.app.error("http failed",t.getMessage());
            }

            @Override
            public void cancelled() {
                Gdx.app.error("http","Cancelled");
            }
        };

        Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.GET);
        httpPost.setUrl("http://app.fitbark.com/oauth/authorize");
        httpPost.setHeader("Authorization", "Bearer "+AuthCode);
        httpPost.setHeader("response_type","client_credentials");
        Gdx.net.sendHttpRequest(httpPost, listener);

        Net.HttpRequest httpPost2 = new Net.HttpRequest(Net.HttpMethods.GET);
        httpPost2.setUrl("http://app.fitbark.com/api/user");
        httpPost2.setHeader("Authorization", "Bearer "+AuthCode);
        Gdx.net.sendHttpRequest(httpPost2, listener);
    }

}
