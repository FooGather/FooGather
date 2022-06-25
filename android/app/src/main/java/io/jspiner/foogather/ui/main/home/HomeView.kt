package io.jspiner.foogather.ui.main.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksActivityViewModel
import com.airbnb.mvrx.compose.mavericksViewModel
import io.jspiner.foogather.dto.CategoryDto
import io.jspiner.foogather.ui.theme.Primary
import io.jspiner.foogather.R
import io.jspiner.foogather.util.format

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    HomeView()
}

@Composable
fun HomeView(
    onItemClick: () -> Unit = {},
    onTimeSelectorClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        CategoryList()
        TimeSelector(onTimeSelectorClick = onTimeSelectorClick)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFF7F7F7))
        )

        FoodList(onItemClick)
    }
}

@Composable
private fun CategoryList() {
    val categoryList = List(10) {
        CategoryDto(it, "카테고리 $it", "")
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.width(12.dp))
        }
        items(categoryList) { item ->
            Column(
                modifier = Modifier.padding(horizontal = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .background(Primary)
                )
                Text(
                    text = item.name,
                    modifier = Modifier.padding(top = 4.dp),
                    fontSize = 12.sp,
                    color = Color(0xFF4F4F4F)
                )
            }
        }
    }
}

@Composable
private fun TimeSelector(
    viewModel: HomeViewModel = mavericksActivityViewModel(),
    onTimeSelectorClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onTimeSelectorClick()
            }
            .padding(vertical = 13.dp, horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(painter = painterResource(id = R.drawable.uil_calender), contentDescription = "")

        val selectedDateTime by viewModel.collectAsState(HomeState::selectedDateTime)
        Text(
            text = selectedDateTime.format("yyyy-MM-dd"),
            fontSize = 14.sp,
            color = Color(0xFF242424),
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .width(1.dp)
                .height(11.dp)
                .background(Color(0xFFD0D0D0))
        )
        Text(
            text = selectedDateTime.format("a h:00"),
            fontSize = 14.sp,
            color = Color(0xFF242424)
        )
    }
}

@Composable
private fun FoodList(onItemClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        repeat(20) {
            FoodItem(onItemClick = onItemClick)
        }
    }
}

@Composable
private fun FoodItem(onItemClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick()
            }
            .padding(horizontal = 18.dp, vertical = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
                .background(Color(0xFFD9D9D9))
        )
        Column(
            modifier = Modifier
                .padding(start = 14.dp, top = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "푸게더 돈까스",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )
            Text(
                text = "부드럽고 촉촉한 안심, 바삭한 튀김옷을 입은 맛있는 돈까스",
                fontSize = 12.sp,
                color = Color(0xFF242424),
                modifier = Modifier.padding(top = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "3/",
                    fontSize = 12.sp,
                    color = Color(0xFF242424),
                )
                Text(
                    text = "5",
                    fontSize = 12.sp,
                    color = Color(0xFF909090),
                )
                Spacer(modifier = Modifier.width(6.dp))

                val reservedCount = 3
                val maxCount = 6

                repeat(reservedCount) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_reserved),
                        contentDescription = ""
                    )
                }
                repeat(maxCount - reservedCount) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_unreserved),
                        contentDescription = ""
                    )
                }

            }
        }
    }
}
