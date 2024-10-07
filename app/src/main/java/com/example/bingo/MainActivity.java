package com.example.bingo;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private GridLayout bingoBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        bingoBoard = findViewById(R.id.bingoBoard);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startButton.setVisibility(View.INVISIBLE);
                bingoBoard.setVisibility(View.VISIBLE);
                generateBingoBoard();
            }
        });

    }

    private void generateBingoBoard() {

        bingoBoard.removeAllViews();

        String[] words = {
                "Unchain Bomba",
                "Flyphase Tombs",
                "Tank Dead in P1",
                "Tank Dead in P2",
                "P2 Melee Tomb Miss",
                "P2 Head Tomb Miss",
                "Tail Swiping The Melee",
                "Freezing The Team",
                "Mechanic Overlap Glitch",
                "Tank Getting Tombed",
                "Tank Swap Fail",
                "Melee Overstack",
                "Flyphase Tomb Dies",
                "Getting Hit By Frost Bomb",
                "Blistering Grab",
                "Low Healing",
        };

        ArrayList<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        Collections.shuffle(wordList);

        bingoBoard.setColumnCount(4);
        bingoBoard.setRowCount(4);

        int cellWidthDp = 80;
        int cellHeightDp = 80;

        // Convert dp to pixels
        float scale = getResources().getDisplayMetrics().density;
        int cellWidthPx = (int) (cellWidthDp * scale + 0.5f);
        int cellHeightPx = (int) (cellHeightDp * scale + 0.5f);

          //szamokkal
//        ArrayList<Integer> numbers = new ArrayList<>();
//        for (int i = 1; i <= 25; i++) {
//            numbers.add(i);
//        }
//        Collections.shuffle(numbers);
        //16 a 4x4 tabla
        for (int i = 0; i < 16; i++) {
//           TextView button = new TextView(this);
//            button.setText(String.valueOf(wordList.get(i)));
//            button.setTextSize(20f);
//            button.setPadding(32, 32, 32, 32);
//            button.setBackgroundResource(android.R.drawable.btn_default);
//            button.setGravity(View.TEXT_ALIGNMENT_CENTER);
           // bingoBoard.addView(button);
            final TextView cell = new TextView(this);
            final String word = wordList.get(i);
            cell.setText(String.valueOf(wordList.get(i)));
            cell.setTextSize(12f);
            cell.setPadding(32, 32, 32, 32);
            cell.setBackgroundResource(android.R.drawable.btn_default);

            cell.setSingleLine(false);
            cell.setMaxLines(3);
            cell.setEllipsize(null);

            cell.setGravity(View.TEXT_ALIGNMENT_CENTER | View.TEXT_ALIGNMENT_GRAVITY);
            cell.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.setMargins(4, 4, 4, 4);
            params.width = cellWidthPx;
            params.height = cellHeightPx;
            cell.setLayoutParams(params);

            cell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cell.setText(word + " \u2716");
                    cell.setTextSize(18f);
                }
            });

            bingoBoard.addView(cell);
        }


    }


}