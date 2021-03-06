package io.jspiner.foogather.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.jspiner.foogather.R
import io.jspiner.foogather.ui.theme.Primary

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    LoginView()
}

@Composable
fun LoginView(onLoginClick: () -> Unit = {}) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Button(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 50.dp)
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(backgroundColor = Primary),
            shape = RoundedCornerShape(10.dp),
            onClick = { onLoginClick() }
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.login_logo),
                    contentDescription = ""
                )
                Text(
                    text = "하러가기",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
    }
}
