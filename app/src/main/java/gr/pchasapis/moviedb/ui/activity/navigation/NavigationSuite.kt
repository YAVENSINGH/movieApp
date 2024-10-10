import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import gr.pchasapis.moviedb.ui.activity.navigation.AppNavHost
import gr.pchasapis.moviedb.ui.activity.navigation.Navigation

@Composable
fun NewHome(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationSuiteScaffold(
        modifier = modifier,
        navigationSuiteItems = {
            TOP_LEVEL_ROUTES.forEach { topLevelRoute ->
                item(
                    selected = currentDestination?.hierarchy?.any {
                        it.route == topLevelRoute.route
                    } == true,
                    label = {
                        Text(text = topLevelRoute.label)
                    },
                    icon = {
                        Icon(
                            imageVector = topLevelRoute.icon,
                            contentDescription = topLevelRoute.route::class.simpleName
                        )
                    },
                    onClick = {
                        navController.navigate(route = topLevelRoute.route)
                    }
                )
            }
        }
    ) {
        AppNavHost(navController)
    }

}

data class TopLevelRoute<T : Any>(val route: T, val icon: ImageVector, val label: String)

val TOP_LEVEL_ROUTES = listOf(
    TopLevelRoute(route = Navigation.Home, icon = Icons.Default.Home, "Home"),
    TopLevelRoute(route = Navigation.Favourites, icon = Icons.Default.Favorite, "Favourite"),
)
