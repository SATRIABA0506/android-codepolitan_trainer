package bagaskara.satria.mydatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddEditActivity extends AppCompatActivity {
    EditText editName, editPriority;
    MyDatabase database;
    Boolean isEdit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database=new MyDatabase(this);
        editName=findViewById(R.id.enter_name);
        editPriority =findViewById(R.id.enter_priority);

        final ItemTodo todo=getIntent().getParcelableExtra("TODO");
        if(todo!=null){
            isEdit=true;
            editName.setText(todo.getName());
            editPriority.setText(String.valueOf(todo.getPriority()));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editName.getText().toString();
                int prio=Integer.parseInt(editPriority.getText().toString());

                if(isEdit){
                    todo.setName(name);
                    todo.setPriority(prio);
                    database.updateItem(todo);

                    Toast.makeText(AddEditActivity.this,"Data berhasil diperbarui",Toast.LENGTH_SHORT).show();

                }else {

                    ItemTodo todo = new ItemTodo(prio, name);
                    long id = database.addItem(todo);
                    if (id > 0) {
                        Toast.makeText(AddEditActivity.this, "Penyimpanan Berhasil", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AddEditActivity.this, "Penyimpanan Gagal", Toast.LENGTH_SHORT).show();
                    finish();
                    }
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
