package app.listview.pedor.com.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    // When clicking a game tile
    public void tileClicked(View view) {
        String tag = view.getTag().toString();
        Button b = (Button)view;
        int row = Character.getNumericValue(tag.toCharArray()[0]);
        int column = Character.getNumericValue(tag.toCharArray()[1]);
        Tile tile = game.draw(row, column);
        switch(tile) {
            case CROSS:
                b.setText("x");
                break;
            case CIRCLE:
                b.setText("o");
                break;
            case INVALID:
                break;
        }
    }

    // Clicking reset
    public void resetClicked(View view) {
        game = new Game();
        for (int i=1; i < 4; i++) {
            for (int j=1; j < 4; j++) {
                Button b = (Button)findViewById(
                        getResources().getIdentifier("button"+i+j, "id",
                                getPackageName()));
                b.setText("");
            }
        }

    }
}
