package id.ajiguna.gmailclonecompose.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import id.ajiguna.gmailclonecompose.model.BottomMenuData

@Composable
fun HomeBottomMenu(){
    val items = listOf(BottomMenuData.Mail,BottomMenuData.Meet)
    
    BottomNavigation() {
        items.forEach { 
            BottomNavigationItem(
                label = { Text(text = it.title)},
                alwaysShowLabel = true,
                selected = false, 
                onClick = { /*TODO*/ }, 
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) })
        }
    }
}