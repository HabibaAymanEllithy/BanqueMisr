import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisr.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteListModalBottomSheetContent(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_favorite_stare),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(18.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                modifier = Modifier,
                fontSize = 20.sp,
                text = "Favourite List",
                color = colorResource(id = R.color.Beige)
            )
        }
        FavouriteItem(name = "Asmaa Dosuky", account = "Account xxxx7890")
        FavouriteItem(name = "Asmaa Dosuky", account = "Account xxxx7890")
        FavouriteItem(name = "Asmaa Dosuky", account = "Account xxxx7890")
    }
}

@Composable
fun FavouriteItem(name: String, account: String) {
    Card(
        modifier = Modifier
            .height(88.dp)
            .background(colorResource(id = R.color.card_color_list))
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 18.dp, start = 8.dp)
                    .size(30.dp)
                    .background(Color.LightGray, shape = CircleShape)
                    .clip(CircleShape)
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.icon_banque),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 18.dp)
            ) {
                Text(name)
                Text(account)
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    FavouriteListModalBottomSheetContent(onDismiss = {})
}