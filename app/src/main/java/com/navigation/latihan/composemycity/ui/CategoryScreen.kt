package com.navigation.latihan.composemycity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.navigation.latihan.composemycity.data.local.DataSource
import com.navigation.latihan.composemycity.data.model.Category
import com.navigation.latihan.composemycity.data.model.Recommendation
import com.navigation.latihan.composemycity.ui.theme.ComposeMyCityTheme

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    recommendations: List<Recommendation> = DataSource.recomendations,
    onItemClicked : (Recommendation) -> Unit = {},
){
    LazyColumn(
        modifier = modifier.padding(10.dp)
    ){
        items(recommendations){
            RecommendationListItem(recommendation= it, onItemClicked = onItemClicked)
        }
    }
}

@Preview
@Preview(uiMode =  UI_MODE_NIGHT_YES)
@Composable
fun CategoryScreenPreview(){
    ComposeMyCityTheme{
        Surface {
            CategoryScreen()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun RecommendationListItem(
    modifier: Modifier = Modifier,
    recommendation: Recommendation = DataSource.recomendations.first(),
    onItemClicked: (Recommendation) -> Unit = {},) {

    androidx.compose.material.Card(
        onClick = { onItemClicked(recommendation) },
        modifier = modifier.padding(2.dp),
        elevation = 2.dp
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = recommendation.image),
                contentDescription = stringResource(id = recommendation.title),
                modifier = Modifier
                    .width(100.dp)
                    .height(75.dp),
                contentScale = ContentScale.Crop)

            Column(
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = stringResource(id = recommendation.title),
                    modifier = Modifier.padding(horizontal = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = stringResource(id = recommendation.description), modifier = Modifier.padding(horizontal = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption)
            }

        }
    }

}
