package wm.whatsyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent in = getIntent();
        String g = in.getStringExtra("grade_text");
        String n = in.getStringExtra("name_text");
        TextView gradeT = (TextView)findViewById(R.id.grade_T);
        TextView nameT = (TextView)findViewById(R.id.name_T);
        gradeT.setText(g);
        nameT.setText(n);
    }
}
