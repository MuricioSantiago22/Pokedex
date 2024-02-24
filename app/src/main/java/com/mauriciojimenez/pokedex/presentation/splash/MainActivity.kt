package com.mauriciojimenez.pokedex.presentation.splash


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.activity.viewModels
import com.mauriciojimenez.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.Modifier
import com.mauriciojimenez.pokedex.presentation.navigation.AppNavigation


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
        mainViewModel.getPokemon()
    }
}