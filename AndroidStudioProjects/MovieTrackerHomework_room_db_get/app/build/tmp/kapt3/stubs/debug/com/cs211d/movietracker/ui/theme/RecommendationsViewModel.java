package com.cs211d.movietracker.ui.theme;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/cs211d/movietracker/ui/theme/RecommendationsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "menuChoice", "", "getMenuChoice", "()I", "setMenuChoice", "(I)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/cs211d/movietracker/model/MovieUIState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentMovie", "", "getCurrentMovie", "()Ljava/lang/String;", "setCurrentMovie", "(Ljava/lang/String;)V", "movieList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getMovieList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "setMovieList", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "", "movie", "updateEntree", "getList", "", "app_debug"})
public final class RecommendationsViewModel extends androidx.lifecycle.ViewModel {
    private int menuChoice = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.cs211d.movietracker.model.MovieUIState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.cs211d.movietracker.model.MovieUIState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentMovie = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.String> movieList;
    
    public RecommendationsViewModel() {
        super();
    }
    
    public final int getMenuChoice() {
        return 0;
    }
    
    public final void setMenuChoice(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.cs211d.movietracker.model.MovieUIState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentMovie() {
        return null;
    }
    
    public final void setCurrentMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.String> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.String> p0) {
    }
    
    public final boolean setCurrentMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String movie) {
        return false;
    }
    
    public final boolean updateEntree(@org.jetbrains.annotations.NotNull()
    java.lang.String movie) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getList() {
        return null;
    }
}