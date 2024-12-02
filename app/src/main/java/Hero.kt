import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    val  name: String,
    val description: String,
    val photo: String,
    val moreInfo: String,

):Parcelable
