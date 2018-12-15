package bagaskara.satria.codepolitanreader;

import android.os.Parcel;
import android.os.Parcelable;

public class Artikel implements Parcelable {
    String judul;
    String penulis;
    String link;
    String thumbnail;

    public Artikel() {
    }

    public Artikel(String judul, String penulis, String link, String thumbnail) {
        this.judul = judul;
        this.penulis = penulis;
        this.link = link;
        this.thumbnail = thumbnail;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;

    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;

    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.penulis);
        dest.writeString(this.link);
        dest.writeString(this.thumbnail);
    }

    protected Artikel(Parcel in) {
        this.judul = in.readString();
        this.penulis = in.readString();
        this.link = in.readString();
        this.thumbnail = in.readString();
    }

    public static final Parcelable.Creator<Artikel> CREATOR = new Parcelable.Creator<Artikel>() {
        @Override
        public Artikel createFromParcel(Parcel source) {
            return new Artikel(source);
        }

        @Override
        public Artikel[] newArray(int size) {
            return new Artikel[size];
        }
    };
}
