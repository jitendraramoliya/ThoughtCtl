package com.thoughtctlapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.tweetsy.ui.theme.ThoughtAppTheme
import com.thoughtctlapp.compo.ImgurListContent
import com.thoughtctlapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var keepSplash = true
    private val delay = 1500L
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup Splash Screen
        val splashScreen = installSplashScreen()
        setupSplashScreen(splashScreen = splashScreen)

        setContent {
            ThoughtAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    ShowMainContent(mainViewModel)
                }
            }
        }
    }

    private fun setupSplashScreen(splashScreen: SplashScreen) {
        // Replace this timer with your logic to load data on the splash screen.
        splashScreen.setKeepOnScreenCondition { keepSplash }
        Handler(Looper.getMainLooper()).postDelayed({
            keepSplash = false
        }, delay)
    }

}

@Preview(showBackground = true)
@Composable
fun ShowMainContent(mainViewModel: MainViewModel? = null) {

//    var isImgList = rememberstate
    val isListSelected = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black, contentColor = Color.White,
                title = {
                    Text(stringResource(id = R.string.app_name))
                },
                actions = {
                    if (isListSelected.value) {
                        IconButton(onClick = { isListSelected.value = false }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                tint = Color.White,
                                contentDescription = "list"
                            )
                        }
                    } else {
                        IconButton(onClick = { isListSelected.value = true}) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                tint = Color.White,
                                contentDescription = "Grid",
                                modifier = Modifier.rotate(90F)
                            )
                        }
                    }
                },
            )
        },
    ) { innerPadding ->
        mainViewModel?.let { ImgurListContent(innerPadding, isListSelected) }
    }
}

