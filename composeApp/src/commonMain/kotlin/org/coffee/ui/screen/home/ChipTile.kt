package org.coffee.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.coffee.FilterColor
import org.coffee.Gray
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun ChipTile() {

    Row(
        modifier=Modifier
            .padding(start = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SelectItem(true,"Nice Cafe")
        SelectItem(false,"Cafe")
        SelectItem(false,"Nos Cafe")
    }



}

@Composable
fun SelectItem(check: Boolean, text: String) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .background(if (check) FilterColor else Gray, shape = RoundedCornerShape(7.dp))
            .padding(vertical = 7.dp, horizontal = 15.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (check) Color.White else FilterColor
        )
    }
}