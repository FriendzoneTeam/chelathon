package mx.friendzoneteam.chelathon.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gianpa on 2/27/16.
 */
public class Venue implements Parcelable {
    public int id;
    public String name;
    public Location location;


    public Venue() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.location, flags);
    }

    protected Venue(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Parcelable.Creator<Venue> CREATOR = new Parcelable.Creator<Venue>() {
        public Venue createFromParcel(Parcel source) {
            return new Venue(source);
        }

        public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };
}
