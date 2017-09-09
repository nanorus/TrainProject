package com.example.nanorus.trainproject.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.nanorus.trainproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogsActivity extends AppCompatActivity {

    @BindView(R.id.activity_dialogs_btn_alert)
    Button mBtnAlert;
    @BindView(R.id.activity_dialogs_btn_fragment)
    Button mBtnFragment;

    DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        ButterKnife.bind(this);
        dialogFragment = new TestDialogFragment();

        mBtnAlert.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Это Alert");
            builder.setMessage("Поздравляем, вы открыли Alert Dialog!");
            builder.setPositiveButton("Действие", (dialogInterface, i) -> Toast.makeText(this, "Нажата позитивная кнопка", Toast.LENGTH_SHORT).show());
            builder.setNegativeButton("Отмена", (dialogInterface, i) -> Toast.makeText(this, "Нажата негативная кнопка", Toast.LENGTH_SHORT).show());
            builder.setOnCancelListener(dialogInterface -> Toast.makeText(this, "Диалог отменен", Toast.LENGTH_SHORT).show());
            builder.show();
        });
        mBtnFragment.setOnClickListener(view -> dialogFragment.show(getFragmentManager(), "dialog"));
    }
}
