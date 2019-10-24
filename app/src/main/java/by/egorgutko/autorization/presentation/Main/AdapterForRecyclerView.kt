package by.egorgutko.autorization.presentation.Main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import by.egorgutko.autorization.R

class AdapterForRecyclerView(myArray: List<*>) : RecyclerView.Adapter<AdapterForRecyclerView.MyAdapetrViewHolder>() {

    private val myArray: List<String>

    init {
        this.myArray = myArray as List<String>
    }

    inner class MyAdapetrViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal var myText: TextView

        init {
            myText = view.findViewById<View>(R.id.mText) as TextView
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapetrViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_for_recycler_view, parent, false)
        return MyAdapetrViewHolder(view)
    }

    override fun onBindViewHolder(myAdapetrViewHolder: MyAdapetrViewHolder, position: Int) {
        myAdapetrViewHolder.myText.text = myArray[position]

    }

    override fun getItemCount(): Int {
        return myArray.size
    }


}
