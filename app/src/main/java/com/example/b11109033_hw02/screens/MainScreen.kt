package com.example.b11109033_hw02.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.b11109033_hw02.ViewsInfo

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Column could be slided.
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemsCount = ViewsInfo.size
        // Show the each Site and brief intro.
        items(itemsCount) {
            BriefItem(
                modifier,
                itemIndex = it,
                navController = navController
            )
        }
    }
}

/**
* fun BriefItem use 'Card' to show each intro.
**/
@Composable
fun BriefItem(
    modifier: Modifier,
    itemIndex: Int,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        // Arrange names and descriptions in sequence.
        Column(
            modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(ViewsInfo[itemIndex].name),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "About:\n" + stringResource(ViewsInfo[itemIndex].briefInfo),
                fontSize = 20.sp,
                modifier = Modifier.padding(30.dp),
                color = Color.Black
            )
            Text(
                text = "...點擊片卡了解更多...",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}
