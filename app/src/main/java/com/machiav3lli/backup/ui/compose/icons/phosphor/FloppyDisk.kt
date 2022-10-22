package com.machiav3lli.backup.ui.compose.icons.phosphor

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.machiav3lli.backup.ui.compose.icons.Phosphor

val Phosphor.FloppyDisk: ImageVector
    get() {
        if (_floppy_disk != null) {
            return _floppy_disk!!
        }
        _floppy_disk = Builder(
            name = "Floppy-disk",
            defaultWidth = 32.0.dp,
            defaultHeight = 32.0.dp,
            viewportWidth = 256.0f,
            viewportHeight = 256.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(219.3f, 80.0f)
                lineTo(176.0f, 36.7f)
                arcTo(15.9f, 15.9f, 0.0f, false, false, 164.7f, 32.0f)
                horizontalLineTo(48.0f)
                arcTo(16.0f, 16.0f, 0.0f, false, false, 32.0f, 48.0f)
                verticalLineTo(208.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, false, false, 16.0f, 16.0f)
                horizontalLineTo(208.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, false, false, 16.0f, -16.0f)
                verticalLineTo(91.3f)
                arcTo(15.9f, 15.9f, 0.0f, false, false, 219.3f, 80.0f)
                close()
                moveTo(168.0f, 208.0f)
                horizontalLineTo(88.0f)
                verticalLineTo(152.0f)
                horizontalLineToRelative(80.0f)
                close()
                moveTo(208.0f, 91.3f)
                verticalLineTo(208.0f)
                horizontalLineTo(184.0f)
                verticalLineTo(152.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, false, false, -16.0f, -16.0f)
                horizontalLineTo(88.0f)
                arcToRelative(16.0f, 16.0f, 0.0f, false, false, -16.0f, 16.0f)
                verticalLineToRelative(56.0f)
                horizontalLineTo(48.0f)
                verticalLineTo(48.0f)
                horizontalLineTo(164.7f)
                lineTo(208.0f, 91.3f)
                close()
                moveTo(160.0f, 72.0f)
                arcToRelative(8.0f, 8.0f, 0.0f, false, true, -8.0f, 8.0f)
                horizontalLineTo(96.0f)
                arcToRelative(8.0f, 8.0f, 0.0f, false, true, 0.0f, -16.0f)
                horizontalLineToRelative(56.0f)
                arcTo(8.0f, 8.0f, 0.0f, false, true, 160.0f, 72.0f)
                close()
            }
        }
            .build()
        return _floppy_disk!!
    }

private var _floppy_disk: ImageVector? = null
