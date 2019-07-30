package com.marshmallow.paywhere;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button send_btn;
    private Animation btn_anim;
    private EditText subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        toolbar = findViewById(R.id.feedback_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(true);
        // Up button has same behavior as back button.
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        send_btn = findViewById(R.id.send_btn);
        btn_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.get_started_btn_anim);
        send_btn.setAnimation(btn_anim);

        subject = findViewById(R.id.feedback_subject);
        message = findViewById(R.id.feedback_msg);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject_text = subject.getText().toString();
                String message_text = message.getText().toString();

                Intent send = new Intent(Intent.ACTION_SEND);
                send.putExtra(Intent.EXTRA_EMAIL, new String[]{"teammarshmallow2019@gmail.com"});
                send.putExtra(Intent.EXTRA_SUBJECT, subject_text);
                send.putExtra(Intent.EXTRA_TEXT, message_text);
                send.setType("message/rfc882");
                startActivity(send);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
