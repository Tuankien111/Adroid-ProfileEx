package tuankien.st001.profileex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView age1, nam, nu;
    private ProgressBar prbar;
    private SeekBar age;
    private EditText name, phone;
    private Switch gender;
    private CheckBox sport;
    private RadioButton rock, pop, rap;
    private Spinner level;
    private Button register, cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tên
        name = this.findViewById(R.id.name);


        //sđt
        phone = this.findViewById(R.id.phone);


        //giới tính
        gender = this.findViewById(R.id.gender);
        nam = this.findViewById(R.id.nam);
        nu = this.findViewById(R.id.nu);

        //tuổi
        age1 = this.findViewById(R.id.age1);
        prbar = this.findViewById(R.id.progress);
        age = this.findViewById(R.id.age);
        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prbar.setProgress(progress);
                age1.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //trình độ
        level = this.findViewById(R.id.level);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.levels_array, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        level.setAdapter(adapter);
        //thể thao
        sport = this.findViewById(R.id.sport);

        //âm nhạc
        rock = this.findViewById(R.id.rock);
        pop = this.findViewById(R.id.pop);
        rap = this.findViewById(R.id.rap);

        //button
        register = this.findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Resultpage.class);
                //ten
                String rname = name.getText().toString();
                intent.putExtra("name", rname);
                //sdt
                String rphone = phone.getText().toString();
                intent.putExtra("phone", rphone);
                //gt
                String rgender;
                if (gender.isChecked()) {
                    rgender = nam.getText().toString();
                    ;
                } else {
                    rgender = nu.getText().toString();
                }
                intent.putExtra("gender", rgender);
                //tuoi
                String rage = age1.getText().toString();
                intent.putExtra("age", rage);
                //trinhdo
                String rlevel = level.getSelectedItem().toString();
                intent.putExtra("level", rlevel);

                //thethao
                String rsport;
                if (sport.isChecked()) {
                    rsport = "Có";
                } else {
                    rsport = "Không";
                }
                intent.putExtra("sport", rsport);

                //amnhac
                String rmusic = "Không";
                if (rock.isChecked() == true) {
                    rmusic = "Rock";
                }
                if (pop.isChecked() == true) {
                    rmusic = "Pop";
                }
                if (rap.isChecked() == true) {
                    rmusic = "Rap";
                }
                intent.putExtra("music", rmusic);
                startActivity(intent);
            }
        });
        cancle = this.findViewById(R.id.btncancel);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                age.setProgress(1);
                age1.setText("1");
                gender.setChecked(false);
                level.setSelection(0);
                sport.setChecked(false);
                rock.setChecked(false);
                pop.setChecked(false);
                rap.setChecked(false);
            }
        });
    }
}