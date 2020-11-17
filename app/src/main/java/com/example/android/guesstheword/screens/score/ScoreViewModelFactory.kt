package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ScoreViewModelFactory (private val finalScore : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T { // T = ViewModel jenis apapun seperti ScoreViewModel / GameView Model Apapun ( Type Generic ) / berupa class sprti GameFragment
        // untuk memastikan itu adalah class view model  maka dibuat clausul if
        if(modelClass.isAssignableFrom(ScoreViewModel::class.java)) {  // memastikan viewModel yang akan kita inginkan
            return ScoreViewModel(finalScore) as T //alias / mengubah menjadi class agar berupa returnnya jenis jenis generic ViewModel T
        }
        throw IllegalArgumentException("Unknown View Model") // melempar exception - memberikan Keterangan jika tidak memenuhi ( menunjuk langsung ) - mengembalikan hasil walaupun type bukan T sehingga aplikasi tidak mati

    }
}