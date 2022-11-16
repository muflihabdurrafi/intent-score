package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button next;
    ImageView homeLogo, awayLogo;
    Uri homeImg, awayImg;
    EditText homeInput, awayInput;
    String s_home, s_away, s_homeimg, s_awayimg;
    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int HOME_REQUEST_CODE = 1;
    private static final int AWAY_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.btn_team);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        homeInput = findViewById(R.id.home_team);
        awayInput = findViewById(R.id.away_team);
        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity

        homeLogo.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI),HOME_REQUEST_CODE);
           }
        });
        awayLogo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI),AWAY_REQUEST_CODE);
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                s_home = homeInput.getText().toString();
                s_away = awayInput.getText().toString();

                if (homeImg!=null && awayImg!=null){
                    s_homeimg = homeImg.toString();
                    s_awayimg = awayImg.toString();
                    Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                    intent.putExtra("key_home",s_home);
                    intent.putExtra("key_away",s_away);
                    intent.putExtra("key_imagehome", s_homeimg);
                    intent.putExtra("key_imageaway", s_awayimg);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Tolong masukkan gambar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Log.d(TAG, "pilih gambar dicancel");
            return;
        } else if (requestCode == HOME_REQUEST_CODE){
            if(data!=null){
                try {
                    Uri imageUri = data.getData();
                    homeImg = imageUri;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), homeImg);
                    homeLogo.setImageBitmap(bitmap);
                } catch (IOException error){
                    Toast.makeText(this, "Can't Load Image",Toast.LENGTH_SHORT).show();
                    Log.e(TAG, error.getMessage());
                }
            }
        } else if (requestCode == AWAY_REQUEST_CODE){
            if(data!=null){
                try {
                    Uri imageUri = data.getData();
                    awayImg = imageUri;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), awayImg);
                    awayLogo.setImageBitmap(bitmap);
                } catch (IOException error){
                    Toast.makeText(this, "Can't Load Image",Toast.LENGTH_SHORT).show();
                    Log.e(TAG, error.getMessage());
                }
            }
        }
    }
}
