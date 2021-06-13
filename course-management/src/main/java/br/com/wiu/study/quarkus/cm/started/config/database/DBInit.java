package br.com.wiu.study.quarkus.cm.started.config.database;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.pgclient.PgPool;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class DBInit {

    private final PgPool client;
    private final boolean schemaCreate;

    public DBInit(PgPool client, @ConfigProperty(name = "myapp.schema.create", defaultValue = "true") boolean schemaCreate) {
        this.client = client;
        this.schemaCreate = schemaCreate;
    }

    void onStart(@Observes StartupEvent ev) {
        if (schemaCreate) {
            initDB();
        }
    }

    private void initDB() {
        client.query("drop table if exists CLASS").execute()
                .flatMap(r -> client.query("create table CLASS (ID serial primary key, DESCRIPTION text not null)").execute())
                .flatMap(r -> client.query("insert into CLASS (description) values ('CLASS_DEFAULT')").execute())
                .await().indefinitely();
    }
}
