package io.jspiner.foogather.ui.done

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.jspiner.foogather.R
import io.jspiner.foogather.ui.theme.Primary

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    DoneView()
}

@Composable
fun DoneView() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "푸게더 신청 완료!",
            fontSize = 24.sp,
            color = Color(0xFF242424),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 30.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.done),
            contentDescription = "",
            modifier = Modifier.padding(top = 19.dp)
        )

        Text(
            "함께할 2명의 푸게더를 기다리고 있어요",
            fontSize = 14.sp,
            color = Color(0xFF242424),
            modifier = Modifier.padding(top = 30.dp)
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 47.dp)
                .padding(top = 9.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(19.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(7.dp),
                backgroundColor = Color(0xFFDEDEDE)
            ) {

            }

            Card(
                modifier = Modifier
                    .height(19.dp)
                    .width(260.dp),
                shape = RoundedCornerShape(7.dp),
                backgroundColor = Color(0xFFE35550)
            ) {

            }

            Text(
                text = "3/5명",
                modifier = Modifier.wrapContentWidth().
                align(Alignment.CenterEnd)
            )

        }

        Spacer(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 24.dp)
                .padding(horizontal = 17.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFEEEEEE))
        )

        Text(
            "푸게더 일정",
            fontSize = 14.sp,
            color = Color(0xFF828282),
        )

        Text(
            "2022.06.25 토요일\n" +
                    "오후 3:00",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF242424),
            textAlign = TextAlign.Center
        )

        Text(
            "푸게더 장소",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 25.dp),
            color = Color(0xFF828282),
        )

        Text(
            "서울 서초구 주흥길 3",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF242424),
        )

        Text(
            "총 인원수",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 25.dp),
            color = Color(0xFF828282),
        )

        Text(
            "5명",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 5.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF242424),
        )

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 75.dp)
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color(0xFFE35550))
            ) {
                Text(
                    text = "예약 취소",
                    color = Color(0xFFE35550),
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.width(11.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Primary),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "홈으로 이동",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}
