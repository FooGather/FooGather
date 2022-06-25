package io.jspiner.foogather.ui.main.reserve

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.jspiner.foogather.ui.theme.Primary

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    ReserveView()
}

@Composable
fun ReserveView() {
    LazyColumn(
    ) {
        item {
            Text(
                text = "신청 내역",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(vertical = 17.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        items(40) {
            ReserveItem()
        }
    }
}

@Composable
private fun ReserveItem() {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xFFEBEBEB)),
        modifier = Modifier
            .padding(horizontal = 17.dp, vertical = 5.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(vertical = 18.dp, horizontal = 20.dp)) {
            Card(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Primary,
            ) {
                Text(
                    text = "푸게더 대기중",
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 9.dp),
                    color = Color.White,
                    fontSize = 10.sp
                )
            }
            Text(
                text = "푸게더 돈까스",
                modifier = Modifier.padding(top = 11.dp),
                color = Color(0xFF242424),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Row(modifier = Modifier.padding(top = 11.dp)) {
                Column() {
                    Text(
                        text = "푸게더 일정",
                        color = Color(0xFF828282),
                        fontSize = 12.sp
                    )
                    Text(
                        text = "푸게더 장소",
                        color = Color(0xFF828282),
                        fontSize = 12.sp
                    )
                    Text(
                        text = "총 인원수",
                        color = Color(0xFF828282),
                        fontSize = 12.sp
                    )
                }

                Column(modifier = Modifier.padding(start = 13.dp)) {
                    Text(
                        text = "2022.06.25 토요일 오후 15:00",
                        color = Color(0xFF4F4F4F),
                        fontSize = 12.sp
                    )
                    Text(
                        text = "서울 서초구 주흥길 3",
                        color = Color(0xFF4F4F4F),
                        fontSize = 12.sp
                    )
                    Text(
                        text = "5명",
                        color = Color(0xFF4F4F4F),
                        fontSize = 12.sp
                    )
                }

            }
        }
    }
}
