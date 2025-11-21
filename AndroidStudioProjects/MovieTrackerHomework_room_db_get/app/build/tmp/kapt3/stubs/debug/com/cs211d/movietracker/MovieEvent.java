package com.cs211d.movietracker;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b\u00a8\u0006\f\u00c0\u0006\u0003"}, d2 = {"Lcom/cs211d/movietracker/MovieEvent;", "", "SaveMovie", "SetMovieName", "DeleteMovie", "ShowDialog", "HideDialog", "Lcom/cs211d/movietracker/MovieEvent$DeleteMovie;", "Lcom/cs211d/movietracker/MovieEvent$HideDialog;", "Lcom/cs211d/movietracker/MovieEvent$SaveMovie;", "Lcom/cs211d/movietracker/MovieEvent$SetMovieName;", "Lcom/cs211d/movietracker/MovieEvent$ShowDialog;", "app_debug"})
public abstract interface MovieEvent {
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/cs211d/movietracker/MovieEvent$DeleteMovie;", "Lcom/cs211d/movietracker/MovieEvent;", "movie", "Lcom/cs211d/movietracker/data/Movie;", "<init>", "(Lcom/cs211d/movietracker/data/Movie;)V", "getMovie", "()Lcom/cs211d/movietracker/data/Movie;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class DeleteMovie implements com.cs211d.movietracker.MovieEvent {
        @org.jetbrains.annotations.NotNull()
        private final com.cs211d.movietracker.data.Movie movie = null;
        
        public DeleteMovie(@org.jetbrains.annotations.NotNull()
        com.cs211d.movietracker.data.Movie movie) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.cs211d.movietracker.data.Movie getMovie() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.cs211d.movietracker.data.Movie component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.cs211d.movietracker.MovieEvent.DeleteMovie copy(@org.jetbrains.annotations.NotNull()
        com.cs211d.movietracker.data.Movie movie) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/cs211d/movietracker/MovieEvent$HideDialog;", "Lcom/cs211d/movietracker/MovieEvent;", "<init>", "()V", "app_debug"})
    public static final class HideDialog implements com.cs211d.movietracker.MovieEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.cs211d.movietracker.MovieEvent.HideDialog INSTANCE = null;
        
        private HideDialog() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/cs211d/movietracker/MovieEvent$SaveMovie;", "Lcom/cs211d/movietracker/MovieEvent;", "<init>", "()V", "app_debug"})
    public static final class SaveMovie implements com.cs211d.movietracker.MovieEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.cs211d.movietracker.MovieEvent.SaveMovie INSTANCE = null;
        
        private SaveMovie() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/cs211d/movietracker/MovieEvent$SetMovieName;", "Lcom/cs211d/movietracker/MovieEvent;", "movieName", "", "<init>", "(Ljava/lang/String;)V", "getMovieName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class SetMovieName implements com.cs211d.movietracker.MovieEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String movieName = null;
        
        public SetMovieName(@org.jetbrains.annotations.NotNull()
        java.lang.String movieName) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMovieName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.cs211d.movietracker.MovieEvent.SetMovieName copy(@org.jetbrains.annotations.NotNull()
        java.lang.String movieName) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/cs211d/movietracker/MovieEvent$ShowDialog;", "Lcom/cs211d/movietracker/MovieEvent;", "<init>", "()V", "app_debug"})
    public static final class ShowDialog implements com.cs211d.movietracker.MovieEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.cs211d.movietracker.MovieEvent.ShowDialog INSTANCE = null;
        
        private ShowDialog() {
            super();
        }
    }
}