package com.example.juniormathfac.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juniormathfac.R
import com.example.juniormathfac.ui.theme.JuniorMathFacTheme


    @Composable
    fun ProfileView(
        button_titles: List<String> = listOf(stringResource(R.string.create_room_button),
            stringResource(R.string.statistics_button),
            stringResource(R.string.tasks_button),
            stringResource(R.string.rules_button)
            )
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
                    .drawBehind {
                        drawRoundRect(
                            Color(0xFFB2CDA5),
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }
                    .padding(horizontal = 60.dp, vertical = 10.dp)
            )
            ProfileCard()
//            Spacer(modifier = Modifier.height(20.dp))
            for (title in button_titles) {
                ProfileButtons(title)
            }

        }
    }

    @Composable
    fun ProfileButtons(title: String) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.button_color), contentColor = Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        ) {
            val color = colorResource(R.color.button_text_color)
            Text(text = title,
                color = color,
                fontSize = 22.sp
            )
        }
    }

@Composable
fun ProfileCard() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color(0xFFB2CDA5)
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "User's profile picture",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .border(1.5.dp, Color.LightGray, CircleShape)

        )
        Text(
            text = stringResource(R.string.user_name),
            fontSize = 22.sp
        )
        Text(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 10.dp),
            text = stringResource(R.string.user_surname),
            fontSize = 22.sp
        )
    }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JuniorMathFacTheme {
            ProfileView()
        }
    }
