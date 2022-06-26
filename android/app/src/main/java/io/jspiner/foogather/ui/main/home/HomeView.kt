package io.jspiner.foogather.ui.main.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksActivityViewModel
import io.jspiner.foogather.dto.CategoryDto
import io.jspiner.foogather.R
import io.jspiner.foogather.dto.FoodDto
import io.jspiner.foogather.util.format

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    HomeView()
}

@Composable
fun HomeView(
    viewModel: HomeViewModel = mavericksActivityViewModel(),
    onItemClick: (Int) -> Unit = {},
    onTimeSelectorClick: () -> Unit = {}
) {
    val categoryList by viewModel.collectAsState(HomeState::categoryList)

    if (categoryList is Success) {
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 13.dp)
                    .align(Alignment.CenterHorizontally),
            )
            CategoryList(categoryList.invoke() ?: emptyList())
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFF7F7F7))
            )
            TimeSelector(onTimeSelectorClick = onTimeSelectorClick)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(Color(0xFFF7F7F7))
            )

            val foodList by viewModel.collectAsState(HomeState::foodList)
            if (foodList is Success) {
                FoodList(foodList.invoke() ?: emptyList(), onItemClick)
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun CategoryList(categoryList: List<CategoryDto>) {
    var selectedCategoryIndex by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.width(12.dp))
        }
        itemsIndexed(categoryList) { index, item ->
            Column(
                modifier = Modifier.padding(horizontal = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clickable {
                            selectedCategoryIndex = index
                        },
                    shape = RoundedCornerShape(4.dp),
                    border = BorderStroke(if (index == selectedCategoryIndex) 1.dp else (-1).dp, Color(0xFFE35550)),
                    backgroundColor = Color(0xFFF7F7F7)
                ) {
                    Image(painter = painterResource(id = item.image), contentDescription = "")
                }
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
private fun FoodList(foodList: List<FoodDto>, onItemClick: (Int) -> Unit = {}) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        foodList.forEach { item ->
            FoodItem(item, onItemClick = onItemClick)
        }
    }
}

@Composable
private fun FoodItem(item: FoodDto, onItemClick: (Int) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(item.id)
            }
            .padding(horizontal = 18.dp, vertical = 15.dp)
    ) {
        Card(
            modifier = Modifier
                .width(90.dp)
                .height(90.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Image(
                painter = painterResource(id = item.foodImageList[1]),
                contentDescription = "",
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 14.dp, top = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = item.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )
            Text(
                text = item.description,
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
                    text = "${item.reservedCount}/",
                    fontSize = 12.sp,
                    color = Color(0xFF242424),
                )
                Text(
                    text = "${item.maxCount}",
                    fontSize = 12.sp,
                    color = Color(0xFF909090),
                )
                Spacer(modifier = Modifier.width(6.dp))

                repeat(item.reservedCount) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_reserved),
                        contentDescription = ""
                    )
                }
                repeat(item.maxCount - item.reservedCount) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_unreserved),
                        contentDescription = ""
                    )
                }

            }
        }
    }
}

