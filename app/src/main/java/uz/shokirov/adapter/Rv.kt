package uz.shokirov.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.models.MyTime
import uz.shokirov.workmanager.databinding.ItemListBinding

class RvAdapter(var list: ArrayList<MyTime>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemRv: ItemListBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: MyTime, position: Int) {
            itemRv.itemTvTime.text = user.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemListBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}