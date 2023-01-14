package jp.gcreate.sample.composesample.ui.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        NormalColumnLayout(text = "hoge", text2 = "fura", price = 10000)
        NormalColumnLayout(text = "あいうえお", text2 = "かきくけこ", price = 4000)
        ColumnWithSurface(text = "hoge", text2 = "fuga", price = 10000)
        ColumnWithSurface(text = "あいうえお", text2 = "かきくけこ", price = 10000)
    }
}

@Preview
@Composable
private fun ColumnScreen_Preview() {
    ColumnScreen()
}