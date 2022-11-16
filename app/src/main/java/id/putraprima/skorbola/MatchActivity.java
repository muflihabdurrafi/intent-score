package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    TextView homeTxt, awayTxt, homeScore, awayScore;
    ImageView homeLogo, awayLogo;
    Button result, reset, add_home_satu, add_home_dua, add_home_tiga, add_away_satu, add_away_dua, add_away_tiga;
    int skor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"

        String home = getIntent().getExtras().getString("key_home");
        final String away = getIntent().getExtras().getString("key_away");
        Uri bitmapHome = Uri.parse(getIntent().getExtras().getString("key_imagehome"));
        Uri bitmapAway = Uri.parse(getIntent().getExtras().getString("key_imageaway"));

        homeTxt = findViewById(R.id.txt_home);
        awayTxt = findViewById(R.id.txt_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        reset = findViewById(R.id.btn_reset);
        result = findViewById(R.id.btn_result);
        homeScore = findViewById(R.id.score_home);
        awayScore = findViewById(R.id.score_away);
        add_home_satu = findViewById(R.id.btn_add_home_satu);
        add_home_dua = findViewById(R.id.btn_add_home_dua);
        add_home_tiga = findViewById(R.id.btn_add_home_tiga);
        add_away_satu = findViewById(R.id.btn_add_away_satu);
        add_away_dua = findViewById(R.id.btn_add_away_dua);
        add_away_tiga = findViewById(R.id.btn_add_away_tiga);

        homeTxt.setText(home);
        awayTxt.setText(away);
        homeLogo.setImageURI(bitmapHome);
        awayLogo.setImageURI(bitmapAway);


        add_home_satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = homeScore.getText().toString();
                int i = Integer.parseInt(score);
                i+=1;
                String a = new Integer(i).toString();
                homeScore.setText(a);
            }
        });
        add_home_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = homeScore.getText().toString();
                int i = Integer.parseInt(score);
                i+=2;
                String a = new Integer(i).toString();
                homeScore.setText(a);
            }
        });
        add_home_tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = homeScore.getText().toString();
                int i = Integer.parseInt(score);
                i+=3;
                String a = new Integer(i).toString();
                homeScore.setText(a);
            }
        });
        add_away_satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = awayScore.getText().toString();
                int i = Integer.parseInt(score);
                i+=1;
                String a = new Integer(i).toString();
                awayScore.setText(a);
            }
        });
        add_away_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = awayScore.getText().toString();
                int i = Integer.parseInt(score);
                i+=2;
                String a = new Integer(i).toString();
                awayScore.setText(a);
            }
        });
        add_away_tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = awayScore.getText().toString();
                int i = Integer.parseInt(score);
                i+=3;
                String a = new Integer(i).toString();
                awayScore.setText(a);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeScore.setText("0");
                awayScore.setText("0");
            }
        });
        result.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);

                startActivity(intent);
            }
        });
    }
}
