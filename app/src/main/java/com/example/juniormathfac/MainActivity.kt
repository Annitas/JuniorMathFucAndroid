package com.example.juniormathfac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.juniormathfac.ui.theme.JuniorMathFacTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                ProfileView()

            }
        }
    }
}

@Composable
fun ProfileView(
    titles: List<String> = listOf("Create Room", "Statistics", "Tasks", "Rules")
) {
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = stringResource(R.string.profile_text),
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .drawBehind { drawRoundRect(
                    Color(0xFFBBAAEE),
                    cornerRadius = CornerRadius(10.dp.toPx())
                ) }
                .padding(horizontal = 60.dp, vertical = 10.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "User's profile picture",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .padding(15.dp)
                .border(1.5.dp, Color.LightGray, CircleShape)

        )
        Text(text = "Margarita",
            fontSize = 22.sp
        )
        Text(text = "Konstantinopolskaya",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        for (title in titles) {
            ProfileButton(title)
        }

    }
}

@Composable
fun ProfileButton(title: String) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow, contentColor = Color.DarkGray),
        modifier = Modifier
            .size(width = 260.dp, height = 65.dp)
            .padding(10.dp)
    ) {
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JuniorMathFacTheme {
        ProfileView()
    }
}