package taufiq.apps.emgas.adapter

import android.content.Context
import com.bumptech.glide.Glide
import taufiq.apps.core.databinding.GameRowBinding
import taufiq.apps.core.domain.Game
import taufiq.apps.core.utils.BaseAdapter
import taufiq.apps.emgas.R

/**
 * Created By Taufiq on 5/19/2021.
 *
 */
class GameAdapters(private val context: Context) : BaseAdapter<Game>(R.layout.game_row) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val gameData = data[position]
        val binding = GameRowBinding.bind(holder.itemView)
        with(binding) {
            Glide.with(context)
                .load(gameData.imageUrl)
                .into(itemImageRow)

            itemTitleRow.text = gameData.name
            itemRatingRow.text = gameData.rating

            root.setOnClickListener { itemClickListener?.invoke(gameData) }
        }
    }
}