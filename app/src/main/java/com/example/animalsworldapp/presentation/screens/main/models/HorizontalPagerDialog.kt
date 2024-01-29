import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.theme.Dark_Gray
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraSpacing
import com.example.animalsworldapp.presentation.theme.Light_Gray
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.NobileMedium
import com.example.animalsworldapp.presentation.theme.SmallSpacing
import kotlin.math.absoluteValue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerDialog(
    faunaList: List<Fauna>,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(pageCount = { faunaList.size })

    HorizontalPager(
        modifier = modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        val fauna = faunaList[page]
        Box(
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
                    translationX = pageOffset * size.width
                    alpha = 1 - pageOffset.absoluteValue
                }
                .fillMaxSize()
                .clickable { navigateToDetails(fauna.objectId) }
        ) {
            AsyncImage(
                model = fauna.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(horizontal = SmallSpacing)
                    .padding(16.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 25.dp,
                            bottomEnd = 25.dp
                        )
                    ),
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(340.dp)
                    .height(120.dp)
                    .padding(bottom = ExtraSpacing)
                    .padding(horizontal = MediumSpacing)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.White)
                    .padding(horizontal = ExtraLargeSpacing),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier,
                    text = fauna.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Dark_Gray,
                        fontFamily = NobileMedium
                    )
                )
                SpacerHeight(MediumSpacing)
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = null,
                        tint = Light_Gray
                    )
                    Text(
                        text = fauna.location, style = MaterialTheme.typography.bodyLarge.copy(
                            color = Dark_Gray, fontFamily = NobileMedium
                        )
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}