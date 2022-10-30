package com.navigation.latihan.composemycity.ui

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.navigation.latihan.composemycity.data.local.DataSource
import com.navigation.latihan.composemycity.data.model.Recommendation
import com.navigation.latihan.composemycity.ui.theme.ComposeMyCityTheme


@Composable
fun RecommendationInfoScreen(
    modifier: Modifier = Modifier,
    contentType: ContentType = ContentType.LIST,
    recommendation: Recommendation? = DataSource.recomendations.first(),
    onNavigateUp: () -> Unit = {}
){
    if (contentType == ContentType.LIST){
        BackHandler {
            onNavigateUp()
        }
    }
    recommendation?.let{
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(id = it.image),
                contentDescription = stringResource(id = it.title),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(vertical = 16.dp)) {
                Text(
                    text = stringResource(id = it.title),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = it.description),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RecommendationInfoScreenPreview() {
    ComposeMyCityTheme {
        Surface {
            RecommendationInfoScreen()
        }
    }
}