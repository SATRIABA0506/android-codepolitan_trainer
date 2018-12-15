package bagaskara.satria.mydatabase;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemTodo implements Parcelable {
    private int id,priority;
    private String name;

    public ItemTodo(int id, int priority, String name) {
        this.id = id;
        this.priority = priority;
        this.name = name;
    }

    public ItemTodo(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public ItemTodo() {
    }

    public int getId() {
        return id;
    }

    public ItemTodo setId(int id) {
        this.id = id;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public ItemTodo setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemTodo setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.priority);
        dest.writeString(this.name);
    }

    protected ItemTodo(Parcel in) {
        this.id = in.readInt();
        this.priority = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<ItemTodo> CREATOR = new Parcelable.Creator<ItemTodo>() {
        @Override
        public ItemTodo createFromParcel(Parcel source) {
            return new ItemTodo(source);
        }

        @Override
        public ItemTodo[] newArray(int size) {
            return new ItemTodo[size];
        }
    };
}
