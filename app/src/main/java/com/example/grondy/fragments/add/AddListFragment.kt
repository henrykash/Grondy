package com.example.grondy.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.grondy.R
import com.example.grondy.data.models.Priority
import com.example.grondy.data.models.ToDoData
import com.example.grondy.data.viewmodel.ToDoViewModel
import com.example.grondy.fragments.SharedViewModel
import kotlinx.android.synthetic.main.fragment_add_list.*
import kotlinx.android.synthetic.main.fragment_add_list.view.*


class AddListFragment : Fragment() {

    private val mToDoViewModel: ToDoViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_list, container, false)

        //set the menu
        setHasOptionsMenu(true)
        //set the color adapter for the spinner
        view.priorities_spinner.onItemSelectedListener = mSharedViewModel.listener

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            //call the insert data to database function here
            insertDataToDb()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {
        val mTitle = title_et.text.toString()
        val mPriority = priorities_spinner.selectedItem.toString()
        val mDescription = description_et.text.toString()

        val validation = mSharedViewModel.verifyDataFromUser(mTitle, mDescription)
        if (validation) {
            //insert data to database
            val newData = ToDoData(
                0,
                mTitle,
                mSharedViewModel.parsePriority(mPriority),
                mDescription
            )
            mToDoViewModel.insertData(newData)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
            //now navigate the user back from the add fragment to list fragment
            findNavController().navigate(R.id.action_addListFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "please fill up all fields", Toast.LENGTH_SHORT).show()
        }
    }

}


