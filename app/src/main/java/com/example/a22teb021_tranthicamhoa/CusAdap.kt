package com.example.a22teb021_tranthicamhoa

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CusAdap (val activity: Activity, val list: List<Data>) : ArrayAdapter<Data>(activity, R.layout.items){
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        val rowView = contexs.inflate(R.layout.items, parent, false)
        val mahp = rowView.findViewById<TextView>(R.id.text1sss)
        val tenhp = rowView.findViewById<TextView>(R.id.text2sss)
        mahp.text = list[position].mahp
        tenhp.text = list[position].ten
        return rowView

    }
}