package inoxoft.simon.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import inoxoft.simon.myapplication.model.Repository
import inoxoft.simon.myapplication.model.TeaDatabase
import inoxoft.simon.myapplication.ui.theme.MyApplicationTheme
import inoxoft.simon.myapplication.view.MkulimaNavigation
import inoxoft.simon.myapplication.viewmodel.MkulimaViewModel

class MainActivity : ComponentActivity() {



    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            TeaDatabase::class.java,
            name="tea.db"
        ).build()
    }


    private val viewModel by viewModels<MkulimaViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MkulimaViewModel(Repository(db)) as T
                }
            }
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    MkulimaNavigation(modifier = Modifier.padding(innerPadding),viewModel)

                }
            }
        }
    }
}
