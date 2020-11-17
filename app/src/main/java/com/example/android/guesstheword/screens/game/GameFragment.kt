/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.main_activity.*

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

//    // The current word
//    private var word = ""
//
//    // The current score
//    private var score = 0
//
//    // The list of words - the front of the list is the next word to guess
//    private lateinit var wordList: MutableList<String>

    private lateinit var binding: GameFragmentBinding

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )

        //ViewModel
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

//        viewModel.score.observe(viewLifecycleOwner, Observer {
//            binding.scoreText.text = it.toString() })

        // Di hapus karena live data nya sudah disertakan dalam binding data di text xml
//        // Fitur Live Data ketika terjadi perubahan maka observe akan mentriger observer untuk melihat perubahan.
//        viewModel.score.observe(viewLifecycleOwner, Observer { newScore -> // lamda hanya penamaan variabel penggati it : mengikuti dari viewModel score
//            binding.scoreText.text = newScore.toString()
//        }) // kalau di activity viewLifecycleOwner... cukup this disini karena di fragment.
//
//        // melihat perubahan data pada viewModel , terjadi perubahan / update pada viewModel word.value makan akan berubah juga pada fun binding yang ada pad ait
//        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
//            binding.wordText.text = newWord
//        })

        //observer
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) gameFinished()

        })

        // mengisi variable yang ada di xml dengan view model
        binding.gameViewModel = viewModel

        // supaaya livedata bisa digunakan pada xml , sehingga bisa di observe
        binding.lifecycleOwner = viewLifecycleOwner



//        resetList()
//        nextWord()
//    Di hapus karena sudah dibinding langsung di xml nya
//        binding.correctButton.setOnClickListener { onCorrect() }
//        binding.skipButton.setOnClickListener { onSkip() }
//        binding.endGameButton.setOnClickListener { onEndGame() }


        // DI Hapus Karena sudah tergantikan dari view Model sudah live data. yang berubah / update
//        updateScoreText()
//        updateWordText()
        return binding.root

    }

    /**
     * Resets the list of words and randomizes the order
     */
//    private fun resetList() {
//        wordList = mutableListOf(
//                "queen",
//                "hospital",
//                "basketball",
//                "cat",
//                "change",
//                "snail",
//                "soup",
//                "calendar",
//                "sad",
//                "desk",
//                "guitar",
//                "home",
//                "railway",
//                "zebra",
//                "jelly",
//                "car",
//                "crow",
//                "trade",
//                "bag",
//                "roll",
//                "bubble"
//        )
//        wordList.shuffle()
//    }

    /** Methods for buttons presses **/

    // dihapus sehingga game fragment tampak simple karena sudah dibinding functionnya

//    private fun onSkip() {
//        viewModel.onSkip()
//        // DI Hapus Karena sudah tergantikan dari view Model sudah live data. yang berubah / update
////        updateWordText()
////        updateScoreText()
//    }
//
//    private fun onCorrect() {
//        viewModel.onCorrect()
//        // DI Hapus Karena sudah tergantikan dari view Model sudah live data. yang berubah / update
////        updateWordText()
////        updateScoreText()
//    }
//
//    private fun onEndGame(){
//        gameFinished()
//    }

    private fun  gameFinished(){
        val action = GameFragmentDirections.actionGameToScore()
//        action.score = viewModel.score
        action.score = viewModel.score.value?:0 //ternary operator - pengecekan nilai - ketika nilai bernilai null maka akan false mengisi angka 0 , jika bernilai true akan megisi nilai score value tersebut.
        NavHostFragment.findNavController(this).navigate(action)
        viewModel.onGameFinishComplete()
    }

//    /**
//     * Moves to the next word in the list
//     */
//    private fun nextWord() {
//        if (!wordList.isEmpty()) {
//            //Select and remove a word from the list
//            word = wordList.removeAt(0)
//        }
//        updateWordText()
//        updateScoreText()
//    }


    // DI Hapus Karena sudah tergantikan dari view Model sudah live data. yang berubah / update

//    /** Methods for updating the UI **/
//
//    private fun updateWordText() {
////        binding.wordText.text = viewModel.word
//        binding.wordText.text = viewModel.word.value.toString()
//    }
//
//    private fun updateScoreText() {
//        binding.scoreText.text = viewModel.score.toString()
//    }
}
