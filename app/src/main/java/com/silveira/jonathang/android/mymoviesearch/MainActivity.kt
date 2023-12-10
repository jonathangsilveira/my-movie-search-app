package com.silveira.jonathang.android.mymoviesearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.silveira.jonathang.android.presentation.compose.SearchResultsContent
import com.silveira.jonathang.android.presentation.theme.MyMovieSearchAppTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieSearchAppTheme {
                SearchScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    val viewModel = koinViewModel<SearchViewModel>()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var textFieldValue by remember { mutableStateOf(TextFieldValue(text = "")) }
            TextField(
                value = textFieldValue.text,
                label = {
                    Text(
                        text = "Search",
                        modifier = Modifier.wrapContentSize()
                    )
                },
                onValueChange = { newText ->
                    textFieldValue = textFieldValue.copy(text = newText)
                    viewModel.onQueryTextChanged(newText)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            val viewState: SearchViewState by viewModel.viewState.collectAsState()
            when (viewState) {
                SearchViewState.EmptyState -> Text(
                    text = "Search for: Movies, TV Shows and People!",
                    modifier = Modifier.wrapContentSize()
                )

                SearchViewState.Fetching -> Text(
                    text = "Loading...",
                    modifier = Modifier.wrapContentSize()
                )

                SearchViewState.GenericError ->
                    Text(
                        text = "Something went wrong",
                        modifier = Modifier.wrapContentSize()
                    )

                SearchViewState.NoResults ->
                    Text(
                        text = "No results found!",
                        modifier = Modifier.wrapContentSize()
                    )

                is SearchViewState.Success -> SearchResultsContent(
                    sections = (viewState as SearchViewState.Success).sections,
                    onItemClick = viewModel::onItemClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
    }
}
