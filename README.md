**Features**
**Home Screen**
Search for movies or TV-series by typing in the search bar.
Add movies/TV-series to your Watchlist as favorites.
Favorites are stored locally in the Room Database.
Displays two lists of items fetched from a public API, toggled via a button or tabs.
Data is efficiently rendered using Jetpack Compose's LazyColumn.
Implements Shimmer layouts for a smooth loading effect.


**Details Screen**
Clicking on an item opens a detailed view with relevant information.

**API Integration**
Simultaneously fetches multiple datasets using Single.zip (RxKotlin).
Utilizes Retrofit for network requests.

**Error Handling**
Gracefully manages errors with proper user-friendly messages to ensure no crashes

**Architecture**
Follows MVVM architecture with ViewModel, LiveData/Flow, and Coroutines for state management.
Uses Hilt for dependency injection, ensuring clean and testable code.
Room database stores and retrieves user favorites efficiently.
Migration to Jetpack Compose
Migration is currently in progress. Check the FavouriteFragment, which is fully migrated to Jetpack Compose.
