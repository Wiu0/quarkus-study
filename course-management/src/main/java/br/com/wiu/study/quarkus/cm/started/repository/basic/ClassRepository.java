package br.com.wiu.study.quarkus.cm.started.repository.basic;

import br.com.wiu.study.quarkus.cm.started.entity.ClassEntity;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class ClassRepository {

    @Inject
    PgPool connection;

    public Multi<ClassEntity> findAll() {
        return connection.query("select * from CLASS").execute().onItem().transformToMulti(
                rows -> Multi.createFrom().items(() -> StreamSupport.stream(rows.spliterator(), false))).
                        onItem().transform(ClassRepository::from);
    }

    public Uni<ClassEntity> findById( Long id) {
        return connection.preparedQuery("select ID, DESCRIPTION from CLASS where ID = $1").execute(Tuple.of(id))
                .onItem().transform(RowSet::iterator)
                .onItem().transform(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
    }

    public Uni<Long> save(ClassEntity classEntity) {
        return connection.preparedQuery("insert into CLASS (DESCRIPTION) values ($1) returning (ID)").execute(Tuple.of(classEntity.getDescription()))
                .onItem().transform(pgRowSet -> pgRowSet.iterator().next().getLong("ID"));
    }

    public Uni<Boolean> update(ClassEntity classEntity) {
        return connection.preparedQuery("update CLASS set DESCRIPTION = $1 where ID = $2").execute(Tuple.of(classEntity.getDescription(), classEntity.getId()))
                .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    public Uni<Boolean> delete(Long id) {
        return connection.preparedQuery("delete from CLASS where ID = $1").execute(Tuple.of(id))
                .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    private static ClassEntity from(Row row) {
        return new ClassEntity(row.getLong("id"), row.getString("description"));
    }
}
