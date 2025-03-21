package com.machiav3lli.backup.ui.compose.icons.phosphor


import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.machiav3lli.backup.ui.compose.icons.Phosphor

val Phosphor.NotePencil: ImageVector
    get() {
        if (_note_pencil != null) {
            return _note_pencil!!
        }
        _note_pencil = Builder(
            name = "Note-pencil",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 256.0f,
            viewportHeight = 256.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(229.7f, 58.3f)
                lineToRelative(-32.0f, -32.0f)
                arcToRelative(8.1f, 8.1f, 0.0f, false, false, -11.4f, 0.0f)
                lineToRelative(-96.0f, 96.0f)
                arcTo(8.1f, 8.1f, 0.0f, false, false, 88.0f, 128.0f)
                verticalLineToRelative(32.0f)
                arcToRelative(8.0f, 8.0f, 0.0f, false, false, 8.0f, 8.0f)
                horizontalLineToRelative(32.0f)
                arcToRelative(8.1f, 8.1f, 0.0f, false, false, 5.7f, -2.3f)
                lineToRelative(96.0f, -96.0f)
                arcTo(8.1f, 8.1f, 0.0f, false, false, 229.7f, 58.3f)
                close()
                moveTo(124.7f, 152.0f)
                horizontalLineTo(104.0f)
                verticalLineTo(131.3f)
                lineToRelative(64.0f, -64.0f)
                lineTo(188.7f, 88.0f)
                close()
                moveTo(200.0f, 76.7f)
                lineTo(179.3f, 56.0f)
                lineTo(192.0f, 43.3f)
                lineTo(212.7f, 64.0f)
                close()
                moveTo(224.0f, 120.0f)
                verticalLineToRelative(88.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, false, true, -16.0f, 16.0f)
                horizontalLineTo(48.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, false, true, -16.0f, -16.0f)
                verticalLineTo(48.0f)
                arcTo(16.0f, 16.0f, 0.0f, false, true, 48.0f, 32.0f)
                horizontalLineToRelative(88.0f)
                arcToRelative(8.0f, 8.0f, 0.0f, false, true, 0.0f, 16.0f)
                horizontalLineTo(48.0f)
                verticalLineTo(208.0f)
                horizontalLineTo(208.0f)
                verticalLineTo(120.0f)
                arcToRelative(8.0f, 8.0f, 0.0f, false, true, 16.0f, 0.0f)
                close()
            }
        }
            .build()
        return _note_pencil!!
    }

private var _note_pencil: ImageVector? = null

@Preview
@Composable
fun NotePencilPreview() {
    Image(
        Phosphor.NotePencil,
        null
    )
}
