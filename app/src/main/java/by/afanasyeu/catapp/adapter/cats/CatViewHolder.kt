package by.afanasyeu.catapp.adapter.cats

import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.signature.ObjectKey
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.item_cat.view.*

class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(id: Long) {
        itemView.apply {
            Glide.with(this)
                .load("http://loremflickr.com/200/200")
                .signature(ObjectKey(id))
                .transform(FitCenter(), RoundedCorners(7))
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        return false
                    }
                })
                .into(imageViewCat)
        }
    }
}