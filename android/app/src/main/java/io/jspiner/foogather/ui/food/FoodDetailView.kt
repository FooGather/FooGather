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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksActivityViewModel
import io.jspiner.foogather.R
import io.jspiner.foogather.ui.theme.Primary

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    FoodDetailView()
}

@Composable
fun FoodDetailView(onReserveClick: () -> Unit = {}) {
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

        ReserveButton(modifier = Modifier.align(Alignment.BottomCenter), onReserveClick)
    }
}

@Composable
private fun TopBar(viewModel: FoodDetailViewModel = mavericksActivityViewModel()) {
    val foodAsync by viewModel.collectAsState(FoodDetailState::food)

    if (foodAsync is Success) {
        val food = foodAsync.invoke() ?: return
        Box(
            modifier = Modifier
                .height(169.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(food.foodImageList[0]),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(169.dp)
                    .background(Color(0xFFD9D9D9)),
                contentScale = ContentScale.Crop
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
}

@Composable
private fun FoodContent(viewModel: FoodDetailViewModel = mavericksActivityViewModel()) {
    val foodAsync by viewModel.collectAsState(FoodDetailState::food)

    if (foodAsync is Success) {
        val food = foodAsync.invoke() ?: return

        Column(
            modifier = Modifier
                .padding(top = 18.dp)
        ) {
            Text(
                text = food.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )
            Text(
                modifier = Modifier.padding(top = 11.dp),
                text = food.description,
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
}

@Composable
private fun RestaurantLocation(viewModel: FoodDetailViewModel = mavericksActivityViewModel()) {
    val foodAsync by viewModel.collectAsState(FoodDetailState::food)

    if (foodAsync is Success) {
        val food = foodAsync.invoke() ?: return
        Row(modifier = Modifier.padding()) {
            Image(
                painter = painterResource(food.storeImage),
                contentDescription = "",
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
                    text = food.restaurantName,
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
}

@Composable
private fun FoodReserveInfo(viewModel: FoodDetailViewModel = mavericksActivityViewModel()) {
    val foodAsync by viewModel.collectAsState(FoodDetailState::food)

    if (foodAsync is Success) {
        val food = foodAsync.invoke() ?: return
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
                    text = "${food.maxCount}명중 ${food.reservedCount}번째",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF242424)
                )

                val reservedCount = food.reservedCount
                val maxCount = food.maxCount

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
}

@Composable
private fun ReserveButton(modifier: Modifier, onReserveClick: () -> Unit = {}) {
    Button(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 50.dp)
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Primary),
        shape = RoundedCornerShape(10.dp),
        onClick = { onReserveClick() }
    ) {
        Text(
            text = "푸게더 신청",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
