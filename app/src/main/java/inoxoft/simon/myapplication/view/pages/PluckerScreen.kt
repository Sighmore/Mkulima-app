package inoxoft.simon.myapplication.view.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import inoxoft.simon.myapplication.model.TeaRecord
import inoxoft.simon.myapplication.ui.theme.green
import inoxoft.simon.myapplication.viewmodel.MkulimaViewModel
import java.time.LocalDate

@Composable
fun PluckerScreen(navController: NavHostController, viewModel: MkulimaViewModel) {

    var pluckerName by remember { mutableStateOf("") }
    var amountPlucked by remember { mutableStateOf("") }
    var totalKilos by remember { mutableStateOf(0) }

    // Current date for records
    val date = LocalDate.now().toString()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Heading
        Text(
            text = "Plucking Management",
            fontSize = 24.sp,
            color = green,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Input fields for Plucker's name and amount plucked
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = pluckerName,
                onValueChange = { pluckerName = it },
                label = { Text("Plucker Name") },
                modifier = Modifier
                    .weight(1f)
                    .width(250.dp)
            )

            OutlinedTextField(
                value = amountPlucked,
                onValueChange = {
                    amountPlucked = it
                },
                label = { Text("Amount Plucked") },
                modifier = Modifier
                    .weight(1f)
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        // Buttons for KTDA, TET, Others
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val handlePluckRecord: (Int) -> Unit = { rate ->
                val amount = amountPlucked.toIntOrNull() ?: 0
                val pluckerAmount = amount * rate
               val record = TeaRecord(
                    pluckerName = pluckerName,
                    pluckerAmount = pluckerAmount,
                    pluckerKilo = amount,
                    totalKilos = totalKilos,
                    date = date,
                   0
               )
                viewModel.upsertRecord(record)
                totalKilos += amount
                pluckerName = ""
                amountPlucked = ""
            }

            Button(
                onClick = { handlePluckRecord(9) },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2FA1AB)
                )
            ) {
                Text(text = "KTDA", fontSize = 16.sp)
            }
            Button(
                onClick = { handlePluckRecord(8) },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF56ab2f)
                )
            ) {
                Text(text = "TET", fontSize = 16.sp)
            }
            Button(
                onClick = { handlePluckRecord(7) },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2FA1AB)
                )
            ) {
                Text(text = "Others", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Record Manager")

        // Navigate to Plucker Records button
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    // Implement today's record fetch logic here
                },
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            ) {
                Text(text = "Today's Records")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = { navController.navigate("pluckerRecords") },
                modifier = Modifier
                    .padding(vertical = 16.dp)
            ) {
                Text(text = "Records", fontSize = 18.sp)
            }
        }
    }
}
