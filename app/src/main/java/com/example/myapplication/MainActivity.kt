import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.LumiSmartTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LumiSmartTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashboardScreen()
                }
            }
        }
    }
}

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "LumiSmart Dashboard",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            item { SectionHeader(title = "Quick Actions") }
            item {
                DashboardCard(
                    title = "Map View",
                    description = "Visualize the location and status of all streetlights.",
                    imageRes = R.drawable.ic_map // Replace with actual image
                )
            }
            item {
                DashboardCard(
                    title = "Toggle Lights",
                    description = "Turn all lights on or off with a single tap.",
                    imageRes = R.drawable.ic_lamp // Replace with actual image
                )
            }
            item { SectionHeader(title = "Management") }
            item {
                DashboardCard(
                    title = "Fault Alerts",
                    description = "Receive notifications about malfunctioning lights.",
                    imageRes = R.drawable.ic_alert // Replace with actual image
                )
            }
            item {
                DashboardCard(
                    title = "Scheduling",
                    description = "Set up automatic lighting schedules based on time or events.",
                    imageRes = R.drawable.ic_calendar // Replace with actual image
                )
            }
            item { SectionHeader(title = "Insights") }
            item {
                DashboardCard(
                    title = "Analytics",
                    description = "View energy consumption, usage patterns, and cost savings.",
                    imageRes = R.drawable.ic_chart // Replace with actual image
                )
            }
            item { SectionHeader(title = "System") }
            item {
                DashboardCard(
                    title = "Settings",
                    description = "Configure system parameters and user preferences.",
                    imageRes = R.drawable.ic_settings // Replace with actual image
                )
            }
        }

        Button(
            onClick = { /* Emergency All-On Action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Emergency All-On")
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
        modifier = Modifier.padding(vertical = 4.dp)
    )
}

@Composable
fun DashboardCard(title: String, description: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle onClick */ }
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                )
            }
        }
    }
}
