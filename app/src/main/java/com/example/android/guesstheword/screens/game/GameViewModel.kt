package com.example.android.guesstheword.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    // The current word
//    var word = ""
    private val _word = MutableLiveData<String>() // mengubah nilai dengan object live data yang bisa diubah dengan type generic String  default null
    // val karena yang berubah member objectnya
    val word: LiveData<String> // variable private variable yan dihubungkan pada  public variable
        get() = _word

    // The current score
//    var score = 0
    private val _score = MutableLiveData<Int>() // mengubah nilai dengan object live data yang bisa diubah dengan type generic Integer - default nya null
    val score: LiveData<Int> // hanya bisa memanggil karena getter  , sedangkan untuk mengubah data nya bisa menggunkan variable yang private bertype MutableLiveData
        get() = _score

    private val _eventGameFinish = MutableLiveData<Boolean>() // untuk memanipulasi di viewModel
    val eventGameFinish : LiveData<Boolean>
        get() = _eventGameFinish


    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        _word.value = "" // membuat default nilai pada live data mutable karena telah berubah menjadi object.
        _score.value = 0 // mengisi nilai initial
        resetList()
        nextWord()
    }

    /**
     * Resets the list of words and randomizes the order
     */

    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
//            word = wordList.removeAt(0)
            _word.value = wordList.removeAt(0)
        }else{
            onGameFinish()
        }
//        updateWordText()
//        updateScoreText()
    }

    /** Methods for buttons presses **/

     fun onSkip() {
//        score-- live data tidak bisa menggunakan operator tersebut karena object
        _score.value = (score.value)?.minus(1)  // caranya dengan mengisi value nya denga minus 1 , tanda tanya disini dimaksudkan bertanya seperti ternary operator
        nextWord()
    }

     fun onCorrect() {
//        score++  live data tidak bisa menggunakan operator tersebut karena object
         _score.value = (score.value)?.plus(1)  // caranya dengan mengisi value nya denga plus 1 , tanda tanya disini dimaksudkan bertanya seperti ternary operator
        nextWord()
    }

    fun onGameFinish(){
        _eventGameFinish.value = true
    }

    fun onGameFinishComplete(){
        _eventGameFinish.value = false // mengubah false ketika mengulang permainan lagi.
    }


}