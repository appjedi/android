package com.cs211d.movietracker;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/cs211d/movietracker/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "db", "Lcom/cs211d/movietracker/data/MovieDatabase;", "getDb", "()Lcom/cs211d/movietracker/data/MovieDatabase;", "db$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/cs211d/movietracker/ui/theme/MovieViewModel;", "getViewModel", "()Lcom/cs211d/movietracker/ui/theme/MovieViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "BottomNavBar", "navController", "Landroidx/navigation/NavController;", "BottomNavItem", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy db$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.cs211d.movietracker.data.MovieDatabase getDb() {
        return null;
    }
    
    private final com.cs211d.movietracker.ui.theme.MovieViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.compose.runtime.Composable()
    public final void BottomNavBar(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u0082\u0001\u0003\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/cs211d/movietracker/MainActivity$BottomNavItem;", "", "route", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabel", "Home", "Search", "Profile", "Lcom/cs211d/movietracker/MainActivity$BottomNavItem$Home;", "Lcom/cs211d/movietracker/MainActivity$BottomNavItem$Profile;", "Lcom/cs211d/movietracker/MainActivity$BottomNavItem$Search;", "app_debug"})
    public static abstract class BottomNavItem {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String route = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String label = null;
        
        private BottomNavItem(java.lang.String route, androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String label) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRoute() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLabel() {
            return null;
        }
        
        @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/cs211d/movietracker/MainActivity$BottomNavItem$Home;", "Lcom/cs211d/movietracker/MainActivity$BottomNavItem;", "<init>", "()V", "app_debug"})
        public static final class Home extends com.cs211d.movietracker.MainActivity.BottomNavItem {
            @org.jetbrains.annotations.NotNull()
            public static final com.cs211d.movietracker.MainActivity.BottomNavItem.Home INSTANCE = null;
            
            private Home() {
            }
        }
        
        @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/cs211d/movietracker/MainActivity$BottomNavItem$Profile;", "Lcom/cs211d/movietracker/MainActivity$BottomNavItem;", "<init>", "()V", "app_debug"})
        public static final class Profile extends com.cs211d.movietracker.MainActivity.BottomNavItem {
            @org.jetbrains.annotations.NotNull()
            public static final com.cs211d.movietracker.MainActivity.BottomNavItem.Profile INSTANCE = null;
            
            private Profile() {
            }
        }
        
        @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/cs211d/movietracker/MainActivity$BottomNavItem$Search;", "Lcom/cs211d/movietracker/MainActivity$BottomNavItem;", "<init>", "()V", "app_debug"})
        public static final class Search extends com.cs211d.movietracker.MainActivity.BottomNavItem {
            @org.jetbrains.annotations.NotNull()
            public static final com.cs211d.movietracker.MainActivity.BottomNavItem.Search INSTANCE = null;
            
            private Search() {
            }
        }
    }
}