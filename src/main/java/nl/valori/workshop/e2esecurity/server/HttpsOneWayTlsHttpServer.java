package nl.valori.workshop.e2esecurity.server;

import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;

public class HttpsOneWayTlsHttpServer extends AbstractHttpServerVerticle {

  @Override
  HttpServerOptions createServerOptions() {
    return new HttpServerOptions()
        .setSsl(true)
        .setTrustStoreOptions(
            new JksOptions()
                .setPath(SECRET_DIR.resolve("truststore.jks").toString())
                .setPassword("TrustStorePassword"))
        .setKeyStoreOptions(
            new JksOptions()
                .setPath(SECRET_DIR.resolve("keystore.p12").toString())
                .setPassword("KeyStorePassword"));
  }

  @Override
  String getScheme() {
    return "https";
  }

  @Override
  int getPort() {
    return 443;
  }
}
