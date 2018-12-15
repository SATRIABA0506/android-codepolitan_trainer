package bagaskara.satria.mydatabase;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    List<ItemTodo>items;
    Context context;

    public TodoListAdapter(List<ItemTodo> items, Context context) {
        this.items = items;
        this.context = context;
    }
    public  void setItems(List<ItemTodo>items){
        this.items=items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_todo,viewGroup,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder todoViewHolder, int i) {
    final ItemTodo todo=items.get(i);
    todoViewHolder.todoName.setText(todo.getName());

    todoViewHolder.todoEdit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent pindahintent=new Intent(context,AddEditActivity.class);
            pindahintent.putExtra("TODO",todo);
            context.startActivity(pindahintent);
        }
    });

    todoViewHolder.todoDone.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MyDatabase database=new MyDatabase(context);
            database.delete(todo.getId());

            items.clear();
            items.addAll(database.getAll());
            notifyDataSetChanged();
        }
    });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder{
        TextView todoName;
        ImageView todoEdit;
        ImageView todoDone;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
                todoName=itemView.findViewById(R.id.todo_name);
                todoDone=itemView.findViewById(R.id.done_todo);
                todoEdit=itemView.findViewById(R.id.edit_todo);
        }




        }
    }

