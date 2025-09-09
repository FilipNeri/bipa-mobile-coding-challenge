package com.filipeneri.bipamobilecodingchallenge.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel

@Composable
fun ListNode(listNodes:List<Node>, mainViewModel: MainViewModel){
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(listNodes.size) { index ->
            ItemNode(node = listNodes[index],index, mainViewModel )
        }
    }
}