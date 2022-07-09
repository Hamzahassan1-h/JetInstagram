package com.vipulasri.jetinstagram.ui.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.theme.JetInstagramTheme


@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
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
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(16.dp))
            PhotoGrid()
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter("https://via.placeholder.com/150"),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Hamza", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Photographer", color = Color.Gray)
        Text("Influencer", color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            ProfileStat("10", "Posts")
            ProfileStat("100", "Followers")
            ProfileStat("10", "Following")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* Handle follow */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                shape = RoundedCornerShape(50)
            ) {
                Text("Follow", color = Color.White)
            }
            OutlinedButton(
                onClick = { /* Handle message */ },
                shape = RoundedCornerShape(50)
            ) {
                Text("Message")
            }
        }
    }
}

@Composable
fun ProfileStat(count: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(count, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(label, color = Color.Gray)
    }
}

@Composable
fun PhotoGrid() {
    val photos = List(6) { "https://via.placeholder.com/150" }
    Column {
        for (i in photos.indices step 3) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0..2) {
                    if (i + j < photos.size) {
                        Image(
                            painter = rememberImagePainter(photos[i + j]),
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(4.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    JetInstagramTheme {
        ProfileScreen()
    }
}
