package com.example.helloandroidstudio.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DollarRateScreen(
    vm: DollarRateViewModel = koinViewModel(),
    modifier: Modifier = Modifier   // 👈 ahora acepta modifier
) {
    val rates by vm.rates.collectAsState()
    var officialBuy by remember { mutableStateOf("") }
    var officialSell by remember { mutableStateOf("") }
    var parallelBuy by remember { mutableStateOf("") }
    var parallelSell by remember { mutableStateOf("") }

    Column(
        modifier = modifier   // 👈 usamos el modifier que viene del Scaffold
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Registrar Tasa de Cambio", modifier = Modifier.padding(bottom = 8.dp))

        OutlinedTextField(
            value = officialBuy,
            onValueChange = { officialBuy = it },
            label = { Text("Oficial Compra") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = officialSell,
            onValueChange = { officialSell = it },
            label = { Text("Oficial Venta") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = parallelBuy,
            onValueChange = { parallelBuy = it },
            label = { Text("Paralelo Compra") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = parallelSell,
            onValueChange = { parallelSell = it },
            label = { Text("Paralelo Venta") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (officialBuy.isNotBlank() && officialSell.isNotBlank() &&
                parallelBuy.isNotBlank() && parallelSell.isNotBlank()
            ) {
                vm.addRate(
                    DollarRateEntity(
                        officialBuy = officialBuy.toDouble(),
                        officialSell = officialSell.toDouble(),
                        parallelBuy = parallelBuy.toDouble(),
                        parallelSell = parallelSell.toDouble(),
                        date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                    )
                )
                // limpiar inputs
                officialBuy = ""
                officialSell = ""
                parallelBuy = ""
                parallelSell = ""
            }
        }) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Histórico:")

        LazyColumn {
            items(rates) { rate ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Oficial: Compra ${rate.officialBuy}, Venta ${rate.officialSell}")
                    Text("Paralelo: Compra ${rate.parallelBuy}, Venta ${rate.parallelSell}")
                    Text("Fecha: ${rate.date}")
                }
            }
        }
    }
}
