package com.norm.mychangesystembarscolor

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import com.norm.mychangesystembarscolor.ui.theme.MyChangeSystemBarsColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = (LocalContext.current as Activity).window
            val view = LocalView.current

            val defaultStatusBarColor = colorScheme.primary
            val defaultNavigationBarColor = Color.Black
            val isDarkThem = isSystemInDarkTheme()

            MyChangeSystemBarsColorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background,
                ) {
                    SystemBarsColorChanger(
                        statusColor = Color.Blue,
                        navigationColor = Color.Red,
                        isLightIcons = true,
                    )
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Button(
                                onClick = {
                                    changeSystemBarsColor(
                                        window = window,
                                        view = view,
                                        statusColor = Color.Magenta,
                                        navigationColor = Color.Yellow,
                                        isLightIcons = false,
                                    )
                                }
                            ) {
                                Text(
                                    text = "Change colors"
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = {
                                    changeSystemBarsColor(
                                        window = window,
                                        view = view,
                                        statusColor = defaultStatusBarColor,
                                        navigationColor = defaultNavigationBarColor,
                                        isLightIcons = isDarkThem,
                                    )
                                }
                            ) {
                                Text(
                                    text = "Set default colors"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}