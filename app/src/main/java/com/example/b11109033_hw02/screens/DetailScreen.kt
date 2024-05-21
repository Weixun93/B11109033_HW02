package com.example.b11109033_hw02.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.b11109033_hw02.ViewsInfo
import com.example.b11109033_hw02.R.drawable

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    itemIndex: Int?
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                navController.navigate(route = "MainScreen")
            }) {
                Image(
                    painterResource(id = drawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
            }
        }
        // "Arrange photos, detailed descriptions, and buttons."
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(ViewsInfo[itemIndex!!].imageResourceId),
                contentDescription = stringResource(ViewsInfo[itemIndex!!].name))
            modifier.clip(RoundedCornerShape(16.dp))
        }
        Text(
            text = stringResource(ViewsInfo[itemIndex!!].name),
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(ViewsInfo[itemIndex!!].directions),
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            MapScreen(itemIndex)
        }
    }
}

// Based on itemIndex to open Google Map and search address.
@Composable
fun MapScreen(itemIndex: Int?) {
    val context = LocalContext.current
    // Define a function to launch a map Intent.
    val startMapIntent = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }

    val address = ViewsInfo[itemIndex!!].address
    Column() {
        Button(
            onClick = {
                // Open maps Intent
                val gmmIntentUri = Uri.parse("geo:0,0?q=$address")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")

                if (mapIntent.resolveActivity(context.packageManager) != null) {
                    startMapIntent.launch(mapIntent)
                }
            },
            shape = MaterialTheme.shapes.large
        ) {
            Text(
                text = "使用 Google Map 開啟地標位置",
                fontSize = 20.sp
            )
        }
    }
}