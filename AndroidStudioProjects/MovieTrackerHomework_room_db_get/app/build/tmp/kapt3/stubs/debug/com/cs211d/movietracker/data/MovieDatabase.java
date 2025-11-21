package com.cs211d.movietracker.data;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/cs211d/movietracker/data/MovieDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "dao", "Lcom/cs211d/movietracker/data/MovieDao;", "getDao", "()Lcom/cs211d/movietracker/data/MovieDao;", "app_debug"})
@androidx.room.Database(entities = {com.cs211d.movietracker.data.Movie.class}, version = 1)
public abstract class MovieDatabase extends androidx.room.RoomDatabase {
    
    public MovieDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.cs211d.movietracker.data.MovieDao getDao();
}