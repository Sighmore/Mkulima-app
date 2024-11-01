package inoxoft.simon.myapplication.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import inoxoft.simon.myapplication.view.pages.HomeScreen
import inoxoft.simon.myapplication.view.pages.PluckerRecordsScreen
import inoxoft.simon.myapplication.view.pages.PluckerScreen
import inoxoft.simon.myapplication.view.pages.WelcomeScreen
import inoxoft.simon.myapplication.viewmodel.MkulimaViewModel

@Composable
fun MkulimaNavigation(modifier: Modifier, viewModel: MkulimaViewModel){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome", builder = {
        composable("welcome"){WelcomeScreen(modifier,navController,viewModel) }
        composable("home"){HomeScreen(navController,viewModel) }
        composable("plucker"){PluckerScreen(navController,viewModel) }
        composable("pluckerRecords"){PluckerRecordsScreen(navController,viewModel) }
//        composable("teaRecords"){TeaRecordsScreen(navController) }
//        composable("pluckingIntervals"){PluckingIntervalsScreen(navController) }
    })

}