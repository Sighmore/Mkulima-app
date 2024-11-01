package inoxoft.simon.myapplication.view.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import inoxoft.simon.myapplication.ui.theme.green
import inoxoft.simon.myapplication.ui.theme.lightblue
import inoxoft.simon.myapplication.viewmodel.MkulimaViewModel

//gemini import all dependencies here



@Composable
fun HomeScreen(navController: NavHostController, viewModel: MkulimaViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top=30.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Welcome Message
        Text(
            text = "Karibu ${viewModel.farmerName.value}",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = green,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.padding(8.dp))

        // Total Kilos Display
        Text(
            text = "Harvest ${viewModel.totalKilos.value}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = lightblue,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Tea Company Data
        val teaCompanies = listOf(
            "KTDA" to "23+7",
            "TET" to "24",
            "Chemalal" to "21",
            "Uniliver" to "23",
            "Sasini" to "43"
        )

        // LazyColumn with Cards
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            //gemini create items here
            items(teaCompanies.size) { index ->
                CompanyCard(companyName = teaCompanies[index].first, price = teaCompanies[index].second)
            }
        }

        Spacer(modifier = Modifier.padding(25.dp))

        // Manage Plucking Button
        Button(
            onClick = {
                navController.navigate("plucker")
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = green
            )
        ) {
            Text(text = "Manage Plucking",
                color = Color.White
            )
        }
    }
}


@Composable
fun CompanyCard(companyName: String, price: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = companyName, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "Ksh: $price /kg", fontSize = 16.sp)
        }
    }
}