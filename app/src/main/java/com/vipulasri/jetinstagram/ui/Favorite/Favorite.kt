package com.vipulasri.jetinstagram.ui.Favorite


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.theme.JetInstagramTheme


@Composable
fun FavoritesScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorites") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_instagram), contentDescription = null)
                    }
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(8.dp))
            Text("Favorites", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            FavoriteItem("https://via.placeholder.com/150", "lil_wyatt838", "Wyatt Torres")
            FavoriteItem("https://via.placeholder.com/150", "sprinkles_bby19", "Gabriela Perez")
            FavoriteItem("https://via.placeholder.com/150", "xander.the.great178", "Alex Koch")
            FavoriteItem("https://via.placeholder.com/150", "kyia_kayaks", "Kyra Marie")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Suggested", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            SuggestedItem("https://via.placeholder.com/150", "frenchie_fry39", "Joseph Lyons")
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle confirm favorites */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50)
            ) {
                Text("Confirm favorites", color = Color.White)
            }
        }
    }
}

@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            textStyle = TextStyle(fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (searchText.isEmpty()) {
                Text("Search", color = Color.Gray, fontSize = 16.sp)
            }
            it()
        }
    }
}

@Composable
fun FavoriteItem(imageUrl: String, username: String, name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(username, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(name, color = Color.Gray, fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /* Handle remove */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            shape = RoundedCornerShape(50)
        ) {
            Text("Remove")
        }
    }
}

@Composable
fun SuggestedItem(imageUrl: String, username: String, name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(username, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(name, color = Color.Gray, fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /* Handle add */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            shape = RoundedCornerShape(50)
        ) {
            Text("Add", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
   JetInstagramTheme {
        FavoritesScreen()
    }
}
