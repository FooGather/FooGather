package io.jspiner.foogather.ui.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    FoodDetailView()
}

@Composable
fun FoodDetailView() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            TopBar()
            Column(
                modifier = Modifier.padding(horizontal = 18.dp)
            ) {
                FoodContent()
                Spacer(
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 11.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFF7F7F7))
                )
                RestaurantLocation()
                Spacer(modifier = Modifier.height(18.dp))
                FoodReserveInfo()
            }
        }

        ReserveButton(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun TopBar() {
    Box(
        modifier = Modifier
            .height(169.dp)
            .fillMaxWidth()
    ) {
        Spacer(
            modifier = Modifier
                .height(169.dp)
                .background(Color(0xFFD9D9D9))
        )
        IconButton(onClick = { }) {
            Icon(
                Icons.Filled.ArrowBack,
                "",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun FoodContent() {
    Column(
        modifier = Modifier
            .padding(top = 18.dp)
    ) {
        Text(
            text = "푸게더 돈까스",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF242424)
        )
        Text(
            modifier = Modifier.padding(top = 11.dp),
            text = "부드럽고 촉촉한 안심, 바삭한 튀김옷을 입은 돈까스입니다. 추억의 향기를 기억하는 분들은 푸게더 한입과 추억이 되살아나는 경험을 할 수 있어요!",
            fontSize = 16.sp,
            color = Color(0xFF4F4F4F)
        )
        Button(
            modifier = Modifier
                .padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF7F7F7)),
            shape = RoundedCornerShape(4.dp),
            onClick = {}
        ) {
            Text(
                text = "메뉴판 더보기",
                fontSize = 14.sp,
                color = Color(0xFF4F4F4F)
            )
        }
    }
}

@Composable
private fun RestaurantLocation() {
    Row(modifier = Modifier.padding()) {
        Spacer(
            modifier = Modifier
                .width(43.dp)
                .height(43.dp)
                .background(Color(0xFF242424))
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 9.dp)
        ) {
            Text(
                text = "푸게더",
                fontSize = 14.sp,
                color = Color(0xFF242424)
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "서울 서초구 주흥길 3",
                fontSize = 12.sp,
                color = Color(0xFF4F4F4F)
            )
        }
    }
}

@Composable
private fun FoodReserveInfo() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        backgroundColor = Color(0xFFF7F7F7)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            Text(
                text = "선택일정",
                fontSize = 14.sp,
                color = Color(0xFF828282)
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "2022.06.25 토요일\n오후 3:00",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )
            Text(
                modifier = Modifier.padding(top = 14.dp),
                text = "푸게더 현황",
                fontSize = 14.sp,
                color = Color(0xFF828282)
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "5명중 3번째",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )

            val reservedCount = 3
            val maxCount = 6

            Row(modifier = Modifier.padding(top = 5.dp)) {
                repeat(reservedCount) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.ic_reserved),
                        contentDescription = ""
                    )
                }
                repeat(maxCount - reservedCount) {
                    Image(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.ic_unreserved),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
private fun ReserveButton(modifier: Modifier) {
    Button(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 50.dp)
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Primary),
        shape = RoundedCornerShape(10.dp),
        onClick = { }
    ) {
        Text(
            text = "푸게더 신청",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
