package com.practice.dishlist.view.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.practice.dishlist.R
import com.practice.dishlist.application.DishListApplication
import com.practice.dishlist.databinding.FragmentAllDishesBinding
import com.practice.dishlist.view.activities.AddUpdateDishActivity
import com.practice.dishlist.view.adapers.DishListAdapter
import com.practice.dishlist.viewmodel.DishListViewModel
import com.practice.dishlist.viewmodel.DishListViewModelFactory
import com.practice.dishlist.viewmodel.HomeViewModel

class AllDishesFragment : Fragment() {

    private lateinit var mBinding: FragmentAllDishesBinding

    private val mDishListViewModel: DishListViewModel by viewModels {
        DishListViewModelFactory((requireActivity().application as DishListApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAllDishesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.rvDishesList.layoutManager = GridLayoutManager(requireActivity(), 2)
        val dishListAdapter = DishListAdapter(this@AllDishesFragment)

        mBinding.rvDishesList.adapter = dishListAdapter

        mDishListViewModel.allDishesList.observe(viewLifecycleOwner) { dishes ->
            dishes?.let {
                if (it.isNotEmpty()) {
                    mBinding.rvDishesList.visibility = View.VISIBLE
                    mBinding.tvNoDishesAddedYey.visibility = View.GONE

                    dishListAdapter.dishesList(it)
                } else {
                    mBinding.rvDishesList.visibility = View.GONE
                    mBinding.tvNoDishesAddedYey.visibility = View.VISIBLE
                }
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_dishes, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_dish -> {
                startActivity(Intent(requireActivity(), AddUpdateDishActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}