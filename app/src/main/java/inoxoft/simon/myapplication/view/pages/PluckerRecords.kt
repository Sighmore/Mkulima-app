package inoxoft.simon.myapplication.view.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import inoxoft.simon.myapplication.model.TeaRecord
import inoxoft.simon.myapplication.viewmodel.MkulimaViewModel

@Composable
fun PluckerRecordsScreen(navController: NavHostController, viewModel: MkulimaViewModel) {
    // Collects the data from the database through the ViewModel
    val teaRecords = viewModel.getAllRecords().collectAsState(initial = emptyList()).value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(teaRecords) { record ->
            TeaRecordRow(record = record, viewModel)
        }
    }
}

@Composable
fun TeaRecordRow(record: TeaRecord, viewModel: MkulimaViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Name:${record.pluckerName}", fontSize = 14.sp, color = Color.Black)
                Text(text = record.date, fontSize = 12.sp, color = Color.Gray)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Ksh. ${record.pluckerAmount}", fontSize = 16.sp, color = Color.Black)
                Text(text = "${record.pluckerKilo} Kgs", fontSize = 16.sp, color = Color.Black)
            }
            Button(onClick = {
                viewModel.deleteRecord(record)
            }
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete",
                    )
            }
        }
    }
}
