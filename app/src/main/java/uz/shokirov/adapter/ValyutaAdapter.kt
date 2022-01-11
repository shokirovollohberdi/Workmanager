package uz.shokirov.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.entity.Valyuta
import uz.shokirov.workmanager.databinding.ItemRvBinding

class RvValyutaAdapter(var list: List<Valyuta>) : RecyclerView.Adapter<RvValyutaAdapter.Vh>() {
    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(valyuta: Valyuta, position: Int) {
            itemRv.tvValyuta.text = valyuta.CcyNm_UZ
            itemRv.tvRate.text = valyuta.Rate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}