package com.disruption.CRE.API;

import com.disruption.CRE.Chorus_Request_Engine;
import masecla.reddit4j.objects.RedditPost;
import java.io.IOException;

public class API {
    public RedditPost getRandomPost() throws IOException, InterruptedException {
        return Chorus_Request_Engine.getClient().getRandom(false, 1).get();
    }
}
