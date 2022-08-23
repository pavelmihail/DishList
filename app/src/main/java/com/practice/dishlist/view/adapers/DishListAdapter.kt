package com.practice.dishlist.view.adapers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.dishlist.databinding.ItemDishLayoutBinding
import com.practice.dishlist.model.entities.DishList

class DishListAdapter(private val fragment: Fragment) :
    RecyclerView.Adapter<DishListAdapter.ViewHolder>() {

    private var dishes: List<DishList> = listOf()

    class ViewHolder(view: ItemDishLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        //Holds the TextView that wil add each item to
        val ivDishImage = view.ivDishImage
        val tvTitle = view.tvDishTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDishLayoutBinding =
            ItemDishLayoutBinding.inflate(LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        Glide.with(fragment)
            .load(dish.image)
            .into(holder.ivDishImage)
        holder.tvTitle.text = dish.title
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    fun dishesList(list: List<DishList>) {
        dishes = list
        notifyDataSetChanged()
    }
}