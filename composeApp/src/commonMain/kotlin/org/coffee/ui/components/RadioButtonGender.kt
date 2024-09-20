package org.coffee.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import org.coffee.CoffeeBTN

@Composable
fun RadioButtonGender(
    radioOption: List<String> = listOf("Male", "Female"),
    onSelected: (String) -> Unit
) {
    var selectedItem by remember { mutableStateOf(radioOption[0]) }


    LazyRow {
        items(radioOption) {
            Row {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .selectable(
                            selected = (selectedItem == it),
                            onClick = {
                                selectedItem = it
                                onSelected(selectedItem)
                            },
                            role = Role.RadioButton,
                        )
                        .padding(horizontal = 10.dp)
                ) {
                    RadioButton(
                        colors = RadioButtonDefaults.colors(
                            selectedColor = CoffeeBTN
                        ),
                        selected = (selectedItem == it),
                        onClick = {
                            selectedItem = it

                        },
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Text(text = it, color = Color.White)
                }
            }
        }
    }
}