package tuankien.st001.profileex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultpage extends AppCompatActivity {
    private TextView name, phone, gender, age, level, sport, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);
        //findid
        name = this.findViewById(R.id.name);
        phone = this.findViewById(R.id.phone);
        gender = this.findViewById(R.id.gender);
        age = this.findViewById(R.id.age);
        level = this.findViewById(R.id.level);
        sport = this.findViewById(R.id.sport);
        music = this.findViewById(R.id.music);
        //gandata
        Intent intent = getIntent();
        String ten = intent.getStringExtra("name");
        name.setText(ten);

        String sdt = intent.getStringExtra("phone");
        phone.setText(sdt);

        String gtinh = intent.getStringExtra("gender");
        gender.setText(gtinh);

        String tuoi = intent.getStringExtra("age");
        age.setText(tuoi);

        String trinhdo = intent.getStringExtra("level");
        level.setText(trinhdo);

        String thethao = intent.getStringExtra("sport");
        sport.setText(thethao);

        String amnhac = intent.getStringExtra("music");
        music.setText(amnhac);
        Button back = this.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultpage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}