package jp.gcreate.sample.composesample.ui.customlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomLayoutScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        LayoutSample()
        LayoutSample(
            modifier = Modifier.padding(end = 56.dp)
        )
        LayoutSample(
            modifier = Modifier.width(180.dp)
                .height(260.dp)
                .align(Alignment.CenterHorizontally),
        )
    }
}

@Preview
@Composable
private fun CustomLayoutScreen_Preview() {
    CustomLayoutScreen()
}
