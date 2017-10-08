package wm.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    boolean isNameNull = true;
    boolean isScoreNull = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = (EditText) findViewById(R.id.edit_name);
        String n = String.valueOf(name.getText());
        if(n.length()==0)
        {
            name.setError("ป้อนชื่อ");
        }
        else
        {
            isNameNull = false;
        }
        EditText score = (EditText) findViewById(R.id.edit_score);
        String s = String.valueOf(score.getText());
        if(s.length()==0)
        {
            score.setError("ป้อนคะเเนน");
        }
        else
        {
            isScoreNull = false;
        }
    }

    public void setError1(View v)
    {
        EditText name = (EditText) findViewById(R.id.edit_name);
        String n = String.valueOf(name.getText());
        if(n.length()==0)
        {
            name.setError("ป้อนชื่อ");
            isNameNull = true;
        }
        else
        {
            isNameNull = false;
        }
    }
    public void setError2(View v)
    {
        EditText score = (EditText) findViewById(R.id.edit_score);
        String n = String.valueOf(score.getText());
        if(n.length()==0)
        {
            score.setError("ป้อนคะเเนน");
            isScoreNull = true;
        }
        else
        {
            isScoreNull = false;
        }
    }
    public void Find_Grade(View v)
    {
        if(!isNameNull&&!isScoreNull)
        {
            EditText name_text = (EditText) findViewById(R.id.edit_name);
            EditText score_text = (EditText) findViewById(R.id.edit_score);
            int score = Integer.valueOf(score_text.getText().toString());
            String name = name_text.getText().toString();
            String grade ;
            if(score>=80)
            {
                grade = "A";
            }
            else if(score>=70)
            {
                grade = "B";
            }
            else if(score>=60)
            {
                grade = "C";
            }
            else if(score>=50)
            {
                grade = "D";
            }
            else
            {
                grade = "F";
            }
            Intent in = new Intent(this,Main2Activity.class);
            in.putExtra("grade_text",grade);
            in.putExtra("name_text",name);
            startActivity(in);
        }
        else if(isNameNull&&isScoreNull)
        {
            Toast t = Toast.makeText(this ,"ป้อนชื่อและคะเเนน", Toast.LENGTH_LONG);
            t.show();
        }
        else if(isNameNull)
        {
            Toast t = Toast.makeText(this ,"ป้อนชื่อ", Toast.LENGTH_LONG);
            t.show();
        }
        else if(isScoreNull)
        {
            Toast t = Toast.makeText(this ,"ป้อนคะเเนน", Toast.LENGTH_LONG);
            t.show();
        }

    }

    public void Exit(View v)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Confirm Exit");
        dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
        dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        dialog.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }
}
