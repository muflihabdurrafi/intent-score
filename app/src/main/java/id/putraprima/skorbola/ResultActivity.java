package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvScore, tvNama, tvMenang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String home = getIntent().getExtras().getString("key_score_home");
        String away = getIntent().getExtras().getString("key_score_away");
        String homeTxt = getIntent().getExtras().getString("key_homeTxt");
        String awayTxt = getIntent().getExtras().getString("key_awayTxt");

        tvScore = findViewById(R.id.textView2);
        tvNama = findViewById(R.id.textView3);
        tvMenang = findViewById(R.id.textView5);

        tvScore.setText(home + "—" + away);
        tvNama.setText(homeTxt + " vs " + awayTxt);

        int i_home = Integer.parseInt(home);
        int i_away = Integer.parseInt(away);

        if (i_home > i_away){
            tvMenang.setText(homeTxt);
        } else {
            tvMenang.setText(awayTxt);
        }
    }
}
