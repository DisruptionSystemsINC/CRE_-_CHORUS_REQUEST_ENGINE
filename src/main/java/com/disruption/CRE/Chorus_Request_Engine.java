package com.disruption.CRE;

import com.disruption.CRE.API.API;
import com.disruptionsystems.DragonLog;
import com.disruptionsystems.logging.LogLevel;
import masecla.reddit4j.client.Reddit4J;
import masecla.reddit4j.client.UserAgentBuilder;

public class Chorus_Request_Engine extends API {
    public static DragonLog logger;
    public static Reddit4J client;
    public Chorus_Request_Engine(DragonLog logger, Reddit4J client){
        this.logger = logger;
        this.client = client;
        System.out.println("Login Successful");
    }

    public static Chorus_Request_Engine createNewCRE(String username, String password, String appID, String secret, String appname, String authorname, String version, DragonLog logger) {
        Reddit4J client = Reddit4J.rateLimited().setUsername(username).setPassword(password)
                .setClientId(appID).setClientSecret(secret)
                .setUserAgent(new UserAgentBuilder().appname(appname).author(authorname).version(version));
        try {
            client.connect();
        } catch (Exception e){
            logger.printToLog(LogLevel.ERROR, "Could not log in: " + e.getMessage());
            System.exit(1);
        }
        return new Chorus_Request_Engine(logger, client);
    }

    public static Reddit4J getClient() {
        return client;
    }

    public static DragonLog getLogger() {
        return logger;
    }

}

