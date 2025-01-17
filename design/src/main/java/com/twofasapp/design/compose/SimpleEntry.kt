package com.twofasapp.design.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.twofasapp.design.theme.icon
import com.twofasapp.design.theme.textPrimary
import com.twofasapp.design.theme.textSecondary

enum class SubtitleGravity { BOTTOM, END }

@Composable
fun SimpleEntry(
    title: String = "",
    subtitle: String = "",
    subtitleGravity: SubtitleGravity = SubtitleGravity.BOTTOM,
    icon: Painter? = null,
    image: Painter? = null,
    iconTint: Color = Color.Unspecified,
    iconVisibleWhenNotSet: Boolean = true,
    iconEnd: Painter? = null,
    iconEndTint: Color = Color.Unspecified,
    isEnabled: Boolean = true,
    iconEndClick: (() -> Unit)? = null,
    titleColor: Color = MaterialTheme.colors.textPrimary,
    modifier: Modifier = Modifier,
    click: (() -> Unit)? = null,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp, Dp.Infinity)
            .clickable(isEnabled) { click?.invoke() }
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
    ) {
        val (iconRef, titleRef, subtitleRef, subtitleEndRef, iconEndRef) = createRefs()
        val alpha = if (isEnabled) 1f else 0.3f

        if (image != null) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(iconRef) {
                        top.linkTo(titleRef.top)
                        start.linkTo(parent.start, margin = 4.dp)
                        end.linkTo(titleRef.start)
                    }
            )
        } else {
            Icon(
                painter = icon ?: painterResource(com.twofasapp.resources.R.drawable.ic_placeholder),
                contentDescription = null,
                tint = if (iconTint != Color.Unspecified) iconTint else MaterialTheme.colors.primary,
                modifier = Modifier
                    .size(if (iconVisibleWhenNotSet) 24.dp else 0.dp)
                    .alpha(if (icon == null) 0f else alpha)
                    .constrainAs(iconRef) {
                        top.linkTo(titleRef.top)
                        start.linkTo(parent.start, margin = 4.dp)
                        end.linkTo(titleRef.start)
                    }
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.body2.copy(fontSize = 17.sp, color = titleColor),
            modifier = Modifier
                .alpha(alpha)
                .constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(
                        if (subtitle.isNotEmpty() && subtitleGravity == SubtitleGravity.BOTTOM) subtitleRef.top else parent.bottom,
                        margin = 1.dp
                    )
                    start.linkTo(iconRef.end, margin = if (iconVisibleWhenNotSet) 28.dp else 16.dp)
                    end.linkTo(iconEndRef.start)
                    end.linkTo(subtitleEndRef.start)
                    width = Dimension.fillToConstraints
                }
        )

        if (subtitle.isNotEmpty() && subtitleGravity == SubtitleGravity.BOTTOM) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.body2.copy(fontSize = 14.sp, color = MaterialTheme.colors.textSecondary),
                modifier = Modifier
                    .alpha(alpha)
                    .constrainAs(subtitleRef) {
                        top.linkTo(titleRef.bottom, margin = 2.dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(titleRef.start)
                        end.linkTo(iconEndRef.start)
                        width = Dimension.fillToConstraints
                    }
            )
        }

        if (subtitle.isNotEmpty() && subtitleGravity == SubtitleGravity.END) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.body2.copy(fontSize = 16.sp, color = MaterialTheme.colors.textSecondary),
                modifier = Modifier
                    .alpha(alpha)
                    .constrainAs(subtitleEndRef) {
                        baseline.linkTo(titleRef.baseline)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            )
        }

        IconButton(
            onClick = {
                if (iconEnd == null && isEnabled) {
                    click?.invoke()
                } else {
                    iconEndClick?.invoke()
                }
            },
            enabled = isEnabled,
            modifier = Modifier
                .size(24.dp)
                .alpha(if (iconEnd == null) 0f else alpha)
                .constrainAs(iconEndRef) {
                    top.linkTo(titleRef.top)
                    end.linkTo(parent.end)
                }
        ) {
            Icon(
                painter = iconEnd ?: painterResource(com.twofasapp.resources.R.drawable.ic_placeholder),
                contentDescription = null,
                tint = if (iconEndTint != Color.Unspecified) iconEndTint else MaterialTheme.colors.icon,
            )
        }

    }
}

@Preview
@Composable
internal fun PreviewSimpleEntryItem() {
    SimpleEntry(
        title = "Title",
        subtitle = "Subtitle",
        subtitleGravity = SubtitleGravity.END,
        icon = painterResource(id = com.twofasapp.resources.R.drawable.ic_send_feedback),
        click = {}
    )
}