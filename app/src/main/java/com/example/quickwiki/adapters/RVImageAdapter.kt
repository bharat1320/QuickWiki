import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickwiki.R
import com.example.quickwiki.fragments.RVImage
import kotlin.collections.ArrayList

class RVImageAdapter(private val item: ArrayList<RVImage>) : RecyclerView.Adapter<RVImageViewHolder>(){
//class ImageRVAdapter(private val item: ArrayList<RVImage>, private val clickListener: ImageClicked) : RecyclerView.Adapter<RVImageViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_image, parent, false)
//        view.setOnClickListener {
//            clickListener.onItemClicked(item[RVImageViewHolder(view).adapterPosition])
//        }
        return RVImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVImageViewHolder, position: Int) {
        Glide.with(holder.image.context).load(item[position].imageUrl).into(holder.image)
        holder.source.text = item[position].user
    }

    override fun getItemCount() = item.size
}
class RVImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var image: ImageView = itemView.findViewById(R.id.RVImage)
    var source: TextView = itemView.findViewById(R.id.RVImageSource)
}
//interface ImageClicked{
//    fun onItemClicked(item: RVImage)
//}
