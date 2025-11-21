package com.cs211d.movietracker.ui.theme;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/cs211d/movietracker/ui/theme/MovieViewModel;", "Landroidx/lifecycle/ViewModel;", "dao", "Lcom/cs211d/movietracker/data/MovieDao;", "<init>", "(Lcom/cs211d/movietracker/data/MovieDao;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/cs211d/movietracker/MovieState;", "_movies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/cs211d/movietracker/data/Movie;", "currentMovie", "", "getCurrentMovie", "()Ljava/lang/String;", "setCurrentMovie", "(Ljava/lang/String;)V", "recommendedMovie", "getRecommendedMovie", "setRecommendedMovie", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onEvent", "", "event", "Lcom/cs211d/movietracker/MovieEvent;", "getCount", "", "getRandomMovie", "app_debug"})
public final class MovieViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.cs211d.movietracker.data.MovieDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.cs211d.movietracker.MovieState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.cs211d.movietracker.data.Movie>> _movies = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentMovie = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String recommendedMovie = "";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.cs211d.movietracker.MovieState> state = null;
    
    public MovieViewModel(@org.jetbrains.annotations.NotNull()
    com.cs211d.movietracker.data.MovieDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentMovie() {
        return null;
    }
    
    public final void setCurrentMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRecommendedMovie() {
        return null;
    }
    
    public final void setRecommendedMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.cs211d.movietracker.MovieState> getState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.cs211d.movietracker.MovieEvent event) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRandomMovie() {
        return null;
    }
}