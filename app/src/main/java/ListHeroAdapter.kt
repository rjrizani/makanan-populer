import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.myrecyclerview.R
import com.dicoding.myrecyclerview.detail

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto)
       // holder.imgPhoto.setImageResource(photo)

        holder.tvName.text = name
        holder.tvDescription.text = description

        val hero = listHero[holder.adapterPosition]
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, detail::class.java)
            intent.putExtra(detail.EXTRA_NAME, hero.name)
            intent.putExtra(detail.EXTRA_DESCRIPTION, hero.description)
            intent.putExtra(detail.EXTRA_PHOTO, hero.photo)
            intent.putExtra(detail.EXTRA_MORE_INFO, hero.moreInfo)
            // ...
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}