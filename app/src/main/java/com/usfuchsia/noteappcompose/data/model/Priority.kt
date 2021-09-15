package com.usfuchsia.noteappcompose.data.model

import androidx.compose.ui.graphics.Color
import com.usfuchsia.noteappcompose.ui.theme.HighPriorityColor
import com.usfuchsia.noteappcompose.ui.theme.LowPriorityColor
import com.usfuchsia.noteappcompose.ui.theme.MediumPriorityColor
import com.usfuchsia.noteappcompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}