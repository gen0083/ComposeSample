package jp.gcreate.sample.composesample.ui.customlayout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun LayoutSample(
    modifier: Modifier = Modifier,
) {
    Layout(
        modifier = modifier,
        content = {
            Text(text = "abc")
            Text(text = "1234567890")
            Text(text = "あいうえお")
            Box(
                modifier = Modifier
                    .size(170.dp)
                    .background(Color.Red)
            )
        },
//            override fun MeasureScope.measure(
//                measurables: List<Measurable>,
//                constraints: Constraints
//            ): MeasureResult {
//            }
//                MeasurePolicy interfaceで実装すべき処理はこうなってる
        measurePolicy = { measurables, constraints ->
            // measurableはこいつの中にある子要素ってことだろう
            // constraintsは成約、minHeightやらmaxHeightやらそういうサイズを決定する上での制約を持ってると思われる
            // 具体的にどんな値がくるんだ？
            Log.d("LayoutSample", "measurable=$measurables, constraints=$constraints")
            var height = 0
            val placables = mutableListOf<Placeable>()
            for ((i, m) in measurables.withIndex()) {
                val measured = m.measure(constraints)
                height = max(height, measured.height)
                placables.add(measured)
            }

            layout(constraints.maxWidth, height) {
                var positionX = constraints.maxWidth
                val padding = 8.dp.toPx().toInt()
                var positionY = 0
                for ((i, p) in placables.withIndex()) {
                    Log.d(
                        "LayoutPlacable",
                        "$p child$i ${p.height}/${p.measuredHeight} ${p.width}/${p.measuredWidth}"
                    )
                    positionX -= p.width + padding
                    val offset = if (i != 1) {
                        IntOffset(positionX, positionY)
                    } else {
                        Alignment.Center.align(
                            IntSize(p.width, p.height),
                            IntSize(constraints.maxWidth, height),
                            LayoutDirection.Ltr,
                        )
                    }
                    if (i != 1) {
                        p.place(offset)
                    } else {
                        p.place(offset, 1f)
                    }

                    positionY += 20
                }
            }
        },
    )
}

@Preview
@Composable
private fun LayoutSample_Preview() {
    LayoutSample()
}