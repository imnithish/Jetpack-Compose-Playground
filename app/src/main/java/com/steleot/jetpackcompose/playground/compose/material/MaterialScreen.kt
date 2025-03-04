package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

val routes = listOf(
    MaterialNavRoutes.AlertDialog,
    MaterialNavRoutes.BackdropScaffold,
    MaterialNavRoutes.BadgedBox,
    MaterialNavRoutes.BottomAppBar,
    MaterialNavRoutes.BottomDrawer,
    MaterialNavRoutes.BottomNavigation,
    MaterialNavRoutes.BottomSheetScaffold,
    MaterialNavRoutes.Button,
    MaterialNavRoutes.Card,
    MaterialNavRoutes.Checkbox,
    MaterialNavRoutes.DropdownMenu,
    MaterialNavRoutes.Divider,
    MaterialNavRoutes.FloatingActionButton,
    MaterialNavRoutes.ExtendedFloatingActionButton,
    MaterialNavRoutes.Elevation,
    MaterialNavRoutes.IconToggleButton,
    MaterialNavRoutes.IconButton,
    MaterialNavRoutes.Icon,
    MaterialNavRoutes.ListItem,
    MaterialNavRoutes.LocalAbsoluteElevation,
    MaterialNavRoutes.LocalContentAlpha,
    MaterialNavRoutes.LocalContentColor,
    MaterialNavRoutes.MaterialTheme,
    MaterialNavRoutes.ModalBottomSheetLayout,
    MaterialNavRoutes.ModalDrawer,
    MaterialNavRoutes.NavigationRail,
    MaterialNavRoutes.OutlinedTextField,
    MaterialNavRoutes.Progress,
    MaterialNavRoutes.RadioButton,
    MaterialNavRoutes.RangeSlider,
    MaterialNavRoutes.Scaffold,
    MaterialNavRoutes.ScrollableTabRow,
    MaterialNavRoutes.Slider,
    MaterialNavRoutes.SnackBar,
    MaterialNavRoutes.Surface,
    MaterialNavRoutes.Swipeable,
    MaterialNavRoutes.SwipeToDismiss,
    MaterialNavRoutes.Switch,
    MaterialNavRoutes.TabRow,
    MaterialNavRoutes.TextField,
    MaterialNavRoutes.Text,
    MaterialNavRoutes.TopAppBar,
    MaterialNavRoutes.TriStateCheckbox,
)

@Composable
fun MaterialScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Material,
        list = routes,
    )
}
