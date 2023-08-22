package id.ajiguna.gmailclonecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.ajiguna.gmailclonecompose.components.GmailDrawerMenu
import id.ajiguna.gmailclonecompose.components.GmailFab
import id.ajiguna.gmailclonecompose.components.HomeAppBar
import id.ajiguna.gmailclonecompose.components.HomeBottomMenu
import id.ajiguna.gmailclonecompose.components.MailList
import id.ajiguna.gmailclonecompose.ui.theme.GmailCloneComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GmailApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val openDialog = remember{
        mutableStateOf(false)
    }
    Scaffold(scaffoldState = scaffoldState,
        topBar = {
            HomeAppBar(scaffoldState, coroutineScope, openDialog)
        },
        drawerContent = {
            GmailDrawerMenu(scrollState = scrollState)
        },
        bottomBar = {
            HomeBottomMenu()
        },
        floatingActionButton = { GmailFab(scrollState) }
    ){
        MailList(it, scrollState)
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GmailCloneComposeTheme {
        GmailApp()
    }
}