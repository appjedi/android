package com.cs211d.movietracker.data;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Movie> __insertAdapterOfMovie;

  private final EntityDeleteOrUpdateAdapter<Movie> __deleteAdapterOfMovie;

  public MovieDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfMovie = new EntityInsertAdapter<Movie>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Movie` (`id`,`movieName`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Movie entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getMovieName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getMovieName());
        }
      }
    };
    this.__deleteAdapterOfMovie = new EntityDeleteOrUpdateAdapter<Movie>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Movie` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Movie entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
      }
    };
  }

  @Override
  public Object save(final Movie movie, final Continuation<? super Unit> $completion) {
    if (movie == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMovie.insert(_connection, movie);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object delete(final Movie movie, final Continuation<? super Unit> $completion) {
    if (movie == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __deleteAdapterOfMovie.handle(_connection, movie);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<Movie>> getMovies() {
    final String _sql = "SELECT * FROM movie";
    return FlowUtil.createFlow(__db, false, new String[] {"movie"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfMovieName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "movieName");
        final List<Movie> _result = new ArrayList<Movie>();
        while (_stmt.step()) {
          final Movie _item;
          final Integer _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          }
          final String _tmpMovieName;
          if (_stmt.isNull(_columnIndexOfMovieName)) {
            _tmpMovieName = null;
          } else {
            _tmpMovieName = _stmt.getText(_columnIndexOfMovieName);
          }
          _item = new Movie(_tmpId,_tmpMovieName);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
